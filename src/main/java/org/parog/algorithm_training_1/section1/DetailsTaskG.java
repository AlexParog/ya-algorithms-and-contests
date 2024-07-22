package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * D. Детали
 */
public class DetailsTaskG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Общее количество сплава в кг
        final int k = scanner.nextInt(); // Масса одной заготовки в кг
        final int m = scanner.nextInt(); // Масса одной детали в кг


        System.out.println(countDetails(n, k, m));
        scanner.close();
    }

    /**
     * Метод для подсчета максимального количества деталей
     *
     * @param n - Общее количество сплава в кг
     * @param k - Масса одной заготовки в кг
     * @param m - Масса одной детали в кг
     * @return максимальное количество деталей
     */
    private static int countDetails(int n, int k, int m) {
        // Если исходное количество сплава меньше массы одной заготовки или масса заготовки меньше массы одной детали
        if (n < k || k < m) {
            return 0;
        }

        // Количество деталей, которые можно изготовить из одной заготовки
        int detailsPerBlank = k / m;
        // Масса сплава, требуемая для изготовления всех деталей из одной заготовки
        int detailsAlloyPerBlank = detailsPerBlank * m;
        // Остаток сплава после изготовления всех деталей из одной заготовки
        int alloyRemainderPerBlank = k % m;

        // Количество полных заготовок, которые можно изготовить из исходного количества сплава
        int blanks = n / detailsAlloyPerBlank;
        // Остаток сплава после изготовления полных заготовок
        int alloyReminder = n % detailsAlloyPerBlank;

        // Если оставшегося сплава недостаточно для изготовления хотя бы одной заготовки
        if (alloyReminder < alloyRemainderPerBlank) {
            blanks--; // Уменьшаем количество заготовок
        }

        return blanks * detailsPerBlank;
    }
}