package org.parog.algorithm_training_1.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B. Определить вид последовательности
 */
public class DetermineTheTypeOfSequenceTaskB {
    private static final String CONSTANT = "CONSTANT";
    private static final String ASCENDING = "ASCENDING";
    private static final String WEAKLY_ASCENDING = "WEAKLY ASCENDING";
    private static final String DESCENDING = "DESCENDING";
    private static final String WEAKLY_DESCENDING = "WEAKLY DESCENDING";
    private static final String RANDOM = "RANDOM";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = new ArrayList<>();

        while (true) {
            int current = scanner.nextInt();
            if (current == -2000000000) {
                break;
            }
            sequence.add(current);
        }

        System.out.println(determineSequenceState(sequence));
    }

    private static String determineSequenceState(List<Integer> sequence) {
        if (sequence.isEmpty()) return "EMPTY";

        boolean isConstant = true;
        boolean isAscending = true;
        boolean isWeaklyAscending = true;
        boolean isDescending = true;
        boolean isWeaklyDescending = true;

        for (int i = 1; i < sequence.size(); i++) {
            int prev = sequence.get(i - 1);
            int curr = sequence.get(i);

            if (curr != prev) isConstant = false;
            if (curr <= prev) isAscending = false;
            if (curr < prev) isWeaklyAscending = false;
            if (curr >= prev) isDescending = false;
            if (curr > prev) isWeaklyDescending = false;
        }

        if (isConstant) return CONSTANT;
        if (isAscending) return ASCENDING;
        if (isWeaklyAscending) return WEAKLY_ASCENDING;
        if (isDescending) return DESCENDING;
        if (isWeaklyDescending) return WEAKLY_DESCENDING;

        return RANDOM;
    }
}
