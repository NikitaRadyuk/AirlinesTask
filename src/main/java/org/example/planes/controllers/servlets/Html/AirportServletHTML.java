package org.example.planes.controllers.servlets.Html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.planes.core.dto.Airport;
import org.example.planes.core.factory.AppContextFactory;
import org.example.planes.service.api.IAirportService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/html/airports")
public class AirportServletHTML extends HttpServlet {

    private final IAirportService service;

    public AirportServletHTML() {
        this.service = AppContextFactory.getBean(IAirportService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/view/airports.jsp").forward(req, resp);
    }
}
