/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Member.model;

import java.sql.Timestamp;


/**
 *
 * @author STU-13
 */
public class MemberDTO {
    private int memNo;
    private String memName;
    private String memEmail;
    private String memPwd;
    private String memTel;
    private String memZip;
    private String memAddr;
    private String memAddrDetail;
    private Timestamp memRegdate;
    private int ProgNo;
    
    public MemberDTO() {
    }

    public MemberDTO(int memNo, String memName, String memEmail, String memPwd, String memTel, String memZip, String memAddr, String memAddrDetail, Timestamp memRegdate, int ProgNo) {
        this.memNo = memNo;
        this.memName = memName;
        this.memEmail = memEmail;
        this.memPwd = memPwd;
        this.memTel = memTel;
        this.memZip = memZip;
        this.memAddr = memAddr;
        this.memAddrDetail = memAddrDetail;
        this.memRegdate = memRegdate;
        this.ProgNo = ProgNo;
    }

    public int getMemNo() {
        return memNo;
    }

    public String getMemName() {
        return memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public String getMemTel() {
        return memTel;
    }

    public String getMemZip() {
        return memZip;
    }

    public String getMemAddr() {
        return memAddr;
    }

    public String getMemAddrDetail() {
        return memAddrDetail;
    }

    public Timestamp getMemRegdate() {
        return memRegdate;
    }

    public int getProgNo() {
        return ProgNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel;
    }

    public void setMemZip(String memZip) {
        this.memZip = memZip;
    }

    public void setMemAddr(String memAddr) {
        this.memAddr = memAddr;
    }

    public void setMemAddrDetail(String memAddrDetail) {
        this.memAddrDetail = memAddrDetail;
    }

    public void setMemRegdate(Timestamp memRegdate) {
        this.memRegdate = memRegdate;
    }

    public void setProgNo(int ProgNo) {
        this.ProgNo = ProgNo;
    }

    @Override
    public String toString() {
        return "MemberDTO{" + "memNo=" + memNo + ", memName=" + memName + ", memEmail=" + memEmail + ", memPwd=" + memPwd + ", memTel=" + memTel + ", memZip=" + memZip + ", memAddr=" + memAddr + ", memAddrDetail=" + memAddrDetail + ", memRegdate=" + memRegdate + ", ProgNo=" + ProgNo +'}';
    }

}
