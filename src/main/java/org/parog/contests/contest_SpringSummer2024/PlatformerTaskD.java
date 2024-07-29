package org.parog.contests.contest_SpringSummer2024;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * D. Игра-платформер
 * <p>
 * TL - лимит по времени
 */
public class PlatformerTaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfCommandsN = scanner.nextInt();
        String commands = scanner.next();

        // уникальные позиции
        Set<Integer> uniqPositions = new HashSet<>();

        // счетчик уникальных позиций
        int countUniqPositions = 0;

        for (int i = 0; i < amountOfCommandsN; i++) {
            int originalPos = getX(commands); // Вычисляем оригинальную позицию
            char originalCommand = commands.charAt(i);

            // Пробуем замену для каждой команды
            for (char replacement : new char[]{'F', 'R', 'L'}) {
                if (originalCommand != replacement) {
                    int newPos = getX(commands, i, replacement);
                    if (uniqPositions.add(newPos)) {
                        countUniqPositions++;
                    }
                }
            }
        }

        System.out.println(countUniqPositions);
    }

    /**
     * Метод для вычисления конечной позиции игрока на основе последовательности команд
     * Если index != -1, то заменяем команду в index на replacement.
     *
     * @param commands    Исходная строка команд
     * @param index       Индекс заменяемой команды
     * @param replacement Новая команда для замены
     * @return Конечная позиция игрока
     */
    private static int getX(String commands, int index, char replacement) {
        int x = 0;
        int direction = 1;

        for (int i = 0; i < commands.length(); i++) {
            char command = (i == index) ? replacement : commands.charAt(i);
            if (command == 'F') {
                x += direction;
            } else if (command == 'R') {
                direction = 1;
            } else if (command == 'L') {
                direction = -1;
            }
        }
        return x;
    }

    /**
     * Метод для вычисления конечной позиции игрока на основе исходной последовательности команд
     *
     * @param commands Исходная строка команд
     * @return Конечная позиция игрока
     */
    private static int getX(String commands) {
        return getX(commands, -1, ' ');
    }
}