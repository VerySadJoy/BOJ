//Question No: 26593
//Title: Best Seller
//Tier: Silver V
import java.util.*;

public class Main {
    static class Item {
        String name;
        int sales;
        double profitPerSale;
        double totalProfit;

        Item(String name, int sales, double profitPerSale) {
            this.name = name;
            this.sales = sales;
            this.profitPerSale = profitPerSale;
            this.totalProfit = sales * profitPerSale;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            String name = parts[0];
            int sales = Integer.parseInt(parts[1]);
            double profitPerSale = Double.parseDouble(parts[2]);
            items.add(new Item(name, sales, profitPerSale));
        }

        items.sort((a, b) -> {
            if (b.totalProfit != a.totalProfit) {
                return Double.compare(b.totalProfit, a.totalProfit);
            } else if (b.sales != a.sales) {
                return Integer.compare(b.sales, a.sales);
            } else {
                return a.name.compareTo(b.name);
            }
        });

        for (Item item : items) {
            System.out.printf("$%.2f - %s/%d%n", item.totalProfit, item.name, item.sales);
        }

        scanner.close();
    }
}
