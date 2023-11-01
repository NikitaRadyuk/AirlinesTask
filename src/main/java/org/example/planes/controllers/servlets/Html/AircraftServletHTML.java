package org.example.planes.controllers.servlets.Html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.planes.core.dto.Aircraft;
import org.example.planes.core.factory.AppContextFactory;
import org.example.planes.service.api.IAircraftService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/html/aircrafts")
public class AircraftServletHTML extends HttpServlet {

    private final IAircraftService service;

    public AircraftServletHTML() {
        this.service = AppContextFactory.getBean(IAircraftService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aircraft> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/view/aircrafts.jsp").forward(req, resp);
    }
}
