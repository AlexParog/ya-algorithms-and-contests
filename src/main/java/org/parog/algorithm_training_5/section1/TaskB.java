package org.parog.algorithm_training_5.section1;

import java.io.*;
import java.util.Arrays;

/**
 * Раунд плей-офф между двумя командами состоит из двух матчей. Каждая команда проводит по одному матчу «дома» и «в гостях».
 * Выигрывает команда, забившая большее число мячей. Если же число забитых мячей совпадает, выигрывает команд,
 * забившая больше мячей «в гостях». Если и это число мячей совпадает, матч переходит в дополнительный тайм или серию пенальти.
 * Вам дан счёт первого матча, а также счёт текущей игры (которая ещё не завершилась). Помогите комментатору сообщить,
 * сколько голов необходимо забить первой команде, чтобы победить, не переводя игру в дополнительное время.
 */
public class TaskB {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int[] firstMatch = Arrays.stream(reader.readLine().split(":"))
                    .mapToInt(Integer::parseInt)
                    .filter(score -> score <= 5)
                    .toArray();
            int[] secondMatch = Arrays.stream(reader.readLine().split(":"))
                    .mapToInt(Integer::parseInt)
                    .filter(score -> score <= 5)
                    .toArray();
            int location = Integer.parseInt(reader.readLine());

            String result = String.valueOf(calculateGoalsNeeded(firstMatch, secondMatch, location));

            writer.write(result);
        }
    }

    public static int calculateGoalsNeeded(int[] firstMatch, int[] secondMatch, int location) {
        final int goalsFirstTeamInFirstMatch = firstMatch[0];
        final int goalsSecondTeamInFirstMatch = firstMatch[1];
        final int goalsFirstTeamInSecondMatch = secondMatch[0];
        final int goalsSecondTeamInSecondMatch = secondMatch[1];

        // если команда 1 ведет в счете по итогу двух матчей
        if (goalsFirstTeamInFirstMatch + goalsFirstTeamInSecondMatch >
                goalsSecondTeamInFirstMatch + goalsSecondTeamInSecondMatch) {
            return 0;
        } else {
            // количество голов, которое команде 1 нужно забить для победы
            int goalsForWin = goalsSecondTeamInFirstMatch + goalsSecondTeamInSecondMatch
                    - goalsFirstTeamInFirstMatch - goalsFirstTeamInSecondMatch + 1;
            // если первая команда уступает по гостевым голам и играет в гостях
            // или ведет по гостевым голам и играет дома,
            // то нужен 1 гол для выигрыша
            if ((goalsFirstTeamInFirstMatch > goalsSecondTeamInSecondMatch && location == 2)
                    || (goalsFirstTeamInFirstMatch < goalsSecondTeamInSecondMatch && location == 1)) {
                goalsForWin -= 1;
            }
            //иначе нужно забить разницу между голами + 1
            return goalsForWin;
        }
    }
}