package teste;

import model.Music;
import model.MusicDao;

public class TesteCadastro {

	public static void main(String[] args) {
		Music usuariomusic = new Music (0,"B","Samanta Silva",7,8,"junho"); //("B","Carlos Souza",2); --> alterei aqui colocando o (); -> 2 = numeroMusicasGravadas
		MusicDao musicDao = new MusicDao();
		musicDao.cadastra(usuariomusic);

	}

}
