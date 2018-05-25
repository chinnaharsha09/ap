package chinna.com.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import chinna.com.retrofitexample.Adaptors.ProfileAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView detailsContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detailsContainer = findViewById(R.id.details_container);
        detailsContainer.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<JsonArray> call = apiService.getProfiles();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray>call, Response<JsonArray> response) {
                List<ProfilesVO> profiles = new ArrayList<ProfilesVO>();
                String result = response.body().toString();
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ProfilesVO profilesVO = new ProfilesVO(jsonObject.getString("id"), jsonObject.getString("name"),jsonObject.getString("age"), jsonObject.getString("gender"), jsonObject.getString("address"), jsonObject.getString("date"));
                        profiles.add(profilesVO);
                    }
                    detailsContainer.setAdapter(new ProfileAdapter(profiles, getApplicationContext()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                Log.d("Data from server", "Number of movies received: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonArray>call, Throwable t) {
                // Log error here since request failed
                Log.e("Data from server", t.toString());
            }
        });
    }
}
