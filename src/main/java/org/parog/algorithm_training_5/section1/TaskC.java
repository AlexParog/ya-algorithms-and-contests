package org.parog.algorithm_training_5.section1;

import java.io.*;

/**
 * Петя - начинающий программист. Сегодня он написал код из n строк.
 * К сожалению оказалось, что этот код трудно читать. Петя решил исправить это, добавив в различные места пробелы.
 * А точнее, для i-й строки ему нужно добавить ровно ai пробелов.
 * Для добавления пробелов Петя выделяет строку и нажимает на одну из трёх клавиш: Space, Tab, и Backspace.
 * При нажатии на Space в строку добавляется один пробел. При нажатии на Tab в строку добавляются четыре пробела.
 * При нажатии на Backspace в строке удаляется один пробел.
 * Ему хочется узнать, какое наименьшее количество клавиш придётся нажать,
 * чтобы добавить необходимое количество пробелов в каждую строку. Помогите ему!
 */
public class TaskC {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int rows = Integer.parseInt(reader.readLine());
            if (rows >= 1) {
                long[] spacesToAdd = new long[rows];
                for (int i = 0; i < rows; i++) {
                    spacesToAdd[i] = Integer.parseInt(reader.readLine());
                }

                String result = String.valueOf(getMinimumNumberOfClicks(spacesToAdd));

                writer.write(result);
            }
        }
    }

    public static long getMinimumNumberOfClicks(long[] spacesToAdd) {
        long count = 0;
        for (long spaces : spacesToAdd) {
            // находим минимальное количество Tab - целая часть деления на 4
            count += spaces / 4;
            // если остаток деления на 4 равен 3, то эффективнее всего добавить два space и один backspace
            if (spaces % 4 == 3) {
                count += 2;
            } else {
                // иначе добавляем остаток деления на 4 - 0, 1, 2
                count += spaces % 4;
            }
        }
        return count;
    }
}
