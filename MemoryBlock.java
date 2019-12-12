/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.curscpu;

import java.util.Comparator;

/**
 *
 * @author НАТАЛИ
 */
public class MemoryBlock {
    private int start;
    private int end;
    public static Comparator<MemoryBlock> byStart = (MemoryBlock  o1, MemoryBlock  o2) -> {
        return o1.getStart()-o2.getStart();
    };
    public MemoryBlock(int start, int end){
        this.start = start;
        this.end = end;
    };

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
