package org.parog.java_section.bank_09122024;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine(Map.of(
                5000, 3,
                1000, 10,
                500, 10,
                100, 10,
                50, 10));


        System.out.println("Остаток в банкомате: " + cashMachine.getTotalBalance());

        cashMachine.getCash("13500"); // Успешно выдаст [5000 x 2, 1000 x 3, 500 x 1]
        System.out.println("Остаток в банкомате: " + cashMachine.getTotalBalance());

        cashMachine.getCash("12345"); // Невозможно выдать
        System.out.println("Остаток в банкомате: " + cashMachine.getTotalBalance());

        cashMachine.getCash("500"); // Успешно выдаст [500 x 1]
        System.out.println("Остаток в банкомате: " + cashMachine.getTotalBalance());
    }
}
