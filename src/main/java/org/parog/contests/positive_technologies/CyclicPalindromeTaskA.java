package org.parog.contests.positive_technologies;

import java.util.Scanner;

/**
 * Задача с олимпиады Positive Technologies: Циклический палиндром
 */
public class CyclicPalindromeTaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String doublePalindrome = isDoublePalindrome(s) ? "YES" : "NO";
        String cyclicPalindrome = isCyclicPalindrome(s) ? "YES" : "NO";

        System.out.println(doublePalindrome);
        System.out.println(cyclicPalindrome);
    }

    /**
     * Является ли строка палиндромом
     *
     * @param s строка
     * @return {@code true} палиндром, иначе {@link false}
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Является ли строка двойным палиндромом
     *
     * @param s строка
     * @return {@code true} палиндром, иначе {@link false}
     */
    public static boolean isDoublePalindrome(String s) {
        if (!isPalindrome(s)) {
            return false;
        }
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        return isPalindrome(firstHalf);
    }

    /**
     * Является ли строка циклическим палиндромом
     *
     * @param s строка
     * @return {@code true} палиндром, иначе {@link false}
     */
    public static boolean isCyclicPalindrome(String s) {
        int n = s.length();
        // Проверка если все символы одинаковые
        if (isAllSame(s)) {
            return true;
        }
        // Проверка если длина нечетная
        if (n % 2 != 0) {
            return false;
        }
        // Поиск всех делителей длины строки
        for (int k = 1; k <= n / 2; k++) {
            if (n % k == 0) {
                boolean isCyclic = true;
                // Проверка для каждого делителя
                for (int i = 0; i < k; i++) {
                    if (s.charAt(i) != s.charAt(k + i)) {
                        isCyclic = false;
                        break;
                    }
                }
                if (isCyclic) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Дополнительная проверка, которая упрощает проверку на палиндром
     *
     * @param s строка
     * @return {@code true} все символы в строке одинаковые, иначе {@link false}
     */
    public static boolean isAllSame(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
