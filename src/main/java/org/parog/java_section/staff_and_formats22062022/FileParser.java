package org.parog.java_section.staff_and_formats22062022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Чтение и парсинг данных из файлов.
 */
public class FileParser {

    /**
     * Чтение и парсинг данных о сотрудниках из файла.
     *
     * @param filePath путь к файлу с данными о сотрудниках
     * @return список сотрудников
     * @throws IOException если возникает ошибка при чтении файла
     */
    public static List<Employee> parseEmployees(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            String[] parts = parseLine(line);
            if (parts.length == 5) {
                Employee employee = new Employee();
                employee.setLastName(parts[0]);
                employee.setFirstName(parts[1]);
                employee.setMiddleName(parts[2]);
                employee.setExperience(Integer.parseInt(parts[3]));
                employee.setPositionCode(parts[4]);
                employees.add(employee);
            }
        }

        return employees;
    }

    /**
     * Чтение и парсинг данных о должностях из файла.
     *
     * @param filePath путь к файлу с данными о должностях
     * @return список должностей
     * @throws IOException если возникает ошибка при чтении файла
     */
    public static List<Position> parsePositions(String filePath) throws IOException {
        List<Position> positions = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            String[] parts = parseLine(line);
            if (parts.length == 2) {
                Position position = new Position();
                position.setPositionCode(parts[0]);
                position.setPositionName(parts[1]);
                positions.add(position);
            }
        }

        return positions;
    }

    /**
     * Парсинг строки на части, учитывая кавычки.
     * <p>
     * Если значение заключено в кавычки (одинарные или двойные), оно считается одним токеном.
     *
     * @param line входная строка
     * @return массив строк, представляющих отдельные токены
     */
    private static String[] parseLine(String line) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        char quoteChar = '\0';

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"' || c == '\'') {
                if (inQuotes && c == quoteChar) {
                    // Закрывающая кавычка
                    inQuotes = false;
                    parts.add(current.toString());
                    current.setLength(0); // Очищаем StringBuilder
                } else if (!inQuotes) {
                    // Открывающая кавычка
                    inQuotes = true;
                    quoteChar = c;
                }
            } else if (c == ' ' && !inQuotes) {
                // Пробел вне кавычек — разделитель
                if (current.length() > 0) {
                    parts.add(current.toString());
                    current.setLength(0);
                }
            } else {
                // Добавляем символ в текущий токен
                current.append(c);
            }
        }

        // Добавляем последний токен, если он есть
        if (current.length() > 0) {
            parts.add(current.toString());
        }

        return parts.toArray(new String[0]);
    }
}
