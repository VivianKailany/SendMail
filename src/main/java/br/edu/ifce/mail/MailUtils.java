package br.edu.ifce.mail;

import org.apache.commons.mail.EmailException;
import br.edu.ifce.bean.Mail;

public class MailUtils {
    public static void sendEmail(Mail mail) throws EmailException {
        new CommonsMail().enviaEmailSimples(mail);
    }
}

