package org.parog.contests.contest1_SpringSummer2024;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * А. Форматирование текста
 * <p>
 * Открытые тест-кейсы с контеста:
 * - once upon a time, in a land far far away lived a princess , whose beauty was yet unmatched
 * - a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,yandex
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        // находим максимальное слово в тексте и умножаем его длину на 3
        int maxLen = Objects.requireNonNull(Arrays.stream(text.split("[ ,]+"))
                        .max(Comparator.comparingInt(String::length))
                        .orElse(""))
                .length() * 3;
        scanner.close();

        // разбиваем на слова и "склеиваем" запятые к ближайшим словам
        List<String> words = getSplitParts(text);

        // форматируем текст согласно условиям задачи
        StringBuilder result = formatText(words, maxLen);
        System.out.println(result);
    }

    /**
     * Составляем итоговый текст согласно формату:
     * 1. в каждой строке должно быть не более len символов
     * 2. после запятой пробел ставится, если она не является последним символом строки
     * 3. если слово не входит на строку i, строка і заканчивается, а слово будет записано на строке (і + 1)
     * 4. последним символом в любой строке должна быть буква или запятая
     *
     * @param words      разбитые форматированные слова
     * @param maxLineLen максимальное количество символов в строке
     * @return форматированный текст
     */
    private static StringBuilder formatText(List<String> words, int maxLineLen) {
        StringBuilder currentLine = new StringBuilder();
        StringBuilder formattedText = new StringBuilder();

        for (int wordNumber = 0; wordNumber < words.size(); wordNumber++) {
            String curWord = words.get(wordNumber);

            // добавляем слово в строку
            if (currentLine.length() + curWord.length() <= maxLineLen) {
                currentLine.append(curWord);

            } else {
                // удаляем лишний пробел в конце строки
                currentLine.setLength(currentLine.length() - 1);
                // перевод на следующую строку
                formattedText.append(currentLine).append("\n");

                // добавляем не поместившееся слово в следующую строку
                currentLine = new StringBuilder(curWord);
            }
            // добавляем пробел после слова или запятой до момента,
            // когда текущее слово не будет последним в списке слов
            if (wordNumber != words.size() - 1) {
                currentLine.append(" ");
            }
        }

        // добавляем оставшиеся слова в конец
        if (!currentLine.isEmpty()) {
            formattedText.append(currentLine);
        }

        return formattedText;
    }

    /**
     * Разбиваем неформатированный текст на части (слова + запятые) так, чтобы выполнялись следующие условия:
     * 1.запятая «приклеивается» к слову перед ней, то есть должна находиться на одной строке с ним;
     * 2. перед запятой пробел не ставится.
     *
     * @param text неформатированный текст
     * @return разбитые форматированные слова
     */
    private static List<String> getSplitParts(String text) {
        List<String> textParts = new ArrayList<>();
        // рассматриваются случаи:
        // 1. слово с одной или более строчными буквами + ноль или более пробелов
        // 2. слово с одной или более строчными буквами + ноль или более пробелов + ноль или одна запятая
        Pattern pattern = Pattern.compile("[a-z]+\\s*,?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group();
            // если находим случами, когда между словом и запятой есть пробелы,
            // то "склеиваем" запятую к ближайшему слову
            if (match.endsWith(",") && match.contains(" ")) {
                match = match.replace(" ", "");
            }
            // убираем лишние проблемы с начала и конца строки, если они есть
            textParts.add(match.trim());
        }

        return textParts;
    }
}
