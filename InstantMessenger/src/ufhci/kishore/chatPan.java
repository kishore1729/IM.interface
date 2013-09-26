/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufhci.kishore;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Kishore
 */
public class chatPan extends JPanel{
    private final javax.swing.JTabbedPane parentPane;
    private javax.swing.JTextArea chatLog;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JTextArea chatText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane chatScr;
    private javax.swing.JButton saveHistory;
    private javax.swing.JButton viewHistory;
    private javax.swing.JButton jButton7;
    private String chatHIst;
    private boolean micMute = false;
    private boolean spkMute = false;
    private boolean callHold = false;
    private int offset =0;    
    // End of variables declaration

    chatPan(JTabbedPane tabbedPanel, String contactName, String inHist) {
        parentPane = tabbedPanel;
        chatHIst = inHist;
        initComponents(parentPane);
        parentPane.setTitleAt(parentPane.indexOfComponent(this.chatPanel), contactName);
        this.setName(contactName);
        chatPanel.setName(contactName);
        chatLog.setText(chatHIst);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setBorder(BorderFactory.createEtchedBorder());
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(buttonMouseListener);
        jButton1.setRolloverEnabled(true);
        
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setBorder(BorderFactory.createEtchedBorder());
        jButton2.setBorderPainted(false);
        jButton2.addMouseListener(buttonMouseListener);
        jButton2.setRolloverEnabled(true);
        
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setBorder(BorderFactory.createEtchedBorder());
        jButton3.setBorderPainted(false);
        jButton3.addMouseListener(buttonMouseListener);
        jButton3.setRolloverEnabled(true);
        
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setBorder(BorderFactory.createEtchedBorder());
        jButton4.setBorderPainted(false);
        jButton4.addMouseListener(buttonMouseListener);
        jButton4.setRolloverEnabled(true);
        
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setBorder(BorderFactory.createEtchedBorder());
        jButton5.setBorderPainted(false);
        jButton5.addMouseListener(buttonMouseListener);
        jButton5.setRolloverEnabled(true);
        
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setBorder(BorderFactory.createEtchedBorder());
        jButton6.setBorderPainted(false);
        jButton6.addMouseListener(buttonMouseListener);
        jButton6.setRolloverEnabled(true);
        
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setBorder(BorderFactory.createEtchedBorder());
        jButton7.setBorderPainted(false);
        jButton7.addMouseListener(buttonMouseListener);
        jButton7.setRolloverEnabled(true);
    }
    
    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }
 
        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
     
    private void initComponents(JTabbedPane parentPane) {

        chatPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatLog = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        chatText = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jTextField1 = new javax.swing.JTextField();
        viewHistory = new javax.swing.JButton();
        saveHistory = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        
        chatLog.setEditable(false);
        chatLog.setColumns(20);
        chatLog.setFont(new java.awt.Font("Verdana", Font.PLAIN, 12)); // NOI18N
        chatLog.setRows(5);
        chatLog.setToolTipText("Chat Log");
        chatLog.setWrapStyleWord(true);
        chatLog.setLineWrap(true);
        jScrollPane1.setViewportView(chatLog);
        chatLog.getAccessibleContext().setAccessibleParent(chatPanel);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jTextField1.setText("Search Chat History..");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        chatText.setText("Enter text here");
        chatText.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                chatTextFocusGained(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/red_square_error.png"))); // NOI18N
        jButton1.setToolTipText("Close this Chat window");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/iphone-call-icon.jpg"))); // NOI18N
        jButton2.setToolTipText("Call contact");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/droidxphoneiconendcall.jpg"))); // NOI18N
        jButton3.setToolTipText("End Call");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/IconsLandmic on.png"))); // NOI18N
        jButton4.setToolTipText("Mute/Unmute mic");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/speaker-icon.png"))); // NOI18N
        jButton5.setToolTipText("Mute/Unmute Speakers");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/hold-icon.png"))); // NOI18N
        jButton6.setToolTipText("Hold call");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jSlider1.setEnabled(false);
        chatText.setLineWrap(true);
        chatScr = new JScrollPane(chatText);
        chatScr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatScr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        chatText.setColumns(20);
        chatText.setRows(1);
        chatScr.setViewportView(chatText);
        
        viewHistory.setText("View History");
        viewHistory.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHistoryActionPerformed(evt);
            }
        });

        saveHistory.setText("Save History");
        saveHistory.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHistoryActionPerformed(evt);
            }
        });
        
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/search-icon-512.png"))); // NOI18N
        jButton7.setToolTipText("Close this Chat window");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(viewHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(chatScr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1)
                            .addComponent(viewHistory)
                            .addComponent(saveHistory)))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatScr, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(parentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    
    public JPanel getInternalPanel(){
        return chatPanel;
    }
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = parentPane.indexOfComponent(parentPane.getSelectedComponent());
        if (i != -1) {
//            chatHIst = chatLog.getText();
            IMinterface.activeChatStrings.remove(chatPanel.getName());
            IMinterface.activeChatStrings.put(chatPanel.getName(), chatHIst);
            parentPane.remove(i);
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jSlider1.setEnabled(true);
        jButton2.setEnabled(false);
        taskSuper.getInstance().reportAction("call");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jSlider1.setEnabled(false);
        jButton2.setEnabled(true);
        taskSuper.getInstance().reportAction("endcall");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if(micMute == false){
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/canstock11556582.jpg")));
            jButton4.setToolTipText("Unmute Microphone");
            micMute = true;
        }
        else{
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/IconsLandmic on.png")));
            jButton4.setToolTipText("Mute Microphone");
            micMute = false;
        }
        taskSuper.getInstance().reportAction("mic");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if(spkMute == false){
            jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/speaker_mute.png")));
            jSlider1.setEnabled(false);
            jSlider1.setValue(0);
            jButton5.setToolTipText("Unmute Speakers");
            spkMute = true;
        }
        else{
            jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/speaker-icon.png")));
            jSlider1.setEnabled(true);
            jSlider1.setValue(50);
            jButton5.setToolTipText("Mute Speakers");
            spkMute = false;
        }
        taskSuper.getInstance().reportAction("speakers");
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        if(callHold == false){
            jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/unhold-icon.png")));
            jButton6.setToolTipText("Continue call");
            callHold = true;
        }
        else{
            jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ufhci/kishore/Images/hold-icon.png")));
            jButton6.setToolTipText("Hold call");
            callHold = false;
        }
        taskSuper.getInstance().reportAction("holdcall");
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        highlight(jTextField1.getText());
        taskSuper.getInstance().reportAction("searchchat");
    }
    
    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        jTextField1.setText("");
        jTextField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }
    
    private void chatTextFocusGained(java.awt.event.FocusEvent evt) {
        chatText.setText("");
        chatText.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }
    
    private void viewHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        chatLog.setText(chatHIst);
        chatLog.setCaretPosition(0);
        taskSuper.getInstance().reportAction("view");
    }

    private void saveHistoryActionPerformed(java.awt.event.ActionEvent evt) {
//        chatLog.setFont(new Font("Verdana",Font.BOLD,12));
        chatLog.append("Chat History saved. "+ new Date().toString() +"\n");
        chatHIst = chatLog.getText();
        taskSuper.getInstance().reportAction("save");
    }
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {
        if(!"".equals(jTextField1.getText())){
            offset =0;
            highlight(jTextField1.getText());
        }
        
    }
    
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        chatLog.setFont(new Font("Veradana",Font.LAYOUT_RIGHT_TO_LEFT,12));
//        chatLog.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        chatLog.append("Jed I Knight : " + chatText.getText() + "\n");
//        chatLog.setFont(new Font("Verdana",Font.ITALIC,12));
//        chatLog.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        String response = VirtualHumanConnection.getResponse(chatText.getText());
        chatText.setText("");
        response = response.replace("&#039;", "\'");
        chatLog.append("Dr. Lok : " + response+ "\n");
        chatHIst = chatLog.getText();
        taskSuper.getInstance().reportAction("send");
    }

    private void highlight(String pattern){
        JTextComponent textComp = chatLog;
        removeHighlights(textComp);

        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());

            int pos;
            // Search for pattern
            pos = text.indexOf(pattern, offset);
            if(pos >= 0){
                hilite.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                offset = pos + pattern.length();
                jTextField1.setBackground(Color.white);
            }
            else{
                offset =0;
                pos = text.indexOf(pattern, offset);
                if(pos > 0){
                    hilite.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                    offset = pos + pattern.length();
                    jTextField1.setBackground(Color.white);
                }else{
                    jTextField1.setBackground(Color.red);
                }
            }
        } catch (BadLocationException e) {
        }
    }
    
    // Removes only our private highlights
    private void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (int i = 0; i < hilites.length; i++) {
            if (hilites[i].getPainter() instanceof MyHighlightPainter) {
                hilite.removeHighlight(hilites[i]);
            }
        }
    }
    
    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.YELLOW);
    class MyHighlightPainter
            extends DefaultHighlighter.DefaultHighlightPainter {

        public MyHighlightPainter(Color color) {
            super(color);
        }
    }
}