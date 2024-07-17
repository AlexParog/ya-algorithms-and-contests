package org.parog.algorithm_training_5.section1;

import java.io.*;
import java.util.Arrays;

/**
 * Вася и Маша участвуют в субботнике и красят стволы деревьев в белый цвет.
 * Деревья растут вдоль улицы через равные промежутки в 1 метр. Одно из деревьев обозначено числом ноль, деревья по одну
 * сторону занумерованы положительными числами 1,2 и т.д., а в другую — отрицательными −1,−2 и т.д.
 * <p>
 * Ведро с краской для Васи установили возле дерева P, а для Маши — возле дерева Q. Ведра с краской очень
 * тяжелые и Вася с Машей не могут их переставить, поэтому они окунают кисть в ведро и уже с этой кистью идут красить дерево.
 * Краска на кисти из ведра Васи засыхает, когда он удаляется от ведра более чем на V метров, а из ведра Маши — на M метров.
 * Определите, сколько деревьев может быть покрашено.
 */
public class TaskA {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {

            int[] arrVasya = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] arrMasha = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            // вася
            int p = arrVasya[0];
            int v = arrVasya[1];
            // маша
            int q = arrMasha[0];
            int m = arrMasha[1];

            // определяем в какой последовательности идут отрезки: Вася-Маша или Маша-Вася
            int result = (p < q) ? getNumberOfTreesPainted(p, v, q, m) : getNumberOfTreesPainted(q, m, p, v);
            String formattedResult = String.valueOf(result);

            writer.write(formattedResult);
        }
    }

    public static int getNumberOfTreesPainted(int p, int v, int q, int m) {
        // пересекаются ли отрезки: конец отрезка Васи и начало отрезка Маши
        if (p + v < q - m) {
            // сумма удвоенных шагов Васи и Маши плюс оба конца отрезков
            return 2 * v + 2 * m + 2;
        } else {
            // максимум закрашенных деревьев среди отрезков только Васи или только Маши
            int maxIntervalsVasyaOrMasha = Math.max(2 * v + 1, 2 * m + 1);
            // количество закрашенных деревьев Маши и Васи, включая пересечение и конец пересечения (закрашенное дерево)
            int intervalVasyaAndMasha = q + m - p + v + 1;
            return Math.max(maxIntervalsVasyaOrMasha, intervalVasyaAndMasha);
        }
    }
}
