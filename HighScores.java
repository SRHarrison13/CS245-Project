/**
 * file: HighScores.java
 * author: S. Harrison, N. Peng, W. Lau
 * class: CS245 Programming Graphical User Interfaces
 * 
 * assignment: Quarter Project, v1.0
 * date last modified: 10/9/17
 * 
 * purpose: This programs displays the High Scores page for our
 * team's Hangman game. When pressed, the Back button returns the
 * user to the main menu window.
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JPanel;
public class HighScores extends JPanel {

    /**
     * method: HighScores
     * purpose: This method is the default constructor for the
     * HighScores class. It creates an instance of the High Scores
     * page to be displayed.
     */
    public HighScores() {
        initComponents();
        this.setSize(new Dimension(600,400));
        getHighScores();
    }

    /**
     * method: initComponents
     * purpose: This method initializes all components of
     * the High Scores page to be displayed.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Trattatello", 0, 24)); // NOI18N
        jLabel1.setText("HIGH SCORES");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ABC...000");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BCD...000");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CDE...000");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel5.setText("DEF...000");

        jLabel6.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel6.setText("EFG...000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * method: jButton1ActionPerformed
     * purpose: This method handles the action of the button
     * being pressed by returning the user to the main menu 
     * screen.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.add(new MenuScreen());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

private void getHighScores() {
    try {
        File file = new File("highscores.txt");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        String line;
        int lineCount = 0;
        while((line = buffer.readLine()) != null) {
            assignText(lineCount, line);
            lineCount++;
        }
    }
    catch(IOException e) {
        e.getMessage();
    }
}
private void assignText(int i, String s) {
    switch(i) {
        case 0:
            jLabel2.setText(s);
            break;
        case 1:
            jLabel3.setText(s);
            break;
        case 2:
            jLabel4.setText(s);
            break;
        case 3:
            jLabel5.setText(s);
            break;
        case 4:
            jLabel6.setText(s);
            break;
        default:
            break;
    }
}

}