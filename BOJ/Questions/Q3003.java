//Question No: 3003
//Title: 킹, 퀸, 룩, 비숍, 나이트, 폰
//Tier: Bronze V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int initialKing = 1;
        int initialQueen = 1;
        int initialRook = 2;
        int initialBishop = 2;
        int initialKnight = 2;
        int initialPawn = 8;
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int king = initialKing - Integer.parseInt(tokenizer.nextToken());
        int queen = initialQueen - Integer.parseInt(tokenizer.nextToken());
        int rook = initialRook - Integer.parseInt(tokenizer.nextToken());
        int bishop = initialBishop - Integer.parseInt(tokenizer.nextToken());
        int knight = initialKnight - Integer.parseInt(tokenizer.nextToken());
        int pawn = initialPawn - Integer.parseInt(tokenizer.nextToken());

        System.out.print(king + " ");
        System.out.print(queen + " ");
        System.out.print(rook + " ");
        System.out.print(bishop + " ");
        System.out.print(knight + " ");
        System.out.print(pawn + " ");        
    }
}