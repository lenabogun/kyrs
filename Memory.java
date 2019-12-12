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
public class Memory {
    ArrayList<MemoryBlock> MemoryBlocks;
    public Memory(){
        MemoryBlocks = new ArrayList<>();
        MemoryBlocks.add(new MemoryBlock(1,Config.osMemory));//Loading OS
    }  
    
    private int findFreeBlocks(int size){
        MemoryBlocks.sort(MemoryBlock.byStart);
        for(int i = 0;i < MemoryBlocks.size()-1;i++){
            if((MemoryBlocks.get(i+1).getStart() - MemoryBlocks.get(i).getEnd())-1 > size) // память занимается включительно
                return MemoryBlocks.get(i).getEnd()+1;
        }
        if((Config.commonMemory-MemoryBlocks.get(MemoryBlocks.size()-1).getEnd())>size)
            return MemoryBlocks.get(MemoryBlocks.size()-1).getEnd()+1;
        return -1;
    }
    
    public boolean fillMemory(Process proc){
        int i;
        if((i = findFreeBlocks(proc.getMemory()))>-1){
            proc.setMemblock(new MemoryBlock(i,i+proc.getMemory()-1));
            MemoryBlocks.add(proc.getMemblock());
            proc.setState(Status.Ready);
            return true;
        }
        return false;
    }
    
    public void freeMemory(MemoryBlock memoryBlock){
        MemoryBlocks.remove(memoryBlock);
    }
    public void add(MemoryBlock memoryBlock){
        MemoryBlocks.add(memoryBlock);
    }
    public int memLoad(){
        int i = 0;
        for(MemoryBlock mb : MemoryBlocks)
            i+=mb.getEnd() - mb.getStart()+1;
        return i/Config.commonMemory*100;
    }
}