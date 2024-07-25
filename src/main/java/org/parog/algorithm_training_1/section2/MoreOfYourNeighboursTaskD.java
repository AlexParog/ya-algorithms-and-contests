package org.parog.algorithm_training_1.section2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * D. Больше своих соседей
 */
public class MoreOfYourNeighboursTaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(countLocalMax(arr));
    }

    /**
     * Определяем сколько в этом списке элементов, которые больше двух своих соседей и выведите количество таких элементов.
     *
     * @param arr массив
     * @return количество локальных максимумов
     */
    private static int countLocalMax(int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
