<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Projeto Send Mail 1.0 - TJW</title>
</head>
<body>
<div>
<h1 align="center">TJW Mail</h1>
</div>
<form action="CheckCredentials" method="post" name="form_loginmail" >
  <p>&nbsp;</p>
  <table width="230" border="0" align="center">
    <tr>
      <td width="70">Usuário:</td>
      <td width="144"><input type="text" name="nomeUsuario"></td>
    </tr>
    <tr>
      <td>Senha:</td>
      <td><input type="password" name="senhaUsuario"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="button" id="button" value="Entrar"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>
