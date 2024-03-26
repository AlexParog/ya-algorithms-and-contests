package org.parog.section3;

import java.util.*;

/**
 * Вам даны три списка чисел. Найдите все числа, которые встречаются хотя бы в двух из трёх списков.
 */
public class TaskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Set<Integer>> listArrays = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int numOfElem = scanner.nextInt();

            Set<Integer> curr = new HashSet<>();
            for (int j = 0; j < numOfElem; j++) {
                curr.add(scanner.nextInt());
            }
            listArrays.add(curr);
        }

        List<Integer> result = findCommonElements(listArrays);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /**
     * Находим частоту повторения каждого числа из каждого списка чисел.
     *
     * @param listArrays список множеств с уникальными числами
     * @return пересечение хотя бы двух множеств в порядке возрастания
     */
    private static List<Integer> findCommonElements(List<Set<Integer>> listArrays) {
        Map<Integer, Integer> repetitionRate = new HashMap<>();

        for (Set<Integer> array : listArrays) {
            for (int num : array) {
                repetitionRate.put(num, repetitionRate.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Фильтруем числа, у которых количество вхождений >= 2
        for (Map.Entry<Integer, Integer> entry : repetitionRate.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}
