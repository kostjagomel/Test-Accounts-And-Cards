package test.accountsandcards.http;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.accountsandcards.http.logging.HttpLoggingInterceptor;
import test.accountsandcards.http.model.Card;
import test.accountsandcards.http.model.MainJson;

public class HttpHelper {

    private static HttpHelper helper;
    private static Retrofit retrofit;
    private static Api api;

    public static synchronized HttpHelper getInstance() {
        if (helper == null) {
            helper = new HttpHelper();
            helper.init();
        }
        return helper;
    }

    public void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public void getContent(final HttpCallback httpCallback ){
        Call<MainJson> mainJsonCall = api.getMainContent();

        mainJsonCall.enqueue(new retrofit2.Callback<MainJson>() {
            @Override
            public void onResponse(Call<MainJson> call, Response<MainJson> response) {
                if(response.isSuccessful()){
                    List<Card> cards = (List<Card>) response.body().getCards();
                    List<test.accountsandcards.buisness.model.Card> modelCards = new ArrayList<>();

                    for (Card card:cards){
                        modelCards.add(new test.accountsandcards.buisness.model.Card(
                                card.getCardTitle(),
                                card.getCardAmount(),
                                card.getCardCurrency(),
                                card.getCardAccountType(),
                                card.getAccountNumber()));
                    }
                    httpCallback.responce(modelCards);
                }
            }

            @Override
            public void onFailure(Call<MainJson> call, Throwable t) {
                httpCallback.showError();
            }
        });

    }

    public interface HttpCallback {
        void responce(List<test.accountsandcards.buisness.model.Card> cards);
        void showError();
    }
}
