/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Class.model;

import com.gym.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author STU-13
 */
public class ClassDAO {
    public ArrayList<ClassDTO> selectAll() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<ClassDTO> list = new ArrayList<>();
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql="select * from class order by classno desc";
            ps = con.prepareStatement(sql);
            
            //4.
            rs = ps.executeQuery();
            while(rs.next()){
                int classno = rs.getInt("classno");
                String classname = rs.getString("classname");
                String teacher = rs.getString("teacher");
                String time = rs.getString("time");
                int limit = rs.getInt("limit");
                int left = rs.getInt("left");
                
                ClassDTO dto = new ClassDTO(classno, classname, teacher, time, limit,left);
                
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public ClassDTO selectByNo(int classno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ClassDTO dto = new ClassDTO();
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql="select * from class where classno = ?";
            ps = con.prepareStatement(sql);
            
            //4.
            rs = ps.executeQuery();
            if(rs.next()){
                classno = rs.getInt("classno");
                String classname = rs.getString("classname");
                String teacher = rs.getString("teacher");
                String time = rs.getString("time");
                int limit = rs.getInt("limit");
                int left = rs.getInt("left");
                
                dto.setClassNo(classno);
                dto.setClassName(classname);
                dto.setTeacher(teacher);
                dto.setTime(time);
                dto.setLimit(limit);
                dto.setLeft(left);
            }
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public void submit(int classno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql="update class set left=left-1 where classno=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, classno);
            
            //4.
            int cnt = ps.executeUpdate();
            System.out.println("업데이트 결과 cnt="+cnt);
            
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public boolean selectLeft(int classno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result=true;
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql="select left from class where classno=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, classno);
            //4
            rs = ps.executeQuery();
            if(rs.next()){
                int cnt = rs.getInt(1);
                if(cnt>0){
                    result=true;
                }else{
                    result=false;
                }
            }
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public int insert(ClassDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql = "insert into class" +
            " values(c_seq.nextval,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getClassName());
            ps.setString(2, dto.getTeacher());
            ps.setString(3, dto.getTime());
            ps.setInt(4, dto.getLimit());
            ps.setInt(5, dto.getLimit());
            
            //4
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int update(ClassDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql = "update class"
                    + " set classname=?, teacher=?, time=?, limit=?, left=?"
                    + " where classno=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getClassName());
            ps.setString(2, dto.getTeacher());
            ps.setString(3, dto.getTime());
            ps.setInt(4, dto.getLimit());
            ps.setInt(5, dto.getLimit());
            ps.setInt(6, dto.getClassNo());
            
            //4
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int delete(int classno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql = "delete from class where classno=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, classno);
            
            //4
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    
}
