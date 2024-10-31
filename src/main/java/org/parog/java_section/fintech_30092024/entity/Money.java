package org.parog.java_section.fintech_30092024.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Класс Money представляет денежную сумму с учетом валюты и правила округления.
 * Используется для представления денежных значений на счетах.
 */
public class Money {

    /**
     * Стандартная валюта для операций в долларах США.
     */
    private static final Currency USD = Currency.getInstance("USD");

    /**
     * Режим округления по умолчанию.
     */
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    /**
     * Сумма денег в формате BigDecimal.
     */
    private final BigDecimal amount;

    /**
     * Валюта, в которой представлена денежная сумма.
     */
    private final Currency currency;

    /**
     * Создает объект Money с указанием суммы в долларах США.
     *
     * @param amount сумма в долларах
     * @return объект Money, представляющий указанную сумму в долларах
     */
    public static Money dollars(BigDecimal amount) {
        return new Money(amount, USD);
    }

    /**
     * Конструктор для создания объекта Money с указанной суммой, валютой и режимом округления по умолчанию.
     *
     * @param amount   сумма денег
     * @param currency валюта, в которой представлена сумма
     */
    public Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }

    /**
     * Конструктор для создания объекта Money с указанной суммой, валютой и заданным режимом округления.
     *
     * @param amount   сумма денег
     * @param currency валюта, в которой представлена сумма
     * @param rounding режим округления для суммы
     */
    public Money(BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), rounding);
    }

    /**
     * Возвращает сумму денег.
     *
     * @return сумма в виде BigDecimal
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Возвращает валюту денежной суммы.
     *
     * @return объект {@link Currency}, представляющий валюту
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Возвращает строковое представление денежной суммы в формате "сумма валюта".
     *
     * @return строковое представление суммы и валюты
     */
    @Override
    public String toString() {
        return getAmount() + getCurrency().getSymbol();
    }
}
