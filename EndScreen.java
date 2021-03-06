/***************************************************************
* file: EndScreen.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/18/2017
*
* purpose: This panel shows the end screen displaying an user's
* score after a game
****************************************************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class EndScreen extends JPanel{
    private JButton endButton;
    private JLabel finalScoreLabel;
    private int score;
    
    public EndScreen(int score) {
        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
        
        this.score = score;
        checkScore(score);
        initComponents();
        
    }
    
    private void initComponents() {
        // Display end button
        endButton = new JButton("End");
        endButton.setToolTipText("Press me to return to the main menu and play again.");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                backToMenuScreen();
            }
        });
        add(endButton);
        
        // Display final score
        finalScoreLabel = new JLabel();
        finalScoreLabel.setText("Your Score: " + score);
        finalScoreLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalScoreLabel.setFont(new java.awt.Font("Trattatello",1,40));
        finalScoreLabel.setToolTipText("Your final score.");
        add(finalScoreLabel);
        
        this.getInputMap().put(KeyStroke.getKeyStroke("F1"),"popCredDisplay");
        this.getActionMap().put("popCredDisplay", new javax.swing.Action() {
            @Override
            public Object getValue(String key) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void putValue(String key, Object value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEnabled(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEnabled() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Point N Click Game\n" +
                        "CS245 Fall 2017\n" + "Samantha Harrison, 011687793\n" +
                        "Wing Hung Lau, 010927657\n" + "Nelly Liu Peng, 010180248");
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("Esc"),"exit");
        this.getActionMap().put("exit", new javax.swing.Action() {
            @Override
            public Object getValue(String key) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void putValue(String key, Object value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEnabled(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEnabled() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    /**
     * Checks the score the player currently has and if higher than
     * those from the highscores.txt file, then prompt the user to
     * input its name
     */
    private void checkScore(int i) {
        try {
            File file = new File("highscores.txt");
            // Retrieve directory file path
            //Path currentRelativePath = Paths.get("");
            //String filePath = currentRelativePath.toAbsolutePath().toString() + "/src/highscores.txt";
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            int lineCount = 0;
            String scoreString;
            while((line = buffer.readLine()) != null) {
                scoreString = line.substring(line.lastIndexOf('.') + 1);
                if(i > Integer.parseInt(scoreString)) {
                    changeScores(lineCount,i);
                    break;
                }
                lineCount++;
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Reads the highscores.txt file and adds new high score
     */
    private void changeScores(int line,int score) {
        String name = (String)JOptionPane.showInputDialog(this,"Please enter your name: ",null);
        name += ". . ." + score;
        try {
            Path file = Paths.get("highscores.txt");
            List<String> lines = Files.readAllLines(file);
            lines.add(line, name);
            lines.remove(lines.size() - 1);
            Files.write(file, lines);
        }
        catch(IOException e) {
            e.getMessage();
        }
    }
    
    /**
     * Return to menu screen
     */
    private void backToMenuScreen() {
        JPanel menuScreen = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, this);
        menuScreen.removeAll();
        menuScreen.add(new MenuScreen());
        menuScreen.revalidate();
        menuScreen.repaint();
    }
}
