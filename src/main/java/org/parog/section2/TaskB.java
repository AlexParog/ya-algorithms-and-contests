package org.parog.section2;

import java.io.*;
import java.util.Arrays;

/**
 * Вася решил заняться торговлей рыбой. С помощью методов машинного обучения он предсказал цены на рыбу на N дней
 * вперёд. Он решил, что в один день он купит рыбу, а в один из следующих дней — продаст (то есть совершит или ровно
 * одну покупку и продажу или вообще не совершит покупок и продаж, если это не принесёт ему прибыли). К сожалению,
 * рыба — товар скоропортящийся и разница между номером дня продажи и номером дня покупки не должна превышать K.
 * <p>
 * Определите, какую максимальную прибыль получит Вася.
 */
public class TaskB {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            final int[] arrNK = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            final int[] prices = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String result = String.valueOf(maximiseProfitLinearComplexity(arrNK, prices));

            writer.write(result);
        }
    }

    /**
     * Реализация через "Скользящие окна", временная сложность O(n*k), то есть линейная сложность.
     *
     * @param arrNK      arrNK[0] - дни продажи, arrNK[1] - срок годности товара
     * @param fishPrices цены на рыбу
     * @return максимальная прибыль
     */
    public static int maximiseProfitLinearComplexity(int[] arrNK, int[] fishPrices) {
        int maxDiff = arrNK[1];
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < fishPrices.length; buyDay++) {
            // окно - это следующий день или несколько следующих дней
            for (int sellDay = buyDay + 1; sellDay <= buyDay + maxDiff
                    && sellDay < fishPrices.length; sellDay++) {
                int profit = fishPrices[sellDay] - fishPrices[buyDay];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
