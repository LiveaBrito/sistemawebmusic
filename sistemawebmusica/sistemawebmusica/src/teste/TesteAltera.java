package teste;

import model.Music;
import model.MusicDao;

public class TesteAltera {

	public static void main(String[] args) {
		
		Music musicas = new Music ("B","Carlos Souza",2,0,"junho");
		
		MusicDao musicDao = new MusicDao();
		musicDao.altera(musicas);

	}

}
