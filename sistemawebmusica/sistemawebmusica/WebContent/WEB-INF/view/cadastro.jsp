<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendamento do Cliente - Cadastro</title>
</head>
<body>


	Seja bem vindo (a) ${clienteAutenticado.nomeCliente}
	<a href="http://localhost:8080/sistemawebmusica/chamadaservlet?acao=logout"><button>sair do sistema</button></a>

<h1>Agendamento - Cadastro</h1>

<form method="post" action="chamadaservlet">

Nome Estúdio: <input type="text" name="txtnomeEstudio" size="80" autocomplete="off"required><br><br> 
Nome Cliente: <input type="text" name="txtnomeCliente" size="80" autocomplete="off"required><br><br> 
Numero Musicas Gravadas: <input type="text" name="txtnumMusicasGravadas" size="50" autocomplete="off"required><br><br> 
Taxa/Hora Estúdio: <input type="text" name="txttaxaHoraEstudio" size="50" autocomplete="off"required><br><br>
Agendar Sessao: <input type="text" name="txtagendarSessao" size="50" autocomplete="off"required><br><br>
<!--Valor Mixagem Musica: <input type="text" name="txtmixarMusica" size="50" autocomplete="off" required><br><br> -->

<input type="hidden" name="acao" value="cadastro">
<input type="submit" value="Cadastrar Cliente">
 

</form>



</body>
</html>