package org.parog.algorithm_training_5.section4;

import java.util.Scanner;

/**
 * Верс нужно подготовить рапорт о последнем боевом вылете. Она уже сочинила в голове текст, осталось лишь его записать.
 * Рапорт будет состоять из двух частей: первая будет содержать n слов, i-е из которых состоит из ai букв, вторая — m слов,
 * j-е из которых состоит из bj букв. Язык Крии не содержит никаких знаков препинания. Верс должна записать рапорт на
 * клетчатом рулоне бумаги, шириной w клеток. Так как рапорт состоит из двух частей, она разделит вертикальной чертой
 * рулон на две части целой ширины, после чего в левой части напишет первую часть, а в правой — вторую.
 * <p>
 * Обе части рапорта записываются аналогично, каждая на своей части рулона. Одна буква слова занимает ровно одну клетку.
 * Первое слово записывается в первой строке рулона, начиная с самой левой клетки этой части рулона. Каждое следующее
 * слово, если это возможно, должно быть записано в той же строке, что и предыдущее, и быть отделено от него ровно
 * одной пустой клеткой. Иначе, оно пишется в следующей строке, начиная с самой левой клетки. Если ширина части рулона
 * меньше, чем длина какого-то слова, которое должно быть написано в этой части, написать эту часть рапорта на части
 * рулона такой ширины невозможно.
 * <p>
 * Гарантируется, что можно провести вертикальную черту так, что обе части рапорта возможно написать. Верс хочет провести
 * вертикальную черту так, чтобы длина рулона, которой хватит, чтобы написать рапорт, была минимальна.
 * Помогите ей найти эту минимальную длину.
 */

public class TaskD {

    /**
     * Вычисляет минимально необходимое количество линий обоев, чтобы покрыть бумагу заданной ширины.
     *
     * @param rolls    Массив с длинами рулонов бумаги.
     * @param maxWidth Максимально возможная ширина бумаги, которую можно покрыть одним рулоном.
     * @return Минимальное количество линий обоев.
     */
    public static int calculateRequiredLines(int[] rolls, int maxWidth) {
        int lines = 0;
        int remainingWidth = 0; // Текущая оставшаяся ширина
        for (int width : rolls) {
            if (width > maxWidth) { // Если длина рулона больше макс. ширины, вернуть очень большое значение
                return Integer.MAX_VALUE;
            }
            if (width <= remainingWidth) {
                remainingWidth -= width + 1; // Оставшееся пространство уменьшается на длину рулона + зазор
            } else {
                remainingWidth = maxWidth - width - 1; // Нужна новая линия
                lines++;
            }
        }
        return lines;
    }

    /**
     * Проверяет, возможно ли улучшить разбиение учитывая текущую позицию.
     *
     * @param a               Массив длин рулонов для одной стены.
     * @param b               Массив длин рулонов для другой стены.
     * @param totalWidth      Общая ширина.
     * @param currentPosition Текущее положение разбиения.
     * @return Возможно ли улучшение.
     */
    public static boolean canOptimizePartition(int[] a, int[] b, int totalWidth, int currentPosition) {
        int remainingWidthForB = totalWidth - currentPosition;
        return calculateRequiredLines(a, currentPosition) < calculateRequiredLines(b, remainingWidthForB);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] rollsA = new int[n];
        int[] rollsB = new int[m];

        for (int i = 0; i < n; i++) {
            rollsA[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            rollsB[i] = scanner.nextInt();
        }

        int left = 0;
        int right = width;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canOptimizePartition(rollsA, rollsB, width, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int ans = Math.min(Math.max(calculateRequiredLines(rollsA, left), calculateRequiredLines(rollsB, width - left)),
                Math.max(calculateRequiredLines(rollsA, left - 1), calculateRequiredLines(rollsB, width - left + 1)));

        System.out.println(ans);
    }
}
