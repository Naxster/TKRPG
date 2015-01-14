import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

/**
 * Created by Naxster on 2015-01-11.
 */

public class MapWindow extends JFrame {

    private MapPanel mapPanel;
    private JTextField TerritoryField;
    private Game game;

    public MapWindow(int[][] map, Game g) {
        this.game = g;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Map Window");
        this.setResizable(false);
        setPreferredSize(new Dimension(525, 750));
        this.setBounds(30, 30, 500, 600);
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel TerritoryPanel = new JPanel();
        TerritoryField = new JTextField("You are in: VILLAGE OF KER'BHINAK");
        TerritoryField.setPreferredSize(new Dimension(505, 30));
        TerritoryField.setEditable(false);
        TerritoryPanel.add(TerritoryField);
        add(TerritoryPanel, BorderLayout.NORTH);

        mapPanel = new MapPanel(map);
        this.add(mapPanel, BorderLayout.CENTER);

        JButton KeyUp = new JButton("UP");
        KeyUp.setPreferredSize(new Dimension(75, 30));
        JButton KeyDown = new JButton("DOWN");
        KeyDown.setPreferredSize(new Dimension(75,30));
        JButton KeyLeft = new JButton("LEFT");
        KeyLeft.setPreferredSize(new Dimension(75,30));
        JButton KeyRight = new JButton("RIGHT");
        KeyRight.setPreferredSize(new Dimension(75,30));

        KeyUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.MoveUp();
                }catch(IOException th){}
            }
        });
        KeyDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.MoveDown();
                }catch(IOException th){}
            }
        });
        KeyLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.MoveLeft();
                }catch(IOException th){}
            }
        });
        KeyRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.MoveRight();
                }catch(IOException th){}
            }
        });

        JPanel ControlsPanel = new JPanel();
        ControlsPanel.setPreferredSize(new Dimension(250,80));
        //ControlsPanel.setLayout(new FlowLayout());

        JPanel L = new JPanel();
        L.setPreferredSize(new Dimension(75, 70));
        JPanel R = new JPanel();
        R.setPreferredSize(new Dimension(75, 70));
        JPanel C = new JPanel();
        C.setPreferredSize(new Dimension(75, 70));

        C.add(KeyUp, BorderLayout.NORTH);
        C.add(KeyDown, BorderLayout.SOUTH);
        L.add(KeyLeft);
        R.add(KeyRight);

        ControlsPanel.add(L, BorderLayout.WEST);
        ControlsPanel.add(C, BorderLayout.CENTER);
        ControlsPanel.add(R, BorderLayout.EAST);

        JButton EquipButton = new JButton("Equipment");
        EquipButton.setPreferredSize(new Dimension(100,60));
        JButton StatsButton = new JButton("Statistics");
        StatsButton.setPreferredSize(new Dimension(100,60));

        EquipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ShowEquipment();
            }
        });

        StatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ShowStats();
            }
        });

        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setPreferredSize(new Dimension(230,80));
        ButtonsPanel.setLayout(new FlowLayout());

        ButtonsPanel.add(EquipButton,BorderLayout.WEST);
        ButtonsPanel.add(StatsButton,BorderLayout.EAST);

        JPanel MenuPanel = new JPanel();
        MenuPanel.setPreferredSize(new Dimension(505, 90));
        MenuPanel.add(ControlsPanel, BorderLayout.EAST);
        MenuPanel.add(ButtonsPanel, BorderLayout.WEST);
        add(MenuPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void repaintPlayer(int newX, int newY){
        mapPanel.playerX = newX;
        mapPanel.playerY = newY;
        mapPanel.repaint();
    }

    public void ChangeTerritory(String name){
        TerritoryField.setText(name);
    }
}
