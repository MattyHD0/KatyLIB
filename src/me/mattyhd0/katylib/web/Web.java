package me.mattyhd0.katylib.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Web {

    public static String getStringFromUrl(String url){

        try {

            URL urlObject = new URL(url);
            URLConnection urlConnection = urlObject.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String response = "";
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                response = response + line;

            }

            bufferedReader.close();
            return response;
        } catch (IOException e){
            return null;
        }

    }

}
