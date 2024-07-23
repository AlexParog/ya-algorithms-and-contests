package org.parog.algorithm_training_1.section2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A. Возрастает ли список?
 */
public class IsTheListGrowingTaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Преобразуем строковые элементы в целые числа
        int[] intArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String result = isMonotonicArr(intArray);
        System.out.println(result);
    }

    private static String isMonotonicArr(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return "NO";
            }
        }
        return "YES";
    }
}
