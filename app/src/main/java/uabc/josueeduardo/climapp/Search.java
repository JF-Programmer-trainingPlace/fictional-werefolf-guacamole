package uabc.josueeduardo.climapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uabc.josueeduardo.climapp.Adapter.DayAdapter;
import uabc.josueeduardo.climapp.Model.Day;

public class Search extends AppCompatActivity {

    RecyclerView recyclerView;
    DayAdapter adapter;
    List<Day> week;
    String API = "cd07e0fa59ab39e593f6352e03b778f3";
    String city="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        week=new ArrayList<>();

        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new DayAdapter(this,week);
        recyclerView.setAdapter(adapter);
    }

    public void search(View view) {
        new SearchWeatherTask().execute();
    }

    private class SearchWeatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SearchView searchView=findViewById(R.id.simpleSearchView);

            city=searchView.getQuery().toString();
            findViewById(R.id.loader2).setVisibility(View.VISIBLE);
            findViewById(R.id.rv).setVisibility(View.GONE);
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            try {

                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                String temp = main.getString("temp") + "°C";

                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                Day day=new Day(weatherDescription,temp,address);
                week.add(day);
                findViewById(R.id.loader2).setVisibility(View.GONE);
                findViewById(R.id.rv).setVisibility(View.VISIBLE);

            } catch (JSONException e) {
            }

        }
    }

}
