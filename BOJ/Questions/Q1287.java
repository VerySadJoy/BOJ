//Question No: 1287
//Title: 할 수 있다
//Tier: Platinum IV
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    private static List<Symbol> symbolBuffer = new ArrayList<>();
    private static int index = 0;
    private enum SymbolType {NUL, DIGIT, NUMBER, EXPR, PLUS, MINUS, STAR, SLASH, LP, RP}

    private static class Symbol {
        public SymbolType type;
        public BigInteger value;

        public Symbol() {
            type = SymbolType.NUL;
        }

        public Symbol(char c) {
            if (c >= '0' && c <= '9') {
                type = SymbolType.DIGIT;
                value = BigInteger.valueOf(c - '0');
            } else if (c == '+') type = SymbolType.PLUS;
            else if (c == '-') type = SymbolType.MINUS;
            else if (c == '*') type = SymbolType.STAR;
            else if (c == '/') type = SymbolType.SLASH;
            else if (c == '(') type = SymbolType.LP;
            else if (c == ')') type = SymbolType.RP;
            else type = SymbolType.NUL;
        }

        public void setAsNumber(Symbol s) {
            type = SymbolType.NUMBER;
            value = value.multiply(BigInteger.TEN).add(s.value);
        }

        public void setAsNumber() {
            type = SymbolType.NUMBER;
        }

        public void setAsExpression() {
            type = SymbolType.EXPR;
        }
    }

    private static Symbol evaluateExpression() throws Exception {
        Symbol result = evaluateTerm();
        while (symbolBuffer.get(index).type == SymbolType.PLUS || symbolBuffer.get(index).type == SymbolType.MINUS) {
            SymbolType symbolType = symbolBuffer.get(index++).type;
            Symbol termResult = evaluateTerm();
            if (symbolType == SymbolType.PLUS) result.value = result.value.add(termResult.value);
            else if (symbolType == SymbolType.MINUS) result.value = result.value.subtract(termResult.value);
        }
        return result;
    }

    private static Symbol evaluateTerm() throws Exception {
        Symbol result = evaluateFactor();
        while (symbolBuffer.get(index).type == SymbolType.STAR || symbolBuffer.get(index).type == SymbolType.SLASH) {
            SymbolType symbolType = symbolBuffer.get(index++).type;
            Symbol factorResult = evaluateFactor();
            if (symbolType == SymbolType.STAR) result.value = result.value.multiply(factorResult.value);
            else if (symbolType == SymbolType.SLASH) result.value = result.value.divide(factorResult.value);
        }
        return result;
    }

    private static Symbol evaluateFactor() throws Exception {
        Symbol result;
        if (null == symbolBuffer.get(index).type) throw new Exception();
        else switch (symbolBuffer.get(index).type) {
            case EXPR:
                result = symbolBuffer.get(index++);
                break;
            case LP:
                index++;
                result = evaluateExpression();
                if (symbolBuffer.get(index).type == SymbolType.RP) index++;
                else throw new Exception();
                break;
            default:
                throw new Exception();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String expression = inputReader.readLine();

        for (int i = 0; i < expression.length(); i++) {
            Symbol symbol = new Symbol(expression.charAt(i));
            if (symbol.type == SymbolType.DIGIT) {
                if (symbolBuffer.isEmpty() || symbolBuffer.get(symbolBuffer.size() - 1).type != SymbolType.NUMBER) {
                    symbol.setAsNumber();
                    symbolBuffer.add(symbol);
                } else symbolBuffer.get(symbolBuffer.size() - 1).setAsNumber(symbol);
            } else {
                if (!symbolBuffer.isEmpty() && symbolBuffer.get(symbolBuffer.size() - 1).type == SymbolType.NUMBER)
                    symbolBuffer.get(symbolBuffer.size() - 1).setAsExpression();
                symbolBuffer.add(symbol);
            }
        }

        if (!symbolBuffer.isEmpty() && symbolBuffer.get(symbolBuffer.size() - 1).type == SymbolType.NUMBER)
            symbolBuffer.get(symbolBuffer.size() - 1).setAsExpression();
        symbolBuffer.add(new Symbol());

        try {
            Symbol result = evaluateExpression();
            if (symbolBuffer.get(index).type != SymbolType.NUL) throw new Exception();
            System.out.println(result.value.toString());
        } catch (Exception e) {
            System.out.println("ROCK");
        }
    }
}