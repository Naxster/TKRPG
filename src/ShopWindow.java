import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-02-23.
 */
public class ShopWindow extends JDialog {
    private Equipment equip;
    private Shop shop;
    public JDesktopPane jdpDesktop;
    private SellButtonListener sellListener;
    private BuyButtonListener buyListener;
    private JLayeredPane backpackPane;
    private JLayeredPane shopPane;
    private JPanel ControlClosePanel;
    private JPanel rightSide;

    public ShopWindow(Shop s, Equipment e) {
        equip = e;
        shop = s;
        sellListener = new SellButtonListener(equip,this);
        buyListener = new BuyButtonListener(shop,this);

        this.setTitle("Shop Window");
        setPreferredSize(new Dimension(1100, 880));
        this.setResizable(false);
        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);
        setLayout(new FlowLayout());
        setModal(true);

        drawElements();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void drawElements(){
        if(backpackPane!= null) {
            remove(shopPane);
            remove(backpackPane);
            remove(ControlClosePanel);
            remove(rightSide);
        }
        //shop
        shopPane = new JLayeredPane();
        shopPane.setBorder(BorderFactory.createTitledBorder("Items for sale"));
        shopPane.setPreferredSize(new Dimension(520, 840));
        shopPane.setLayout(new FlowLayout());

        for(int i=0;i<shop.items.length;i++){
            Thing item = shop.items[i];
            JPanel row = new JPanel();
            ThingPanel itemPanel;
            if(item != null){
                itemPanel = new ThingPanel(Integer.toString(i+1),item.name, item.cost, item.showDetails(),this);
            }
            else {
                itemPanel = new ThingPanel(Integer.toString(i + 1),this);
            }
            JButton changeButton = new JButton("Buy");
            changeButton.setActionCommand(Integer.toString(i+1));
            changeButton.addActionListener(buyListener);

            row.add(itemPanel, BorderLayout.WEST);
            row.add(changeButton, BorderLayout.EAST);
            shopPane.add(row);
        }
        add(shopPane, BorderLayout.WEST);

        rightSide = new JPanel();
        rightSide.setPreferredSize(new Dimension(520, 840));

        //backpack
        backpackPane = new JLayeredPane();
        backpackPane.setBorder(BorderFactory.createTitledBorder("Player's Backpack"));
        backpackPane.setPreferredSize(new Dimension(520, 600));
        backpackPane.setLayout(new FlowLayout());

        for(int i=0;i<equip.things.length;i++){
            Thing item = equip.things[i];
            JPanel row = new JPanel();
            ThingPanel itemPanel;
            if(item != null){
                itemPanel = new ThingPanel(Integer.toString(i+1),item.name, item.cost, item.showDetails(),this);
            }
            else {
                itemPanel = new ThingPanel(Integer.toString(i + 1),this);
            }
            JButton changeButton = new JButton("Sell");
            changeButton.setActionCommand(Integer.toString(i+1));
            changeButton.addActionListener(sellListener);

            row.add(itemPanel, BorderLayout.WEST);
            row.add(changeButton, BorderLayout.EAST);
            backpackPane.add(row);
        }

        JPanel extra = new JPanel();

        JTextField HPotText = new JTextField("Health Potions: " + equip.getPlayerHPot(), 12);
        HPotText.setEditable(false);

        JTextField MPotText = new JTextField("Mana Potions: " + equip.getPlayerMPot(), 12);
        MPotText.setEditable(false);

        JTextField GoldText = new JTextField("Gold: " + equip.getPlayerGold(), 15);
        GoldText.setEditable(false);

        extra.add(HPotText,BorderLayout.WEST);
        extra.add(MPotText);
        extra.add(GoldText,BorderLayout.EAST);
        backpackPane.add(extra);

        rightSide.add(backpackPane, BorderLayout.NORTH);

        //info&close
        ControlClosePanel = new JPanel();
        ControlClosePanel.setPreferredSize(new Dimension(480, 100));

        JPanel SellPanel = new JPanel();

        JButton HPotButton = new JButton("Buy Health Pot");
        HPotButton.setPreferredSize(new Dimension(200, 40));
        HPotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellHPPotion();
            }
        });

        JButton MPotButton = new JButton("Buy Mana Pot");
        MPotButton.setPreferredSize(new Dimension(200, 40));
        MPotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellMPPotion();
            }
        });

        SellPanel.add(HPotButton, BorderLayout.WEST);
        SellPanel.add(MPotButton, BorderLayout.EAST);

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(80, 40));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ControlClosePanel.add(SellPanel, BorderLayout.WEST);
        ControlClosePanel.add(closeButton, BorderLayout.EAST);

        rightSide.add(ControlClosePanel, BorderLayout.SOUTH);
        add(rightSide,BorderLayout.EAST);
    }

    private void sellHPPotion(){
        shop.sellHPPotion(this);
        drawElements();
        invalidate();
        validate();
        repaint();
    }
    private void sellMPPotion(){
        shop.sellMPPotion(this);
        drawElements();
        invalidate();
        validate();
        repaint();
    }
}
