package modelo;

public abstract class Frete {
    
    private int distancia;
    private double valor;  

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Frete(int distancia) {
        this.distancia = distancia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
        
    public Frete() {
        
    }

    public abstract void calcularPreco() ;

}
