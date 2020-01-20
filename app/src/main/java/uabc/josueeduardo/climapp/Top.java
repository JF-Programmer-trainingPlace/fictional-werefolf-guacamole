package uabc.josueeduardo.climapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import uabc.josueeduardo.climapp.Adapter.DayAdapter;
import uabc.josueeduardo.climapp.Model.Day;

public class Top extends AppCompatActivity {

    RecyclerView recyclerView;
    DayAdapter adapter;
    List<Day> week;
    String API = "cd07e0fa59ab39e593f6352e03b778f3";
    String CITY ="";
    List<String> favs = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        week=new ArrayList<>();

        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new WeatherTask1().execute();
        new WeatherTask2().execute();
        new WeatherTask3().execute();

      //  week.add(
        //        new Day(
          //              "Very cool",
            //            "Hot",
              //          "13.3 inch, Silver, 1.35 kg"));

        //week.add(
          //      new Day(
            //            "Not cool",
              //          "very hot",
                //        "14 inch, Gray, 1.659 kg"));

        //week.add(
          //      new Day(
            //            "Cool",
              //          "Supa hot",
                //        "13.3 inch, Silver, 1.35 kg"));

        adapter=new DayAdapter(this,week);
        recyclerView.setAdapter(adapter);

    }


    private class WeatherTask1 extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + "Mexicali" + "&units=metric&appid=" + API);
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

            } catch (JSONException e) {
            }

        }
    }

    private class WeatherTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + "San diego" + "&units=metric&appid=" + API);
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
            } catch (JSONException e) {

            }

        }
    }

    private class WeatherTask3 extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            findViewById(R.id.loader2).setVisibility(View.VISIBLE);
            findViewById(R.id.rv).setVisibility(View.GONE);

        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + "Barcelona" + "&units=metric&appid=" + API);
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
