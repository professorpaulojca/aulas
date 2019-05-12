package modelo;

public enum TipoFormaPag {

	avista {
		@Override
		public Formapag obterFormapag() {
			return new Avista();
		}
	},
	credito {
		@Override
		public Formapag obterFormapag() {
			return new Credito();
		}
	},
        debito {
		@Override
		public Formapag obterFormapag() {
			return new Debito();
		}
	},
        crediario {
		@Override
		public Formapag obterFormapag() {
			return new Crediario();
		}
	},
        boleto {
		@Override
		public Formapag obterFormapag() {
			return new Boleto();
		}
	};
	
	public abstract Formapag obterFormapag();
        
	
}
