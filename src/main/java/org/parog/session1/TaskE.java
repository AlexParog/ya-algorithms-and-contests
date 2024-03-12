package org.parog.session1;

import java.io.*;
import java.util.Arrays;

/**
 * k друзей организовали стартап по производству укулеле для кошек. На сегодняшний день прибыль составила n рублей.
 * Вы, как главный бухгалтер компании, хотите в каждый из ближайших d дней приписывать по одной цифре в конец числа,
 * выражающего прибыль. При этом в каждый из дней прибыль должна делиться на k.
 */
public class TaskE {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {

            int[] inputParameters = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            String result = calculateProfitInDays(inputParameters);

            writer.write(result);
        }
    }

    public static String calculateProfitInDays(int[] inputParameters) {
        int initialProfit = inputParameters[0];
        int people = inputParameters[1];
        int days = inputParameters[2];

        if (isProfitDivisibleByPeople(initialProfit, people)) {
            initialProfit *= 10;
        } else {
            int nearby = calculateNearestProfit(initialProfit, people);
            if (isNearestProfitSmaller(initialProfit, nearby)) {
                initialProfit = nearby;
            } else {
                return "-1";
            }
        }
        return formatProfitWithZeros(initialProfit, days);
    }

    /**
     * Является ли увеличенная в 10 раз прибыль ближайшим кратным
     *
     * @param profit нынешняя прибыль
     * @param people количество учредителей
     * @return кратна или нет
     */
    private static boolean isProfitDivisibleByPeople(int profit, int people) {
        return profit * 10 % people == 0;
    }

    /**
     * Находим ближайшее большее или равное кратное. Это делается путём деления profit * 10 на people,
     * округления до следующего целого числа и умножения на people
     *
     * @param profit нынешняя прибыль
     * @param people количество учредителей
     * @return ближайшее большее или равное кратное
     */
    private static int calculateNearestProfit(int profit, int people) {
        return (profit * 10 / people + 1) * people;
    }

    /**
     * Определяем возможность получения прибыли от нового ближайшего кратного:
     * 1) успешное увеличение прибыли, т. к. ближайшее кратное меньше, чем увеличенное значение прибыли плюс 10%
     * 2) выход в ноль, когда ближайшее кратное равно увеличенному значению прибыли плюс 10%
     * 3) невозможность увелечения прибыли, ближайшее кратное числу людей значение больше, чем увеличенное значение прибыли плюс 10%
     *
     * @param profit  нынешняя прибыль
     * @param nearest ближайшее большее или равное кратное
     * @return возможность получения прибыли
     */
    private static boolean isNearestProfitSmaller(int profit, int nearest) {
        return nearest < (profit + 1) * 10;
    }

    /**
     * Вычисляем прибыль с учетом первого дня.
     *
     * @param profit конечная прибыль
     * @param days   дни
     * @return форматированная прибыль
     */
    private static String formatProfitWithZeros(int profit, int days) {
        return profit + "0".repeat(days - 1);
    }
}
