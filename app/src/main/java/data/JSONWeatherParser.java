package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by Veraj on 2018-03-01.
 */

public class JSONWeatherParser {
    public static Weather getWeather (String data){ //data is the the string that is passed in from WeatherHttpClient
        Weather weather = new Weather();
        //create JSONObject from data
        try {
            JSONObject jsonObject = new JSONObject(data);
            Place place = new Place();

            //Get coord object from online
            JSONObject coordObj = Utils.getObject("coord", jsonObject); //jsonObject is the one we are parsing
            place.setLat(Utils.getFloat("lat", coordObj));
            place.setLon(Utils.getFloat("lon", coordObj));

            //Get the sys object from online
            JSONObject sysObject = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObject));
            place.setLast_update( Utils.getInt("dt", jsonObject));
            place.setSenset(Utils.getInt("sunset", sysObject));
            place.setSunrise(Utils.getInt("sunrise", sysObject));
            place.setCity(Utils.getString("name", jsonObject));
            weather.place = place;

            //weather info
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description", jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main", jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon", jsonWeather));

            JSONObject jsonWind = Utils.getObject("wind", jsonObject);
            weather.wind.setDeg(Utils.getFloat("deg", jsonWind));
            weather.wind.setSpeed(Utils.getFloat("speed", jsonWind));

            JSONObject cloudObj = Utils.getObject("clouds", jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudObj));

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}




