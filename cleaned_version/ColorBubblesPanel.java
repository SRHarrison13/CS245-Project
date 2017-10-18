/***************************************************************
* file: ColorBubblesPanel.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/17/2017
*
* purpose: This panel plays the game of Bubble colors.
* An user is prompted to select the appropriate bubble whose
* color matches the color of the string shown on the screen.
****************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.Timer;

public class ColorBubblesPanel extends JPanel{

    // Bubble color pics
    private ImageIcon blue = new ImageIcon(getClass().getResource("/img/Blue_Circle.png"));
    private ImageIcon green = new ImageIcon(getClass().getResource("/img/Green_Circle.png"));
    private ImageIcon red = new ImageIcon(getClass().getResource("/img/Red_Circle.png"));
    private ImageIcon purple = new ImageIcon(getClass().getResource("/img/Purple_Circle.png"));
    private ImageIcon yellow = new ImageIcon(getClass().getResource("/img/Yellow_Circle.png"));

    // Components
    private JButton button1,button2,button3,button4,button5;
    private JLabel chosenColor, endGame, scoreLabel;
    private JPanel topPanel;
    private int score,numRounds;
    private ColorBubbles game;

    public ColorBubblesPanel() {
        game = new ColorBubbles();
        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
        this.setLayout(new BorderLayout());

        initComponents();
    }

    /**
     * Create top panel that includes timer and score labels
     */
    private void initializeTopPanel() {
        topPanel = new JPanel(new GridLayout(1,2));

        // Display current time and date
        JLabel dateTimeLabel = new JLabel();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        dateTimeLabel.setFont(new Font("Tahoma", 1, 14));
        dateTimeLabel.setText(dateFormat.format(new Date()));
        topPanel.add(dateTimeLabel);
        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dateTimeLabel.setText(dateFormat.format(new Date()));
            }
        });
        time.setRepeats(true);
        time.start();

        // Display score
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", 0, 20));
        topPanel.add(scoreLabel);

        // Add this panel to main panel
        add(topPanel, BorderLayout.PAGE_START);
    }

    private void initComponents() {
        // Initialize variables
        score = 0;
        numRounds = 1;

        // Initialize topPanel
        initializeTopPanel();

        button1 = new JButton();
        button1.setIcon(getRandIcon());
        button1.setSize(new Dimension(80,80));
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setLocation(genRandCoordinate1());
        button1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               checkColor(button1);
           }
       });
       add(button1);
       
       button2 = new JButton();
       button2.setIcon(getRandIcon());
       button2.setSize(new Dimension(50,50));
       button2.setLocation(genRandCoordinate2());
       button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               checkColor(button2);
           }
       });
       add(button2);
       
       button3 = new JButton();
       button3.setIcon(getRandIcon());
       button3.setSize(new Dimension(50,50));
       button3.setLocation(genRandCoordinate3());
       button3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               checkColor(button3);
           }
       });
       add(button3);
       
       button4 = new JButton();
       button4.setIcon(getRandIcon());
       button4.setSize(new Dimension(50,50));
       button4.setLocation(genRandCoordinate4());
       button4.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               checkColor(button4);
           }
       });
       add(button4);
       
       button5 = new JButton();
       button5.setIcon(getRandIcon());
       button5.setSize(new Dimension(50,50));
       button5.setLocation(genRandCoordinate5());
       button5.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               checkColor(button5);
           }
       });
       add(button5);
       
       chosenColor = new JLabel();
       chosenColor.setText(game.getChosenColor());
       chosenColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
       chosenColor.setSize(new Dimension(200,100));
       chosenColor.setFont(new Font("Tratello",0,16));
       chosenColor.setForeground(game.getStringColor());
       chosenColor.setLocation(275, 200);
       add(chosenColor);
   }
   
   private Point genRandCoordinate1() {
       Random rand = new Random();
       int x = rand.nextInt(50);
       int y = rand.nextInt(50);
       Point p = new Point(x,y);
       return p;
   }
   
   private Point genRandCoordinate2() {
       Random rand = new Random();
       int x = 600 - rand.nextInt(100) - 75;
       int y = rand.nextInt(100);
       Point p = new Point(x,y);
       return p;
   }
   
   private Point genRandCoordinate3() {
       Random rand = new Random();
       int x = 600 - rand.nextInt(50) - 75;
       int y = 400 - rand.nextInt(50) - 75;
       Point p = new Point(x,y);
       return p;
   }
   
   private Point genRandCoordinate4() {
       Random rand = new Random();
       int x = 300 + rand.nextInt(100) - 75;
       int y = 400 - rand.nextInt(100) - 75;
       Point p = new Point(x,y);
       return p;
   }
   
   private Point genRandCoordinate5() {
       Random rand = new Random();
       int x = rand.nextInt(100);
       int y = 400 - rand.nextInt(100) - 75;
       Point p = new Point(x,y);
       return p;
   }
   
   private ImageIcon getRandIcon() {
       Random rand = new Random();
       int choice = rand.nextInt(5);
       ImageIcon chosen = blue;
       switch(choice) {
           case 0:
               chosen = red;
               break;
           case 1:
               chosen = yellow;
               break;
           case 2:
               chosen = green;
               break;
           case 3:
               chosen = blue;
               break;
           case 4:
               chosen = purple;
               break;
           default:
               break;
       }
       return chosen;
   }

   private void checkColor(JButton button) {
       if(button.getIcon() == blue && game.checkColor(Color.BLUE)) {
           score += 100;
       }
       else if(button.getIcon() == green && game.checkColor(Color.green)) {
           score += 100;
       }
       else if(button.getIcon() == purple && game.checkColor(Color.MAGENTA)) {
           score += 100;
       }
       else if(button.getIcon() == red && game.checkColor(Color.red)) {
           score += 100;
       }
       else if(button.getIcon() == yellow && game.checkColor(Color.YELLOW)) {
           score += 100;
       }
       
       game.reset();
       button1.setIcon(getRandIcon());
       button2.setIcon(getRandIcon());
       button3.setIcon(getRandIcon());
       button4.setIcon(getRandIcon());
       button5.setIcon(getRandIcon());
       chosenColor.setText(game.getChosenColor());
       chosenColor.setForeground(game.getStringColor());
       this.repaint();
       
       numRounds++;
       if(numRounds > 5) {
           
           endGame();
       }
   }
   
   private void endGame() {
       remove(chosenColor);
       
       
       endGame = new JLabel("End of Game");
       endGame.setSize(new Dimension(200,100));
       endGame.setFont(new Font("Tratello",0,16));
       add(endGame);
       
       /*scoreLabel = new JLabel("Your score: " + score);
       scoreLabel.setSize(new Dimension(200,100));
       scoreLabel.setFont(new Font("Tratello",0,16));
       add(scoreLabel);*/
   }
}