package modelo;

public class Sedex extends Frete {

    @Override
    public void calcularPreco() {
        this.setValor(this.getDistancia() * 1.45 + 12);
    }
	
}
