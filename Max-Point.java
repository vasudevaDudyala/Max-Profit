import java.util.*;

public class Main {

    static class Building {
        String name;
        int time;
        int earnings;

        Building(String name, int time, int earnings) {
            this.name = name;
            this.time = time;
            this.earnings = earnings;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Time Unit: ");
        int n = sc.nextInt();

        Building[] buildings = {
            new Building("T", 5, 1500),
            new Building("P", 4, 1000),
            new Building("C", 10, 2000)
        };

        solve(n, buildings);
    }

    public static void solve(int n, Building[] buildings) {
        long maxProfit = 0;
        List<String> results = new ArrayList<>();
        for (int t = 0; t <= n / 5; t++) {
            for (int p = 0; p <= (n - (t * 5)) / 4; p++) {
                int remainingAfterTP = n - (t * 5) - (p * 4);
                int c = remainingAfterTP / 10;
                long currentProfit = calculateProfit(n, t, p, c, buildings);
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    results.clear();
                    results.add(formatOutput(t, p, c));
                } else if (currentProfit == maxProfit && currentProfit > 0) {
                    results.add(formatOutput(t, p, c));
                }
            }
        }

        System.out.println("Earnings: $" + maxProfit);
        System.out.println("Solutions:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
    }

    private static long calculateProfit(int n, int t, int p, int c, Building[] b) {
        long total = 0;
        int currentTime = 0;
        for (int i = 0; i < t; i++) {
            currentTime += b[0].time;
            total += (long) (n - currentTime) * b[0].earnings;
        }
        for (int i = 0; i < p; i++) {
            currentTime += b[1].time;
            total += (long) (n - currentTime) * b[1].earnings;
        }
        for (int i = 0; i < c; i++) {
            currentTime += b[2].time;
            total += (long) (n - currentTime) * b[2].earnings;
        }

        return total;
    }

    private static String formatOutput(int t, int p, int c) {
        return "T: " + t + " P: " + p + " C: " + c;
    }
}