package com.example.admin.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=d7b900681c37193223281142%20bd919019";
    TextView Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = (TextView) findViewById(R.id.display);
        new getInfo().execute();

    }
        class getInfo extends AsyncTask<Void, String, Void> {


            @Override
            protected Void doInBackground(Void... params) {

                JSONGetter jsonGetter = new JSONGetter(URL);
                String json = jsonGetter.getJSON();

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("Weather");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject temp = jsonArray.getJSONObject(i);
                        String id = temp.getString("id");
                        String main = temp.getString("main");
                        String description = temp.getString("description");

                        publishProgress(id + "/n" + main + "/n" + description);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
                Display.setText(values[0]);
            }
        }


    }

