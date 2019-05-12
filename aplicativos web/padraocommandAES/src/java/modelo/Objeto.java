/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import utilidades.AES;

/**
 *
 * @author profe
 */
public class Objeto {
   final String secretKey = "chavequevoceescolher";

    private int id;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Objeto(int id) {
        this.id = id;
    }

    public Objeto() {
    }

    public String getIdcrypt() {
     
        String originalString = Integer.toString(this.id);
        String encryptedString = AES.encrypt(originalString, secretKey);
        return encryptedString;

    }
    
     public void setIdcrypt(String idc) {
      
        String decryptedString = AES.decrypt(idc, secretKey);
        this.id = Integer.parseInt(decryptedString);

    }
}
