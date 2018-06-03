package test.accountsandcards.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test.accountsandcards.http.model.MainJson;

public interface Api {

    @GET("/Traz9g/alseda/master/json")
    Call<MainJson> getMainContent();
}
