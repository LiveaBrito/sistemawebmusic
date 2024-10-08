<%@page import="model.Music"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração Dados Clientes</title>
</head>
<body>

Seja bem vindo (a) ${clienteAutenticado.nomeCliente}

<a href="http://localhost:8080/sistemawebmusica/chamadaservlet?acao=logout"><button>sair do sistema</button></a>

<h1> Alteração de Dados</h1>


<form method="post" action="chamadaservlet">

Id Cliente: <input type="text" name="txtidCliente" size="5" value="${musicas.idCliente}" readonly>

Nome Estudio: <input type="text" name="txtnomeEstudio" size="70" value="${musicas.nomeEstudio} " autocomplete="off" required>

Nome Cliente: <input type="text" name="txtnomeCliente" value="${musicas.nomeCliente}" size="65" autocomplete="off" required><br><br>

Numero Musicas Gravadas: <input type="text" name="txtnumMusicasGravadas" value="${musicas.numMusicasGravadas}" size="10" autocomplete="off" required>

Taxa/Hora Estúdio: <input type="text" name="txttaxaHoraEstudio" value="${musicas.taxaHoraEstudio}" size="10" autocomplete="off" required>

Agendar Sessao: <input type="text" name="txtagendarSessao" value="${musicas.agendarSessao}" size="20" autocomplete="off" required>

Faturamento: <input type="text" name="txtfaturamento" value="${musicas.faturamento}" size="10" readonly><br><br> 

Mixar Musica: <input type="text" name="txtmixarMusica" value="${musicas.mixarMusica}" size="10" readonly><br><br>

Valor Total: <input type="text" name="txtvalorTotal" value="${musicas.valorTotal}" size="10" readonly><br><br>

<!-- Valor Mixar Musica: <input type="text" name="txtmixarMusica" value="${musicas.mixarMusica}" size="10" readonly><br><br> -->


<input type="hidden" name="acao" value="altera">

<input type="submit" value="Alterar Dados Cliente">

</form>


</body>
</html>