import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            for (int multiple = f; multiple <= n; multiple += f) {
                multiples[f] += freq[multiple];
            }
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long rem = budget;
        long totalItems = 0;

        for (int[] item : items) {
            long price = item[1];
            if (price >= 2 * minPrice) {
                break;
            }
            if (rem < price) {
                break;
            }

            long maxBundles = multiples[item[0]] - 1;
            if (maxBundles <= 0) {
                continue;
            }

            long canBuy = Math.min(maxBundles, rem / price);
            totalItems += canBuy * 2;
            rem -= canBuy * price;
        }

        totalItems += rem / minPrice;

        return (int) totalItems;
    }
}