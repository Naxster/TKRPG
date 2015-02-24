import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by Naxster on 2015-01-28.
 */
public class EquipmentWindow extends JDialog {

    private Equipment equip;
    public JDesktopPane jdpDesktop;
    private ChangeButtonListener listener;
    private JLayeredPane mainPane;
    private JLayeredPane backpackPane;
    private JPanel InfoClosePanel;

    public EquipmentWindow(Equipment e) {
        equip = e;
        listener = new ChangeButtonListener(equip,this);

        this.setTitle("Eqipment Window");
        setPreferredSize(new Dimension(550, 720));
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
        if(mainPane!= null) {
            remove(mainPane);
            remove(backpackPane);
            remove(InfoClosePanel);
        }
        mainPane = new JLayeredPane();
        mainPane.setBorder(BorderFactory.createTitledBorder("Main Weapons"));
        mainPane.setPreferredSize(new Dimension(520, 150));
        mainPane.setLayout(new FlowLayout());

        if (equip.gracz.weapon != null) {
            ThingPanel mainWeapon = new ThingPanel("W.",equip.gracz.weapon.name, equip.gracz.weapon.cost, equip.gracz.weapon.showDetails(),(JDialog)this);
            mainPane.add(mainWeapon,BorderLayout.NORTH);
        }
        else {
            ThingPanel mainwWeapon = new ThingPanel("W.",this);
            mainPane.add(mainwWeapon,BorderLayout.NORTH);
        }
        if (equip.gracz.amulet != null) {
            ThingPanel mainAmulet = new ThingPanel("A.",equip.gracz.amulet.name, equip.gracz.amulet.cost, equip.gracz.amulet.showDetails(),this);
            mainPane.add(mainAmulet);
        }
        else {
            ThingPanel mainAmulet = new ThingPanel("A.",this);
            mainPane.add(mainAmulet);
        }
        if (equip.gracz.shield != null) {
            ThingPanel mainShield = new ThingPanel("S.",equip.gracz.shield.name, equip.gracz.shield.cost, equip.gracz.shield.showDetails(),this);
            mainPane.add(mainShield);
        }
        else {
            ThingPanel mainShield = new ThingPanel("S.",this);
            mainPane.add(mainShield);
        }

        add(mainPane, BorderLayout.NORTH);

        //backpack
        backpackPane = new JLayeredPane();
        backpackPane.setBorder(BorderFactory.createTitledBorder("Backpack"));
        backpackPane.setPreferredSize(new Dimension(520, 430));
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
            JButton changeButton = new JButton("Change");
            changeButton.setActionCommand(Integer.toString(i+1));
            changeButton.addActionListener(listener);

            row.add(itemPanel, BorderLayout.WEST);
            row.add(changeButton, BorderLayout.EAST);
            backpackPane.add(row);
        }
        add(backpackPane);

        //info&close
        InfoClosePanel = new JPanel();
        InfoClosePanel.setPreferredSize(new Dimension(480, 100));

        //--> items
        JPanel ItemsPanel = new JPanel();
        ItemsPanel.setPreferredSize(new Dimension(480, 30));
        ItemsPanel.setLayout(new FlowLayout());

        JTextField ClawsText = new JTextField("Claws: " + equip.claw,10);
        ClawsText.setEditable(false);
        JTextField EboniteText = new JTextField("Ebonite: " + equip.ebon,10);
        EboniteText.setEditable(false);
        JTextField DustText = new JTextField("Dust: " + equip.dust,10);
        DustText.setEditable(false);
        JTextField VenomText = new JTextField("Venom: " + equip.venom,10);
        VenomText.setEditable(false);

        ItemsPanel.add(ClawsText, BorderLayout.WEST);
        ItemsPanel.add(EboniteText);
        ItemsPanel.add(DustText);
        ItemsPanel.add(VenomText, BorderLayout.EAST);

        InfoClosePanel.add(ItemsPanel, BorderLayout.NORTH);

        //--> extra
        JPanel ExtraPanel = new JPanel();
        ExtraPanel.setLayout(new FlowLayout());
        ExtraPanel.setPreferredSize(new Dimension(480, 70));

        JPanel extra = new JPanel();

        JTextField HPotText = new JTextField("HP Pot: " + equip.getPlayerHPot(), 7);
        HPotText.setEditable(false);

        JTextField MPotText = new JTextField("MP Pot: " + equip.getPlayerMPot(), 7);
        MPotText.setEditable(false);

        JTextField GoldText = new JTextField("Gold: " + equip.getPlayerGold(), 12);
        GoldText.setEditable(false);

        extra.add(HPotText,BorderLayout.WEST);
        extra.add(MPotText);
        extra.add(GoldText, BorderLayout.EAST);

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ExtraPanel.add(extra, BorderLayout.WEST);
        ExtraPanel.add(closeButton, BorderLayout.EAST);

        InfoClosePanel.add(ExtraPanel,BorderLayout.SOUTH);

        add(InfoClosePanel, BorderLayout.SOUTH);
    }
}
