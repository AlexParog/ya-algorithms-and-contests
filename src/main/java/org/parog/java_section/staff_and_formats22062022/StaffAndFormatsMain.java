package org.parog.java_section.staff_and_formats22062022;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Читаем данные из файлов, находим сотрудников с наибольшим стажем для каждой должности
 * и записываем результаты в новый файл.
 */
public class StaffAndFormatsMain {
    public static void main(String[] args) {
        try {
            List<Employee> employees = FileParser.parseEmployees("src/main/java/org/parog/java_section/staff_and_formats22062022/employees.txt");
            List<Position> positions = FileParser.parsePositions("src/main/java/org/parog/java_section/staff_and_formats22062022/positions.txt");

            Map<String, Employee> olds = findEmployeesWithMaxExperience(employees);

            FileWriter.writeEmployeesWithPositions(olds, positions, "employees_with_positions.txt");

            System.out.println("Данные успешно записаны в файл employees_with_positions.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Находит сотрудников с наибольшим стажем для каждой должности.
     *
     * @param employees список сотрудников
     * @return карта, где ключ — код должности, а значение — сотрудник с наибольшим стажем
     */
    private static Map<String, Employee> findEmployeesWithMaxExperience(List<Employee> employees) {
        Map<String, Employee> maxExperienceEmployees = new HashMap<>();

        for (Employee employee : employees) {
            String positionCode = employee.getPositionCode();
            Employee currentMax = maxExperienceEmployees.get(positionCode);

            if (currentMax == null || currentMax.getExperience() < employee.getExperience()) {
                maxExperienceEmployees.put(positionCode, employee);
            }
        }

        return maxExperienceEmployees;
    }
}
