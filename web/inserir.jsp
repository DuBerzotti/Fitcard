
<%@page import="controller.CategoriaController"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


        <script>
            $(document).ready(function () {
                var $CampoAgencia = $("#Agencia");
                $CampoAgencia.mask('000-00');
            });
        </script>

        <script>
            $(document).ready(function () {
                var $CampoConta = $("#Conta");
                $CampoConta.mask('00.000-0');
            });

        </script>

        <script>
            $(document).ready(function () {
                var $CampoCnpj = $("#Cnpj");
                $CampoCnpj.mask('00.000.000/0000-00');
            });

            $(document).ready(function () {
                var $CampoCnpj = $("#Data");
                $CampoCnpj.mask('00/00/0000');
            });

        </script>

        <script>

            function validaDat(dataentrada) {
                var patternData = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;

                var date = dataentrada;
                var ardt = new Array;
                var ExpReg = new RegExp("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}");
                ardt = date.split("/");

                if (date.search(ExpReg) == -1) {
                    alert("Data invalida");

                } else if (((ardt[1] == 4) || (ardt[1] == 6) || (ardt[1] == 9) || (ardt[1] == 11)) && (ardt[0] > 30))
                    alert("Data invalida");
                else if (ardt[1] == 2) {
                    if ((ardt[0] > 28) && ((ardt[2] % 4) != 0))
                        alert("Data invalida");
                    if ((ardt[0] > 29) && ((ardt[2] % 4) == 0))
                        alert("Data invalida");
                }
                return false;
            }

        </script>

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

            <form action="cadEst" method="POST">


                <h3 style="color: orange;">${msg} </h3>

                <p>
                    <input type="hidden" name="codigo" value="${est.codigo}" readonly />
                </p>

                <p>
                    Razão Social:<br>
                    <input type="text" name="razaosocial" value="${est.razaosocial}" required="true" />
                </p>

                <p>
                    Nome Fantasia:<br>
                    <input type="text" name="nomefantasia" value="${est.nomefantasia}" />
                </p>

                <p>
                    CNPJ:<br>
                    <input type="text" name="cnpj" id="Cnpj" placeholder="00.000.000/0000-00" maxlength="18" autocomplete="off" value="${est.cnpj}" required="true"/>
                </p>

                <p>
                    Email:<br>
                    <input type="email" name="email" value="${est.email}"  />
                </p>

                <p>
                    Endereço:<br>
                    <input type="text" name="endereco" value="${est.endereco}" />
                </p>

                <p>
                    Cidade:<br>
                    <input type="text" name="cidade" value="${est.cidade}" />
                </p>

                <p>
                    Estado:<br>
                    <input type="text" name="estado" value="${est.estado}" />
                </p>

                <p>
                    Telefone:<br>
                    <input type="text" name="telefone" value="${est.telefone}" />

                </p>

                <p>
                    Data de Cadastro:<br>
                    <input  type="text" name="datacadastro" id="Data" value="<fmt:formatDate value="${est.datacadastro}" pattern="dd/MM/yyyy" />" placeholder="00/00/0000" onblur="validaDat(this.value)"/>
                </p>

                <p>
                    Status:<br>
                    <select name="status">
                        <option value="Ativo">Ativo</option>
                        <option value="Inativo">Inativo</option>
                    </select>
                </p>

                Categoria:<br>
                <select name="categoria">
                    <%
                        String cat;
                        CategoriaController catC = new CategoriaController();

                        for (Categoria categoria : catC.getCategoria()) {
                    %>
                    <option value="<%= categoria.getCategoria()%>"><%= categoria.getCategoria()%></option>
                    <%
                        }
                    %>
                </select>
                <p></p>
                <p>
                    Agencia:<br>
                    <input type="text" name="agencia" id="Agencia" placeholder="000-00" maxlength="5" autocomplete="off" value="${est.agencia}" />
                </p>

                <p>
                    Conta:<br>
                    <input type="text" name="conta" id="Conta" placeholder="00.000-0" maxlength="8" autocomplete="off" value="${est.conta}"/>
                </p>

                <input class="btn btn-success" type="submit" value="Salvar" />
                <a class="btn btn-info" href="index.jsp" >Voltar</a>


            </form>
        </div>

    </body>
</html>
