package org.parog.algorithm_training_5.section2;

import java.util.Scanner;

/**
 * Из шахматной доски по границам клеток выпилили связную (не распадающуюся на части) фигуру без дыр.
 * Требуется определить ее периметр.
 */
public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCutOffCells = scanner.nextInt();

        // края матрицы являются барьером
        int[][] board = new int[10][10];

        // отмечаем вырезанные клетки
        for (int i = 0; i < numOfCutOffCells; ++i) {
            int pointX = scanner.nextInt();
            int pointY = scanner.nextInt();
            board[pointX][pointY] = 1;
        }

        System.out.println(getPerimeter(board));
    }

    /**
     * Проходимся по шахматной доске 8x8, находим вырезанные клетки и с помощью сдвигов находим периметр, считая
     * нулевые элементы вокруг фигуры.
     *
     * @param board шахматная доска с барьерами по краям
     * @return периметр вырезанной фигуры
     */
    public static int getPerimeter(int[][] board) {
        // сдвиги по координатам x и y
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        int perimeter = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                if (board[x][y] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int neighbour = board[x + dx[k]][y + dy[k]];

                        if (neighbour == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}