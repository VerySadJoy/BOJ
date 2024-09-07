//Question No: 1992
//Title: 쿼드트리
//Tier: Silver I
import java.util.Scanner;

public class Main {
	
	public static int[][] image;
	public static StringBuilder resultBuilder = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int size = scanner.nextInt();
		image = new int[size][size];	

		for (int i = 0; i < size; i++) {
			String line = scanner.next();
			for (int j = 0; j < size; j++) {
				image[i][j] = line.charAt(j) - '0';
			}
		}
		
		compressImage(0, 0, size);
		System.out.println(resultBuilder);
	}
	
	public static void compressImage(int x, int y, int size) {
		if (canBeCompressed(x, y, size)) {
			resultBuilder.append(image[x][y]);
			return;
		}
		
		int newSize = size / 2;
		
		resultBuilder.append('(');
		compressImage(x, y, newSize);                    
		compressImage(x, y + newSize, newSize);            
		compressImage(x + newSize, y, newSize);            
		compressImage(x + newSize, y + newSize, newSize);
		resultBuilder.append(')');
	}
	
	public static boolean canBeCompressed(int x, int y, int size) {
		int initialValue = image[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (initialValue != image[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}