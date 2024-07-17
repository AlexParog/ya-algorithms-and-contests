package org.parog.algorithm_training_5.section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Задано две строки, нужно проверить, является ли одна анаграммой другой.
 * Анаграммой называется строка, полученная из другой перестановкой букв.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstRow = scanner.nextLine().toLowerCase();
        String secondRow = scanner.nextLine().toLowerCase();

        if (firstRow.length() == secondRow.length()) {
            System.out.println(isAnagram(firstRow, secondRow));
        } else {
            System.out.println("NO");
        }
    }

    /**
     * Является ли строка анаграммой
     *
     * @param firstRow  первая строка
     * @param secondRow вторая строка
     * @return YES - анаграмма, NO - разные строки
     */
    public static String isAnagram(String firstRow, String secondRow) {
        char[] charsFirstRow = firstRow.toCharArray();
        Arrays.sort(charsFirstRow);

        char[] charsSecondRow = secondRow.toCharArray();
        Arrays.sort(charsSecondRow);

        return Arrays.equals(charsFirstRow, charsSecondRow) ? "YES" : "NO";
    }
}