package br.edu.ifce.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCredentials
 */
public class CheckCredentials extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String dbPasswd;

    public String getDbPasswd() {
        return dbPasswd;
    }

    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCredentials() {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dbPasswd = config.getInitParameter("admin");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");

        if (isValidCredentials(nomeUsuario, senhaUsuario)) {
            authenticateUser(request, nomeUsuario);
            response.sendRedirect("FormMail");
        } else {
            redirectToLoginPage(request, response);
        }
    }

    /**
     * Valida as credenciais do usuário.
     */
    private boolean isValidCredentials(String nomeUsuario, String senhaUsuario) {
        return nomeUsuario != null && senhaUsuario != null
                && nomeUsuario.equals("admin") && senhaUsuario.equals(this.dbPasswd);
    }

    /**
     * Autentica o usuário e armazena a sessão.
     */
    private void authenticateUser(HttpServletRequest request, String nomeUsuario) {
        request.getSession().setAttribute("usuario", nomeUsuario);
    }

    /**
     * Redireciona o usuário para a página de login.
     */
    private void redirectToLoginPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Credenciais incorretas. Redirecionando de volta para login.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
