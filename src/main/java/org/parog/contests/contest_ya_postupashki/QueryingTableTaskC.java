package org.parog.contests.contest_ya_postupashki;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * C. Запрос к таблице
 */
public class QueryingTableTaskC {
    // инициализация границ (очень большое число)
    private static final int INFINITY_VALUE = 2000000000;
    // Словарь для хранения индексов столбцов по их именам
    private static Map<String, Integer> colIndex = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processQueries(scanner);
        scanner.close();
    }

    public static void processQueries(Scanner scanner) {
        int numRows = scanner.nextInt();   // Количество строк
        int numCols = scanner.nextInt();   // Количество столбцов
        int numQueries = scanner.nextInt(); // Количество запросов
        int[][] matrix = new int[numRows][numCols]; // Таблица значений

        // Чтение и сохранение имен столбцов
        for (int i = 0; i < numCols; ++i) {
            String colName = scanner.next();
            colIndex.put(colName, i); // Сохранение индекса столбца по его имени
        }

        // Чтение значений матрицы
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Инициализация массивов для хранения границ значений
        int[] minColumnValues = new int[numCols];
        int[] maxColumnValues = new int[numCols];
        Arrays.fill(minColumnValues, -INFINITY_VALUE); // Минимальные значения
        Arrays.fill(maxColumnValues, INFINITY_VALUE);  // Максимальные значения

        // Обработка каждого запроса
        for (int q = 0; q < numQueries; ++q) {
            String colName = scanner.next(); // Имя столбца
            String opType = scanner.next();  // Тип операции (">" или "<")
            int x = scanner.nextInt();       // Значение для сравнения
            int colId = colIndex.get(colName); // Индекс столбца по его имени

            // Обновление границ значений для соответствующего столбца
            if (opType.equals(">")) {
                minColumnValues[colId] = Math.max(minColumnValues[colId], x);
            } else {
                maxColumnValues[colId] = Math.min(maxColumnValues[colId], x);
            }
        }

        // Переменная для хранения итоговой суммы
        long result = 0;
        // Проверка каждой строки на соответствие всем ограничениям
        for (int i = 0; i < numRows; ++i) {
            boolean isValidRow = true;
            long rowSum = 0;

            for (int j = 0; j < numCols; ++j) {
                // Если элемент строки выходит за рамки интервалов
                if (matrix[i][j] <= minColumnValues[j] || matrix[i][j] >= maxColumnValues[j]) {
                    isValidRow = false;
                    break;
                }
                rowSum += matrix[i][j];
            }

            // Если строка удовлетворяет всем ограничениям, добавляем её сумму к результату
            if (isValidRow) {
                result += rowSum;
            }
        }

        // Вывод итоговой суммы
        System.out.println(result);
    }
}
