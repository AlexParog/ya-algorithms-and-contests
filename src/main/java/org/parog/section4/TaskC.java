package org.parog.section4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Как известно, Саруман Радужный очень любит порядок. Поэтому все полки его войска стоят друг за другом, причем каждый
 * следующий полк содержит количество орков не меньше, чем предыдущий.
 * <p>
 * Перед тем как напасть на Хельмову Падь, Саруман решил провести несколько вылазок для разведки. Чтобы его отряды никто
 * не заметил, он решил каждый раз отправлять несколько подряд идущих полков так, чтобы суммарное количество орков в них
 * было равно определенному числу. Так как это всего лишь разведка, каждый полк после вылазки возвращается на свое место.
 * Задачу выбрать нужные полки он поручил Гриме Змеиному Языку. А Грима не поскупится на вознаграждение, если вы ему поможете.
 */

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, q;
        n = scanner.nextInt();
        q = scanner.nextInt();
        scanner.nextLine(); // Пропускаем оставшуюся часть строки

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Пропускаем оставшуюся часть строки после чтения чисел

        int[] prefixSums = calculatePrefixSums(numbers);

        ArrayList<Integer[]> requiredSums = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int len = scanner.nextInt(), sum = scanner.nextInt();
            requiredSums.add(new Integer[]{len, sum});
        }

        ArrayList<Integer> positions = findPositions(prefixSums, n, requiredSums, q);

        for (int pos : positions) {
            System.out.print(pos + " ");
        }
    }

    /**
     * Вычисляет префиксные суммы для заданного массива.
     *
     * @param numbers Массив чисел.
     * @return Массив префиксных сумм.
     */
    public static int[] calculatePrefixSums(int[] numbers) {
        int[] prefixSums = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + numbers[i - 1];
        }
        return prefixSums;
    }

    /**
     * Находит начальные позиции подмассивов, суммы значений которых соответствуют заданным суммам.
     *
     * @param prefixSums   Массив префиксных сумм.
     * @param length       Длина подмассива.
     * @param requiredSums Массив требуемых сумм.
     * @param queryCount   Количество запросов.
     * @return Список начальных позиций подмассивов.
     */
    public static ArrayList<Integer> findPositions(int[] prefixSums, int length, ArrayList<Integer[]> requiredSums,
                                                   int queryCount) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            Integer[] query = requiredSums.get(i);
            int sequenceLength = query[0], sumRequired = query[1];

            int left = 1, right = length + 1 - sequenceLength, position = -1;
            while (left < right) {
                int middle = (left + right) / 2;
                if (prefixSums[middle + sequenceLength - 1] - prefixSums[middle - 1] >= sumRequired) {
                    position = middle;
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            if (position != -1 && prefixSums[position + sequenceLength - 1] - prefixSums[position - 1] == sumRequired) {
                positions.add(position);
            } else {
                positions.add(-1);
            }
        }
        return positions;
    }
}
