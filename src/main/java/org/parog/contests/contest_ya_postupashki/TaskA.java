package org.parog.contests.contest_ya_postupashki;

import java.util.Scanner;

/**
 * А. Новая история
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int day1 = scanner.nextInt();
        int hour1 = scanner.nextInt();
        int min1 = scanner.nextInt();
        int sec1 = scanner.nextInt();

        int year2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int day2 = scanner.nextInt();
        int hour2 = scanner.nextInt();
        int min2 = scanner.nextInt();
        int sec2 = scanner.nextInt();


        long totalDays;
        long totalSeconds = 0;
        // считаем итерационно разницу в количестве лет, месяцев и дней в секундах
        while (year1 != year2 || month1 != month2 || day1 != day2) {
            totalSeconds += 24L * 60 * 60;
            day1++;

            if (day1 > daysInMonth(month1)) {
                day1 = 1;
                month1++;

                if (month1 > 12) {
                    month1 = 1;
                    year1++;
                }
            }
        }

        // добавляем оставшуюся разницу в часах, минутах и секундах
        totalSeconds += (hour2 - hour1) * 3600L + (min2 - min1) * 60L + (sec2 - sec1);
        // выделяем целую часть в днях
        totalDays = totalSeconds / (24 * 60 * 60);
        // оставшиеся секунды
        totalSeconds %= (24 * 60 * 60);

        System.out.println(totalDays + " " + totalSeconds);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Количество дней в каждом месяце, начиная с 1
     *
     * @param month месяц
     * @return количество дней месяце
     */
    public static int daysInMonth(int month) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month];
    }
}
