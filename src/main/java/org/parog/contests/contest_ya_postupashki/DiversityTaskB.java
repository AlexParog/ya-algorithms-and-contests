package org.parog.contests.contest_ya_postupashki;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * B. Разнообразие
 */
public class DiversityTaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // количество карт у игрока А
        int n = scanner.nextInt();
        // количество карт у игрока B
        int m = scanner.nextInt();
        // количество изменений
        int q = scanner.nextInt();
        // balance отслеживает разницу в количестве каждой карты между игроками А и B, где
        // ключ - номер карты, значение - разница в количестве карт у игрока А и игрока B
        Map<Integer, Integer> balance = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int value = scanner.nextInt();
            balance.put(value, balance.getOrDefault(value, 0) + 1);
        }

        for (int i = 0; i < m; ++i) {
            int value = scanner.nextInt();
            balance.put(value, balance.getOrDefault(value, 0) - 1);
        }

        // сумма модулей -> количество карт на столе
        // разнообразие определяется суммой модулей разниц карт
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            answer += Math.abs(entry.getValue());
        }

        // перед каждым изменением вычитается старое значение,
        // затем добавляется новое для правильного пересчета разнообразия
        for (int i = 0; i < q; ++i) {
            // Чтение типа операции (добавление или удаление)
            int operationType = scanner.nextInt();
            // Чтение игрока (A или B)
            char who = scanner.next().charAt(0);
            // Чтение значения карты
            int x = scanner.nextInt();

            // Уменьшение текущего разнообразия на значение до изменения
            answer -= Math.abs(balance.getOrDefault(x, 0));

            // Обновление баланса в зависимости от игрока и типа операции
            if (who == 'A') {
                balance.put(x, balance.getOrDefault(x, 0) + operationType);
            } else {
                balance.put(x, balance.getOrDefault(x, 0) - operationType);
            }

            // Увеличение разнообразия на новое значение
            answer += Math.abs(balance.getOrDefault(x, 0));

            System.out.print(answer + " ");
        }

        scanner.close();
    }
}
