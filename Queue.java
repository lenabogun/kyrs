/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.curscpu;

import java.util.ArrayList;

/**
 *
 * @author НАТАЛИ
 */
public class Queue {
    private static int lastProcess;
    private ArrayList<Process> queue;
    public Queue(){
        queue = new ArrayList<>();
        lastProcess = 1;
    }
    
    public void add(Process p){
        queue.add(p);
        lastProcess++;
    }
    public void add(){
        Process p = new Process(lastProcess);
        add(p);
        lastProcess++;
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public void clear(){
        queue.clear();
    }
    
    public void remove(Process p){
        queue.remove(p);
    }
    
    public void remove(int i){
        queue.remove(i);
    }
    
    public void removeFirst(){
        remove(0);
    }
    
    public Process getFirst(){
        if(!isEmpty())
            return queue.get(0);
        else
            return null;
    }
    
    public int size(){
        return this.queue.size();
    }
    public ArrayList<Process> getList(){
        return queue;
    }
    
    public static int getLastProcess() {
        return lastProcess;
    }
}