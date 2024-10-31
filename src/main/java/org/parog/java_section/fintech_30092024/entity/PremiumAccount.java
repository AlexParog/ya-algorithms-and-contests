package org.parog.java_section.fintech_30092024.entity;

import java.math.BigDecimal;

/**
 * Класс PremiumAccount представляет премиум-счет, который имеет сниженный
 * процент комиссии и более высокий лимит на операции перевода.
 */
public class PremiumAccount extends Account {

    /**
     * Процентная ставка комиссии для премиум-счета.
     * Комиссия составляет 1% от суммы перевода при превышении лимита.
     */
    private final BigDecimal commissionRate = new BigDecimal("0.01");

    /**
     * Лимит перевода, после превышения которого применяется комиссия.
     */
    private final BigDecimal transferLimit = new BigDecimal("20000");

    /**
     * Конструктор для создания премиум-счета с заданными идентификатором, владельцем и балансом.
     *
     * @param id      уникальный идентификатор счета
     * @param owner   имя владельца счета
     * @param balance начальный баланс счета
     */
    public PremiumAccount(Long id, String owner, Money balance) {
        super(id, owner, balance);
    }

    /**
     * Возвращает процентную ставку комиссии для премиум-счета.
     *
     * @return процентная ставка комиссии
     */
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    /**
     * Возвращает лимит перевода для премиум-счета, после которого применяется комиссия.
     *
     * @return лимит перевода
     */
    public BigDecimal getTransferLimit() {
        return transferLimit;
    }
}
