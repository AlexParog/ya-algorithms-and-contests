package org.parog.section3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Дан массив a из n чисел. Найдите минимальное количество чисел, после удаления которых попарная разность
 * оставшихся чисел по модулю не будет превышать 1, то есть после удаления ни одно число не должно отличаться от
 * какого-либо другого более чем на 1.
 */
public class TaskD {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            final int[] arrNK = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            final int[] row = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String result = isRepeatingNumber(arrNK[1], row);

            writer.write(result);
        }
    }

    /**
     * Подобно очереди используем множество и добавляем элементы одновременно удаляем старые элементы, чтобы поддерживать
     * размер "окна". Временная сложность O(n), где n - количество элементов в row.
     *
     * @param k   максимальная разница
     * @param row числа
     * @return YES - нашли повторяющееся число удовлетворяя условие k, NO - такого числа нет либо условие не удовлетворяется
     */
    public static String isRepeatingNumber(int k, int[] row) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < row.length; i++) {
            if (set.contains(row[i])) {
                return "YES";
            }
            set.add(row[i]);

            // Удаляем элемент, который находится за пределами окна размером k
            if (i >= k) {
                set.remove(row[i - k]);
            }
        }

        return "NO";
    }
}