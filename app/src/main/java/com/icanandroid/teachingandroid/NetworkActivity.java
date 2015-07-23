package com.icanandroid.teachingandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class NetworkActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AsyncTask<String, Void, JSONObject> networkTask = new AsyncTask<String, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(String... params) {
                String host = params[0];

                try {
                    URL url = new URL(host);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream inStream = connection.getInputStream();
                    String response = readInputStream(inStream);
                    return new JSONObject(response);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(JSONObject responseObject) {
                super.onPostExecute(responseObject);
                // Do something with the response
            }

            private String readInputStream(InputStream inStream) {
                // Read data from the input stream
                return null;
            }
        };
        networkTask.execute("http://cutecorgipictures.com");
    }
}
