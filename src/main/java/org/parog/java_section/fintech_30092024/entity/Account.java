package org.parog.java_section.fintech_30092024.entity;

/**
 * Абстрактный класс Account представляет банковский счет с основными полями,
 * такими как идентификатор, владелец и баланс. Этот класс служит базой для
 * различных типов счетов, которые могут отличаться комиссией или лимитами на перевод.
 * <p>
 * Наследуемые классы, такие как {@link StandardAccount} и {@link PremiumAccount}, могут
 * иметь различные условия и ограничения на операции перевода.
 * </p>
 */
public abstract class Account {

    /**
     * Уникальный идентификатор счета.
     */
    private final Long id;

    /**
     * Имя владельца счета.
     */
    private final String owner;

    /**
     * Баланс счета, представленный объектом {@link Money}.
     */
    private Money balance;

    /**
     * Конструктор для создания счета с заданными идентификатором, именем владельца и начальным балансом.
     *
     * @param id      уникальный идентификатор счета
     * @param owner   имя владельца счета
     * @param balance начальный баланс счета
     */
    public Account(Long id, String owner, Money balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * Возвращает уникальный идентификатор счета.
     *
     * @return идентификатор счета
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает имя владельца счета.
     *
     * @return имя владельца
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Возвращает текущий баланс счета.
     *
     * @return объект {@link Money}, представляющий баланс счета
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс счета.
     *
     * @param balance объект {@link Money}, представляющий новый баланс счета
     */
    public void setBalance(Money balance) {
        this.balance = balance;
    }

    /**
     * Возвращает строковое представление баланса счета, используя метод {@link Money#toString()}.
     *
     * @return строковое представление текущего баланса счета
     */
    public String getTotalBalance() {
        return balance.toString();
    }
}

