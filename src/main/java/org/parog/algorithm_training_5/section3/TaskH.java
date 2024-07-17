package org.parog.algorithm_training_5.section3;

import java.util.*;

/**
 * Вася любит решать головоломки со спичками. Чаще всего они формулируются следующим образом: дано изображение A,
 * составленное из спичек; переложите в нем минимальное количество спичек так, чтобы получилось изображение B.
 * Например, из номера текущего командного чемпионата школьников Санкт-Петербурга по программированию, можно получить
 * ромб с диагональю, переложив всего три спички.
 * Головоломки, которые решает Вася, всегда имеют решение. Это значит, что набор спичек, используемый в изображении A,
 * совпадает с набором спичек, используемым в изображении B. Кроме того, в одном изображении никогда не встречаются
 * две спички, у которых есть общий участок ненулевой длины (то есть спички могут пересекаться, но не могут
 * накладываться друг на друга).
 * Вася устал решать головоломки вручную, и теперь он просит вас написать, программу, которая будет решать головоломки за него.
 * Программа будет получать описания изображений A и B и должна найти минимальное количество спичек, которые надо
 * переложить в изображении A, чтобы полученная картинка получалась из B параллельным переносом.
 */

// wrong answer
public class TaskH {
    // Класс Vector представляет вектор с начальной точкой и смещением
    static class MyVector {
        int startX, startY, moveX, moveY;

        MyVector(int startX, int startY, int moveX, int moveY) {
            this.startX = startX;
            this.startY = startY;
            this.moveX = moveX;
            this.moveY = moveY;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> figureA = new ArrayList<>();
        List<List<Integer>> figureB = new ArrayList<>();

        addCoordinatesForFigure(scanner, n, figureA);

        addCoordinatesForFigure(scanner, n, figureB);

        int result = solution(n, figureA, figureB);
        System.out.println(result);
    }

    // Метод создает вектор по координатам концов спички
    static MyVector createVector(List<Integer> cords) {
        int x1 = cords.get(0), y1 = cords.get(1), x2 = cords.get(2), y2 = cords.get(3);
        int xStart = x1, yStart = y1, xEnd = x2, yEnd = y2;

        if (yStart > yEnd || (yStart == yEnd && xStart > xEnd)) {
            xStart = x2;
            yStart = y2;
            xEnd = x1;
            yEnd = y1;
        } else if (xStart == xEnd && yStart == yEnd) {
            // Добавляем проверку для случая, когда начальная и конечная точки совпадают
            return null; // Возвращаем null в этом случае
        }

        int xMove = xEnd - xStart;
        int yMove = yEnd - yStart;

        return new MyVector(xStart, yStart, xMove, yMove);
    }

    // Метод создает отображение, где ключами являются векторы смещения, а значениями - списки векторов,
    // начинающихся с той же точки и имеющих такое же смещение
    static Map<MyVector, List<MyVector>> createVectorsDirection(List<List<Integer>> figure) {
        Map<MyVector, List<MyVector>> vectorsDirection = new HashMap<>();

        for (List<Integer> cords : figure) {
            MyVector vector = createVector(cords);
            if (!vectorsDirection.containsKey(vector)) {
                vectorsDirection.put(vector, new ArrayList<>());
            }
            vectorsDirection.get(vector).add(new MyVector(vector.startX, vector.startY, vector.moveX, vector.moveY));
        }
        return vectorsDirection;
    }

    // Метод находит минимальное количество спичек, которые нужно переложить,
    // чтобы изображение A совпало с изображением B путем параллельного переноса
    static int solution(int n, List<List<Integer>> figureA, List<List<Integer>> figureB) {
        Map<MyVector, List<MyVector>> vectorsDirectionA = createVectorsDirection(figureA);
        Map<MyVector, List<MyVector>> vectorsDirectionB = createVectorsDirection(figureB);

        Map<MyVector, Integer> diff = new HashMap<>();
        int max = 0;

        for (Map.Entry<MyVector, List<MyVector>> entry : vectorsDirectionB.entrySet()) {
            MyVector k = entry.getKey();
            if (!vectorsDirectionA.containsKey(k)) continue;

            for (MyVector itemA : entry.getValue()) {
                for (MyVector vector : vectorsDirectionA.get(k)) {
                    int dx = vector.startX - itemA.startX;
                    int dy = vector.startY - itemA.startY;
                    MyVector diffVector = new MyVector(dx, dy, 0, 0);
                    diff.put(diffVector, diff.getOrDefault(diffVector, 0) + 1);
                    max = Math.max(max, diff.get(diffVector));
                }
            }
        }

        // Добавляем проверку на отсутствие ключей в vectorsDirectionB
        if (max == 0 && !vectorsDirectionA.isEmpty()) {
            return n;
        }

        return n - max;
    }

    private static void addCoordinatesForFigure(Scanner scanner, int n, List<List<Integer>> figureA) {
        for (int i = 0; i < n; i++) {
            List<Integer> coordinates = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                coordinates.add(scanner.nextInt());
            }
            figureA.add(coordinates);
        }
    }
}
