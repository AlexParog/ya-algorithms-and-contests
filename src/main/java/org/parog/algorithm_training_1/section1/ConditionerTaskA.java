package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * A. Кондиционер
 */
public class ConditionerTaskA {
    private static final String FREEZE_MODE = "freeze";
    private static final String HEAT_MODE = "heat";
    private static final String AUTO_MODE = "auto";
    private static final String FAN_MODE = "fan";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tRoom = scanner.nextInt();
        int tCond = scanner.nextInt();

        String mode = scanner.next();

        if (FREEZE_MODE.equals(mode)) {
            // выбираем минимум среди температур
            System.out.println(Math.min(tRoom, tCond));
        } else if (HEAT_MODE.equals(mode)) {
            // выбираем максимум среди температур
            System.out.println(Math.max(tRoom, tCond));
        } else if (AUTO_MODE.equals(mode)) {
            // отрегулируется до желаемой температуры на кондиционере
            System.out.println(tCond);
        } else if (FAN_MODE.equals(mode)) {
            // неважно какая желаемая температура, всегда будет температура комнаты
            System.out.println(tRoom);
        }
    }
}
