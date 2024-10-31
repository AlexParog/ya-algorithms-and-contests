package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.exception.ErrorTransferException;
import org.parog.java_section.fintech_30092024.entity.Money;

public class TransferService {
    private final TransferStrategy transferStrategy;

    public TransferService(TransferStrategy transferStrategy) {
        this.transferStrategy = transferStrategy;
    }

    public void executeTransfer(Account from, Account to, Money amount) {
        if (!validateAccounts(from, to, amount)) {
            throw new ErrorTransferException(String.format("The transfer amount=%s cannot be more than the current " +
                    "account amount=%s", amount.toString(), from.getBalance().toString()));
        }
        transferStrategy.transferTo(from, to, amount);
        logTransaction(from, to, amount);
    }

    private boolean validateAccounts(Account from, Account to, Money amount) {
        return from != null && to != null && amount.getAmount().compareTo(from.getBalance().getAmount()) < 1;
    }

    private void logTransaction(Account from, Account to, Money amount) {
        System.out.printf("Transaction from=%s to=%s completed. Amount:%s%n", from.getOwner(),
                to.getOwner(), amount.toString());
    }
}
