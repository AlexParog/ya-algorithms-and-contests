package org.parog.java_section.fintech_30092024.entity;

import java.math.BigDecimal;

/**
 * Класс StandardAccount представляет стандартный банковский счет,
 * который имеет установленную комиссию и лимит перевода.
 * <p>
 * Комиссия применяется к переводам, если сумма превышает определенный лимит.
 * </p>
 */
public class StandardAccount extends Account {

    /**
     * Процентная ставка комиссии для стандартного счета.
     * Комиссия составляет 5% от суммы перевода при превышении лимита.
     */
    private final BigDecimal commissionRate = new BigDecimal("0.05");

    /**
     * Лимит перевода, после превышения которого применяется комиссия.
     */
    private final BigDecimal transferLimit = new BigDecimal("10000");

    /**
     * Конструктор для создания стандартного счета с заданными идентификатором, владельцем и балансом.
     *
     * @param id      уникальный идентификатор счета
     * @param owner   имя владельца счета
     * @param balance начальный баланс счета
     */
    public StandardAccount(Long id, String owner, Money balance) {
        super(id, owner, balance);
    }

    /**
     * Возвращает процентную ставку комиссии для стандартного счета.
     *
     * @return процентная ставка комиссии
     */
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    /**
     * Возвращает лимит перевода для стандартного счета, после которого применяется комиссия.
     *
     * @return лимит перевода
     */
    public BigDecimal getTransferLimit() {
        return transferLimit;
    }
}
