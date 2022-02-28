/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.Member.model;

import com.gym.Attend.model.AttendDAO;
import com.gym.db.DBUtil;
import com.gym.view.U_HomeFrame;
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
public class MemberDAO {
    public static final int LOGIN_OK=1;
    public static final int PWD_NO=2;
    public static final int EMAIL_NO=3;
    
    public static final int USABLE=1;
    public static final int UNUSABLE=2;
    
    private AttendDAO Adao = new AttendDAO();
    private U_HomeFrame Uf;
    private int memno;
    
    public MemberDAO(){}
    public MemberDAO(U_HomeFrame Uf){
        this();
        this.Uf= Uf;
    }
    public int loginCheck(String email,String pwd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int result=0;
        try {
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select MEMPWD from MEMBER where MEMEMAIL = ?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, email);
            
            //4.
            rs = ps.executeQuery();
            
            if(rs.next()){
                String dbPwd = rs.getString(1);
                
                if(dbPwd.equals(pwd)){
                    //로그인
                    result=LOGIN_OK;
                }else{
                    //비밀번호 틀림
                    result=PWD_NO;
                }
            }else{
                //이메일 존재x
                result=EMAIL_NO;
            }
            System.out.println("로그인 체크 결과, result="+result
                +", 매개변수 email = "+email+", pwd = "+pwd);
            return result;
        } finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public int insertMember(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql="insert into MEMBER(memno,memname,mememail,mempwd,memtel,memzip,memaddr,memaddrdetail,memregdate,progno)" +
                        " values(mem_seq.nextval,?,?,?,?,?,?,?,default,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getMemName());
            ps.setString(2, dto.getMemEmail());
            ps.setString(3, dto.getMemPwd());
            ps.setString(4, dto.getMemTel());
            ps.setString(5, dto.getMemZip());
            ps.setString(6, dto.getMemAddr());
            ps.setString(7, dto.getMemAddrDetail());
            ps.setInt(8, dto.getProgNo());
            
            //4.
            int cnt = ps.executeUpdate();
            
            System.out.println("회원가입 결과, cnt = "+cnt+", 매개변수 dto = "+dto);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public int isdup(String mememail) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result=0;
        
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select count(*) from member where mememail=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, mememail);
            
            //4.
            rs = ps.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                
                if(count>0){
                    result=UNUSABLE;
                }else{
                    result=USABLE;
                }
            }
            System.out.println("아이디 중복확인 결과, result= "+result+
                    ",매개변수 mememail= "+mememail);
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public MemberDTO selectMember(String email) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        MemberDTO dto = new MemberDTO();
        try{
            //1,2
            con = DBUtil.getConnection();
            //3
            String sql="select * from member where mememail=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1,email);
            //4
            rs=ps.executeQuery();
            if(rs.next()){
                int memNo = rs.getInt("memNo");
                String memName = rs.getString("memName");
                String memPwd = rs.getString("memPwd");
                String memTel = rs.getString("memTel");
                String memZip = rs.getString("memZip");
                String memAddr = rs.getString("memAddr");
                String memAddrDetail = rs.getString("memAddrDetail");
                Timestamp memRegdate = rs.getTimestamp("memRegdate");
                int ProgNo = rs.getInt("ProgNo");
                
                dto.setMemAddr(memAddr);
                dto.setMemAddrDetail(memAddrDetail);
                dto.setMemEmail(email);
                dto.setMemName(memName);
                dto.setMemNo(memNo);
                dto.setMemPwd(memPwd);
                dto.setMemRegdate(memRegdate);
                dto.setMemTel(memTel);
                dto.setMemZip(memZip);
                dto.setProgNo(ProgNo);
            }
            System.out.println("회원정보 조회 결과, dto="+dto+", 매개변수 email= "+email);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public ArrayList<MemberDTO> selectAll() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        try{
            con=DBUtil.getConnection();
            
            String sql="select * from member"
                    + " order by memno desc";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                int memno = rs.getInt("memno");
                String memname = rs.getString("memname");
                String mememail = rs.getString("mememail");
                String mempwd = rs.getString("mempwd");
                String memtel = rs.getString("memtel");
                String memzip = rs.getString("memzip");
                String memaddr = rs.getString("memaddr");
                String memaddrdetail = rs.getString("memaddrdetail");
                Timestamp memregdate = rs.getTimestamp("memregdate");
                int progno = rs.getInt("progno");
                
                MemberDTO dto = new MemberDTO(memno, memname, mememail, mempwd, memtel, memzip, memaddr, memaddrdetail, memregdate, progno);
        
                list.add(dto);
                
                System.out.println("listSize= "+list.size());
            }
        return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public int updateMember(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3.
            String sql="update member"
                    + " set memtel=?,memzip=?,memaddr=?,memaddrdetail=?,progno=?"
                    + " where mememail=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getMemTel());
            ps.setString(2, dto.getMemZip());
            ps.setString(3, dto.getMemAddr());
            ps.setString(4, dto.getMemAddrDetail());
            ps.setInt(5, dto.getProgNo());
            ps.setString(6, dto.getMemEmail());
            
            //4
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }     
    }
    
    public int deleteMember(String email) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            
            //3
            String sql="delete from member where mememail=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, email);
            //4
            int cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
}
