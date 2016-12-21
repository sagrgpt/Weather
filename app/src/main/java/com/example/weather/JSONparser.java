package com.example.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONparser {
    public static Weather parseFeed(JSONObject obj){
        try{
            Weather weather = new Weather();
        //Cordinate object
            JSONObject cordinateobj = obj.getJSONObject("coord");
            weather.setLat(Float.valueOf(cordinateobj.getString("lat")));
            weather.setLon(Float.valueOf(cordinateobj.getString("lon")));
        //Weather Array
            JSONArray jArr = obj.getJSONArray("weather");
            JSONObject weatherobj = jArr.getJSONObject(0);
            weather.setWeatherCondition(weatherobj.getString("main"));
            weather.setConditionDescription(weatherobj.getString("description"));
            weather.setIconNo(weatherobj.getString("icon"));
        //Main Object
            JSONObject mainObj = obj.getJSONObject("main");
            weather.setTemp(Double.valueOf(mainObj.getString("temp")));
            weather.setPressure(Float.valueOf(mainObj.getString("pressure")));
            weather.setHumidity(Float.valueOf(mainObj.getString("humidity")));
            weather.setTempMin(Float.valueOf(mainObj.getString("temp_min")));
            weather.setTempMax(Float.valueOf(mainObj.getString("temp_max")));
            weather.setSeaLevel(Float.valueOf(mainObj.getString("sea_level")));
            weather.setGroundLevel(Float.valueOf(mainObj.getString("grnd_level")));
        //Wind Object
            JSONObject windObj = obj.getJSONObject("wind");
            weather.setWindSpeed(Float.valueOf(windObj.getString("speed")));
        //Sys Object
            JSONObject sysObj = obj.getJSONObject("sys");
            weather.setCountry(sysObj.getString("country"));
            weather.setSunrise(Float.valueOf(sysObj.getString("sunrise")));
            weather.setSunset(Float.valueOf(sysObj.getString("sunset")));
        //Name Object
            weather.setCityName(obj.getString("name"));
            return weather;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
