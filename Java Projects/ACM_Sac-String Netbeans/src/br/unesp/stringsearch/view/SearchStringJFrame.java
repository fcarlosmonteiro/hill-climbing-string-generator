/*     */ package br.unesp.stringsearch.view;
/*     */ 
			import javax.swing.*;
/*     */ import br.unesp.stringsearch.databases.Acm;
/*     */ import br.unesp.stringsearch.databases.Ieee;
/*     */ import br.unesp.stringsearch.databases.ScienceDirect;
/*     */ import br.unesp.stringsearch.databases.Scopus;
/*     */ import br.unesp.stringsearch.databases.SpringerLink;
/*     */ import br.unesp.stringsearch.databases.WebScience;
/*     */ import br.unesp.stringsearch.utils.GerenciadorStrings;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class SearchStringJFrame extends JFrame
/*     */ {
/*     */   private JButton btnClear;
/*     */   private JButton btnClose;
/*     */   private JButton btnGenerate;
/*     */   private JCheckBox ckAcm;
/*     */   private JCheckBox ckAll;
/*     */   private JCheckBox ckIeee;
/*     */   private JCheckBox ckScienceDirect;
/*     */   private JCheckBox ckScopus;
/*     */   private JCheckBox ckSpringer;
/*     */   private JCheckBox ckWebScience;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   private JTextArea taPartA;
/*     */   private JTextArea taPartB;
/*     */   private JTextArea taPartResults;
/*     */ 
/*     */   public SearchStringJFrame()
/*     */   {
/*  33 */     initComponents();
/*  34 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*     */ 
/*  36 */     setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
/*     */     try
/*     */     {
/*  42 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*     */     } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException ex) {
/*  44 */       System.out.println(new StringBuilder().append("Mensagem:").append(ex.getMessage()).toString());
/*     */     }
/*     */ 
/*  47 */     SwingUtilities.updateComponentTreeUI(this);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  59 */     this.jPanel1 = new JPanel();
/*  60 */     this.jLabel1 = new JLabel();
/*  61 */     this.jLabel2 = new JLabel();
/*  62 */     this.jScrollPane1 = new JScrollPane();
/*  63 */     this.taPartA = new JTextArea();
/*  64 */     this.jLabel3 = new JLabel();
/*  65 */     this.jScrollPane2 = new JScrollPane();
/*  66 */     this.taPartB = new JTextArea();
/*  67 */     this.jLabel4 = new JLabel();
/*  68 */     this.jScrollPane3 = new JScrollPane();
/*  69 */     this.taPartResults = new JTextArea();
/*  70 */     this.jLabel5 = new JLabel();
/*  71 */     this.ckAcm = new JCheckBox();
/*  72 */     this.ckIeee = new JCheckBox();
/*  73 */     this.ckScienceDirect = new JCheckBox();
/*  74 */     this.ckScopus = new JCheckBox();
/*  75 */     this.ckWebScience = new JCheckBox();
/*  76 */     this.jLabel6 = new JLabel();
/*  77 */     this.jLabel7 = new JLabel();
/*  78 */     this.ckSpringer = new JCheckBox();
/*  79 */     this.ckAll = new JCheckBox();
/*  80 */     this.jPanel2 = new JPanel();
/*  81 */     this.btnGenerate = new JButton();
/*  82 */     this.btnClear = new JButton();
/*  83 */     this.btnClose = new JButton();
/*     */ 
/*  85 */     setDefaultCloseOperation(3);
/*  86 */     setTitle("::. String Search");
/*  87 */     setResizable(false);
/*     */ 
/*  89 */     this.jLabel1.setFont(new Font("Century Gothic", 1, 18));
/*  90 */     this.jLabel1.setHorizontalAlignment(0);
/*  91 */     this.jLabel1.setText("Search String");
/*     */ 
/*  93 */     this.jLabel2.setFont(new Font("Century Gothic", 1, 12));
/*  94 */     this.jLabel2.setText("Part A:");
/*     */ 
/*  96 */     this.taPartA.setColumns(20);
/*  97 */     this.taPartA.setFont(new Font("Courier New", 0, 14));
/*  98 */     this.taPartA.setLineWrap(true);
/*  99 */     this.taPartA.setRows(5);
/* 100 */     this.jScrollPane1.setViewportView(this.taPartA);
/*     */ 
/* 102 */     this.jLabel3.setFont(new Font("Century Gothic", 1, 12));
/* 103 */     this.jLabel3.setText("Part B:");
/*     */ 
/* 105 */     this.taPartB.setColumns(20);
/* 106 */     this.taPartB.setFont(new Font("Courier New", 0, 13));
/* 107 */     this.taPartB.setLineWrap(true);
/* 108 */     this.taPartB.setRows(5);
/* 109 */     this.jScrollPane2.setViewportView(this.taPartB);
/*     */ 
/* 111 */     this.jLabel4.setFont(new Font("Century Gothic", 1, 12));
/* 112 */     this.jLabel4.setText("Results:");
/*     */ 
/* 114 */     this.taPartResults.setColumns(20);
/* 115 */     this.taPartResults.setFont(new Font("Courier New", 0, 13));
/* 116 */     this.taPartResults.setLineWrap(true);
/* 117 */     this.taPartResults.setRows(5);
/* 118 */     this.jScrollPane3.setViewportView(this.taPartResults);
/*     */ 
/* 120 */     this.jLabel5.setFont(new Font("Century Gothic", 1, 12));
/* 121 */     this.jLabel5.setText("Databases:");
/*     */ 
/* 123 */     this.ckAcm.setFont(new Font("Century Gothic", 0, 12));
/* 124 */     this.ckAcm.setText("ACM");
/*     */ 
/* 126 */     this.ckIeee.setFont(new Font("Century Gothic", 0, 12));
/* 127 */     this.ckIeee.setText("IEEE");
/* 128 */     this.ckIeee.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 130 */         SearchStringJFrame.this.ckIeeeActionPerformed(evt);
/*     */       }
/*     */     });
/* 134 */     this.ckScienceDirect.setFont(new Font("Century Gothic", 0, 12));
/* 135 */     this.ckScienceDirect.setText("Science Direct");
/*     */ 
/* 137 */     this.ckScopus.setFont(new Font("Century Gothic", 0, 12));
/* 138 */     this.ckScopus.setText("Scopus");
/*     */ 
/* 140 */     this.ckWebScience.setFont(new Font("Century Gothic", 0, 12));
/* 141 */     this.ckWebScience.setText("Web of Science");
/*     */ 
/* 143 */     this.jLabel6.setFont(new Font("Century Gothic", 0, 12));
/* 144 */     this.jLabel6.setHorizontalAlignment(0);
/* 145 */     this.jLabel6.setText("Example: (word 1 OR word 2 OR .... OR word N).");
/*     */ 
/* 147 */     this.jLabel7.setFont(new Font("Century Gothic", 1, 12));
/* 148 */     this.jLabel7.setText("AND");
/*     */ 
/* 150 */     this.ckSpringer.setFont(new Font("Century Gothic", 0, 12));
/* 151 */     this.ckSpringer.setText("SpringerLink");
/*     */ 
/* 153 */     this.ckAll.setFont(new Font("Century Gothic", 1, 12));
/* 154 */     this.ckAll.setText("All");
/* 155 */     this.ckAll.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 157 */         SearchStringJFrame.this.ckAllStateChanged(evt);
/*     */       }
/*     */     });
/* 161 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 162 */     this.jPanel1.setLayout(jPanel1Layout);
/* 163 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(13, 13, 13).addComponent(this.jScrollPane3)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.ckAcm).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ckIeee).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ckScienceDirect).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ckScopus).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ckSpringer).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ckWebScience).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.ckAll)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(0, 0, 32767)).addComponent(this.jLabel6, GroupLayout.Alignment.TRAILING, -1, 609, 32767).addComponent(this.jScrollPane1)))).addContainerGap()));
/*     */ 
/* 206 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(10, 10, 10).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jScrollPane1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jScrollPane2, -2, 88, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel5).addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ckAcm).addComponent(this.ckIeee).addComponent(this.ckScienceDirect).addComponent(this.ckScopus).addComponent(this.ckWebScience).addComponent(this.ckSpringer).addComponent(this.ckAll)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, 168, -2).addComponent(this.jLabel4)).addContainerGap()));
/*     */ 
/* 241 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder("Operations"));
/*     */ 
/* 243 */     this.btnGenerate.setFont(new Font("Century Gothic", 1, 12));
/* 244 */     this.btnGenerate.setText("Generate");
/* 245 */     this.btnGenerate.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 247 */         SearchStringJFrame.this.btnGenerateActionPerformed(evt);
/*     */       }
/*     */     });
/* 251 */     this.btnClear.setFont(new Font("Century Gothic", 1, 12));
/* 252 */     this.btnClear.setText("Clear all");
/* 253 */     this.btnClear.setPreferredSize(new Dimension(89, 25));
/* 254 */     this.btnClear.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 256 */         SearchStringJFrame.this.btnClearActionPerformed(evt);
/*     */       }
/*     */     });
/* 260 */     this.btnClose.setFont(new Font("Century Gothic", 1, 12));
/* 261 */     this.btnClose.setText("Close");
/* 262 */     this.btnClose.setPreferredSize(new Dimension(89, 25));
/* 263 */     this.btnClose.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 265 */         SearchStringJFrame.this.btnCloseActionPerformed(evt);
/*     */       }
/*     */     });
/* 269 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 270 */     this.jPanel2.setLayout(jPanel2Layout);
/* 271 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnGenerate, -1, 129, 32767).addComponent(this.btnClear, -1, -1, 32767).addComponent(this.btnClose, -1, -1, 32767)).addContainerGap()));
/*     */ 
/* 281 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnGenerate, -2, 37, -2).addGap(18, 18, 18).addComponent(this.btnClear, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnClose, -2, 41, -2).addContainerGap()));
/*     */ 
/* 293 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 294 */     getContentPane().setLayout(layout);
/* 295 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
/*     */ 
/* 304 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */ 
/* 314 */     pack();
/*     */   }
/*     */ 
/*     */   private void btnGenerateActionPerformed(ActionEvent evt)
/*     */   {
/* 319 */     StringBuilder sb = new StringBuilder();
/* 320 */     List wordsA = new ArrayList();
/* 321 */     List wordsB = new ArrayList();
/*     */ 
/* 323 */     String partA = this.taPartA.getText().trim();
/* 324 */     String partB = this.taPartB.getText().trim();
/*     */ 
/* 326 */     if (partA.length() > 0) {
/* 327 */       wordsA = GerenciadorStrings.dividePalavras(partA);
/*     */     }
/*     */ 
/* 330 */     if (partB.length() > 0) {
/* 331 */       wordsB = GerenciadorStrings.dividePalavras(partB);
/*     */     }
/*     */ 
/* 334 */     if ((!wordsA.isEmpty()) && (!wordsB.isEmpty()))
/*     */     {
/* 336 */       if (this.ckAcm.isSelected()) {
/* 337 */         sb.append("ACM DL:\n\n");
/* 338 */         sb.append(Acm.generate(wordsA, wordsB));
/* 339 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 342 */       if (this.ckIeee.isSelected()) {
/* 343 */         sb.append("IEEE Xplorer:\n\n");
/* 344 */         sb.append(Ieee.generate(wordsA, wordsB));
/* 345 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 348 */       if (this.ckScienceDirect.isSelected()) {
/* 349 */         sb.append("SCIENCE DIRECT:\n\n");
/* 350 */         sb.append(ScienceDirect.generate(wordsA, wordsB));
/* 351 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 354 */       if (this.ckScopus.isSelected()) {
/* 355 */         sb.append("SCOPUS:\n\n");
/* 356 */         sb.append(Scopus.generate(wordsA, wordsB));
/* 357 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 360 */       if (this.ckSpringer.isSelected()) {
/* 361 */         sb.append("SPRINGERLINK:\n\n");
/* 362 */         sb.append(SpringerLink.generate(wordsA, wordsB));
/* 363 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 366 */       if (this.ckWebScience.isSelected()) {
/* 367 */         sb.append("WEB OF SCIENCE:\n\n");
/* 368 */         sb.append(WebScience.generate(wordsA, wordsB));
/* 369 */         sb.append("\n\n--------------------------------");
/*     */       }
/*     */     }
/* 372 */     else if (!wordsA.isEmpty())
/*     */     {
/* 374 */       if (this.ckAcm.isSelected()) {
/* 375 */         sb.append("ACM DL:\n\n");
/* 376 */         sb.append(Acm.generate(wordsA));
/* 377 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 380 */       if (this.ckIeee.isSelected()) {
/* 381 */         sb.append("IEEE Xplorer:\n\n");
/* 382 */         sb.append(Ieee.generate(wordsA));
/* 383 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 386 */       if (this.ckScienceDirect.isSelected()) {
/* 387 */         sb.append("SCIENCE DIRECT:\n\n");
/* 388 */         sb.append(ScienceDirect.generate(wordsA));
/* 389 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 392 */       if (this.ckScopus.isSelected()) {
/* 393 */         sb.append("SCOPUS:\n\n");
/* 394 */         sb.append(Scopus.generate(wordsA));
/* 395 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 398 */       if (this.ckSpringer.isSelected()) {
/* 399 */         sb.append("SPRINGERLINK:\n\n");
/* 400 */         sb.append(SpringerLink.generate(wordsA));
/* 401 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 404 */       if (this.ckWebScience.isSelected()) {
/* 405 */         sb.append("WEB OF SCIENCE:\n\n");
/* 406 */         sb.append(WebScience.generate(wordsA));
/* 407 */         sb.append("\n\n--------------------------------");
/*     */       }
/*     */     }
/*     */     else {
/* 411 */       if (this.ckAcm.isSelected()) {
/* 412 */         sb.append("ACM DL:\n\n");
/* 413 */         sb.append(Acm.generate(wordsB));
/* 414 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 417 */       if (this.ckIeee.isSelected()) {
/* 418 */         sb.append("IEEE Xplorer:\n\n");
/* 419 */         sb.append(Ieee.generate(wordsB));
/* 420 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 423 */       if (this.ckScienceDirect.isSelected()) {
/* 424 */         sb.append("SCIENCE DIRECT:\n\n");
/* 425 */         sb.append(ScienceDirect.generate(wordsB));
/* 426 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 429 */       if (this.ckScopus.isSelected()) {
/* 430 */         sb.append("SCOPUS:\n\n");
/* 431 */         sb.append(Scopus.generate(wordsB));
/* 432 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 435 */       if (this.ckSpringer.isSelected()) {
/* 436 */         sb.append("SPRINGERLINK:\n\n");
/* 437 */         sb.append(SpringerLink.generate(wordsB));
/* 438 */         sb.append("\n\n--------------------------------\n\n");
/*     */       }
/*     */ 
/* 441 */       if (this.ckWebScience.isSelected()) {
/* 442 */         sb.append("WEB OF SCIENCE:\n\n");
/* 443 */         sb.append(WebScience.generate(wordsB));
/* 444 */         sb.append("\n\n--------------------------------");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 449 */     this.taPartResults.setText(sb.toString());
/*     */   }
/*     */ 
/*     */   private void btnClearActionPerformed(ActionEvent evt)
/*     */   {
/* 454 */     this.taPartA.setText("");
/* 455 */     this.taPartB.setText("");
/* 456 */     this.taPartResults.setText("");
/*     */ 
/* 458 */     clearCkeck(false);
/*     */   }
/*     */ 
/*     */   private void ckIeeeActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void ckAllStateChanged(ChangeEvent evt)
/*     */   {
/* 467 */     if (this.ckAll.isSelected())
/* 468 */       clearCkeck(true);
/*     */     else
/* 470 */       clearCkeck(false);
/*     */   }
/*     */ 
/*     */   private void btnCloseActionPerformed(ActionEvent evt)
/*     */   {
/* 476 */     dispose();
/*     */   }
/*     */ 
/*     */   private void clearCkeck(boolean b)
/*     */   {
/* 481 */     this.ckAcm.setSelected(b);
/* 482 */     this.ckIeee.setSelected(b);
/* 483 */     this.ckScienceDirect.setSelected(b);
/* 484 */     this.ckScopus.setSelected(b);
/* 485 */     this.ckSpringer.setSelected(b);
/* 486 */     this.ckWebScience.setSelected(b);
/* 487 */     this.ckAll.setSelected(b);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 499 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 500 */         if ("Nimbus".equals(info.getName())) {
/* 501 */           UIManager.setLookAndFeel(info.getClassName());
/* 502 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 506 */       Logger.getLogger(SearchStringJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 508 */       Logger.getLogger(SearchStringJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 510 */       Logger.getLogger(SearchStringJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 512 */       Logger.getLogger(SearchStringJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 517 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 520 */         new SearchStringJFrame().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.view.SearchStringJFrame
 * JD-Core Version:    0.6.2
 */