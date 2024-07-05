//Question No: 23886
//Title: 알프수
//Tier: Bronze I
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> lst = new ArrayList<>();
        
        for (char ch : input.toCharArray()) {
            lst.add(Character.getNumericValue(ch));
        }
        
        checkAlpsoo(lst);
    }
    
    public static void checkAlpsoo(List<Integer> lst) {
        int initialSlope = lst.get(1) - lst.get(0);
        int slope = initialSlope;
        
        if (slope <= 0) {
            System.out.println("NON ALPSOO");
            return;
        }
        
        for (int i = 1; i < lst.size() - 1; i++) {
            if (lst.get(i).equals(lst.get(i + 1))) {
                System.out.println("NON ALPSOO");
                return;
            }

            int upsideDownside = (lst.get(i) - lst.get(i - 1)) * (lst.get(i + 1) - lst.get(i));
            
            if (upsideDownside > 0) {
                if (slope != (lst.get(i + 1) - lst.get(i))) {
                    System.out.println("NON ALPSOO");
                    return;
                }
            } else {
                slope = lst.get(i + 1) - lst.get(i);
            }
        }
        
        if (slope < 0) {
            System.out.println("ALPSOO");
        } else {
            System.out.println("NON ALPSOO");
        }
    }
}
