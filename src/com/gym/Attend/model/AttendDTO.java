/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Attend.model;

import java.sql.Timestamp;

/**
 *
 * @author STU-13
 */
public class AttendDTO {
    private int attno;
    private Timestamp attdate;
    private int memNo;

    public AttendDTO() {
    }

    public AttendDTO(int attno, Timestamp attdate, int memNo) {
        this.attno = attno;
        this.attdate = attdate;
        this.memNo = memNo;
    }

    public int getAttno() {
        return attno;
    }

    public Timestamp getAttdate() {
        return attdate;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setAttno(int attno) {
        this.attno = attno;
    }

    public void setAttdate(Timestamp attdate) {
        this.attdate = attdate;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return "AttendDTO{" + "attno=" + attno + ", attdate=" + attdate + ", memNo=" + memNo + '}';
    }

}
