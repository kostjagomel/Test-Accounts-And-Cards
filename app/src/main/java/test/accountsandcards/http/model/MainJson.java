package test.accountsandcards.http.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainJson {
    ErrorInfo errorInfo;
    List<Card> cards;
}
