package OS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GridDrawer extends JPanel{

    protected JFrame frame;
    private JPanel userGrid, enemyGrid;
    
    protected JLabel user, enemy, userResult, enemyResult, ComputerGuess;
    
    protected Grid g1;
    protected Grid g2;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void setUpGrid() {

        frame = new JFrame(); 
        userGrid = new JPanel();
        enemyGrid = new JPanel();
        
        user = new JLabel("Your BattleShips");
        enemy = new JLabel("Comp BattleShips");
        
        userResult = new JLabel("");
        enemyResult = new JLabel("");
        
        ComputerGuess = new JLabel("");

        frame.setLayout(new GridBagLayout());
        // setting the frame size to fill the screen

        frame.setSize(screenSize.width, screenSize.height);

        g1 = new Grid();
        g2 = new Grid();

        g1.setPreferredSize(new Dimension(500, 500));
        g2.setPreferredSize(new Dimension(500, 500));
        userGrid.add(g1);
        enemyGrid.add(g2);

        userGrid.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(""),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                userGrid.getBorder()));
                
        enemyGrid.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(""),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                enemyGrid.getBorder()));
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(userGrid, c);

        c.gridx = 1;
        c.gridy = 0;
        frame.add(enemyGrid, c);
        
        c.gridx = 0;
        c.gridy = 1;
        frame.add(user, c);
        
        c.gridx = 1;
        c.gridy = 1;
        frame.add(enemy, c);
        
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(userResult, c);
        
        c.gridx = 1;
        c.gridy = 2;
        frame.add(enemyResult, c);
        
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        frame.add(ComputerGuess, c);

        frame.setVisible(true);
    }

}