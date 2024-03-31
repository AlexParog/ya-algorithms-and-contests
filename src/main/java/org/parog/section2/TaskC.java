package org.parog.section2;

import java.io.*;
import java.util.Arrays;

/**
 * На столе лежали две одинаковые верёвочки целой положительной длины.
 * Петя разрезал одну из верёвочек на N частей, каждая из которых имеет целую положительную длину, так что на столе стало
 * N+1 верёвочек. Затем в комнату зашла Маша и взяла одну из лежащих на столе верёвочек. По длинам оставшихся на столе N
 * верёвочек определите, какую наименьшую длину может иметь верёвочка, взятая Машей.
 */
public class TaskC {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int numberRopes = Integer.parseInt(reader.readLine());

            int[] ropes = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String result = String.valueOf(getMinimalRopeRazbor(ropes));

            writer.write(result);
        }
    }

    /**
     * В задаче две ситуации:
     * 1) Когда одна (максимальная) из двух изначальных веревок лежит среди оставшихся и необходимо вернуть
     * разницу между ней и суммой остальных.
     * 2) Когда вторую изначальную веревку взяла Маша, тогда возвращаем сумму длин всех веревок на столе.
     *
     * @param ropes длины оставшихся веревочек
     * @return наименьшая длина, которую может иметь верёвочка, взятая Машей
     */
    public static int getMinimalRope(int[] ropes) {
        int maxRope = Arrays.stream(ropes)
                .max()
                .getAsInt();

        int maxRopeIndex = -1;
        // находим индекс максимального элемента
        for (int i = 0; i < ropes.length; i++) {
            if (ropes[i] == maxRope) {
                maxRopeIndex = i;
                break;
            }
        }
        // находим сумму без учета максимальной веревки
        int withoutMaxRope = 0;
        for (int i = 0; i < ropes.length; i++) {
            if (i != maxRopeIndex) {
                withoutMaxRope += ropes[i];
            }
        }

        return (maxRope - withoutMaxRope > 0) ? (maxRope - withoutMaxRope) : (maxRope + withoutMaxRope);
    }

    /**
     * Вариация решения задачи в Разборе. Сначала найдем сумму длин веревочек и максимальную веревочку.
     * Если удвоенная максимальная больше суммы всех веревочек, то была изъята маленькая. Иначе была изъята половина -
     * равная сумме всех.
     *
     * @param ropes длины оставшихся веревочек
     * @return наименьшая длина, которую может иметь верёвочка, взятая Машей
     */
    public static int getMinimalRopeRazbor(int[] ropes) {
        int sumOfRopes = Arrays.stream(ropes)
                .sum();
        int maxRope = Arrays.stream(ropes)
                .max()
                .getAsInt();

        return (maxRope * 2 > sumOfRopes) ? (maxRope * 2 - sumOfRopes) : sumOfRopes;
    }
}