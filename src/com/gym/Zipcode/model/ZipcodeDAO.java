/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Zipcode.model;

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
public class ZipcodeDAO {
    public ArrayList<ZipcodeDTO> searchDong(String dong) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ZipcodeDTO> list = new ArrayList<>();
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql = "select * from zipcode where dong like '%' || ? || '%' ";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dong);
            
            //4.
            rs = ps.executeQuery();
            while(rs.next()){
                String zipcode = rs.getString("zipcode");
                String sido = rs.getString("sido");
                String gugun = rs.getString("gugun");
                dong = rs.getString("dong");
                String startbunji = rs.getString("startbunji");
                String endbunji = rs.getString("endbunji");
                int seq = rs.getInt("seq");
                
                ZipcodeDTO dto = new ZipcodeDTO(zipcode, sido, gugun, dong, startbunji, endbunji, seq);
                
                list.add(dto);
            }
            System.out.println("우편번호 검색 결과, list.size()= "+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
