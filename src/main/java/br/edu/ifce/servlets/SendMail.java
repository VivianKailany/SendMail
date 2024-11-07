package br.edu.ifce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import br.edu.ifce.bean.Mail;
import br.edu.ifce.mail.MailUtils;

public class SendMail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("usuario");
        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            Mail mail = new Mail();
            BeanUtils.populate(mail, request.getParameterMap());
            MailUtils.sendEmail(mail);
            response.sendRedirect("ResumoEmailsEnviados");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
