package org.parog.java_section.fintech_30092024;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;
import org.parog.java_section.fintech_30092024.entity.PremiumAccount;
import org.parog.java_section.fintech_30092024.entity.StandardAccount;
import org.parog.java_section.fintech_30092024.service.TransferService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        TransferService transferService = new TransferService();

        // Создать два аккаунта
        Account sonAcc = new StandardAccount(1L, "Son", Money.dollars(new BigDecimal(100)));
        Account dadAcc = new PremiumAccount(2L, "Dad", Money.dollars(new BigDecimal(100_000)));

        // пример 1: перевести сумму с аккаунта отца на счет сына c учетом комиссии перевода с Премиум
        transferService.executeTransfer(dadAcc, sonAcc, Money.dollars(new BigDecimal(25000)));
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());
        // пример 2: перевести сумму с аккаунта сына на счет отца c учетом комиссии перевода со Стандарта
        transferService.executeTransfer(sonAcc, dadAcc, Money.dollars(new BigDecimal(11_000)));
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());

        // пример 3: перевести сумму с аккаунта отца на счет сына без комиссии
        transferService.executeTransfer(dadAcc, sonAcc, Money.dollars(new BigDecimal(1000)));
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());

        // пример 4: перевести сумму с аккаунта сына на счет отца без комиссии
        transferService.executeTransfer(sonAcc, dadAcc, Money.dollars(new BigDecimal(5000)));
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());

        // пример 5: перевести сумму отцу, превышающую общую сумму денег на счет сына (обработка ошибки)
        transferService.executeTransfer(sonAcc, dadAcc, Money.dollars(new BigDecimal(100_000)));

    }
}
