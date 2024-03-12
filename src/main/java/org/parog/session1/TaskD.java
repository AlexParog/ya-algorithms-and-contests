package org.parog.session1;

import java.util.Scanner;

/**
 * На шахматной доске стоят слоны и ладьи, необходимо посчитать, сколько клеток не бьется ни одной из фигур.
 * <p>
 * Шахматная доска имеет размеры 8 на 8. Ладья бьет все клетки горизонтали и вертикали, проходящих через клетку,
 * где она стоит, до первой встретившейся фигуры. Слон бьет все клетки обеих диагоналей, проходящих через клетку,
 * где он стоит, до первой встретившейся фигуры.
 */

// https://contest.yandex.ru/contest/59539/problems/D/
// WRONG ANSWER
public class TaskD {
    private static final int SIZE = 8;  // Размер шахматной доски
    private static final boolean[][] attacked = new boolean[SIZE][SIZE];  // Клетки под атакой

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            String row = scanner.nextLine().trim();
            for (int j = 0; j < SIZE; j++) {
                char piece = row.charAt(j);
                if (piece == 'R') {
                    markRookMoves(i, j);
                } else if (piece == 'B') {
                    markBishopMoves(i, j);
                }
            }
        }

        // Подсчет непокрытых клеток.
        int safeSpots = 0;
        for (boolean[] row : attacked) {
            for (boolean cell : row) {
                if (!cell) {
                    safeSpots++;
                }
            }
        }

        System.out.println(safeSpots);
    }

    private static void markRookMoves(int r, int c) {
        for (int i = 0; i < SIZE; i++) {
            attacked[r][i] = true;
            attacked[i][c] = true;
        }
    }

    private static void markBishopMoves(int r, int c) {
        for (int i = 0; i < SIZE; i++) {
            if (isInBounds(r + i, c + i)) attacked[r + i][c + i] = true;
            if (isInBounds(r - i, c + i)) attacked[r - i][c + i] = true;
            if (isInBounds(r + i, c - i)) attacked[r + i][c - i] = true;
            if (isInBounds(r - i, c - i)) attacked[r - i][c - i] = true;

        }
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && c >= 0 && r < SIZE && c < SIZE;
    }
}
