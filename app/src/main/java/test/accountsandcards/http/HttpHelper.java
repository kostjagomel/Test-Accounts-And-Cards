package test.accountsandcards.http;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.accountsandcards.http.model.MainJson;

public class HttpHelper {

    private static HttpHelper helper;
    private static Retrofit retrofit;
    private static Api api;

    public static synchronized HttpHelper getInstance() {
        if (helper == null) {
            helper = new HttpHelper();
        }
        return helper;
    }

    public void init() {

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public void getContent(final HttpCallback httpCallback ){
        Call<MainJson> mainJsonCall = api.getMainContent();

        mainJsonCall.enqueue(new retrofit2.Callback<MainJson>() {
            @Override
            public void onResponse(Call<MainJson> call, Response<MainJson> response) {
                httpCallback.responce(response.body());
            }

            @Override
            public void onFailure(Call<MainJson> call, Throwable t) {
                httpCallback.showError();
            }
        });

    }

    public interface HttpCallback {
        void responce(MainJson mainJson);
        void showError();
    }
}
