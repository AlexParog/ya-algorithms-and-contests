package org.parog.java_section.bank_09122024;

import java.util.LinkedHashMap;
import java.util.Map;

public class CashMachine {
    private Long totalBalance;
    private Map<Integer, Integer> billsAndQuantities;

    public CashMachine(Map<Integer, Integer> billsAndQuantities) {
        this.totalBalance = getSumBillsInCashMachine(billsAndQuantities);
        this.billsAndQuantities = new LinkedHashMap<>(billsAndQuantities);
    }

    public void getCash(String userRequest) {
        if (userRequest == null || userRequest.isEmpty()) {
            throw new IllegalArgumentException("Сумма не валидна");
        }

        long userAmount = Long.parseLong(userRequest);
        if (userAmount <= 0 || userAmount > totalBalance) {
            System.out.println("Невозможно выдать запрошенную сумму: " + userAmount);
            return;
        }

        Map<Integer, Integer> result = new LinkedHashMap<>();
        long remainingAmount = userAmount;

        for (Map.Entry<Integer, Integer> entry : billsAndQuantities.entrySet()) {
            int denomination = entry.getKey(); // номинал купюры
            int quantity = entry.getValue();  // количество купюр

            if (remainingAmount <= 0) {
                break;
            }

            int neededBills = (int) (remainingAmount / denomination); // сколько нужно от текущего номинала
            int usedBills = Math.min(neededBills, quantity); // берем не больше, чем есть в банкомате

            if (usedBills > 0) {
                result.put(denomination, usedBills); // сохраняем результат
                remainingAmount -= (long) usedBills * denomination; // уменьшаем остаток
            }
        }

        if (remainingAmount > 0) {
            System.out.println("Невозможно выдать сумму " + userAmount + ", недостаточно купюр нужных номиналов.");
        } else {
            // Успешно выдаем деньги, обновляем банкомат
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                int denomination = entry.getKey();
                int count = entry.getValue();
                billsAndQuantities.put(denomination, billsAndQuantities.get(denomination) - count);
            }

            totalBalance -= userAmount;
            System.out.println("Успешно выдано " + userAmount + ": " + result);
        }
    }


    private Long getSumBillsInCashMachine(Map<Integer, Integer> billsAndQuantities) {
        long totalSum = 0;

        for (Map.Entry<Integer, Integer> entry : billsAndQuantities.entrySet()) {
            totalSum += (long) entry.getKey() * entry.getValue();
        }
        return totalSum;
    }

    public Long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Long totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Map<Integer, Integer> getBillsAndQuantities() {
        return billsAndQuantities;
    }

    public void setBillsAndQuantities(Map<Integer, Integer> billsAndQuantities) {
        this.billsAndQuantities = billsAndQuantities;
    }
}