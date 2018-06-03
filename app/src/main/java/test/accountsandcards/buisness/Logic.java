package test.accountsandcards.buisness;

import android.widget.Toast;

import java.util.List;

import test.accountsandcards.MainActivity;
import test.accountsandcards.buisness.model.Card;
import test.accountsandcards.http.HttpHelper;

import static java.lang.Thread.sleep;

public class Logic {

    private static Logic logic;

    public static synchronized Logic getInstance() {
        if (logic == null) {
            logic = new Logic();
        }
        return logic;
    }

    public void updateContent(final MainActivity mainActivity, final LogicCallback logicCallback){

        HttpHelper.getInstance().getContent(new HttpHelper.HttpCallback() {
            @Override
            public void responce(List<Card> cards) {
                logicCallback.update(cards);
            }

            @Override
            public void showError() {
                Toast.makeText(mainActivity,"Упс, что-то пошло не так",Toast.LENGTH_LONG);
            }
        });
    }

    public interface LogicCallback {
        void update(List<Card> cards);
    }
}
