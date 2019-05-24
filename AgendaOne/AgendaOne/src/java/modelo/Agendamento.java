/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author user
 */
public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private Servico servico;
    private Date data;
    private Time hora;
    private Date datafinal;
    private Time horafinal;
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Time getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Time horafinal) {
        this.horafinal = horafinal;
    }

    public Agendamento() {
    }

    public Agendamento(Date data) {
        this.data = data;
    }

    public Agendamento(int id, Cliente cliente, Servico servico, Date data, Time hora, Date datafinal, Time horafinal, Double valor) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.datafinal = datafinal;
        this.horafinal = horafinal;
        this.valor = valor;
    }

   
    
    
    
    
    
}
