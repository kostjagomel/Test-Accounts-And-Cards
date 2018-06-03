package test.accountsandcards.http.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorInfo {
    String error;
    String errorText;
}
