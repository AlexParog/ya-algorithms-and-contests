package org.parog.java_section.staff_and_formats22062022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Запись данных о сотрудниках и их должностях в файл.
 */
public class FileWriter {

    /**
     * Записывает данные о сотрудниках с наибольшим стажем для каждой должности в файл.
     *
     * @param maxExperienceEmployees карта сотрудников с наибольшим стажем (ключ — код должности)
     * @param positions              список должностей
     * @param outputFilePath         путь к выходному файлу
     * @throws IOException если возникает ошибка при записи в файл
     */
    public static void writeEmployeesWithPositions(Map<String, Employee> maxExperienceEmployees,
                                                   List<Position> positions,
                                                   String outputFilePath) throws IOException {
        StringBuilder content = new StringBuilder();

        for (Position position : positions) {
            Employee employee = maxExperienceEmployees.get(position.getPositionCode());

            if (employee != null) {
                content.append(employee.getLastName()).append(" ")
                        .append(employee.getFirstName()).append(" ")
                        .append(employee.getMiddleName()).append(" \"")
                        .append(position.getPositionName()).append("\" ")
                        .append(employee.getExperience()).append("\n");
            }
        }

        Files.write(Paths.get(outputFilePath), content.toString().getBytes());
    }
}
