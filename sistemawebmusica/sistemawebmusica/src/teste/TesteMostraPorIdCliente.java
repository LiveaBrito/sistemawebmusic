package teste;

import model.Music;
import model.MusicDao;

public class TesteMostraPorIdCliente {

	public static void main(String[] args) {
		MusicDao musicDao = new MusicDao();
		Music usuariomusic = musicDao.mostraPorIdCliente(1); //pode tentar trocar isso caso queira
		
		if(usuariomusic!=null) { //antes estava como music
			System.out.println("IdCliente: " + usuariomusic.getIdCliente());
			System.out.println("nomeEstudio: " + usuariomusic.getNomeEstudio());
			System.out.println("nomeCliente: " + usuariomusic.getNomeCliente());
			System.out.println("numMusicasGravadas: " + usuariomusic.getNumMusicasGravadas());
			System.out.println("taxaHoraEstudio: " + usuariomusic.getTaxaHoraEstudio());
			System.out.println("faturamento: " + usuariomusic.getFaturamento());
			System.out.println("agendarSessao: " + usuariomusic.getAgendarSessao());
			System.out.println();
			
		}else {
			System.out.println("IdCliente Não Existe!!!");
		}

	}

}
