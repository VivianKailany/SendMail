<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Projeto Send Mail 1.0 - TJW</title>
</head>
<body>
    <h1 align="center">Formulário de Envio de Emails</h1>
    <p align="center">Captura automática de parâmetros da Requisição usando JavaBeans - 
    <a href="Logout">Sair</a></p>
    <form action="SendMail" method="post">
        <table align="center">
            <tr><td>Assunto:</td><td><input type="text" name="assunto"></td></tr>
            <tr><td>Destinatário:</td><td><input type="text" name="destinatario"></td></tr>
            <tr><td>Mensagem:</td><td><textarea name="mensagem" rows="5" cols="45"></textarea></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="Enviar e-mail"></td></tr>
        </table>
    </form>
</body>
</html>
