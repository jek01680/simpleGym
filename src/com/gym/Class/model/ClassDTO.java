/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Class.model;

/**
 *
 * @author STU-13
 */
public class ClassDTO {
    private int ClassNo;
    private String ClassName;
    private String teacher;
    private String time;
    private int limit;
    private int left;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
    
    public ClassDTO() {
    }

    public ClassDTO(int ClassNo, String ClassName, String teacher, String time, int limit,int left) {
        this.ClassNo = ClassNo;
        this.ClassName = ClassName;
        this.teacher = teacher;
        this.time = time;
        this.limit = limit;
        this.left = left;
    }

    public int getClassNo() {
        return ClassNo;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }

    public int getLimit() {
        return limit;
    }

    public void setClassNo(int ClassNo) {
        this.ClassNo = ClassNo;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ClassDTO{" + "ClassNo=" + ClassNo + ", ClassName=" + ClassName + ", teacher=" + teacher + ", time=" + time + ", limit=" + limit + ", left=" + left + '}';
    }

}
