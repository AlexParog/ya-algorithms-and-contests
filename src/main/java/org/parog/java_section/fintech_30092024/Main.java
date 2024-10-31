package org.parog.java_section.fintech_30092024;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;
import org.parog.java_section.fintech_30092024.service.StandardTransferStrategy;
import org.parog.java_section.fintech_30092024.service.TransferService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        StandardTransferStrategy standardTransferStrategy = new StandardTransferStrategy();
        TransferService transferService = new TransferService(standardTransferStrategy);
        // Создать два аккаунта
        Account sonAcc = new Account(1L, "Son", Money.dollars(new BigDecimal(100)));
        Account dadAcc = new Account(2L, "Dad", Money.dollars(new BigDecimal(10000)));

        // пример 1: перевести сумму с аккаунта отца на счет сына
        transferService.executeTransfer(dadAcc, sonAcc, Money.dollars(new BigDecimal(1000)));
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());

        // пример 2: перевести сумму отцу, превышающую общую сумму денег на счет сына (обработка ошибки)
        transferService.executeTransfer(sonAcc, dadAcc, Money.dollars(new BigDecimal(5000)));

        // пример 3: создать третий счет (матери) и перевести одновременно с аккаунта матери на счет отцу и сыну
        Account momAcc = new Account(3L, "Mom", Money.dollars(new BigDecimal(5000)));
        //TODO: проверка многопоточности (как проверить такой кейс?)
        transferService.executeTransfer(momAcc, dadAcc, Money.dollars(new BigDecimal(500)));
        transferService.executeTransfer(momAcc, sonAcc, Money.dollars(new BigDecimal(4500)));

        System.out.println(momAcc.getTotalBalance());
        System.out.println(dadAcc.getTotalBalance());
        System.out.println(sonAcc.getTotalBalance());


    }
}
