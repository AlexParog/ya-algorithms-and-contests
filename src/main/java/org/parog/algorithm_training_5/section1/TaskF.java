package org.parog.algorithm_training_5.section1;

import java.io.*;
import java.util.Arrays;

/**
 * Миша сидел на занятиях математики в Высшей школе экономики и решал следующую задачу: дано n целых чисел и нужно
 * расставить между ними знаки + и × так, чтобы результат полученного арифметического выражения был нечётным
 * (например, между числами 5, 7, 2, можно расставить арифметические знаки следующим образом: 5×7+2=37).
 * Так как примеры становились все больше и больше, а Миша срочно убегает в гости, от вас требуется написать программу
 * решающую данную задачу.
 */

// https://contest.yandex.ru/contest/59539/problems/F/
// WRONG ANSWER
public class TaskF {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {

            int quantity = Integer.parseInt(reader.readLine());
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String result = getOperators(quantity, numbers);

            writer.write(result);
        }
    }

    public static String getOperators(int quantity, int[] numbers) {
        StringBuilder result = new StringBuilder();
        // Определение начального состояния
        boolean res = numbers[0] % 2 != 0;

        for (int i = 0; i < quantity - 1; i++) {
            if (res) {
                // Если res == true (текущее число нечетное), то логика выбора символа меняется
                if (numbers[i + 1] % 2 != 0) {
                    result.append("x");
                } else {
                    result.append("+");
                    // Важно обновлять состояние res согласно логике Python кода
                    res = false;
                }
            } else {
                if (numbers[i + 1] % 2 != 0) {
                    result.append("+");
                    // обновляем состояние res
                    res = true;
                } else {
                    result.append("x");
                }
            }
        }
        return result.toString();
    }
}