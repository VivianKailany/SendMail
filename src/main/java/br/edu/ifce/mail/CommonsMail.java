package br.edu.ifce.mail;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.edu.ifce.bean.Mail;
public class CommonsMail {

    public CommonsMail() { }

    public void enviaEmailSimples(Mail mail) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setAuthentication("ct5848187@gmail.com", "Contateste@1/5");
        email.setFrom("ct5848187@gmail.com", "Teste");
        email.setSSLOnConnect(true);
        email.setStartTLSRequired(true);
        email.setSubject(mail.getAssunto());
        email.setMsg(mail.getMensagem());
        email.addTo(mail.getDestinatario());
        email.send();
    }
}
