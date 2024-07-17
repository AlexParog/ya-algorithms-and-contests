package org.parog.algorithm_training_5.section4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан массив из N целых чисел. Все числа от −10^9 до 10^9.
 * <p>
 * Нужно уметь отвечать на запросы вида “Cколько чисел имеют значения от L до R?”.
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mass = new int[n];
        for (int i = 0; i < n; i++) {
            mass[i] = scanner.nextInt();
        }
        Arrays.sort(mass);

        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int leftBorder = scanner.nextInt();
            int rightBorder = scanner.nextInt();
            int indexOfLeftBorder = binarySearchFirstX(leftBorder, mass);
            int indexOfRightBorderPlusOne = binarySearchFirstX(rightBorder + 1, mass);
            System.out.print(indexOfRightBorderPlusOne - indexOfLeftBorder + " ");
        }
    }

    /**
     * Выполняет бинарный поиск в отсортированном массиве для нахождения индекса
     * первого вхождения числа x. Если число не найдено, возвращает индекс
     * ближайшего числа, которое больше или равно x.
     *
     * @param x   Искомое число.
     * @param arr Отсортированный массив чисел.
     * @return Индекс первого вхождения числа x или индекс ближайшего числа,
     * которое больше или равно x.
     */
    public static int binarySearchFirstX(int x, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (arr[m] >= x) {
                right = m - 1;
                answer = m;
            } else {
                left = m + 1;
            }
        }
        if (right == -1) return 0;
        if (left == arr.length) return arr.length;
        return answer;
    }
}
