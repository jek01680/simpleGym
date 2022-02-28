/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Submit.model;

/**
 *
 * @author STU-13
 */
public class SubmitDTO {
    private int subno;
    private int ClassNo;
    private int memNo;

    public SubmitDTO() {
    }

    public SubmitDTO(int subno, int ClassNo, int memNo) {
        this.subno = subno;
        this.ClassNo = ClassNo;
        this.memNo = memNo;
    }

    public int getSubno() {
        return subno;
    }

    public int getClassNo() {
        return ClassNo;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setSubno(int subno) {
        this.subno = subno;
    }

    public void setClassNo(int ClassNo) {
        this.ClassNo = ClassNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return "SubmitDTO{" + "subno=" + subno + ", ClassNo=" + ClassNo + ", memNo=" + memNo + '}';
    }
    
}
