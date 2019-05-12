/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunocmc
 */
public class adptCursoExtraCurricular extends CursoExtraCurricular implements IDados{

    @Override
    public String getDados() {
            return this.getNome() + "\n Data:" + this.getData();
    }

    public adptCursoExtraCurricular(String nome, String data, String indicadopara) {
        super(nome, data, indicadopara);
    }
    
    
}
