<%-- 
    Document   : listarPacientes
    Created on : 1 de jul de 2022, 17:07:34
    Author     : EduardoVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="model.Paciente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes</title>
    </head>
    <body>
        <a href="paciente?op=add">Adicioanr novo paciente</a>
        <h1>Listagem de pacientes</h1>
        <%            
        ArrayList<Paciente> registros = (ArrayList<Paciente>) request.getAttribute("registros");
                 
        for (Paciente i : registros) {        
        %>

        <%= i.getNome() %>, <%= i.getEndereco() %>, <%= i.getTelefone() %>, <%= i.getDataNascimento() %> 
        
        | <a href="paciente?op=d&q=<%= i.getId() %>">remover</a> | 
        <a href="paciente?op=r&q=<%= i.getId() %>">exibir</a> | 
        <a href="paciente?op=a&q=<%= i.getId() %>">atualizar</a> <br>

        <%
            }
        %>
    </body>
</html>
