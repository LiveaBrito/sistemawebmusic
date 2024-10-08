package teste;

import model.Music;
import model.MusicDao;

public class TesteAutentica {

	public static void main(String[] args) {
		MusicDao musicDao = new MusicDao();
		Music usuariomusic = musicDao.autentica("Csantos", "123");
		System.out.println(usuariomusic.getNomeEstudio());
		System.out.println(usuariomusic.getNomeCliente());
		//System.out.println(usuariomusic.getTaxaHoraMusica());

	}

}
