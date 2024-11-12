//Question No: 4149
//Title: 큰 수 소인수분해
//Tier: Platinum I
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static BigInteger modularExponentiation(BigInteger base, BigInteger exponent, BigInteger modulus) {
        return base.modPow(exponent, modulus);
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    private static boolean millerRabinTest(BigInteger number, BigInteger base) {
        BigInteger exponent = number.subtract(BigInteger.ONE);
        int powerOfTwoCount = 0;

        while (exponent.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            powerOfTwoCount++;
            exponent = exponent.divide(BigInteger.TWO);
        }

        BigInteger result = modularExponentiation(base, exponent, number);
        if (result.equals(BigInteger.ONE) || result.equals(number.subtract(BigInteger.ONE))) {
            return true;
        }

        for (int i = 0; i < powerOfTwoCount - 1; i++) {
            result = modularExponentiation(result, BigInteger.TWO, number);
            if (result.equals(number.subtract(BigInteger.ONE))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(BigInteger number) {
        int[] testBases = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

        if (number.equals(BigInteger.ONE)) return false;
        if (number.equals(BigInteger.TWO) || number.equals(BigInteger.valueOf(3))) return true;
        if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false;

        for (int base : testBases) {
            if (number.equals(BigInteger.valueOf(base))) return true;
            if (!millerRabinTest(number, BigInteger.valueOf(base))) return false;
        }
        return true;
    }

    private static BigInteger pollardRho(BigInteger number) {
        if (isPrime(number)) return number;
        if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return BigInteger.TWO;

        Random random = new Random();
        BigInteger x = new BigInteger(number.bitLength(), random).mod(number.subtract(BigInteger.TWO)).add(BigInteger.TWO);
        BigInteger y = x;
        BigInteger constant = new BigInteger(number.bitLength(), random).mod(number.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger divisor = BigInteger.ONE;

        while (divisor.equals(BigInteger.ONE)) {
            x = (modularExponentiation(x, BigInteger.TWO, number).add(constant).add(number)).mod(number);
            y = (modularExponentiation(y, BigInteger.TWO, number).add(constant).add(number)).mod(number);
            y = (modularExponentiation(y, BigInteger.TWO, number).add(constant).add(number)).mod(number);
            divisor = gcd(x.subtract(y).abs(), number);

            if (divisor.equals(number)) return pollardRho(number);
        }
        return isPrime(divisor) ? divisor : pollardRho(divisor);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger number = new BigInteger(reader.readLine().trim());
        List<BigInteger> primeFactors = new ArrayList<>();

        while (number.compareTo(BigInteger.ONE) > 0) {
            BigInteger divisor = pollardRho(number);
            primeFactors.add(divisor);
            number = number.divide(divisor);
        }

        Collections.sort(primeFactors);

        for (BigInteger factor : primeFactors) {
            writer.write(factor + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}