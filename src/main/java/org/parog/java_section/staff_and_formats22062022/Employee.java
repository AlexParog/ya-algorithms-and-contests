package org.parog.java_section.staff_and_formats22062022;

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private int experience;
    private String positionCode;

    public Employee() {
    }

    public Employee(String lastName, String firstName, String middleName, int experience, String positionCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.experience = experience;
        this.positionCode = positionCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", experience=" + experience +
                ", positionCode='" + positionCode + '\'' +
                '}';
    }
}
