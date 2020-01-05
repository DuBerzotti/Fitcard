<%@page import="model.Estabelecimento"%>
<%@page import="controller.EstabelecimentoController"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FitCard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }

            /* On small screens, set height to 'auto' for sidenav and grid */
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
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

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-8 text-left"> 
                    <body>
                        <h3 style="color: orange;">${msg} </h3>

                        <br/>
                        <table border="3" class="table">
                            <thead class="thead-dark">
                            <th>Código</th>
                            <th>Razão Social</th>
                            <th>Nome Fantasia</th>
                            <th>CNPJ</th>
                            <th>Email</th>
                            <th>Endereço</th>
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>Telefone</th>
                            <th>Data Cadastro</th>
                            <th>Categoria</th>
                            <th>Status</th>
                            <th>Agência</th>
                            <th>Conta</th>
                            <th>EDITAR</th>
                            <th>EXCLUIR</th>
                                <%
                                    EstabelecimentoController estC = new EstabelecimentoController();

                                    for (Estabelecimento estabelecimento : estC.getTodos()) {
                                %>
                            <tr>
                                <td><%= estabelecimento.getCodigo()%></td>
                                <td><%= estabelecimento.getRazaosocial()%></td>
                                <td><%= estabelecimento.getNomefantasia()%></td>
                                <td><%= estabelecimento.getCnpj()%></td>
                                <td><%= estabelecimento.getEmail()%></td>
                                <td><%= estabelecimento.getEndereco()%></td>
                                <td><%= estabelecimento.getCidade()%></td>
                                <td><%= estabelecimento.getEstado()%></td
                                <td></td>
                                <td><%= estabelecimento.getTelefone()%> </td>   
                                <td><%= estabelecimento.getDatacadastro()%></td>
                                <td><%= estabelecimento.getCategoria()%></td>
                                <td><%= estabelecimento.getStatus()%></td>
                                <td><%= estabelecimento.getAgencia()%></td>
                                <td><%= estabelecimento.getConta()%></td>
                                <td><a class="btn btn-danger" href="cadEst?acao=delete&codigo=<%= estabelecimento.getCodigo()%>">excluir</a></td>
                                <td><a class="btn btn-warning" href="cadEst?acao=editar&codigo=<%= estabelecimento.getCodigo()%>">Alterar</a></td>
                            </tr>
                            <%
                                }
                            %>
                            </thead>
                        </table>
                    </body>
                </div>
            </div>
        </div>


    </body>
</html>
