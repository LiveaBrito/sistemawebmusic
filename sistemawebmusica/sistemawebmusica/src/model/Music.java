package model;

public class Music {
	
	
	public Music (String nomeEstudio, String nomeCliente, double numMusicasGravadas, double taxaHoraEstudio, String agendarSessao) { //double taxaHoraEstudio, double faturamento) { //String agendarSessao, String mixarMusica) {
		//this.idCliente = idCliente;
		this.nomeEstudio = nomeEstudio;
		this.nomeCliente = nomeCliente;
		this.numMusicasGravadas = numMusicasGravadas;
		this.taxaHoraEstudio = taxaHoraEstudio;
		this.faturamento = this.calcularTaxaHrEst();
		this.agendarSessao = agendarSessao;
		this.mixarMusica = calcularMixagem();
		this.valorTotal = calcularValorTotal();
	}
	
	
		
	public Music (int idCliente, String nomeEstudio, String nomeCliente, double numMusicasGravadas, double taxaHoraEstudio, String agendarSessao) { //double faturamento) { //double taxaHoraEstudio, double faturamento) { //String agendarSessao, String mixarMusica) {
		this.idCliente = idCliente;
		this.nomeEstudio = nomeEstudio;
		this.nomeCliente = nomeCliente;
		this.numMusicasGravadas = numMusicasGravadas;
		this.taxaHoraEstudio = taxaHoraEstudio;
		this.faturamento = this.calcularTaxaHrEst(); //this.calcularFaturamento(); //colocar aqui this.faturamento = calcularFaturamento;
		this.agendarSessao = agendarSessao;
		this.mixarMusica = calcularMixagem();
		this.valorTotal = calcularValorTotal();
		

		
		
	}
	
	
	
	//Propriedades ou Atributos
	public Music() {}	

		private int idCliente;
		private String nomeEstudio;
		private String nomeCliente;
		private double numMusicasGravadas;
		private double taxaHoraEstudio;
		private double faturamento;
		private String agendarSessao;
		private double mixarMusica;
		private double valorTotal;
		private String login;
		private String senha;
		
	
		
	//M�todos
		public double calcularTaxaHrEst() {
			if(this.taxaHoraEstudio >= 1 && this.taxaHoraEstudio <=3) { //organizado em horas
				return 50;
			}else if(this.taxaHoraEstudio >= 4 && this.taxaHoraEstudio <=7) {
				return 100;
			}else if(this.taxaHoraEstudio >= 8 && this.taxaHoraEstudio <= 10) {
				return 200;
			}else if(this.taxaHoraEstudio >= 11 && this.taxaHoraEstudio <= 15) {
				return 500;
			}else if(this.taxaHoraEstudio >= 16) {
				return 700;
			
			}
			return faturamento;
			
		}
		
		public double calcularMixagem() {
				return numMusicasGravadas * 50;
			}

		public double calcularValorTotal() {
			return this.faturamento + this.mixarMusica;
		}
		
			
		//}
		
		//double calcularFaturamento() {
			
		//}
		
		//String agendamentoDaSessao() {
			//return cadastro
			//System.out.println("");
		//}
		
		//String mixagemDaMusica() {
		
		//}	
		
	public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		//}
		//id cliente = ra aluno
		public int getIdCliente() {
			return idCliente;
		}
		
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		
		public String getAgendarSessao() {
			return agendarSessao;
		}
		
		public void setAgendarSessao(String agendarSessao) {
			this.agendarSessao = agendarSessao;
		}
		
		public double getMixarMusica() {
			return mixarMusica;
		}
		
		public void setMixarMusica(double mixarMusica) {
			this.mixarMusica = mixarMusica;
		}


		public String getNomeEstudio() {
			return nomeEstudio;
		}

		public void setNomeEstudio(String nomeEstudio) {
			this.nomeEstudio = nomeEstudio;
		}

		public String getNomeCliente() {
			return nomeCliente;
		}

		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}

		public double getNumMusicasGravadas() {
			return numMusicasGravadas;
		}

		public void setNumMusicasGravadas(double numMusicasGravadas) {
			this.numMusicasGravadas = numMusicasGravadas;
		}

		public double getTaxaHoraEstudio() {
			return taxaHoraEstudio;
		}

		public void setTaxaHoraEstudio(double taxaHoraEstudio) {
			this.taxaHoraEstudio = taxaHoraEstudio;
		}

		public double getFaturamento() {
			return faturamento;
		}

		public void setFaturamento(double faturamento) {
			this.faturamento = faturamento;
		}
		
		public double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}
	
	
}
