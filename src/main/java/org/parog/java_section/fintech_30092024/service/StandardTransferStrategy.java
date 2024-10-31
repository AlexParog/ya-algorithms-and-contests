package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;

public class StandardTransferStrategy implements TransferStrategy {
    @Override
    public void transferTo(Account from, Account to, Money amount) {
        // вычитаем средства с текущего счета
        Money subtractionBalance = Money.dollars(from.getBalance().getAmount().subtract(amount.getAmount()));
        from.setBalance(subtractionBalance);
        // пополняем другой счет
        Money transferAmount = Money.dollars(to.getBalance().getAmount().add(amount.getAmount()));
        to.setBalance(transferAmount);
    }
}
