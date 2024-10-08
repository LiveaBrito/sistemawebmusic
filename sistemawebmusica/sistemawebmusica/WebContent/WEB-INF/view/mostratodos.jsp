<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>musicas</title>

</head>

<body>



    Seja bem-vindo(a) ${clienteAutenticado.nomeCliente}

    <a href="http://localhost:8080/sistemawebmusica/chamadaservlet?acao=logout"><button>sair do sistema</button></a>

    
    <h1>Clientes Cadastrados</h1>

    

    <a href="http://localhost:8080/sistemawebmusica/chamadaservlet?acao=cadastro"><button>Cadastrar Cliente</button></a>

    <br><br>

    

    <c:if test="${not empty musicas}">

        <table border="1" style="width: 90%">

            <thead>

                <tr style="background-color: black; color: white;">

                    <th>IdCliente</th>

                    <th>NomeEstudio</th>

                    <th>NomeCliente</th>

                    <th>Numero de Musicas Gravadas</th>

                    <th>Taxa Hora Estudio</th>
                    
                    <th>Agendar Sessao</th>
                    
                    <th>Faturamento</th>
                                        
                    <th>Mixar Musica</th>
                    
                    <th>Valor Total</th>

                    <th colspan="2">Ação</th>

                </tr>

            </thead>

            <tbody>

                <c:forEach var="musicas" items="${musicas}">

                    <tr>

                        <td>${musicas.idCliente}</td>

                        <td>${musicas.nomeEstudio}</td>

                        <td>${musicas.nomeCliente}</td>

                        <td>${musicas.numMusicasGravadas}</td>

                        <td>${musicas.taxaHoraEstudio}</td>
                        
                        <td>${musicas.agendarSessao}</td>
                        
                        <td> R$ ${musicas.faturamento}</td>
                                                
                        <td> R$ ${musicas.mixarMusica}</td>
                        
                        <td> R$ ${musicas.valorTotal}</td>

                        <td><a href="chamadaservlet?acao=altera&idCliente=${musicas.idCliente}">Alterar</a></td>

                        <td><a href="chamadaservlet?acao=exclui&idCliente=${musicas.idCliente}">Excluir</a></td>

                    </tr>

                </c:forEach>        

            </tbody>

        </table>

    </c:if>

    <c:if test="${empty musicas}">

        <h2>Nenhuma musica Cadastrada no Sistema!!!!</h2>

    </c:if>

    

</body>

</html>





