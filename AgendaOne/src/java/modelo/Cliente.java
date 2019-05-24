
package modelo;


public class Cliente {
   private int id;
   private String nome;
   private String cpf;
   private String telefone;
   private String endereco;
   private Tipo tipo;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String telefone, String endereco, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    
    
    
   
   
}
