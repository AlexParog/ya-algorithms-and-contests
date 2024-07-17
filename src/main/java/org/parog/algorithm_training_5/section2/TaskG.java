package org.parog.algorithm_training_5.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дан массив целых положительных чисел a длины n. Разбейте его на минимально возможное количество отрезков,
 * чтобы каждое число было не меньше длины отрезка которому оно принадлежит. Длиной отрезка считается количество чисел
 * в нем. Разбиение массива на отрезки считается корректным, если каждый элемент принадлежит ровно одному отрезку.
 */

public class TaskG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; ++testCase) {
            int arrayLength = scanner.nextInt();
            List<Integer> segmentLengths = new ArrayList<>();
            int currentSegmentLength = 0;
            int maximumAllowedLength = Integer.MAX_VALUE;

            for (int i = 0; i < arrayLength; ++i) {
                int currentValue = scanner.nextInt();

                // Сброс и создание нового отрезка при необходимости
                if (currentSegmentLength >= maximumAllowedLength || currentSegmentLength >= currentValue) {
                    segmentLengths.add(currentSegmentLength);
                    // Перезапуск с текущим значением как первым в отрезке
                    currentSegmentLength = 1;
                    // Обновление максимально разрешенной длины отрезка
                    maximumAllowedLength = currentValue;
                } else {
                    // Продолжение текущего отрезка
                    ++currentSegmentLength;
                    // Обновление максимума, если текущее значение меньше
                    maximumAllowedLength = Math.min(maximumAllowedLength, currentValue);
                }
            }

            // Добавление последнего непустого отрезка, если он есть
            if (currentSegmentLength > 0) {
                segmentLengths.add(currentSegmentLength);
            }

            // Вывод результата
            System.out.println(segmentLengths.size());
            for (int length : segmentLengths) {
                System.out.print(length + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
