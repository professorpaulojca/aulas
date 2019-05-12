package modelo;


public class Normal extends Frete {

    @Override
    public void calcularPreco() {
       this.setValor(this.getDistancia() * 1.25 + 10);
    }
	
}
