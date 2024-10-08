package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //olhar essa biblioteca
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.http.HttpServlet; //eu inseri essa biblioteca

import model.Music;
import model.MusicDao;	

@WebServlet("/chamadaservlet")
public class MeuServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao") ==null ? "login" : request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		boolean clienteAutenticado = sessao.getAttribute("clienteAutenticado") == null;
		boolean paginaProtegida = !(acao.equals("login"));
		if(clienteAutenticado && paginaProtegida) {
			response.sendRedirect("http://localhost:8080/sistemawebmusica");
			return;
		}
		
		if(acao.equals("login")) {
			response.sendRedirect("http:localhost:8080/sistemawebmusica");
			
	}else if(acao.equals("cadastro")) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastro.jsp");
		rd.forward(request, response);
		
	}else if(acao.equals("mostratodos")) {
		
		MusicDao musicDao = new MusicDao();
		List<Music> musicas = musicDao.mostraTodos();
		
		request.setAttribute("musicas", musicas);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
		rd.forward(request,response);
		
	}else if (acao.equals("exclui")) {
		int idCliente = Integer.valueOf(request.getParameter("idCliente"));
		MusicDao musicDao = new MusicDao();
		musicDao.excluiPorIdCliente(idCliente);
		response.sendRedirect("http://localhost:8080/sistemawebmusica/chamadaservlet?acao=mostratodos");
		
	}else if(acao.equals("altera")) {
		int idCliente = Integer.valueOf(request.getParameter("idCliente"));
		MusicDao musicDao = new MusicDao();
		Music musicas = musicDao.mostraPorIdCliente(idCliente);
		request.setAttribute("musicas", musicas);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/altera.jsp");
		rd.forward(request, response);
		
	}else if(acao.equals("logout")) {
		sessao.invalidate();
		response.sendRedirect("http://localhost:8080/sistemawebmusica");
	}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("login")) {
			String login = request.getParameter("txtlogin");
			String senha = request.getParameter("txtsenha");
			
			MusicDao musicDao = new MusicDao();
			Music usuariomusic = musicDao.autentica(login, senha);
			
			if (usuariomusic != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("clienteAutenticado", usuariomusic); //aqui
				response.sendRedirect("http://localhost:8080/sistemawebmusica/chamadaservlet?acao=mostratodos");
				
			}else {
				response.sendRedirect("http://localhost:8080/sistemawebmusica");
		}
		
		}else if (acao.equals("cadastro")) {
			
			String nomeEstudio = request.getParameter("txtnomeEstudio");
			String nomeCliente = request.getParameter("txtnomeCliente");
			double numMusicasGravadas = Double.valueOf(request.getParameter("txtnumMusicasGravadas"));
			double taxaHoraEstudio = Double.valueOf(request.getParameter("txttaxaHoraEstudio"));
			String agendarSessao = request.getParameter("txtagendarSessao");
			//double mixarMusica = request.getParameter("txtmixarMusica");
			//double faturamento = Double.valueOf(request.getParameter("txtfaturamento"));
			
			Music usuariomusic = new Music(nomeEstudio,nomeCliente,numMusicasGravadas,taxaHoraEstudio,agendarSessao);
			//Music usuariomusic = new Music();
			
			MusicDao musicDao = new MusicDao();
			musicDao.cadastra(usuariomusic); //aqui
			
			response.sendRedirect("http://localhost:8080/sistemawebmusica/chamadaservlet?acao=mostratodos");
			
		}else if (acao.equals("altera")) {
			int idCliente = Integer.valueOf(request.getParameter("txtidCliente"));
			String nomeEstudio = request.getParameter("txtnomeEstudio");
			String nomeCliente = request.getParameter("txtnomeCliente");
			double numMusicasGravadas = Double.valueOf(request.getParameter("txtnumMusicasGravadas"));
			double taxaHoraEstudio = Double.valueOf(request.getParameter("txttaxaHoraEstudio"));
			String agendarSessao = request.getParameter("txtagendarSessao");
			//double faturamento = Double.valueOf(request.getParameter("txtfaturamento"));
			
		Music musicas = new Music (idCliente,nomeEstudio,nomeCliente,numMusicasGravadas,taxaHoraEstudio, agendarSessao);
		
		MusicDao musicDao = new MusicDao();
		musicDao.altera(musicas);
		
		response.sendRedirect("http://localhost:8080/sistemawebmusica/chamadaservlet?acao=mostratodos");
			
		}
	}
}


