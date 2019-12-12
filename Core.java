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
public class Core {
    private boolean free;
    private Process proc;
    
    public Core(){
        free = true;
        proc = null;
    }

    public Process getProc() {
        return proc;
    }

    public boolean isFree() {
        return free;
    }

    public void Free() {
        this.free = true;
        this.proc = null;
    }
    public void setProc(Process proc) {
        this.proc = proc;
        this.free = false;
    }
}
