package org.parog.contests.contest_SpringSummer2024;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * C. Пересекающиеся отрезки
 * <p>
 * Done
 */
public class IntersectingSectionsTaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amountOfSegmentsN = Integer.parseInt(reader.readLine());
        Segment[] segments = new Segment[amountOfSegmentsN];

        // Читаем координаты отрезков.
        for (int i = 0; i < amountOfSegmentsN; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            segments[i] = new Segment(start, end);
        }

        // Сортируем отрезки по их начальным координатам (а если они одинаковы, то по конечным координатам).
        Arrays.sort(segments, (s1, s2) -> {
            if (s1.start != s2.start) {
                return Integer.compare(s1.start, s2.start);
            } else {
                return Integer.compare(s1.end, s2.end);
            }
        });

        int[] bad = new int[amountOfSegmentsN];
        int currentMaxEndOfSegment = 0;

        // Проверяем пересечение слева направо
        for (int i = 0; i < amountOfSegmentsN; i++) {
            Segment segment = segments[i];
            if (segment.end <= currentMaxEndOfSegment) {
                bad[i] = 1;
            }
            currentMaxEndOfSegment = Math.max(currentMaxEndOfSegment, segment.end);
        }

        int currentMinEndOfSegment = Integer.MAX_VALUE;

        // Проверяем пересечение справа налево
        for (int i = amountOfSegmentsN - 1; i >= 0; i--) {
            Segment segment = segments[i];
            if (segment.end >= currentMinEndOfSegment) {
                bad[i] = 1;
            }
            currentMinEndOfSegment = Math.min(currentMinEndOfSegment, segment.end);
        }

        int result = 0;
        for (int i = 0; i < amountOfSegmentsN; ++i) {
            result += (bad[i] == 0) ? 1 : 0;
        }

        writer.write(result + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
