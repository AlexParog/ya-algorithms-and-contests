package org.parog.algorithm_training_1.section1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * I. Узник Замка If
 */
public class PrisonerOfTheCastleIfTaskI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        // кирпич
        int[] brick = {a, b, c};
        // отверстие
        int[] hole = {d, e};

        String result = miniBubbleSort(brick, hole);
        System.out.println(result);
    }

    /**
     * Упорядочиванием числа для дальнейшего сравнения высоты и ширины, так как длина будет самой большой
     * (будет в конце отсортированного массива). В данном сравнении длина кирпича нам не важна, главное, чтобы высота
     * и ширина кирпича были меньше или равны высоты и ширины отверстия.
     *
     * @param brick параметры кирпича
     * @param hole  параметры отверстия
     * @return {@code true} кирпич пройдет в отверстие, иначе {@code false}
     */
    private static String miniBubbleSort(int[] brick, int[] hole) {
        Arrays.sort(brick);
        Arrays.sort(hole);

        boolean isBrickGoIntoHole = hole[0] >= brick[0] && brick[1] <= hole[1];

        return isBrickGoIntoHole ? "YES" : "NO";
    }
}
