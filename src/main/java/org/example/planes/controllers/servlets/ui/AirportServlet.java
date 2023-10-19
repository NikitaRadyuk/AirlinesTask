package org.example.planes.controllers.servlets.ui;

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

@WebServlet(urlPatterns = "/airports")
public class AirportServlet extends HttpServlet {
    private final IAirportService service;

    public AirportServlet() {
        this.service = AirportServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/view/airports.jsp").forward(req, resp);
    }
}
