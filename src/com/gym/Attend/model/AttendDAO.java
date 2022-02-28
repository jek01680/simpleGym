/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gym.Attend.model;

import com.gym.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author STU-13
 */
public class AttendDAO {
    
    public int printAtt(int memno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="insert into attend(attno,attdate,memno)" +
                        " values(att_seq.nextval,sysdate,?)";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, memno);
            
            //4.
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
   public ArrayList<AttendDTO> selectAll(int memno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                 
        ArrayList<AttendDTO> list = new ArrayList<>();
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql = "select attno,attdate,memno from attend where memno=?"
                    + " order by attno desc";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, memno);
            //4
            rs = ps.executeQuery();
            while(rs.next()){
                int attno = rs.getInt("attno");
                Timestamp attdate = rs.getTimestamp("attdate");
                memno = rs.getInt("memno");
                
                AttendDTO dto = new AttendDTO(attno, attdate, memno);
                
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
   
   public boolean check(int memno) throws SQLException{
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs= null;
       
       boolean result=false;
       try{
           con = DBUtil.getConnection();
           
           String sql="select count(*) from attend where memno=?"
                   + " and trunc(attdate)=trunc(sysdate)";
           ps = con.prepareStatement(sql);
           ps.setInt(1, memno);
           
           rs = ps.executeQuery();
           if(rs.next()){
               int count = rs.getInt(1);
               
               if(count>0){
                   result=false;
               }else{
                   result=true;
               }
           }
           return result;
       }finally{
           DBUtil.dbClose(rs, ps, con);
       }
   }
}
