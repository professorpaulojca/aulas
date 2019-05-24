package modelo;

public class Servico {

    private int id;
    private String nome;
    private int situacao;
    private TipoServico tipo;
    private double valor;
    private double tempo;

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public Servico(int id, String nome, int situacao, TipoServico tipo, double valor, double tempo) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
        this.tipo = tipo;
        this.valor = valor;
        this.tempo = tempo;
    }
    
    public Servico() {
    }

    public Servico(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    public Servico(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Servico(int id) {
        this.id = id;
    }

}
