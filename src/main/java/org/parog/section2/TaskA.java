package org.parog.section2;

import java.io.*;
import java.util.Arrays;

/**
 * На клетчатой плоскости закрашено K клеток. Требуется найти минимальный по площади прямоугольник, со сторонами,
 * параллельными линиям сетки, покрывающий все закрашенные клетки.
 */
public class TaskA {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int quantityPaintedCell = Integer.parseInt(reader.readLine());
            int[] coordinatesX = new int[quantityPaintedCell];
            int[] coordinatesY = new int[quantityPaintedCell];

            for (int i = 0; i < quantityPaintedCell; i++) {
                String[] parts = reader.readLine().split(" ");
                coordinatesX[i] = Integer.parseInt(parts[0]);
                coordinatesY[i] = Integer.parseInt(parts[1]);
            }

            String result = getMinimumRectangularArea(quantityPaintedCell, coordinatesX, coordinatesY);

            writer.write(result);
        }
    }

    public static String getMinimumRectangularArea(int quantityPaintedCell, int[] coordinatesX, int[] coordinatesY) {
        // встроенная сортировка O(n log n)
        Arrays.sort(coordinatesX);
        Arrays.sort(coordinatesY);

        // минимальный левый X
        int minX = coordinatesX[0];
        // минимальный левый Y
        int minY = coordinatesY[0];
        // максимальный левый X
        int maxX = coordinatesX[quantityPaintedCell - 1];
        // максимальный левый Y
        int maxY = coordinatesY[quantityPaintedCell - 1];

        return minX + " " + minY + " " + maxX + " " + maxY;
    }
}
