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
}
