package test.accountsandcards.buisness.model;

public class Card {

    String cardTitle;
    String cardAmount;
    String cardCurrency;
    String cardAccountType;
    String accountNumber;

    public Card(String cardTitle, String cardAmount, String cardCurrency, String cardAccountType, String accountNumber) {
        this.cardTitle = cardTitle;
        this.cardAmount = cardAmount;
        this.cardCurrency = cardCurrency;
        this.cardAccountType = cardAccountType;
        this.accountNumber = accountNumber;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(String cardAmount) {
        this.cardAmount = cardAmount;
    }

    public String getCardCurrency() {
        return cardCurrency;
    }

    public void setCardCurrency(String cardCurrency) {
        this.cardCurrency = cardCurrency;
    }

    public String getCardAccountType() {
        return cardAccountType;
    }

    public void setCardAccountType(String cardAccountType) {
        this.cardAccountType = cardAccountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
