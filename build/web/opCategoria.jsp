
<%@page import="controller.CategoriaController"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Fitcard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Fitcard</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">Home</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Estabelecimento
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="index.jsp">Listar Estabelecimento</a></li>
                            <li><a href="inserir.jsp">Adicionar Estabelecimento</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categoria
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="categoria.jsp">Listar Categoria</a></li>
                            <li><a href="opCategoria.jsp">Adicionar Categoria</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">

            <form action="cadCat" method="POST">


                <h3 style="color: orange;">${msg} </h3>

                <p>
                    <input type="hidden" name="codigo" value="${cat.codigo}" readonly />
                </p>

                <p>
                    Categoria:<br>
                    <input type="text" name="categoria" value="${cat.categoria}" required="true" />
                </p>

                <input class="btn btn-success" type="submit" value="Salvar" />
                <a class="btn btn-info" href="categoria.jsp" >Voltar</a>


            </form>
        </div>

    </body>
</html>
