package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class View extends JFrame
{
    public JPanel topPanel;
    public JPanel bottomPanel;
    public JPanel mechanicsPanel;
    public JPanel gamePanel;

    private JButton playButton;
    private JButton tutorialButton;
    private JButton exitButton;
    private JButton backButton;
    private JButton gridButton[][];

    public View()
    {
        //ENTIRE FRAME---------------------------------------------------------------------
        JFrame wholeFrame = new JFrame();
        wholeFrame.setTitle("Capture The Quadrants!");
        wholeFrame.setSize(720,720);
        wholeFrame.setBackground(new Color(254,239,222));
        wholeFrame.setResizable(false);
        wholeFrame.setLayout(null);
        wholeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------


        //TOP PANEL------------------------------------------------------------------------
        topPanel = new JPanel();
        topPanel.setBounds(0,0,720,240);
        topPanel.setBackground(new Color(218,227,230));

        //Component 1: Title
        JLabel title = new JLabel();
        ImageIcon picture = new ImageIcon("C:\\Users\\PC\\Downloads\\CAPTURE THE QUADRANTS.png");
        title.setIcon(picture);
        topPanel.add(title);
        //---------------------------------------------------------------------------------



        //BOTTOM PANEL---------------------------------------------------------------------
        bottomPanel = new JPanel();
        bottomPanel.setBounds(0,240,720,480);
        bottomPanel.setBackground(new Color(218,227,230));
        bottomPanel.setLayout(null);

        //Component 1: Play button
        playButton = new JButton();
        playButton.setBounds(270,125,150,62);
        playButton.setBackground(new Color(223,218,205));
        playButton.setFont(new Font("Comic Sans",Font.BOLD,30));
        playButton.setText("PLAY");
        playButton.setFocusable(false);

        //Component 2: Tutorial button
        tutorialButton = new JButton();
        tutorialButton.setBounds(220,225,250,62);
        tutorialButton.setBackground(new Color(223,218,205));
        tutorialButton.setFont(new Font("Comic Sans",Font.BOLD,30));
        tutorialButton.setText("TUTORIAL");
        tutorialButton.setFocusable(false);

        //Component 2: Exit button
        exitButton = new JButton();
        exitButton.setBounds(270,325,150,62);
        exitButton.setBackground(new Color(223,218,205));
        exitButton.setFont(new Font("Comic Sans",Font.BOLD,30));
        exitButton.setText("EXIT");
        exitButton.setFocusable(false);

        //Add the components to the panel
        bottomPanel.add(playButton);
        bottomPanel.add(tutorialButton);
        bottomPanel.add(exitButton);
        //---------------------------------------------------------------------------------

        //MECHANICS PANEL---------------------------------------------------------------------
        mechanicsPanel = new JPanel();
        mechanicsPanel.setBounds(0,240,720,480);
        mechanicsPanel.setBackground(new Color(218,227,230));
        mechanicsPanel.setLayout(null);
        mechanicsPanel.setVisible(false);

        //Component 1: Back button
        backButton = new JButton();
        backButton.setBounds(310,370,60,60);
        backButton.setBackground(new Color(200,209,212));
        backButton.setFont(new Font("Comic Sans",Font.BOLD,30));
        backButton.setText("<");
        backButton.setFocusable(false);

        //Component 2: Text Display
        JLabel explanation = new JLabel();
        explanation.setBounds(0,0,720,420);
        ImageIcon explanationImage = new ImageIcon("C:\\Users\\PC\\Downloads\\mechanics.png");
        explanation.setIcon(explanationImage);

        //Add the components to the panel
        mechanicsPanel.add(backButton);
        mechanicsPanel.add(explanation);
        //---------------------------------------------------------------------------------

        //GAME PANEL---------------------------------------------------------------------
        gamePanel = new JPanel();
        gamePanel.setBounds(0,240,720,440);
        gamePanel.setBackground(new Color(218,227,230));
        gamePanel.setLayout(new GridLayout(6,6,0,0));
        gamePanel.setVisible(false);

        //Component 1: Grid/GameBoard-------------------------------------------------------
        gridButton = new JButton[6][6];
        for(int row=0;row<6;row++)
        {
            for(int col=0;col<6;col++)
            {
                gridButton[row][col] = new JButton(" ");
                gridButton[row][col].setFocusable(false);
                gamePanel.add(gridButton[row][col]);//new class sa view which is each tile extending JButton constructor passes x and y (2 properties) constructor would be constructor niya parameters x and y call super
            }
        }
        //---------------------------------------------------------------------------------

        //WHOLE FRAME----------------------------------------------------------------------
        wholeFrame.add(topPanel);
        wholeFrame.add(bottomPanel);
        wholeFrame.add(mechanicsPanel);
        wholeFrame.add(gamePanel);
        //---------------------------------------------------------------------------------

        wholeFrame.setVisible(true);
    }

    //add methods for button listeners-------------------------------
    public JButton getPlayButton()
    {
        return playButton; //listener ONE (1)
    }
    public JButton getTutorialButton()
    {
        return tutorialButton;  //listener TWO (2)
    }
    public JButton getExitButton()
    {
        return exitButton; //listener THREE (3)
    }
    public JButton getBackButton()
    {
        return backButton; //listener FOUR (4)
    }
    public JButton getGridButton(int row, int col)
    {
        return gridButton[row][col]; //listener FIVE (5)
    }
    //---------------------------------------------------------------------

    //add methods for returning panels ------------------------------------
    public JPanel getTopPanel() {
        return topPanel;
    }
    public JPanel getBottomPanel()
    {
        return bottomPanel;
    }
    public JPanel getMechanicsPanel()
    {
        return mechanicsPanel;
    }
    public JPanel getGamePanel()
    {
        return gamePanel;
    }
    //---------------------------------------------------------------------

}