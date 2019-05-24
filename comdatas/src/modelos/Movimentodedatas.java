/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author profe
 */
public class Movimentodedatas {
    
    private int id;
    private Date dataehorajuntos; //timestamp
    private Date somentedata;
    private Time somentehora;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataehorajuntos() {
        return dataehorajuntos;
    }

    public void setDataehorajuntos(Date dataehorajuntos) {
        this.dataehorajuntos = dataehorajuntos;
    }

    public Date getSomentedata() {
        return somentedata;
    }

    public void setSomentedata(Date somentedata) {
        this.somentedata = somentedata;
    }

    public Time getSomentehora() {
        return somentehora;
    }

    public void setSomentehora(Time somentehora) {
        this.somentehora = somentehora;
    }

    public Movimentodedatas() {
    }

    public Movimentodedatas(int id, Date dataehorajuntos, Date somentedata, Time somentehora) {
        this.id = id;
        this.dataehorajuntos = dataehorajuntos;
        this.somentedata = somentedata;
        this.somentehora = somentehora;
    } 
    
    
}
