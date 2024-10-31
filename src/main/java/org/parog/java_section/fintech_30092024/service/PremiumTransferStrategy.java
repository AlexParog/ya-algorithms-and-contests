package org.parog.java_section.fintech_30092024.service;

import org.parog.java_section.fintech_30092024.entity.Account;
import org.parog.java_section.fintech_30092024.entity.Money;
import org.parog.java_section.fintech_30092024.entity.PremiumAccount;

import java.math.BigDecimal;

/**
 * Класс PremiumTransferStrategy реализует стратегию перевода средств для премиум-счетов,
 * которая учитывает специфическую для данного типа аккаунтов комиссию за перевод.
 */
public class PremiumTransferStrategy implements TransferStrategy {

    /**
     * Выполняет перевод средств с премиум-счета на другой счет с учетом комиссии.
     *
     * @param from   счет отправителя, предполагается, что это премиум-счет
     * @param to     счет получателя
     * @param amount сумма перевода
     */
    @Override
    public void transferTo(Account from, Account to, Money amount) {
        Money amountAfterCommission = applyCommission((PremiumAccount) from, amount);
        // Вычитаем средства с учетом комиссии с текущего счета отправителя
        Money subtractionBalance = Money.dollars(from.getBalance().getAmount().subtract(amountAfterCommission.getAmount()));
        from.setBalance(subtractionBalance);
        // Пополняем баланс счета получателя без учета комиссии за перевод
        Money transferAmount = Money.dollars(to.getBalance().getAmount().add(amount.getAmount()));
        to.setBalance(transferAmount);
    }

    /**
     * Применяет комиссию к сумме перевода, если она превышает установленный лимит.
     *
     * @param from   премиум-счет отправителя
     * @param amount сумма перевода
     * @return скорректированная сумма с учетом комиссии
     */
    private Money applyCommission(PremiumAccount from, Money amount) {
        if (amount.getAmount().compareTo(from.getTransferLimit()) > 0) {
            BigDecimal commission = amount.getAmount().multiply(from.getCommissionRate());
            return Money.dollars(amount.getAmount().add(commission));
        }
        return amount;
    }
}
