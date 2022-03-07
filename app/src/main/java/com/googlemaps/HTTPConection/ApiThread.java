package com.googlemaps.HTTPConection;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiThread extends AsyncTask<Void, Void, String> {
    public ApiThread() {

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // Read API results
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data = bufferedReader.readLine();
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(String data) {
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(data);

            jObject = jObject.getJSONObject("results");

            String sunrise = jObject.getString("sunrise");
            Log.i("logtest", "------>" + sunrise);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
