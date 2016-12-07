/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.util;

/**
 *
 * @author ricardoalvim
 */
public class GMail extends Mail{
    public GMail(){
        super();
        this.setAuth("true");
        this.setHost("smtp.gmail.com");
        this.setPort("587");
        this.setTtls("true");
        this.setUser("2016tecservice@gmail.com");
        this.setPasswd("sert2016");
    }
}
