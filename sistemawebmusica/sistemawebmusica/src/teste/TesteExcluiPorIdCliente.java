package teste;

import model.MusicDao;

public class TesteExcluiPorIdCliente {
	public static void main(String[] args) {
		MusicDao musicDao = new MusicDao();
		musicDao.excluiPorIdCliente(2);
		
	}


}
