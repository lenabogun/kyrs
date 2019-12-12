/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.curscpu;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author НАТАЛИ
 */
public class Scheduler extends TickGenerator{
    private CPU cpu;
    private Queue Procqueue;
    private Queue Finnqueue;
    private ArrayList<Queue> Rejequeues;
    private Memory memory;
    public Scheduler(final int coresN, int memoryVolume){
        Rejequeues = new ArrayList<>();
        for(int i=0; i < Config.maxPriority; i++)
            Rejequeues.add(new Queue());
        Procqueue = new Queue();
        memory = new Memory();
        Config.commonMemory = memoryVolume;
        cpu = new CPU(coresN);    
    }
    
    @Override
    public void run() {
        tick();
        if(relocProcess())
            addProcess();
        for (Core core : cpu.cores) {
            if (core.isFree()){ 
                if (!Procqueue.isEmpty()){
                    core.setProc(Procqueue.getFirst());
                    Procqueue.removeFirst();
                    core.getProc().setState(Status.Running);
                }
            }
            else
            {
                core.getProc().incBurstTime();
                if(core.getProc().isFinish()){
                    getFinnqueue().add(core.getProc());
                    core.Free();
                }
            }
        }
    }
    
    public void addProcess(){
        Process p = new Process(Queue.getLastProcess());
        if(memory.fillMemory(p)){
            Procqueue.add(p);
        }
        else{
            Rejequeues.get(p.getPriority()).add(p);
        }
    }
    
    public boolean relocProcess(){
        for(Queue R : Rejequeues){
            if(!R.isEmpty()){
                Process p = R.getFirst();
                if(memory.fillMemory(p)){
                    Procqueue.add(p);
                    R.removeFirst();
                    return true;
                }
            }
        }
        return false;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Queue getProcqueue() {
        return Procqueue;
    }

    public ArrayList<Queue> getRejequeues() {
        return Rejequeues;
    }

    public Queue getFinnqueue() {
        return Finnqueue;
    }
    
    public int getMemLoad(){
        return memory.memLoad();
    }
}
