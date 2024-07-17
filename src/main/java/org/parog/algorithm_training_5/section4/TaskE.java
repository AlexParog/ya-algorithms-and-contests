package org.parog.algorithm_training_5.section4;

import java.util.Scanner;

/**
 * Георг Кантор доказал, что множество всех рациональных чисел счетно (т.е. все рациональные числа можно пронумеровать).
 * <p>
 * Чтобы упорядочить дроби необходимо их положить в таблицу, как показано на рисунке. В строку с номером i этой матрицы
 * по порядку записаны дроби с числителем i, а в столбец с номером j дроби со знаменателем j.
 * Дальше необходимо выписать все дроби в том порядке, как показано на рисунке стрелками.
 * <p>
 * Вам требуется по числу n найти числитель и знаменатель n-ой дроби.
 */

public class TaskE {

    /**
     * Возвращает сумму арифметической прогрессии до n-ого элемента.
     *
     * @param n Последний номер элемента в прогрессии.
     * @return Сумму арифметической прогрессии.
     */
    private static int sumArithmeticProgression(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Число для поиска n-ой дроби в упорядоченной последовательности Кантора.

        int left = 0;
        int right = n + 1;
        int diagonal;

        // Бинарный поиск для определения номера диагонали, на которой расположена n-ая дробь.
        while (left < right) {
            int middle = (left + right) / 2;
            if (sumArithmeticProgression(middle) >= n) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        diagonal = left;
        int positionInDiagonal = n - sumArithmeticProgression(diagonal - 1);

        // Вывод результата в зависимости от четности номера диагонали.
        if (diagonal % 2 == 1) {
            System.out.println(positionInDiagonal + "/" + (diagonal - positionInDiagonal + 1));
        } else {
            System.out.println((diagonal - positionInDiagonal + 1) + "/" + positionInDiagonal);
        }
    }
}