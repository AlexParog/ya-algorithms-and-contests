package org.parog.java_section.staff_and_formats22062022;

public class Position {
    private String positionCode;
    private String positionName;

    public Position() {
    }

    public Position(String positionCode, String positionName) {
        this.positionCode = positionCode;
        this.positionName = positionName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionCode='" + positionCode + '\'' +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
