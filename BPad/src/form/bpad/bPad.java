/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.bpad;




import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import form.bpad.jmenu;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;



/**
 *
 * @author benedict barnes
 */
public class bPad extends javax.swing.JFrame {
   
    /**
     * Creates new form bPad
     */
    //Creating a method for Openfolder
    public static void desktop() throws IOException{
    
// Demonstrate "Openfolder" dialog:

    Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("/home/benedict/Desktop");
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }
    }
    
    //Creating a method/function for Openfile
     static void Openfile(JTextArea output) throws IOException{
     
// Demonstrate "Openfile" dialog:

         int val =  FileChooser.showOpenDialog(null); 
      if (val == JFileChooser.APPROVE_OPTION){ 
          File file =FileChooser.getSelectedFile();
          
          try{
          output.read(new FileReader(file.getAbsolutePath()),null);
              
          } catch(IOException e){
          System.out.println("Problem accessing file");
          }
                }
      
      else{
      System.out.println("File cannot be accessed");
      }        
    }                                          
 //Creating a method/function for savefile      
      public static void saveFile() throws IOException
    {
                JFileChooser savefile = new JFileChooser();
        String filename = "";
        
        savefile.setSelectedFile(new File(filename));
        BufferedWriter writer;
       // Demonstrate "Save File" dialog:
        int saveF = savefile.showSaveDialog(null);
        if(saveF == JFileChooser.APPROVE_OPTION){
            try {
          // if file doesnt exists, then create it
               writer = new BufferedWriter(new FileWriter(savefile.getSelectedFile()));
             // Writes the content to the file
               text.write(writer);
                writer.close();
               //Display message after file has being saved.
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(saveF == JFileChooser.CANCEL_OPTION){
            // Display message if cancel option is used 
            JOptionPane.showMessageDialog(null, "File save has been canceled");
        }
    
    }

    
//Creating a method/function for  Save file  As "Save As"
        public static void SaveAs()throws IOException{
            
        JFrame saveAs = new JFrame();  
        JFileChooser SaveAs = new JFileChooser();
        String filename = "";
        
        SaveAs.setSelectedFile(new File(filename));
        BufferedWriter writer;
       // Demonstrate "Save File" dialog:
        int sa = SaveAs.showSaveDialog(null);
        if(sa == JFileChooser.APPROVE_OPTION){
            try {
          // if file doesnt exists, then create it
               writer = new BufferedWriter(new FileWriter(SaveAs.getSelectedFile()));
             // Writes the content to the file
               text.write(writer);
                writer.close();
               //Display message after file has being saved.
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(sa == JFileChooser.CANCEL_OPTION){
            // Display message if cancel option is used 
            JOptionPane.showMessageDialog(null, "File save has been canceled");
        }
    
        }
     //Creating  a method/function to help paste to textarea from any origin  
    static void Paste(JTextArea output) throws IOException{
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String writeMe = null;
        Transferable text = new StringSelection(writeMe);
        clip.setContents(text, null);
    }
    
    //Creating  a method/function to help cut to from text area
    public static void cut(JTextArea output) throws IOException{
    Clipboard clipbd = Toolkit.getDefaultToolkit().getSystemClipboard();
    String selection = text.getSelectedText();
    StringSelection clipString = new StringSelection(selection);
    clipbd.setContents(clipString, clipString);
text.replaceRange("", text.getSelectionStart(),
                        text.getSelectionEnd());
    }
    
    public static void SelectAll() throws IOException{
    
    text.selectAll();
    
    }
  

    
    public bPad() {
        initComponents();
         
        
        this.setLocationRelativeTo(null);    
        this.setSize(600,600);
          ImageIcon img =  new ImageIcon("b.jpg");
        this.setIconImage(img.getImage());
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setColumns(20);
        text.setFont(text.getFont());
        text.setLineWrap(true);
        text.setRows(5);
        text.setWrapStyleWord(true);
        jScrollPane1.setViewportView(text);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/new file.png")); // NOI18N
        jMenuItem1.setText("New File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/of.jpg")); // NOI18N
        jMenuItem2.setText("Open File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/folder.jpg")); // NOI18N
        jMenuItem3.setText("Open Folder");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenu3.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/r1.jpg")); // NOI18N
        jMenu3.setText("Open Recent");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Reopen Closed Files");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem4.setText("Clear Opened File List");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenu1.add(jMenu3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/save1.jpg")); // NOI18N
        jMenuItem5.setText("Save");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/sasas.jpg")); // NOI18N
        jMenuItem6.setText("Save As");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/close.jpg")); // NOI18N
        jMenuItem9.setText("Close Window");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/copy.GIF")); // NOI18N
        jMenuItem14.setText("Copy");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/cut.GIF")); // NOI18N
        jMenuItem15.setText("Cut");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/paste.GIF")); // NOI18N
        jMenuItem16.setText("Paste");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem25.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/select all.jpg")); // NOI18N
        jMenuItem25.setText("Select All");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem25);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Help");

        jMenu10.setText("Contents");

        jMenuItem26.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/About.gif")); // NOI18N
        jMenuItem26.setText("About Us");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem26);

        jMenuItem27.setIcon(new javax.swing.ImageIcon("/home/benedict/NetBeansProjects/BPad/contacts.jpg")); // NOI18N
        jMenuItem27.setText("Contact");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem27);

        jMenu9.add(jMenu10);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      // implementing window events
    //exit window on exit
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
                       System.exit(0);        
    }//GEN-LAST:event_jMenuItem9ActionPerformed
          // implementing window events
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
                    // Adding an  event to Reopen closed files in  bpad.
       new ReOpenClosedFiles().setVisible(true);
       
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            new clearrecent().setVisible(true);    
    }//GEN-LAST:event_jMenuItem4ActionPerformed
               // implementing window events
           //Open a new file upon  demand
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            Openfile(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
                                               
               // implementing window events
    //Copy from text area
    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
         
        java.awt.datatransfer.Clipboard clipbd = getToolkit().getSystemClipboard();
        String selection = text.getSelectedText();
                StringSelection clipString = new StringSelection(selection);
                clipbd.setContents(clipString, clipString);    
            
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        
        try {
            Paste(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
               new Newfile().setVisible(true); 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
        // implementing window events
    //Save a file as what one prefers
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            SaveAs();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
                
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    // implementing window events
    // Open a folder
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
                try{  desktop();}
                catch(IOException m){
                    m.printStackTrace();
                };        
        

    }//GEN-LAST:event_jMenuItem3ActionPerformed
        // implementing window events
          //Save a file
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            saveFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    // implementing window events
          //Cutting a text from text area.
    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        try {
            cut(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed
// implementing window events
          //Opening the about us frame which tells us what this application is about.
    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
               new AboutUs().setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
               new ContactUs().setVisible(true);
               
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
             
        try {    
            SelectAll();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem25ActionPerformed

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
            java.util.logging.Logger.getLogger(bPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bPad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JFileChooser FileChooser;
    private static javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private static javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem14;
    private static javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JMenuItem jMenuItem5;
    private static javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables

    
    
    }

  

