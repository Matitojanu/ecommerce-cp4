package pl.januszkiewicz.creditcard;


import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;
    private BigDecimal balance;
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignCredit(BigDecimal creditLimit) {
        if (isCreditAlreadyAssigned()) {
            throw new CreditCantBeAssignedTwiceException();
        }

        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) <= 0;
    }

    public void withdraw(BigDecimal money) {
        if(canAfford(money)) {
            throw new NotEnoughMoneyException();
        }
        this.balance = this.balance.subtract(money);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}