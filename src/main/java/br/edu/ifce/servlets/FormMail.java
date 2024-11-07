package br.edu.ifce.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormMail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("FormMail.jsp");
        dispatcher.forward(request, response);
    }
}
