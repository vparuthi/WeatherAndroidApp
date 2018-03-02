package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

/**
 * Created by Veraj on 2018-03-01.
 */

public class WeatherHttpClient {

    public String getWeatherData (String place){
        HttpURLConnection connection = null; //this is the object that will connect
        InputStream inputStream = null; //this is the object that will intitally recieves the bytes of data

        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            //Read the response
            StringBuffer stringBuffer = new StringBuffer(); //think of this like a bucket for all the data
            inputStream = connection.getInputStream(); //it is reciving bytes of data that we cannot directly read

            //bufferReader is the only thing that can read the bytes that inputStream has
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null){ // this parse's the data
                stringBuffer.append(line + "\r\n"); //as it reads a line it creates a new one to keep it organized
                //append means add to the 'string'
            }
            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString(); //needs to be converted to type String

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
