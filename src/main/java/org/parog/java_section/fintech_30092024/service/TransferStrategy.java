package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;

public interface TransferStrategy {
    void transferTo(Account from, Account to, Money amount);
}
