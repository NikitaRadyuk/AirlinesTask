package org.example.planes.controllers.servlets.Html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.planes.core.dto.Aircraft;
import org.example.planes.service.api.IAircraftService;
import org.example.planes.service.factory.AircraftServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/html/aircrafts")
public class AircraftServletHTML extends HttpServlet {
    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Aircraft> planes = this.aircraftService.getAll();
            req.setAttribute("planes", planes);
            req.getRequestDispatcher("/views/aircraft.jsp").forward(req,resp);
        } catch(ServletException e){
            throw new ServletException("Ошибка при отображении аэропортов", e);
        }
    }
}
