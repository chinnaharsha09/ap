package chinna.com.retrofitexample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("profiles")
    Call<JsonArray> getProfiles();

}
