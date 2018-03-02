package model;

/**
 * Created by Veraj on 2018-03-01.
 */

public class Place {
    private float lon;
    private float lat;
    private long senset;
    private long sunrise;
    private String country;
    private String city;
    private long last_update;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public long getSenset() {
        return senset;
    }

    public void setSenset(long senset) {
        this.senset = senset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getLast_update() {
        return last_update;
    }

    public void setLast_update(long last_update) {
        this.last_update = last_update;
    }
}







