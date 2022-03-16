package org.openjfx;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class WeatherResult {
    private Long dt;
    private Float temp;
    private Float feels_like;
    private int pressure;
    private int humidity;
    private Float wind_speed;
    public String getTemp(){
        return String.valueOf(temp);
    }
    public String getDt(){
        return LocalDateTime.ofEpochSecond(dt, 0, ZoneOffset.UTC).toString();
    }
    public Long getDtFloat(){
        return dt;
    }
    public Float getTempFloat() {
        return temp;
    }
    public WeatherResult(){
    }
}
