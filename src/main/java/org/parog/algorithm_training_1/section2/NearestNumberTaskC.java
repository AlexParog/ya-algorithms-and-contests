package org.parog.algorithm_training_1.section2;

import java.util.Scanner;

/**
 * C. Ближайшее число
 */
public class NearestNumberTaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthArr = scanner.nextInt();
        int[] array = new int[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.println(detectNearestNum(array, target));
        scanner.close();
    }

    /**
     * Находим в массиве элемент, который является самым близким по величине к заданному числу target
     *
     * @param arr       массив чисел
     * @param target    цель
     * @return ближайшее число
     */
    private static int detectNearestNum(int[] arr, int target) {
        // ближайшее значение
        int nearest = arr[0];
        // минимальная разница как абсолютная разница между первым элементом и target
        int diff = Math.abs(target - nearest);

        // для каждого элемента вычисляем абсолютную разницу
        for (int i = 1; i < arr.length; i++) {
            int curDiff = Math.abs(target - arr[i]);
            // если текущая меньше глобальной
            if (curDiff < diff) {
                diff = curDiff;
                nearest = arr[i];
            }
        }

        return nearest;
    }
}
