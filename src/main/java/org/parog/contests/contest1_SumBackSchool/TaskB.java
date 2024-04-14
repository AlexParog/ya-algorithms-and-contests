package org.parog.contests.contest1_SumBackSchool;

import java.io.*;

/**
 * B. Проверка печати
 * Зимние каникулы... Чудесное время, полное ощущения волшебства, веселых игр на улице в снегу и прочих детских радостей.
 * Но не для Васи. Вася — стартапер. И вот его осенила новая идея — сделать собственный клавиатурный тренажер!
 * Сел Вася и принялся писать код.
 * Дни и ночи напролет Вася усердно трудился. И вот, прототип уже почти дописан, за исключением одной маленькой детали.
 * Тренажер представляет собой серию заданий: запрос к пользователю набрать некоторую строку a.
 * После этого пользователь должен как можно быстрее набрать на экране строку a, используя только латинские буквы
 * и клавиши управления. Вася решил записывать все нажатия клавиш пользователя в отдельный лог. В нем присутствуют
 * маленькие латинские буквы, а также управляющие конструкции
 * <delete> Удаление символа после текущей позиции курсора.
 * <bspace> Удаление символа перед текущей позицией курсора.
 * <left> Курсор перемещается влево на один символ.
 * <right> Курсор перемещается вправо на один символ.
 * Если управляющая конструкция перемещает курсор за границы текущей строки или пытается удалить несуществующий символ,
 * то ничего не происходит. Теперь у Васи есть строчка, которую должен был набрать пользователь, и последовательность
 * нажатий клавиш, считанная из лога. Помогите Васе выяснить, справился ли пользователь с заданием!
 * <p>
 * Формат ввода
 * Даны две строки a и b, разделённые переводом строки, — задание пользователя и последовательность нажатий клавиш
 * (1 ≤ |a|, |b| ≤ 1000).
 * <p>
 * Формат вывода
 * Если пользователь справился с заданием, выведите "Yes" (без кавычек), в противном случае выведите "No".
 * <p>
 * Сложность по времени: O(N^2), где N - длина строки лога, а также log.indexOf('>', i) - поиск символа '>'
 * в подстроке - в худшем случае O(N).
 * Сложность по памяти: O(N), где N - длина, использующегося StringBuilder для хранения строки currentString, которая может
 * достигать длины строки expected в худшем случае.
 */
public class TaskB {
    /**
     * Путь к input.txt
     */
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";
    /**
     * Путь к output.txt
     */
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";
    /**
     * Команда <delete>
     */
    private static final String DELETE = "delete";
    /**
     * Команда <bspace>
     */
    private static final String BSPACE = "bspace";
    /**
     * Команда <left>
     */
    private static final String LEFT = "left";
    /**
     * Команда <right>
     */
    private static final String RIGHT = "right";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {

            String expected = reader.readLine().toLowerCase();
            String userAttempt = reader.readLine().toLowerCase();

            String result = isUserHasSucceeded(expected, userAttempt);
            writer.write(result);
        }
    }

    /**
     * Определяет, успешно ли пользователь ввел заданную строку,
     * анализируя лог его действий на клавиатуре.
     *
     * @param expected ожидаемая строка, которую должен был ввести пользователь
     * @param log      лог действий пользователя, содержащий буквы и управляющие конструкции:
     *                 - <delete> - удалить символ после курсора
     *                 - <bspace> - удалить символ перед курсором
     *                 - <left> - переместить курсор влево
     *                 - <right> - переместить курсор вправо
     * @return "Yes", если пользователь успешно ввел строку, иначе "No"
     */
    private static String isUserHasSucceeded(String expected, String log) {
        StringBuilder currentString = new StringBuilder();
        int cursorPos = 0; // Позиция в currentString

        int i = 0; // Позиция сканирования в строке log
        while (i < log.length()) {
            char c = log.charAt(i);
            if (Character.isLetter(c)) {
                currentString.insert(cursorPos, c);
                cursorPos++;
                i++;
            } else if (c == '<') {
                int endPos = log.indexOf('>', i);
                if (endPos == -1) {
                    break; // Некорректная команда, прерываем обработку
                }
                String command = log.substring(i + 1, endPos);
                switch (command) {
                    case DELETE:
                        if (cursorPos < currentString.length()) {
                            currentString.deleteCharAt(cursorPos);
                        }
                        break;
                    case BSPACE:
                        if (cursorPos > 0) {
                            currentString.deleteCharAt(cursorPos - 1);
                            cursorPos--;
                        }
                        break;
                    case LEFT:
                        if (cursorPos > 0) cursorPos--;
                        break;
                    case RIGHT:
                        if (cursorPos < currentString.length()) cursorPos++;
                        break;
                }
                i = endPos + 1; // Перемещаемся за '>'
            } else {
                i++; // Неизвестный символ, продолжаем
            }
        }

        return currentString.toString().equals(expected) ? "Yes" : "No";
    }
}
