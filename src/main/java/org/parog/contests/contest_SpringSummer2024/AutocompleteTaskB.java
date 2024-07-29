package org.parog.contests.contest_SpringSummer2024;

import java.util.Scanner;

/**
 * В. Автодополнение на минималках
 */
public class AutocompleteTaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCountN = scanner.nextInt();
        int queriesQ = scanner.nextInt();
        scanner.nextLine();

        // словарь слов
        String[] dictionary = new String[wordCountN];
        for (int i = 0; i < wordCountN; i++) {
            dictionary[i] = scanner.nextLine();
        }

        // массив запросов
        int[] result = new int[queriesQ];

        for (int i = 0; i < queriesQ; i++) {
            // значение k для текущего запроса
            int curQueryK = scanner.nextInt();
            String prefix = scanner.next();
            result[i] = findWordByBinarySearch(dictionary, prefix, curQueryK);
        }

        scanner.close();

        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * Метод для поиска k-го слова, которое начинается с данного префикса.
     *
     * @param dictionary Массив слов словаря, отсортированный в лексикографическом порядке
     * @param prefix     Префикс, который должны иметь слова
     * @param k          Порядковый номер искомого слова среди слов с данным префиксом
     * @return Порядковый номер искомого слова в словаре или -1, если такого слова нет
     */
    private static int findWordByBinarySearch(String[] dictionary, String prefix, int k) {
        int left = 0;
        int right = dictionary.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // начинается ли слово с нужного префикса
            if (dictionary[mid].startsWith(prefix)) {
                // является ли это первое слово с таким префиксом
                if (mid == 0 || !dictionary[mid - 1].startsWith(prefix)) {
                    left = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (dictionary[mid].compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Проверка, что найдена начальная позиция слов с префиксом
        if (left < dictionary.length && dictionary[left].startsWith(prefix)) {
            int indexOfWordK = left + k - 1;  // Индекс k-го слова с данным префиксом

            // Проверка, что индекс не выходит за границы массива и слово начинается с нужного префикса
            if (indexOfWordK < dictionary.length && dictionary[indexOfWordK].startsWith(prefix)) {
                return indexOfWordK + 1;  // Возвращаем порядковый номер слова
            }
        }

        return -1;
    }
}
