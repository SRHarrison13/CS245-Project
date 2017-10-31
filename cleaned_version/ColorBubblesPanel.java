/***************************************************************
* file: ColorBubblesPanel.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/19/2017
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
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ColorBubblesPanel extends JPanel{

    // Bubble color names
    private String[] colorNames = {"blue", "green", "red", "purple", "yellow"};

    // Components
    private JLabel chosenColor, scoreLabel;
    private JPanel topPanel, bubblePanel;
    private int score, numRounds;
    private ColorBubbles game;

    public ColorBubblesPanel(int score) {
        // Initialize variables
        game = new ColorBubbles();
        this.score = score;
        numRounds = 1;

        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(50,50,50));
        this.setLayout(new BorderLayout());

        initComponents();
    }

    /**
     * Initialize the main components of this bubble game panel
     */
    private void initComponents() {
        // Initialize topPanel
        initializeTopPanel();

        // Initialize bubbles and panel
        bubblePanel = new JPanel();
        bubblePanel.setLayout(null);
        initializeBubbles();
    }

    /**
     * Create top panel that includes timer, score label, and color string label
     */
    private void initializeTopPanel() {
        topPanel = new JPanel(new GridLayout(1,3));

        // Display current time and date
        JLabel dateTimeLabel = new JLabel();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        dateTimeLabel.setFont(new Font("Tahoma", 1, 14));
        dateTimeLabel.setText(dateFormat.format(new Date()));
        dateTimeLabel.setToolTipText("The current time and date.");
        topPanel.add(dateTimeLabel);
        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dateTimeLabel.setText(dateFormat.format(new Date()));
            }
        });
        time.setRepeats(true);
        time.start();

        // Display color string
        chosenColor = new JLabel();
        chosenColor.setText(game.getChosenString());
        chosenColor.setForeground(game.getChosenColor());
        chosenColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        chosenColor.setFont(new Font("Trattatello",1,20));
        chosenColor.setToolTipText("This is the color bubble to select!");
        chosenColor.setFont(new Font("Tratello",1,20));
        topPanel.add(chosenColor);

        // Display score
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", 0, 20));
        scoreLabel.setToolTipText("Your current score.");
        topPanel.add(scoreLabel);

        // Add this panel to main panel
        add(topPanel, BorderLayout.PAGE_START);
    }

    /**
     * Initialize bubbles on the screen
     */
    private void initializeBubbles() {
        for (int i=0; i<colorNames.length; i++) {
            String color = colorNames[i];
            JButton button = new JButton();

            button.setName(color);
            button.setToolTipText("Click me to select this color!");
            button.setIcon(new ImageIcon(getClass().getResource("/img/"+color+".png")));
            button.setRolloverIcon(new ImageIcon(getClass().getResource("/img/"+color+"_hover.png")));
            button.setSize(new Dimension(80,80));
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setLocation(genRandCoordinate());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    checkColor(button);
                }
            });
            bubblePanel.add(button);
        }
        add(bubblePanel, BorderLayout.CENTER);
    }

    private Point genRandCoordinate() {
        Random rand = new Random();
        int x = rand.nextInt(500);
        int y = rand.nextInt(300);
        Point p = new Point(x,y);
        return p;
    }

    private void checkColor(JButton button) {
        // Check that color of button matches the color of the current string
        String buttonColor = button.getName();
        if(buttonColor.equals(game.getChosenColorToString())) {
            score += 100;
            scoreLabel.setText("Score: " + score);
        }

        // Refresh bubble board
        game.reset();
        bubblePanel.removeAll();
        remove(bubblePanel);
        initializeBubbles();
        chosenColor.setText(game.getChosenString());
        chosenColor.setForeground(game.getChosenColor());
        this.repaint();

        // User can only play 5 rounds
        numRounds++;
        if(numRounds > 5) {
            endGame();
        }
    }

    /**
     * End the bubble panel game. Guide the user to the end screen panel
     */
    private void endGame() {
        JPanel menuScreen = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, this);
        menuScreen.removeAll();
        menuScreen.add(new SudokuPanel(score));
        menuScreen.revalidate();
        menuScreen.repaint();
    }
}