/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiCliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiServer.Consignment;
import rmiServer.Employee;
import rmiServer.Exemplo01;
import rmiServer.Portion;

/**
 *
 * @author Jhonathan
 */
public class Pay extends javax.swing.JFrame {
    
    List<Portion> listPortion = new ArrayList<Portion>();
    List<Consignment> listConsignment = new ArrayList<Consignment>();
    List<Employee> listEmployee = new ArrayList<Employee>();

    /**
     * Creates new form Pay
     */
    public Pay() throws RemoteException, NotBoundException {
        initComponents();
        listConsignmente();
    }
    
    public void listConsignmente() throws RemoteException, NotBoundException{
        Exemplo01 ex = new Exemplo01();
        listConsignment = ex.getConsigment();
        listEmployee = ex.getEmployee();
        Registry reg;
        reg = LocateRegistry.getRegistry("localhost", 7000);
            rmiServer.IExemplo01 exemploRmi =
            (rmiServer.IExemplo01) reg.lookup("ExemploRMI01");
            listConsignment = exemploRmi.getConsigment();
            listEmployee = exemploRmi.getEmployee();
            
        String value_consignment;      
            
        String [] colunas = {"Matricula","Funcionário", "Valor da Consignação", "Banco", "N° de Contrato", "Data"}; 
        String [][] dados = new String[listConsignment.size()][colunas.length];
        for(int i = 0 ; i < listConsignment.size() ; i++){
                
            value_consignment = String.format("%.2f", listConsignment.get(i).getValue_consignment());

            dados[i][0] = listConsignment.get(i).getRegistration()+ "";
            for(int j = 0; j < listEmployee.size(); j++){
                if(listEmployee.get(j).getRegistration() == listConsignment.get(i).getRegistration()){
                    dados[i][1] = listEmployee.get(j).getName();
                }
            }
            dados[i][2] = value_consignment;
            dados[i][3] = listConsignment.get(i).getBank()+ "";
            dados[i][4] = listConsignment.get(i).getContract_number()+ "";
            dados[i][5] = listConsignment.get(i).getDay()+
                    "/"+listConsignment.get(i).getMonth()+"/"+listConsignment.get(i).getYear();
        }
            jTable2.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));
    }
    
    public void listPortion() throws RemoteException, NotBoundException{
        
        Exemplo01 ex = new Exemplo01();
        listPortion = ex.getPortions();
        listConsignment = ex.getConsigment();
        Registry reg;
        reg = LocateRegistry.getRegistry("localhost", 7000);
            rmiServer.IExemplo01 exemploRmi =
            (rmiServer.IExemplo01) reg.lookup("ExemploRMI01");
            listPortion = exemploRmi.getPortions();
            listConsignment = exemploRmi.getConsigment();
            
        int tie = 0;
        for(int l = 0; l < listConsignment.size(); l++){
            if(listConsignment.get(l).getContract_number() == Integer.parseInt(contract_number.getText())){
                tie = listConsignment.get(l).getPlots();
            }
        }
        String [] colunasP = {"Nº Contrato", "Valor da Parcela", "Estado", "Data"};
        String [][] dadosP = new String[tie][colunasP.length];
        
        String portion_value;
        
        for(int i = 0 ; i < listPortion.size(); i++){
            if(Integer.parseInt(contract_number.getText()) == listPortion.get(i).getContract_number()){
                for(int j = 0; j < tie; j++){
                    
                    portion_value = String.format("%.2f", listPortion.get(i).getPortion_value());
                    
                    dadosP[j][0] = listPortion.get(i).getContract_number()+ "";
                    dadosP[j][1] = portion_value;
                    dadosP[j][2] = listPortion.get(i).getStatus()+ "";
                    dadosP[j][3] = listPortion.get(i).getDay()+
                            "/"+listPortion.get(i).getMonth()+"/"+listPortion.get(i).getYear();
                    i++;
                }
            }
        }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(dadosP,colunasP));
    }
    
    public void payInstallmentMonth() throws RemoteException, NotBoundException{
        
        Exemplo01 ex = new Exemplo01();
            
            Registry reg;
            reg = LocateRegistry.getRegistry("localhost", 7000);
                rmiServer.IExemplo01 exemploRmi =
                (rmiServer.IExemplo01) reg.lookup("ExemploRMI01");
                
            if(Integer.parseInt(month.getText()) == 0){
                listPortion();
            }else{
                exemploRmi.payInstallment(Integer.parseInt(month.getText()));
                listPortion();
            }
            new PaymentMessage().setVisible(true);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        month = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contract_number = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setText("Pagar Parcelas");

        jButton1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        month.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        month.setText("0");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel3.setText("Escolha mês que deseja pagar");

        contract_number.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        contract_number.setText("0");

        jButton2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel1.setText("Nº Contrato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel3))
                        .addGap(60, 407, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contract_number, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contract_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            listPortion();
        } catch (RemoteException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            payInstallmentMonth();
        } catch (RemoteException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pay().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contract_number;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField month;
    // End of variables declaration//GEN-END:variables
}
