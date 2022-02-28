/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.view;

import com.gym.Member.model.MemberDAO;
import com.gym.Member.model.MemberDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author STU-13
 */
public class EditFrame extends javax.swing.JFrame implements ActionListener{
    private MemberDAO dao;
    private U_HomeFrame UF;
    private MemberDTO dto;
    /**
     * Creates new form EditFrame
     */
    public EditFrame() {
        initComponents();
        
        init();
        addEvent();
    }

    public EditFrame(U_HomeFrame UF,MemberDTO dto){
        this();
        
        this.UF=UF;
        this.dto=dto;
        setMember();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btEdit = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        cbProg = new javax.swing.JComboBox<>();
        tfEmail1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfPwd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cbTel1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfTel2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTel3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfZipcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfAddress1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAddress2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btEdit.setText("수정");

        btSearch.setText("번호검색");

        tfName.setEditable(false);

        cbProg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "기본사용권", "다이어트PT", "재활PT", "웨딩케어PT", "체형교정PT", "산후PT", "운동선수PT", "토탈PT" }));

        tfEmail1.setEditable(false);

        jLabel9.setText("가입상품");

        tfPwd.setEditable(false);

        jLabel1.setText("이름");

        cbTel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "010", "011", "012", "013", "014", "015", "016", "017", "050", "060", "070", " " }));

        jLabel2.setText("이메일");

        jLabel3.setText("비밀번호");

        jLabel4.setText("전화번호");

        jLabel5.setText("우편번호");

        jLabel6.setText("주소");

        jLabel7.setText("상세주소");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(tfTel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfAddress2)
                    .addComponent(tfAddress1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfPwd)
                    .addComponent(cbProg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEmail1)
                    .addComponent(tfName))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(39, 39, 39)
                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbProg;
    private javax.swing.JComboBox<String> cbTel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    public javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfPwd;
    private javax.swing.JTextField tfTel2;
    private javax.swing.JTextField tfTel3;
    public javax.swing.JTextField tfZipcode;
    // End of variables declaration//GEN-END:variables

    private void addEvent() {
        btEdit.addActionListener(this);
        btSearch.addActionListener(this);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dao = new MemberDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btEdit){
            try {
                memEdit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==btSearch){
            Subzipcode f = new Subzipcode(this);
            f.setVisible(true);
        }
}

    private void memEdit() throws SQLException {
         //1.
            int memno = dto.getMemNo();
            String memname = dto.getMemName();
            String mememail = dto.getMemEmail();
            String mempwd = dto.getMemPwd();
            String tel2=tfTel2.getText();
            String tel3=tfTel3.getText();
            String memtel="";
            String memzip = tfZipcode.getText();
            String memaddr = tfAddress1.getText();
            String memaddrdetail = tfAddress2.getText();
            Timestamp memRegdate = dto.getMemRegdate();
            int progno  = 100;
            
            int program = cbProg.getSelectedIndex();
            
            switch(program){
                case 0:
                    break;
                case 1:
                    progno=101;
                    break;
                case 2:
                    progno=102;
                    break;
                case 3:
                    progno=103;
                    break;
                case 4:
                    progno=104;
                    break;
                case 5:
                    progno=105;
                    break;
                case 6:
                    progno=106;
                    break;
                case 7:
                    progno=107;
                    break;
            }
            if(tel2!=null && !tel2.isEmpty() && tel3!=null && !tel3.isEmpty()){
                memtel = cbTel1.getSelectedItem().toString()+"-"+tel2+"-"+tel3;
            }else{
                JOptionPane.showMessageDialog(this, "전화번호를 바르게 입력해주세요");
                return;
            }
            
            //2
            MemberDTO dto = new MemberDTO(memno, memname, mememail, mempwd, memtel, memzip, memaddr, memaddrdetail, memRegdate, progno);
            
            int cnt = dao.updateMember(dto);
            
            if(cnt>0){
                JOptionPane.showMessageDialog(this, "수정되었습니다!");
                UF.p=false;
                UF.setting(UF.p);
                this.dispose();
            }
    }

    private void setMember() {
        tfName.setText(dto.getMemName());
        tfAddress1.setText(dto.getMemAddr());
        tfAddress2.setText(dto.getMemAddrDetail());
        tfEmail1.setText(dto.getMemEmail());
        String hp = dto.getMemTel();
        if(hp!=null && !hp.isEmpty()){
            String[] hpArr=hp.split("-");
            
            tfTel2.setText(hpArr[1]);
            tfTel3.setText(hpArr[2]);
            cbTel1.setSelectedItem(hpArr[0]);
        }
        tfZipcode.setText(dto.getMemZip());
    }
}