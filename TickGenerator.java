/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.curscpu;

import java.util.TimerTask;

/**
 *
 * @author НАТАЛИ
 */
public class TickGenerator extends TimerTask{
    private static int time = 0;
    public TickGenerator(){}
    public static int getTime() {
        return time;
    }
    public static void tick(){
        tick(1);
    }
    public static void tick(int _time){
        time += _time;
    }
    @Override
    public void run(){
        tick();
    }
}
