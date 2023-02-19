package problems;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

	public static void main(String[] args) {

		StockBuySell stock = new StockBuySell();

		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;

		stock.StockBuySell(price, n);
		
		System.out.println(maxProfit(price));

	}

	void StockBuySell(int price[], int n) {
		int profit = 0;

		if (n == 1)
			return;

		int count = 0;
		ArrayList<Interval> sol = new ArrayList<Interval>();

		int i = 0;
		while (i < n - 1) {

			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			e.sell = i - 1;
			sol.add(e);

			count++;
		}

		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++) {
				System.out.println("Buy on day: " + sol.get(j).buy + "        " + "Sell on day : " + sol.get(j).sell);
				profit = profit + price[sol.get(j).sell] - price[sol.get(j).buy];

			}

		System.out.println("Profit : " + profit);

		return;
	}

	public static int maxProfit(int[] prices) {
		int max_profit = 0;
		int min_value = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min_value) {
				min_value = prices[i];
			} else if (prices[i] - min_value > max_profit) {
				max_profit = prices[i] - min_value;
			}
		}

		return max_profit;
	}

}

class Interval {
	int buy, sell;
}
