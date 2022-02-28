/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Submit.model;

import com.gym.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author STU-13
 */
public class SubmitDAO {
    public int Submit(int classno,int memno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql ="insert into submit"
                    + " values(sub_seq.nextval,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, classno);
            ps.setInt(2, memno);
            
            //4.
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public boolean checkSubmitted(int classno,int memno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean result = false;
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql ="select count(*) from submit"
                    + " where classno=? and memno=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, classno);
            ps.setInt(2, memno);
            
            //4.
            rs = ps.executeQuery();
            while(rs.next()){
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
