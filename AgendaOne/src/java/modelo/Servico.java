package modelo;

public class Servico {

    private int id;
    private String nome;

    private int situacao;
    private TipoServico tipo;

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

    public Servico() {
    }

    public Servico(int id, String nome, int situacao, TipoServico tipo) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
        this.tipo = tipo;
    }

    public Servico(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

    public Servico(int id) {
        this.id = id;
    }

}
