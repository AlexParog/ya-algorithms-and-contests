package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;

/**
 * Интерфейс TransferStrategy определяет общий метод для стратегий перевода,
 * обеспечивая возможность применения различных правил перевода в зависимости от типа аккаунта.
 */
public interface TransferStrategy {
    /**
     * Выполняет перевод средств с одного счета на другой.
     *
     * @param from   счет отправителя
     * @param to     счет получателя
     * @param amount сумма перевода
     */
    void transferTo(Account from, Account to, Money amount);
}
