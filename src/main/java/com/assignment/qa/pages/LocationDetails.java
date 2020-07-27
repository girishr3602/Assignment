package com.assignment.qa.pages;

public class LocationDetails {
    private String name;
    private String condition;
    private String windDetails;
    private String humidity;
    private String temperatureInDegrees;
    private String temperatureInFahrenheit;

    public LocationDetails(String name, String condition, String windDetails, String humidity, String temperatureInDegrees, String temperatureInFahrenheit) {
        this(name, condition, windDetails, humidity, temperatureInDegrees);
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }

    public LocationDetails(String name, String condition, String windDetails, String humidity, String temperatureInDegrees) {
        this.name = name;
        this.condition = condition;
        this.windDetails = windDetails;
        this.humidity = humidity;
        this.temperatureInDegrees = temperatureInDegrees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWindDetails() {
        return windDetails;
    }

    public void setWindDetails(String windDetails) {
        this.windDetails = windDetails;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperatureInDegrees() {
        return temperatureInDegrees;
    }

    public void setTemperatureInDegrees(String temperatureInDegrees) {
        this.temperatureInDegrees = temperatureInDegrees;
    }

    public String getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }

    public void setTemperatureInFahrenheit(String temperatureInFahrenheit) {
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }
}
