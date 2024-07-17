package org.parog.algorithm_training_5.section3;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Костя успешно прошел собеседование и попал на стажировку в отдел разработки сервиса «Музыка».
 * Конкретно ему поручили такое задание — научиться подбирать плейлист для группы друзей, родственников или коллег.
 * При этом нужно подобрать такой плейлист, в который входят исключительно нравящиеся всем членам группы песни.
 * Костя очень хотел выполнить это задание быстро и качественно, но у него не получается. Помогите ему написать программу,
 * которая составляет плейлист для группы людей.
 */
public class TaskA {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int members = Integer.parseInt(reader.readLine());
            Set<String> songsAllMembers = new HashSet<>();

            // если один человек в группе
            if (members == 1) {
                int numberOfSongs = Integer.parseInt(reader.readLine());
                String[] songs = reader.readLine().split(" ");
                songsAllMembers.addAll(List.of(songs));

                writer.write(String.valueOf(songsAllMembers.size()));
                writer.newLine();
                writer.write(printSongs(songsAllMembers));

                return;
            }

            for (int i = 0; i < members; i++) {
                int numberOfMemberSongs = Integer.parseInt(reader.readLine());
                Set<String> memberFavSongs = new HashSet<>(List.of(reader.readLine().split(" ")));

                if (i == 0) {
                    songsAllMembers.addAll(memberFavSongs);
                } else {
                    songsAllMembers.retainAll(memberFavSongs);
                }
            }

            writer.write(String.valueOf(songsAllMembers.size()));
            writer.newLine();
            writer.write(printSongs(songsAllMembers));
        }
    }

    /**
     * Преобразуем Set<String> в строку, с условием лексикографического порядка
     *
     * @param songsAllMembers любимые песни всех участников
     * @return песни в лексикографическом порядке
     */
    public static String printSongs(Set<String> songsAllMembers) {
        return songsAllMembers.stream()
                .sorted()
                .collect(Collectors.joining(" "));
    }
}