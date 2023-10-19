package org.example.planes.core.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

public class FlightFilter {
    private OffsetDateTime scheduledDeparture;
    private OffsetDateTime scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;

    public FlightFilter(){}

    public FlightFilter(OffsetDateTime scheduledDeparture, OffsetDateTime scheduledArrival, String departureAirport, String arrivalAirport, String status) {
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
    }

    public OffsetDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(OffsetDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public OffsetDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(OffsetDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightFilter that = (FlightFilter) o;
        return Objects.equals(scheduledDeparture, that.scheduledDeparture) && Objects.equals(scheduledArrival, that.scheduledArrival) && Objects.equals(departureAirport, that.departureAirport) && Objects.equals(arrivalAirport, that.arrivalAirport) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduledDeparture, scheduledArrival, departureAirport, arrivalAirport, status);
    }

    @Override
    public String toString() {
        return "FlightFilter{" +
                "scheduledDeparture=" + scheduledDeparture +
                ", scheduledArrival=" + scheduledArrival +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
