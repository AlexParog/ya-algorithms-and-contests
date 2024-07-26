package org.parog.algorithm_training_1.section2;

import java.util.Scanner;

/**
 * E. Чемпионат по метанию коровьих лепешек
 */
public class CowCakesThrowingChampionshipTaskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthArr = scanner.nextInt();
        int[] array = new int[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(getWinnerIndex(array, lengthArr));
    }

    /**
     * Вычисляем максимально высокое место, занятое Василием
     *
     * @param arr       массив
     * @param lengthArr длина массива
     * @return место в турнирной таблице
     */
    public static int getWinnerIndex(int[] arr, int lengthArr) {
        int winner = 0;
        int winnerIndex = 0;
        // находим победителя, который стоит перед Васей (значение и индекс)
        for (int i = 0; i < lengthArr; i++) {
            if (arr[i] > winner) {
                winner = arr[i];
                winnerIndex = i;
            }
        }

        return getVasyaPlace(arr, lengthArr, winnerIndex);
    }

    /**
     * @param arr         массив
     * @param lengthArr   длина массива
     * @param winnerIndex индекс победителя
     * @return наивысшее место Васи в чемпионате
     */
    private static int getVasyaPlace(int[] arr, int lengthArr, int winnerIndex) {
        int vasya = 0;
        // находим самое наибольшую попытку Васи, которая удовлетворяет условия:
        // 1. Число метров, на которое он метнул лепешку, оканчивалось на 5
        // 2. Участник, метавший лепешку сразу после Василия, метнул ее на меньшее количество метров
        for (int i = winnerIndex + 1; i < lengthArr - 1; i++) {
            if ((arr[i] > vasya) && (arr[i] % 10 == 5) && (arr[i] > arr[i + 1])) {
                vasya = arr[i];
            }
        }


        int highestPlace = 0;
        // если существует участники чемпионата, которые удовлетворяют выше описанные условия
        if (vasya > 0) {
            highestPlace++;
            // определяем призовое место Васи
            for (int i = 0; i < lengthArr; i++) {
                if (arr[i] > vasya) {
                    highestPlace++;
                }
            }
        }
        return highestPlace;
    }
}