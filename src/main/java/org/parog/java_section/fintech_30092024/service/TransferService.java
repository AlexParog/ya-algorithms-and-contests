package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;
import org.parog.java_section.fintech_30092024.entity.PremiumAccount;
import org.parog.java_section.fintech_30092024.entity.StandardAccount;
import org.parog.java_section.fintech_30092024.exception.ErrorTransferException;

/**
 * Класс TransferService обеспечивает выполнение денежных переводов между счетами
 * с использованием подходящей стратегии перевода, основанной на типе аккаунта.
 * Класс также реализует валидацию суммы перевода и логгирование успешных транзакций.
 */
public class TransferService {

    /**
     * Выполняет перевод средств между счетами с использованием подходящей стратегии перевода.
     * Метод синхронизирован для обеспечения потокобезопасности.
     *
     * @param from   счет отправителя
     * @param to     счет получателя
     * @param amount сумма перевода
     * @throws ErrorTransferException если сумма перевода превышает текущий баланс счета отправителя
     */
    public synchronized void executeTransfer(Account from, Account to, Money amount) {
        TransferStrategy transferStrategy = selectStrategy(from);

        if (!validateTransferAmount(from, to, amount)) {
            throw ErrorTransferException.errorTransferException(
                    "The transfer amount={0} cannot be more than the current account amount={1}",
                    amount.toString(), from.getBalance().toString()
            ).get();
        }
        transferStrategy.transferTo(from, to, amount);
        logTransaction(from, to, amount);
    }

    /**
     * Определяет стратегию перевода в зависимости от типа аккаунта.
     *
     * @param account счет отправителя
     * @return соответствующая стратегия перевода для переданного счета
     * @throws IllegalArgumentException если тип аккаунта не распознан
     */
    private TransferStrategy selectStrategy(Account account) {
        if (account instanceof StandardAccount) {
            return new StandardTransferStrategy();
        } else if (account instanceof PremiumAccount) {
            return new PremiumTransferStrategy();
        } else {
            throw new IllegalArgumentException("Unknown account type");
        }
    }

    /**
     * Проверяет, что сумма перевода не превышает баланс счета отправителя.
     *
     * @param from   счет отправителя
     * @param to     счет получателя
     * @param amount сумма перевода
     * @return true, если сумма перевода допустима, иначе false
     */
    private boolean validateTransferAmount(Account from, Account to, Money amount) {
        return from != null && to != null && amount.getAmount().compareTo(from.getBalance().getAmount()) < 1;
    }

    /**
     * Логгирует успешное выполнение транзакции, включая данные о счетах и сумму перевода.
     *
     * @param from   счет отправителя
     * @param to     счет получателя
     * @param amount сумма перевода
     */
    private void logTransaction(Account from, Account to, Money amount) {
        System.out.printf("Transaction from=%s to=%s completed. Amount:%s%n", from.getOwner(),
                to.getOwner(), amount.toString());
    }
}
