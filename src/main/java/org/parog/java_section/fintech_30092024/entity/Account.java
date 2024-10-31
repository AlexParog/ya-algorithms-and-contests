package org.parog.java_section.fintech_30092024.entity;

public class Account {
    private final Long id;
    private final String owner;
    private Money balance;

    public Account(Long id, String owner, Money balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getTotalBalance() {
        return balance.toString();
    }
}
