package Main.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.Main;

import javax.swing.*;

/**
 *
 * @author erfan
 */
public class CityMenu extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form CityMenu
     */
    public CityMenu() {
        initComponents();
        setVisible(true);
        Thread t1 = new Thread(this , "update Budget");
        t1.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        cityLabel = new javax.swing.JLabel();
        cityNameLabel = new javax.swing.JLabel();
        budgetLabel = new javax.swing.JLabel();
        budgetAmountLabel = new javax.swing.JLabel();
        terminalButton = new javax.swing.JButton();
        vehicleButton = new javax.swing.JButton();
        engageButton = new javax.swing.JButton();
        hotelButton = new javax.swing.JButton();
        roomButton = new javax.swing.JButton();
        journeyButton = new javax.swing.JButton();
        bankButton = new javax.swing.JButton();
        statusButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        cityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLabel.setText("City : ");

        cityNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityNameLabel.setText(Main.selectedCity.getCityName());

        budgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetLabel.setText("Budget : ");

        budgetAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAmountLabel.setText(String.valueOf( Main.selectedCity.getBudget() ) );

        terminalButton.setText("Build Terminal");
        terminalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminalButtonActionPerformed(evt);
            }
        });

        vehicleButton.setText("Buy Vehicle");
        vehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleButtonActionPerformed(evt);
            }
        });

        engageButton.setText("Engage");
        engageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engageButtonActionPerformed(evt);
            }
        });

        hotelButton.setText("Build Hotel");
        hotelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelButtonActionPerformed(evt);
            }
        });

        roomButton.setText("Build Room");
        roomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomButtonActionPerformed(evt);
            }
        });

        journeyButton.setText("Make Journey");
        journeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journeyButtonActionPerformed(evt);
            }
        });

        bankButton.setText("Banks");
        bankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankButtonActionPerformed(evt);
            }
        });

        statusButton.setText("Show Status");
        statusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(budgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(budgetAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(166, 166, 166)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(vehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(roomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(46, 46, 46)
                                                                .addComponent(bankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(113, 113, 113)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(journeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(engageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(7, 7, 7)
                                                                .addComponent(statusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(114, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hotelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(terminalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(budgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(budgetAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(terminalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(engageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hotelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(journeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void terminalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new TerminalMenu();
    }

    private void vehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new BuyVehicleMenu();
    }

    private void engageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new EngageMenu();
    }

    private void hotelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        new BuildHotel();
    }

    private void roomButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        new BuildRoom();
    }

    private void journeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        new JourneyGUI();
    }

    private void bankButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        new BankMenu();
    }

    private void statusButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        new ShowStatusMenu();
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton bankButton;
    private javax.swing.JLabel budgetAmountLabel;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel cityNameLabel;
    private javax.swing.JButton engageButton;
    private javax.swing.JButton hotelButton;
    private javax.swing.JButton journeyButton;
    private javax.swing.JButton roomButton;
    private javax.swing.JButton statusButton;
    private javax.swing.JButton terminalButton;
    private javax.swing.JButton vehicleButton;
    // End of variables declaration



    void updateBudget(){
        while (true) {

            budgetAmountLabel.setText(String.valueOf(Main.selectedCity.getBudget()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public void run(){
        updateBudget();
    }
}
