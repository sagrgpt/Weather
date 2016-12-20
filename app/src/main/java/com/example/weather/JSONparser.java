package com.example.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONparser {
    public static Weather parseFeed(JSONObject obj){
        try{
            Weather weather = new Weather();

            JSONObject cordinateobj = obj.getJSONObject("coord");
            weather.setLat(Float.valueOf(cordinateobj.getString("lat")));
            weather.setLon(Float.valueOf(cordinateobj.getString("lon")));
            weather.setCityName(obj.getString("name"));

            JSONArray jArr = obj.getJSONArray("weather");
            JSONObject weatherboj = jArr.getJSONObject(0);
            weather.setWeatherDescription(weatherboj.getString("description"));

            return weather;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
