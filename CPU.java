/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.curscpu;

/**
 *
 * @author НАТАЛИ
 */
public class CPU {
    Core[] cores;
    public CPU(final int coresNumber){
        cores = new Core[coresNumber]; 
        for(int i = 0; i < coresNumber; i++){
            cores[i] = new Core();
        }
    }
}
