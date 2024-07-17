package org.parog.algorithm_training_5.section3;

import java.util.*;

/**
 * С целью экономии чернил в картридже принтера было принято решение укоротить некоторые слова в тексте. Для этого был
 * составлен словарь слов, до которых можно сокращать более длинные слова. Слово из текста можно сократить, если в словаре
 * найдется слово, являющееся началом слова из текста. Например, если в списке есть слово "лом", то слова из текста "ломбард",
 * "ломоносов" и другие слова, начинающиеся на "лом", можно сократить до "лом".
 * Если слово из текста можно сократить до нескольких слов из словаря, то следует сокращать его до самого короткого слова.
 */
public class TaskF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dictionaryWords = scanner.nextLine().split(" ");
        String[] textWords = scanner.nextLine().split(" ");

        String result = getAbbreviatedText(dictionaryWords, textWords);

        System.out.println(result);
    }

    /**
     * Возвращает текст, в котором длинные слова сокращены до самого короткого слова,
     * до которого можно сократить это слово согласно заданному словарю сокращений.
     *
     * @param dictionaryWords Массив слов из словаря сокращений.
     * @param text            Массив слов текста.
     * @return Строка с сокращенными словами.
     */
    public static String getAbbreviatedText(String[] dictionaryWords, String[] text) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(dictionaryWords));

        List<String> finalLine = new ArrayList<>();

        for (String word : text) {
            boolean found = false;
            // Проверяем возможность сокращения слова до какого-либо слова из словаря
            for (int i = 1; i < word.length(); i++) {
                String start = word.substring(0, i);
                if (uniqueWords.contains(start)) {
                    finalLine.add(start);
                    found = true;
                    break;
                }
            }

            if (!found) {
                finalLine.add(word);
            }
        }

        return String.join(" ", finalLine);
    }
}
