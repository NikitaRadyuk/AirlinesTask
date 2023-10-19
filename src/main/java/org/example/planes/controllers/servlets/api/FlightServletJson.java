package org.example.planes.controllers.servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.service.api.IFlightService;
import org.example.planes.service.factory.FlightServiceFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(urlPatterns = "/api/flights")
public class FlightServletJson extends HttpServlet {
    public static final String PAGE_PARAM = "page";
    public static final String SIZE_PARAM = "size";

    public static final String SCHEDULED_DEPARTURE_PARAM = "scheduled_departure";
    public static final String SCHEDULED_ARRIVAL_PARAM = "scheduled_arrival";
    public static final String DEPARTURE_AIRPORT_PARAM = "departure_airport";
    public static final String ARRIVAL_AIRPORT_PARAM = "arrival_airport";
    public static final String STATUS_PARAM = "status";

    public static final ObjectMapper mapper = new ObjectMapper();
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private final IFlightService service;

    public FlightServletJson() {
        this.service = FlightServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String scheduledDepartureRaw = req.getParameter(SCHEDULED_DEPARTURE_PARAM);
        LocalDate scheduledDeparture = null;
        if(scheduledDepartureRaw != null && !scheduledDepartureRaw.isBlank()){
            scheduledDeparture = LocalDate.parse(scheduledDepartureRaw, formatter);
        }

        String scheduledArrivalRaw = req.getParameter(SCHEDULED_ARRIVAL_PARAM);
        LocalDate scheduledArrival = null;
        if(scheduledArrivalRaw != null && !scheduledArrivalRaw.isBlank()){
            scheduledArrival = LocalDate.parse(scheduledArrivalRaw, formatter);
        }

        String departureAirport = req.getParameter(DEPARTURE_AIRPORT_PARAM);
        String arrivalAirport = req.getParameter(ARRIVAL_AIRPORT_PARAM);
        String status = req.getParameter(STATUS_PARAM);


        String pageRaw = req.getParameter(PAGE_PARAM);
        int page;
        if(pageRaw == null || pageRaw.isBlank()){
            page = 1;
        } else {
            page = Integer.parseInt(pageRaw);
        }
        String sizeRaw = req.getParameter(SIZE_PARAM);
        int size;
        if(sizeRaw == null || sizeRaw.isBlank()){
            size = 50;
        } else {
            size = Integer.parseInt(sizeRaw);
        }

        FlightFilter filter = new FlightFilter(scheduledDeparture, scheduledArrival, departureAirport, arrivalAirport, status);
        Pageable pageable = new Pageable(page, size);

        List<Flight> data = this.service.getPage(filter, pageable);
        resp.setContentType("application/json; charset=utf-8");

        resp.getWriter().write(mapper.writeValueAsString(data));
    }
}
