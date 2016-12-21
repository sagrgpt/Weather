package com.example.weather;

import android.app.ProgressDialog;
import android.content.Context;
import android.icu.text.DecimalFormat;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//
    private static final String TAG = "ParserJSONObject";


    private TextView geoLocation;
    private TextView temp;
    private TextView weatherCondition;
    private ImageView weatherIcon;
    private Weather weather;
    private String baseURL = "http://api.openweathermap.org/data/2.5/weather?";
    private String appid= "&appid=66451ecc6b1c2babaf8f5ecaf52aa932";
    String URLcriteria;
    private String url;
    ProgressDialog pDialog;
    LocationManager locationManager;
    Double latitude;
    Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        connection();

    }

    private void connection(){

        geoLocation = (TextView) findViewById(R.id.geoLocation);
        weatherCondition = (TextView) findViewById(R.id.weatherCondition);
        temp = (TextView) findViewById(R.id.weatherTemp);
        weatherIcon = (ImageView) findViewById(R.id.weatherIcon);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = LocationManager.NETWORK_PROVIDER;
        try {
            Location location = locationManager.getLastKnownLocation(provider);
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }catch(SecurityException e){
            e.printStackTrace();
        }
        URLcriteria = "lat="+latitude+"&lon="+longitude;
        url = baseURL+URLcriteria+appid;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                weather = JSONparser.parseFeed(response);
                geoLocation.setText(weather.getCityName());
                weatherCondition.setText(weather.getWeatherCondition());
                temp.setText(weather.getTemp()+"\u2103");
                weatherIcon.setImageResource(R.drawable.summericon);
                pDialog.hide();

                Log.d(TAG,response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: "+ error.getMessage());
                pDialog.hide();
            }
        });


        Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);
    }
}
