<%-- 
    Document   : adicionarPessoa
    Created on : 1 de jul de 2022, 17:18:26
    Author     : EduardoVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo paciente</title>
    </head>
    <body>
        <h1>Adicionar paciente</h1>
        <form action="paciente" method="post">
            Nome: <input type="text" name="nome" value="João smith"> <br>
            Endereço <input type="text" name="endereco" value="rua sem esquina nº33"> <br>
            Email: <input type="text" name="email" value="jhon@gmail.com"> <br>
            Telefone: <input type="text" name="telefone" value="(47)123123123"> <br>
            Data de Nacimento <input type="text" name="dataNacimento" value="10/10/2010"> <br>
            <input type="submit" value="Criar">
        </form>
    </body>
</html>
