package org.parog.contests.contest1_SumBackSchool;

import java.util.Scanner;

/**
 * A. Эмо бой
 * При регистрации на портале каждый эмо бой обязан придумать себе никнейм. Никнейм должен быть не короче восьми символов,
 * содержать в себе хотя бы одну цифру, и хотя бы по одной заглавной и прописной английской букве.
 * <p>
 * Формат ввода
 * Вводится никнейм — последовательность букв и цифр без пробелов. Длина строки не превосходит 100 символов.
 * <p>
 * Формат вывода
 * Выведите «YES», если ник подходит для эмо боя, и «NO» — в противном случае.
 * <p>
 * Сложность по времени: O(N), где N длина строки
 * Сложность по памяти: O(1) - константная сложность, так как используем входящую строку
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.next();

        String result = isRightNickname(nickname) ? "YES" : "NO";
        System.out.println(result);
    }

    /**
     * Проверяет, соответствует ли данный никнейм требованиям для эмо-боя.
     * <p>
     * Никнейм должен удовлетворять следующим условиям:
     * - Длина не менее 8 символов.
     * - Содержит хотя бы одну цифру.
     * - Содержит хотя бы одну строчную букву.
     * - Содержит хотя бы одну заглавную букву.
     *
     * @param nickname никнейм для проверки
     * @return true, если никнейм подходит, иначе false
     */
    private static boolean isRightNickname(String nickname) {
        if (nickname.length() < 8) {
            return false;
        }

        boolean hasDigit = false, hasLower = false, hasUpper = false;
        for (char c : nickname.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
        }
        return hasDigit && hasLower && hasUpper;
    }
}
