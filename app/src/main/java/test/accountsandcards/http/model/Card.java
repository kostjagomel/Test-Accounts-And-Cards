package test.accountsandcards.http.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {
    String cardTitle;
    String cardAmount;
    String cardCurrency;
    String cardAccountType;
    String accountNumber;

    public String getCardTitle() {
        return cardTitle;
    }

    public String getCardAmount() {
        return cardAmount;
    }

    public String getCardCurrency() {
        return cardCurrency;
    }

    public String getCardAccountType() {
        return cardAccountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
