package com.example.veraj.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import data.JSONWeatherParser;
import data.WeatherHttpClient;
import model.Weather;

public class MainActivity extends AppCompatActivity {

    private TextView cityName;
    private TextView temp;
    private ImageView iconView;
    private TextView description;
    private TextView humididty;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;

    private static final String TAG = "com.example.veraj.weatherapp";

    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (TextView) findViewById(R.id.city);
        temp = (TextView) findViewById(R.id.temp);
        iconView = (ImageView) findViewById(R.id.icon);
        description = (TextView) findViewById(R.id.cloud);
        humididty = (TextView) findViewById(R.id.humidity);
        pressure = (TextView) findViewById(R.id.pressure);
        wind = (TextView) findViewById(R.id.wind);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);
        updated = (TextView) findViewById(R.id.updated);

        renderWeatherData("Spokane,US");
    }

    public void renderWeatherData(String city){
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city + "&appid="+"bd2afbf295e7cc104ea151d3c8ca2a35"});
    }

    private class WeatherTask extends AsyncTask<String, Void, Weather>{
        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
        }

        @Override
        protected Weather doInBackground(String... strings) {
            String data = ((new WeatherHttpClient().getWeatherData(strings[0])));
            weather = JSONWeatherParser.getWeather(data);
            Log.i(TAG,"Data: " + weather.place.getCity());
            return weather;
        }
    }
}
