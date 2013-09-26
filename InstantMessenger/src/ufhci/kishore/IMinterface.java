/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufhci.kishore;

import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 *
 * @author Kishore
 */
public class IMinterface extends javax.swing.JApplet {
    private ArrayList<String> activeChats = new ArrayList<String>(50); 
    private ArrayList<chatPan> activeChatPan = new ArrayList<chatPan>(50);
    public static TreeMap activeChatStrings = new TreeMap(); 
    private ArrayList<String> nameList = new ArrayList<String>(50);
    private ArrayList<struct> structList = new ArrayList<struct>();
    private int activeCount =0;
    
    private static ArrayList<String> taskListPractice = new ArrayList<String>(10);
    private static ArrayList<String> taskListRec = new ArrayList<String>(10);
    public static String Result=null;
    public static boolean praticeOn = true;
    public static int cmdMode =0;
    
    private static Clipboard clipboard = null;
    
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(IMinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initComponents();
                    initContacts(contactList);
                    initTaskList();
                    clipboard = getToolkit().getSystemClipboard();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateDisplay(boolean prac, int index){
        if (prac){
            if(index == 77){
                infoDisplay.setText("Great! Now that you have practiced, whenever you are ready for the recorded TaskList Click the button below.");
                taskTextArea.setText("Results will be posted here");
            }else{
                infoDisplay.setText(taskListPractice.get(index));
                taskTextArea.setText("Task: "+ String.valueOf(index)+ " out of 10");
            }
        }else{
            if(index == 77){
                infoDisplay.setText("Congratulations! Work Done. Result text should be copied to clipboard, otherwise, please copy text from below, and email to kishore@cise.ufl.edu");
                taskTextArea.setText(Result);
                taskTextArea.setEnabled(true);
                taskTextArea.setEditable(true);
                taskTextArea.setFocusable(true);
                taskTextArea.selectAll();
                StringSelection data;
                data = new StringSelection(Result);
                clipboard.setContents(data, data);
            }else{
                infoDisplay.setText(taskListRec.get(index));
                taskTextArea.setText("Task: "+ String.valueOf(index)+ " out of 10");
            }
        }        
    }
    
    public static void updateCommand(int cmdMo){
        cmdMode = cmdMo;
        switch (cmdMo){
            case 99:// after init... going into Pratice task list
                taskMainBut.setText("Skip Current Task");
                break;
            case 1: // after practice task list.. going into actual measurement
                taskMainBut.setText("Launch TaskList (Recorded round)");
                break;
            case 2:// done.. show result copy and send email
                taskMainBut.setText("Click to complete the Final Survey");
                break;
            default:
                //TODO error handling
                break;
        }
    }
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        tabbedPanel = new javax.swing.JTabbedPane();
        ContactsBasePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        myContactIcon = new javax.swing.JLabel();
        myStatus = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        contactSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        infoDisplay = new javax.swing.JLabel();
        taskMainBut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskTextArea = new javax.swing.JTextArea();

        tabbedPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tabbedPanelComponentRemoved(evt);
            }
        });
        tabbedPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabbedPanelPropertyChange(evt);
            }
        });

        myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/online-icon.png"))); // NOI18N
        myContactIcon.setFocusable(false);

        myStatus.setBackground(new java.awt.Color(51, 255, 51));
        myStatus.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        myStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Busy", "Idle", "Invisible", "Sign out" }));
        myStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myStatusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText(" Jed I Knight");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myContactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(myContactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contactSearch.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        contactSearch.setText("Search for a contact...");
        contactSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contactSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactSearchFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/search-icon-512.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/add-user-icon.png"))); // NOI18N
        jButton2.setToolTipText("Add new contact");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/remove_user.png"))); // NOI18N
        jButton3.setToolTipText("Remove selected Contact");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/settings-icon.png"))); // NOI18N
        jButton4.setToolTipText("Settings");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        contactList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        contactList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                contactListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(contactList);

        javax.swing.GroupLayout ContactsBasePanelLayout = new javax.swing.GroupLayout(ContactsBasePanel);
        ContactsBasePanel.setLayout(ContactsBasePanelLayout);
        ContactsBasePanelLayout.setHorizontalGroup(
            ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContactsBasePanelLayout.createSequentialGroup()
                .addGroup(ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContactsBasePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ContactsBasePanelLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContactsBasePanelLayout.createSequentialGroup()
                        .addComponent(contactSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
        ContactsBasePanelLayout.setVerticalGroup(
            ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContactsBasePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContactsBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoDisplay.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        infoDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoDisplay.setText("Check out the interface. Whenever you are ready, Click on the button below to start practice round.");

        taskMainBut.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        taskMainBut.setText("Launch TaskList (Practice round)");
        taskMainBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskMainButActionPerformed(evt);
            }
        });

        taskTextArea.setEditable(false);
        taskTextArea.setBackground(new java.awt.Color(240, 240, 240));
        taskTextArea.setColumns(20);
        taskTextArea.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        taskTextArea.setRows(1);
        taskTextArea.setBorder(null);
        taskTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        taskTextArea.setEnabled(false);
        taskTextArea.setFocusable(false);
        jScrollPane2.setViewportView(taskTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(taskMainBut, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(infoDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(taskMainBut, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addComponent(ContactsBasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabbedPanel)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContactsBasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void contactSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactSearchFocusGained
        contactSearch.setText("");
        contactSearch.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }//GEN-LAST:event_contactSearchFocusGained

    private void myStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myStatusActionPerformed
        switch (myStatus.getSelectedIndex()){
            case 0:
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/online-icon.png")));
                myStatus.setBackground(Color.GREEN);
                break;
            case 1:
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/busy-icon.png")));
                myStatus.setBackground(Color.RED);
                break;
            case 2:
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/away-icon.png")));
                myStatus.setBackground(Color.YELLOW);
                break;
            case 3:
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/offline-icon.png")));
                myStatus.setBackground(Color.GRAY);
                break;
            case 4:
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/offline-icon.png")));
                myStatus.setBackground(Color.GRAY);
                myPopup exitPop = new myPopup();
                exitPop.mysetVisible(true);
                myContactIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/online-icon.png")));
                myStatus.setBackground(Color.GREEN);
                myStatus.setSelectedIndex(0);
                break;
            default:
            //TODO error handling
            break;
        }
        taskSuper.getInstance().reportAction("combobox");
    }//GEN-LAST:event_myStatusActionPerformed

    private void contactListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_contactListValueChanged
        if (contactList.getSelectedIndex() != -1) {
            struct selStruct =  (struct) contactList.getSelectedValue();
            String conName = selStruct.conName;
            boolean foundMatch = false;
            for(int it=0; it<activeCount; it++){
                 if(true == conName.equals(activeChats.get(it))){
                     foundMatch = true;
                     tabbedPanel.setSelectedIndex(it);
                 }      
            }
           if(false == foundMatch){
                activeChatPan.add(new chatPan(tabbedPanel, conName, activeChatStrings.get(conName).toString()));
                activeChats.add(conName);
                activeCount++;
           }
        } else {
        //TODO: handle error case
        }
    }//GEN-LAST:event_contactListValueChanged

    private void tabbedPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabbedPanelComponentRemoved
        Component compe = evt.getChild();
        String conName = compe.getName();
        removeChatTab(conName);
    }//GEN-LAST:event_tabbedPanelComponentRemoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean found = false;
        for (int it =0; it < nameList.size(); it++){
            if(nameList.get(it).equalsIgnoreCase(contactSearch.getText())){
                contactList.setSelectedIndex(it);
                found = true;
                break;
            }
        }
        if (!found){
            contactList.clearSelection();
        }
        taskSuper.getInstance().reportAction("searchcon");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void contactSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactSearchFocusLost
//TODO : remove focus code
    }//GEN-LAST:event_contactSearchFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String newData;
        Icon addCon = new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/add-user-icon.png"));
        taskSuper.getInstance().reportAction("add");
        newData = (String) JOptionPane.showInputDialog(null, "Please enter the Full Name of the person you want to add", "Add a new contact", JOptionPane.PLAIN_MESSAGE, addCon, null, "Full Name ...");
        if (newData.isEmpty() || newData.equals("Full Name ...")){
            JOptionPane.showMessageDialog(null, "Invalid Name", "Add a new contact", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nameList.add(newData);
        activeChatStrings.put(newData, "");
        Object[] possibilities = {"Male", "Female", "Other"};
        String gender = (String)JOptionPane.showInputDialog(null,"Please select the gender of the person","Add a new contact",JOptionPane.PLAIN_MESSAGE, addCon, possibilities, "Male");
        structList.add(addContactInit(gender.equalsIgnoreCase("male"),(int)(Math.random()*5),newData));
        contactList.setListData(structList.toArray());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        struct selVal = (struct) contactList.getSelectedValue();
        int selID = contactList.getSelectedIndex();
        String conName;
        Icon addCon = new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/remove_user.png"));
        if(selVal != null){
            conName = selVal.conName;
            structList.remove(selID);
            contactList.setListData(structList.toArray());
            contactList.repaint();
            nameList.remove(selID);
            activeChatStrings.remove(conName);
            if(activeChats.contains(conName)){
                for (int it =0; it < activeCount; it++){
                    if(activeChats.get(it).equalsIgnoreCase(conName)){
                        JPanel revist = activeChatPan.get(it).getInternalPanel();
                        int index = tabbedPanel.indexOfComponent(revist);
                        tabbedPanel.remove(index);
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Selected contact has been deleted!", "Delete contact", JOptionPane.ERROR_MESSAGE, addCon);
            taskSuper.getInstance().reportAction("delete");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a contact to delete", "Delete contact", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "Settings menu is under development.\nSorry for the inconvience.","Settings",JOptionPane.INFORMATION_MESSAGE);
        taskSuper.getInstance().reportAction("settings");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void taskMainButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskMainButActionPerformed
        switch (cmdMode){
            case 0:// after init... going into Pratice task list
                taskSuper.getInstance().startPracticeTaskList();
                break;
            case 1: // after practice task list.. going into actual measurement
                taskSuper.getInstance().startTaskList();
                break;
            case 2:// done.. show result copy and send email
                 try
                {
                    AppletContext a = getAppletContext();
                    URL u = new URL("http://bit.ly/ufhciSurvey");
                    a.showDocument(u,"_blank");
                }
                catch (MalformedURLException e){
                }
                break;
            case 99://skipping current task
                taskSuper.getInstance().skipTask();
                break;
            default:
                //TODO error handling
                break;
        }
        
    }//GEN-LAST:event_taskMainButActionPerformed

    private void tabbedPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabbedPanelPropertyChange
        
    }//GEN-LAST:event_tabbedPanelPropertyChange

    private void removeChatTab(String conName){
        int it=0;
        for(; it<activeCount; it++){
            if (conName.equals(activeChats.get(it))){
                break;
            }
        }
        if(it<activeCount){
            activeChatPan.remove(it);
            activeChats.remove(it);
            activeCount--;
            Component selVal = tabbedPanel.getSelectedComponent();
            if (selVal == null){
                contactList.clearSelection();
            }else{
                String nextChat = selVal.getName();
                for(it =0; it<nameList.size(); it++){            
                    if (nextChat.equals(nameList.get(it))){
                        contactList.setSelectedIndex(it);
                    }
                }
            }
        }
    }
    
    private void initContacts(JList contactList){
        String initHist = "Jed I Knight : Hello\nDr. Lok : Hi, how can I help you today?\nJed I Knight : Research\nDr. Lok : I lead the Virtual Experiences Research Group (VERG).  We develop and study virtual humans and mixed reality interfaces.  If you haven\'t already, please visit our webpage at verg.cise.ufl.edu to look at our work.  In particular, please look athe Virtual Patients and the Augmented Anesthesia Machine project pages.\nJed I Knight : Goodbye\nDr. Lok : Thanks for chatting.  Please keep the following passcode for contacting the \'real\' me: verg\n";
        nameList.add("Tony Stark");nameList.add("Dr. Benjamin Lok ");
        nameList.add("Adele Adkins");nameList.add("Katy Perry");
        nameList.add("Bruno Mars");nameList.add("Enrique Iglesias");
        nameList.add("Rihanna Fenty");nameList.add("Luke Bryan");
        nameList.add("Tramar Dillard");nameList.add("Taylor Swift");
        ArrayList<Boolean> gender = new ArrayList<Boolean>(10);
        gender.add(true);gender.add(true);
        gender.add(false);gender.add(false);
        gender.add(true);gender.add(true);
        gender.add(false);gender.add(true);
        gender.add(true);gender.add(false);
        for(int it=0;it<10;it++)
        {
            activeChatStrings.put(nameList.get(it), initHist);
            structList.add(addContactInit(gender.get(it),(int)(Math.random()*5),nameList.get(it)));
        }
        contactList.setCellRenderer(new newCellRenderer());
        contactList.setListData(structList.toArray());
    }
    
    private struct addContactInit(Boolean gender, int status, String contactName){

    String iconPath = null;

    if (gender == true)//male
     {
         switch (status){
             case 1:// busy
                 iconPath = "/ufhci/kishore/Images/busy-icon-48.png";
                 break;
             case 2://idle
                 iconPath = "/ufhci/kishore/Images/away-icon-48.png";
                 break;
             case 3://invisibe
                 iconPath = "/ufhci/kishore/Images/offline-icon-48.png";
                 break;
             case 4:// music
                 iconPath = "/ufhci/kishore/Images/music-icon-48.png";
                 break;
             default://regular
                iconPath = "/ufhci/kishore/Images/online-icon-48.png";
                 break;
         }
     }
     else//female
     {
         switch (status){
             case 0://regular
                 iconPath = "/ufhci/kishore/Images/online-girl-icon-48.png";
                 break;
             case 1:// busy
                 iconPath = "/ufhci/kishore/Images/busy-girl-icon-48.png";
                 break;
             case 2://idle
                 iconPath = "/ufhci/kishore/Images/away-girl-icon-48.png";
                 break;
             case 3://invisible
                 iconPath = "/ufhci/kishore/Images/offline-icon-48.png";
                 break;
             case 4:// music
                 iconPath = "/ufhci/kishore/Images/music-girl-icon-48.png";
                 break;
             case 5://shopping
                 iconPath = "/ufhci/kishore/Images/shipping-girl-icon-48.png";
                 break;
         }
     }
    struct compStruct = new struct();
    compStruct.conIcon = new javax.swing.ImageIcon(getClass().getResource(iconPath)); // NOI18N
    if(contactName.length() > 2){
        compStruct.conName = contactName;
    }else{
        compStruct.conName = "Unknown Contact";
    }
    return compStruct;
}
    
    private void initTaskList(){
        taskListPractice.add("Start a voice chat with a contact.");
        taskListPractice.add("End a voice chat with a contact.");
        taskListPractice.add("Change status of user.");
        taskListPractice.add("Search for a contact.");
        taskListPractice.add("Type \"What is a virtual human?\" and send to a contact.");
        taskListPractice.add("Save the chat to chat history.");
        taskListPractice.add("Add a new contact.");
        taskListPractice.add("View the chat history with a contact.");
        taskListPractice.add("Search chat history.");
        taskListPractice.add("Delete a contact.");

        taskListRec.add("Add a new contact.");
        taskListRec.add("Type \"What is a virtual human?\" and send to a contact.");
        taskListRec.add("Save the chat to chat history.");
        taskListRec.add("View the chat history with a contact.");
        taskListRec.add("Search chat history.");
        taskListRec.add("Delete a contact.");
        taskListRec.add("Search for a contact.");
        taskListRec.add("Start a voice chat with a contact.");
        taskListRec.add("End a voice chat with a contact.");
        taskListRec.add(" Change status of user.");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContactsBasePanel;
    private javax.swing.JPanel basePanel;
    private javax.swing.JList contactList;
    private javax.swing.JTextField contactSearch;
    private static javax.swing.JLabel infoDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel myContactIcon;
    private javax.swing.JComboBox myStatus;
    private javax.swing.JTabbedPane tabbedPanel;
    private static javax.swing.JButton taskMainBut;
    private static javax.swing.JTextArea taskTextArea;
    // End of variables declaration//GEN-END:variables
}

class struct{
    public String conName;
    public Icon conIcon;
}


class newCellRenderer extends JLabel implements ListCellRenderer<Object> {
     public newCellRenderer() {
         setOpaque(true);
     }

    @Override
     public Component getListCellRendererComponent(JList<?> list,
                                                   Object value,
                                                   int index,
                                                   boolean isSelected,
                                                   boolean cellHasFocus) {
         
         struct reHash = (struct)value;
         setText(reHash.conName);
         setFont(new java.awt.Font("Verdana", 0, 12));
         Color background;
         Color foreground;
         // check if this cell represents the current DnD drop location
         JList.DropLocation dropLocation = list.getDropLocation();
         if (dropLocation != null
                 && !dropLocation.isInsert()
                 && dropLocation.getIndex() == index) {

             background = Color.BLUE;
             foreground = Color.WHITE;

         // check if this cell is selected
         } else if (isSelected) {
             background = Color.YELLOW;
             foreground = Color.BLACK;

         // unselected, and not the DnD drop location
         } else {
             background = Color.WHITE;
             foreground = Color.BLACK;
         }
         setIcon(reHash.conIcon);
         setBackground(background);
         setForeground(foreground);
         return this;
     }
 }