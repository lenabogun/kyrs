package com.mycompany.curscpu;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author НАТАЛИ
 */
public class Process {

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    private int id;
    private String name;
    private int time;
    private int memory;
    private int timeIn;
    private int priority;
    private int burstTime;
    private MemoryBlock memblock;
    private Status state;
    
    public Process(int _id){
        Random r = new Random();
        id = _id;
        memory = 5 + r.nextInt(Config.commonMemory/2 - 4);
        time = r.nextInt(Config.maxTime);
        timeIn = TickGenerator.getTime();
        name = "p"+id;
        burstTime = 0;
        state = Status.Waiting;
    }
    
    public boolean isFinish(){
        return burstTime >= time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getMemory() {
        return memory;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
    
    public void incBurstTime() {
        this.burstTime += 1;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public MemoryBlock getMemblock() {
        return memblock;
    }

    public void setMemblock(MemoryBlock memblock) {
        this.memblock = memblock;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
    
}
