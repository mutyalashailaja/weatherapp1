package com.example.admin.weatherapp;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Admin on 05-12-2016.
 */
public class JSONGetter {

    public String URL;

    public JSONGetter(String URL) {
        this.URL = URL;
    }


    public String getJSON(){

        String json=null;

        HttpGet httpGet=new HttpGet(URL);
        HttpClient httpClient=new DefaultHttpClient();
        try {
            HttpResponse httpResponse=httpClient.execute(httpGet);
            HttpEntity httpEntity=httpResponse.getEntity();
            json=EntityUtils.toString(httpEntity);

            Log.d("here is my data:::",json);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return json;





    }}

