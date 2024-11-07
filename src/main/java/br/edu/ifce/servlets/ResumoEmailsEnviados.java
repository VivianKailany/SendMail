package br.edu.ifce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResumoEmailsEnviados extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int n_access = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("TJW")) {
                    n_access = Integer.parseInt(cookie.getValue()) + 1;
                    cookie.setValue(String.valueOf(n_access));
                    response.addCookie(cookie);
                    found = true;
                    break;
                }
            }
        }
        
        if (!found) {
            Cookie newCookie = new Cookie("TJW", "1");
            newCookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(newCookie);
        }

        request.setAttribute("n_access", n_access);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resumoEmailsEnviados.jsp");
        dispatcher.forward(request, response);
    }
}
