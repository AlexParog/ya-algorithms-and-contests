package org.parog.contests.contest2_SumBackSchool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Продавец рыбы
 * <p>
 * <a href="https://youtu.be/mHZYsmALlMw?t=879">Разбор задачи</a>
 */
public class BuyerFishTaskB {
    public static void main(String[] args) throws IOException {
        int numCases = 1;
        while (numCases-- > 0) {
            process();
        }
    }

    public static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numElements = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());

        long result = 0;
        Deque<Pair> dq = new LinkedList<>();
        int[] takenCount = new int[numElements];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numElements; ++i) {
            int value = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekFirst().index <= i - windowSize) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast().value >= value) {
                dq.pollLast();
            }
            dq.addLast(new Pair(value, i));
            result += dq.peekFirst().value;
            takenCount[dq.peekFirst().index]++;
        }

        out.println(result);
        for (int i = 0; i < numElements; ++i) {
            out.print(takenCount[i] + " ");
        }
        out.println();
        out.flush();
    }

    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}