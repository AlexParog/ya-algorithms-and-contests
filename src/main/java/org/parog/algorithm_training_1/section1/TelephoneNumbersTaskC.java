package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * C. Телефонные номера
 */
public class TelephoneNumbersTaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String newPhoneNum = match(scanner);
        String oldOne = match(scanner);
        String oldTwo = match(scanner);
        String oldThree = match(scanner);
        scanner.close();

        // есть ли новый телефонный номер в книжке
        System.out.println(oldOne.equals(newPhoneNum) ? "YES" : "NO");
        System.out.println(oldTwo.equals(newPhoneNum) ? "YES" : "NO");
        System.out.println(oldThree.equals(newPhoneNum) ? "YES" : "NO");
    }

    /**
     * Считываем построчно номера телефонов и приводим к формату: 8<код 3 цифры><номер 7 цифр>, пропуская "()-".
     *
     * @return телефонный номер
     */
    private static String match(Scanner scanner) {
        String phone = scanner.nextLine();
        StringBuilder tmp = new StringBuilder();

        for (char num : phone.toCharArray()) {
            if (num == '+' || Character.isDigit(num)) {
                tmp.append(num);
            }
        }

        if (tmp.charAt(0) == '+') {
            tmp = new StringBuilder(tmp.substring(2));
            tmp.insert(0, '8');
        }

        if (tmp.length() == 7) {
            tmp.insert(0, "8495");
        }

        return tmp.toString();
    }
}
