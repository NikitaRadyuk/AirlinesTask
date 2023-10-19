package org.example.planes.controllers.servlets.Html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.planes.core.dto.Airport;
import org.example.planes.service.api.IAirportService;
import org.example.planes.service.factory.AirportServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/html/airports")
public class AirportServletHTML extends HttpServlet {
    private IAirportService airportService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<Airport> airports = this.airportService.getAll();
            req.setAttribute("airports", airports);
            req.getRequestDispatcher("/views/airport.jsp").forward(req,resp);
        } catch(ServletException e){
            throw new ServletException("Ошибка при отображении аэропортов", e);
        }
    }
}
