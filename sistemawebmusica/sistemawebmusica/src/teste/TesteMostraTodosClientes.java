package teste;

import java.util.List;

import model.Music;
import model.MusicDao;

public class TesteMostraTodosClientes{

	public static void main(String[] args) {
		MusicDao musicDao = new MusicDao();
		List<Music> musicas = musicDao.mostraTodos();
		
		for(Music music : musicas) {
			System.out.println("idCliente: " + music.getIdCliente());
			System.out.println("nomeEstudio: " + music.getNomeEstudio());
			System.out.println("nomeCliente: " + music.getNomeCliente());
			System.out.println("numMusicasGravadas: " + music.getNumMusicasGravadas());
			System.out.println("taxaHoraEstudio: " + music.getTaxaHoraEstudio());
			System.out.println("faturamento: " + music.getFaturamento());
			System.out.println("agendarSessao: " + music.getAgendarSessao());
			System.out.println();
			
		}
		
	}

	
}


