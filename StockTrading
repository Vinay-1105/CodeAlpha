import java.util.Scanner;

public class StockTrading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stock prices and shares
        String[] stocks = {"TCS", "INFY", "WIPRO", "HCL"};
        double[] prices = {350.0, 160.0, 450.0, 120.0};
        int[] shares = {0, 0, 0, 0};
        double balance = 5000.0;

        while (true) {
            System.out.println("\nBalance: ₹" + balance + " | Commands: BUY, SELL, PORTFOLIO, BALANCE, EXIT");
            System.out.print("Enter command: ");
            String command = sc.next().toUpperCase();
            if (command.equals("EXIT")) break;

            if (command.equals("BUY") || command.equals("SELL")) {
                System.out.print("Stock (TCS, INFY, WIPRO, HCL): ");
                String stock = sc.next().toUpperCase();
                int index = getStockIndex(stock, stocks);
                if (index == -1) {
                    System.out.println("Invalid stock!");
                    continue;
                }

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                double total = prices[index] * quantity;

                if (command.equals("BUY")) {
                    if (balance >= total) {
                        balance -= total;
                        shares[index] += quantity;
                        System.out.println("Bought " + quantity + " shares of " + stock);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {  // SELL
                    if (shares[index] >= quantity) {
                        balance += total;
                        shares[index] -= quantity;
                        System.out.println("Sold " + quantity + " shares of " + stock);
                    } else {
                        System.out.println("Not enough shares.");
                    }
                }
            } else if (command.equals("PORTFOLIO")) {
                System.out.println("-Portfolio-");
                double totalValue = 0;
                for (int i = 0; i < stocks.length; i++) {
                    double stockValue = shares[i] * prices[i];
                    totalValue += stockValue;
                    System.out.println(stocks[i] + ": " + shares[i] + " shares, Value: ₹" + stockValue);
                }
                System.out.println("Total Portfolio Value: ₹" + totalValue);
            } else if (command.equals("BALANCE")) {
                System.out.println("Current Balance: ₹" + balance);
            } else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }

    // Helper to get stock index by name
    private static int getStockIndex(String stock, String[] stocks) {
        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i].equals(stock)) return i;
        }
        return -1;
    }
}
