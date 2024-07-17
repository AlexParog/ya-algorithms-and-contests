package org.parog.algorithm_training_5.section3;

import java.util.*;

/**
 * Дан массив a из n чисел. Найдите минимальное количество чисел, после удаления которых попарная разность
 * оставшихся чисел по модулю не будет превышать 1, то есть после удаления ни одно число не должно отличаться от
 * какого-либо другого более чем на 1.
 */
public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int minDeleteCount = findMinDeleteCount(n, numbers);
        System.out.println(minDeleteCount);
    }

    /**
     * Находит минимальное количество элементов для удаления, чтобы удовлетворить заданное условие.
     *
     * @param n       Общее количество элементов.
     * @param numbers Список чисел.
     * @return Минимальное количество элементов для удаления.
     */
    private static int findMinDeleteCount(int n, List<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Инициализация минимального количества удаленных элементов до общего количества элементов
        int minDeleteCount = n;
        Set<Integer> processedNumbers = new HashSet<>();

        for (int num : numbers) {
            if (processedNumbers.contains(num)) {
                continue;
            }

            int currentCount = frequencyMap.get(num);
            int nextCount = frequencyMap.getOrDefault(num + 1, 0);
            int prevCount = frequencyMap.getOrDefault(num - 1, 0);
            // Вычисление общей разницы после удаления текущего числа
            int totalDiff = n - currentCount - Math.max(nextCount, prevCount);
            minDeleteCount = Math.min(minDeleteCount, totalDiff);
            processedNumbers.add(num);
        }

        // Возвращение минимального количества удаленных элементов
        return minDeleteCount;
    }
}