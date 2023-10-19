package org.example.planes.core.dto;

import java.util.Objects;

public class Airport {
    private String airportCode;
    private String airportName;
    private String city;
    private String point;
    private String timezone;

    public Airport() {
    }

    public Airport(String airportCode, String airportName, String city, String point, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.point = point;
        this.timezone = timezone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCity() {
        return city;
    }

    public String getPoint() {
        return point;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportCode, airport.airportCode) && Objects.equals(airportName, airport.airportName) && Objects.equals(city, airport.city) && Objects.equals(point, airport.point) && Objects.equals(timezone, airport.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode, airportName, city, point, timezone);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName=" + airportName +
                ", city=" + city +
                ", point='" + point + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}

