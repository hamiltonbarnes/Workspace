/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.bpad;

/**
 *
 * @author benedict barnes
 */

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import form.bpad.bPad;
import java.awt.datatransfer.StringSelection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.Clipboard;
public class jmenu extends JMenuBar {
    
       
        
    public jmenu(JTextArea output){
       
        //creating a  menubar
        JMenuBar menubar = new JMenuBar();
      //Creating a file menu and it sub  menus
JMenu fileMenu = new JMenu("File ");
JMenuItem fileItem1 = new JMenuItem("New File");
fileItem1.setIcon(new ImageIcon("new file.png"));
// implementation of event listners
    //defines what should be done when a user performs a certain action 
fileItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Newfile().setVisible(true);
            }    
});
fileMenu.add(fileItem1);

JMenuItem fileItem9 = new JMenuItem("Open File");
fileItem9.setIcon(new ImageIcon("of.jpg"));

// implementation of event listners
    //defines what should be done when a user performs a certain action 
fileItem9.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  
                    bPad.Openfile(output);
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
});
fileMenu.add(fileItem9);


JMenuItem fileItem2 = new JMenuItem("Open Folder");
fileItem2.setIcon(new ImageIcon("folder.jpg"));

// implementation of event listners
    //defines what should be done when a user performs a certain action 
fileItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bPad.desktop();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    
});
fileMenu.add(fileItem2);

JMenu menuItem = new JMenu("Open Recent");
menuItem.setIcon(new ImageIcon("r1.jpg"));
JMenuItem menuItem1 = new JMenuItem("ReOpen Closed Files");
menuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             new ReOpenClosedFiles().setVisible(true);   
            }
});
            
menuItem.add(menuItem1);

JMenuItem menuItem2 = new JMenuItem("Clear Opened File List");
menuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             new clearrecent().setVisible(true);   
            }
});
menuItem.add(menuItem2);

fileMenu.add(menuItem);

JMenuItem fileItem3 = new JMenuItem("Save");
fileItem3.setIcon(new ImageIcon("save1.jpg"));
// implementation of event listners
    //defines what should be done when a user performs a certain action 
 
fileItem3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                 
                    try {
                        
                        bPad.saveFile();
                    } catch (IOException ex) {
                       ex.printStackTrace();
                    }
            
                          }
           
});
fileMenu.add(fileItem3);

JMenuItem fileItem4 = new JMenuItem("Save As");

// implementation of event listners
    //defines what should be done when a user performs a certain action 
fileItem4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              try{
              bPad.SaveAs();
              } catch (IOException ex){
              
              ex.printStackTrace();
              }
            }
});
 


fileMenu.add(fileItem4);

JMenuItem fileItem5 = new JMenuItem("Save All");
fileMenu.add(fileItem5);



JMenuItem fileItem8 = new JMenuItem("Close Window");
fileItem8.setIcon(new ImageIcon("close.jpg"));
// implementation of event listners
    //defines what should be done when a user performs a certain action  
fileItem3.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){

System.exit(0);
}

});
fileMenu.add(fileItem8);
add(fileMenu);

//Building the edit menu togather with it submenus
JMenuBar editmenu = new JMenuBar();
JMenu EditMenu = new JMenu("Edit ");


JMenuItem editItem3 = new JMenuItem("Copy");
editItem3.setIcon(new ImageIcon("copy.GIF"));
editItem3.addActionListener(new ActionListener(){
            java.awt.datatransfer.Clipboard clipbd = getToolkit().getSystemClipboard();
            @Override
            public void actionPerformed(ActionEvent e) {
             String selection = output.getSelectedText();
                StringSelection clipString = new StringSelection(selection);
                clipbd.setContents(clipString, clipString);    
            
            }
});
EditMenu.add(editItem3);

JMenuItem editItem4 = new JMenuItem("Paste");
editItem4.setIcon(new ImageIcon("paste.GIF"));
editItem4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bPad.Paste(output);
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
});

EditMenu.add(editItem4);


JMenuItem editItem6 = new JMenuItem("Cut");
editItem6.setIcon(new ImageIcon("cut.GIF"));
// implementation of event listners
    //defines what should be done when a user performs a certain action 
editItem6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            try{
                bPad.cut(output);
            }  catch(IOException ex){
            ex.printStackTrace();
            } 
            
            }



});
EditMenu.add(editItem6);
JMenuItem editItem7 = new JMenuItem("Select All");
editItem7.setIcon(new ImageIcon("select all.jpg"));
// implementation of event listners
    //defines what should be done when a user performs a certain action 
editItem6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    bPad.SelectAll();
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }

});
EditMenu.add(editItem7);

editmenu.add(EditMenu);

add(editmenu);

//Building the find menu and it's subs
JMenuBar findmenu = new JMenuBar();
JMenu FindMenu = new JMenu("Find ");

JMenuItem findItem1 = new JMenuItem("Find");
FindMenu.add(findItem1);

findmenu.add(FindMenu);
add(findmenu);



    
//Building the help menu and it's subs
JMenuBar helpmenu = new JMenuBar();
JMenu       HelpMenu = new JMenu("Help");
    JMenu helpItem1 = new JMenu("Contents");
HelpMenu.add(helpItem1);


JMenuItem helpItem2 = new JMenuItem("About"); 
helpItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AboutUs().setVisible(true);
        
            }
        });
helpItem1.add(helpItem2);

JMenuItem helpItem3 = new JMenuItem("Contacts");
helpItem3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               new ContactUs().setVisible(true);  
                             
            }

});
helpItem1.add(helpItem3);

helpmenu.add(HelpMenu);
add(helpmenu);
    
    
    }

        }
