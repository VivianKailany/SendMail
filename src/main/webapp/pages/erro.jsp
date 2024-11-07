<!-- error.jsp -->
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            border: 1px solid #f5c6cb;
            padding: 20px;
            background-color: #f8d7da;
            border-radius: 5px;
            width: 300px;
        }
        h1 {
            font-size: 24px;
            margin: 0;
        }
        p {
            margin: 10px 0;
        }
        a {
            color: #721c24;
            text-decoration: underline;
        }
        a:hover {
            color: #a94442;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Erro ao Enviar o Email</h1>
        <p><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Ocorreu um erro inesperado. Tente novamente." %></p>
        <p><a href="javascript:history.back()">Voltar</a> | <a href="index.jsp">Página Inicial</a></p>
    </div>
</body>
</html>
