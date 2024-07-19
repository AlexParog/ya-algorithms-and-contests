package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * F. Расстановка ноутбуков
 */
public class ArrangementOfLaptopsTaskF {
    /**
     * Класс стола
     */
    static class Table {
        /**
         * Длина
         */
        private int length;
        /**
         * Ширина
         */
        private int width;
        /**
         * Площадь стола
         */
        private int square;

        /**
         * Конструктор стола
         *
         * @param length1 длина первого ноутбука
         * @param width1  ширина первого ноутбука
         * @param length2 длина второго ноутбука
         * @param width2  ширина второго ноутбука
         */
        public Table(int length1, int width1, int length2, int width2) {
            this.length = Math.max(length1, length2);
            this.width = width1 + width2;
            this.square = length * width;
        }

        static Table getSmallestArea(Table a, Table b) {
            return a.square <= b.square ? a : b;
        }

        @Override
        public String toString() {
            return length + " " + width;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        Table laptop1 = Table.getSmallestArea(new Table(a, b, c, d), new Table(a, b, d, c));
        Table laptop2 = Table.getSmallestArea(new Table(b, a, c, d), new Table(b, a, d, c));

        System.out.println(Table.getSmallestArea(laptop1, laptop2).toString());
    }
}
