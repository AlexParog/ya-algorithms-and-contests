package org.parog.section4;

import java.util.Scanner;

/**
 * Поле в игре в одномерный морской бой имеет размеры 1×n. Ваша задача — найти такое максимальное k, что на поле можно
 * расставить один корабль размера 1×k, два корабля размера 1×(k−1), …, k кораблей размера 1×1, причем корабли, как и в
 * обычном морском бое, не должны касаться друг друга и пересекаться.
 */
public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long maxShips = findMaxShips(n);
        System.out.println(maxShips);
    }

    /**
     * Метод для поиска максимального числа кораблей, которое можно разместить на поле.
     *
     * @param n количество клеток на поле
     * @return максимальное количество кораблей, которое можно разместить
     */
    public static long findMaxShips(long n) {
        long left = 0;
        long right = n;
        long answer = -1;

        // Бинарный поиск для определения максимального числа кораблей
        while (left <= right) {
            long middle = (left + right) / 2;
            if (isValidConfiguration(n, middle)) {
                left = middle + 1;
                answer = middle;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }

    /**
     * Метод для проверки возможности размещения кораблей на поле для заданного числа кораблей.
     *
     * @param availableCells количество клеток на поле
     * @param shipCount      количество кораблей, которые необходимо разместить
     * @return {@code true}, если размещение возможно, {@code false} в противном случае
     */
    public static boolean isValidConfiguration(long availableCells, long shipCount) {
        availableCells -= shipCount;
        shipCount -= 1;
        long shipLength = 2;

        // Проверяем возможность размещения кораблей на поле
        while (shipCount > 0) {
            availableCells -= (shipCount + 1) * shipLength;
            if (availableCells < 0) {
                return false;
            }
            shipCount -= 1;
            shipLength += 1;
        }

        return availableCells >= 0;
    }
}