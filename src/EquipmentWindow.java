import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-01-28.
 */
public class EquipmentWindow extends JDialog {

    private Equipment equip;
    public JDesktopPane jdpDesktop;

    public EquipmentWindow(Equipment e) {
        equip = e;

        this.setTitle("Eqipment Window");
        setPreferredSize(new Dimension(500, 700));
        this.setResizable(false);
        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);
        setLayout(new FlowLayout());
        setModal(true);


        //main weapons
        JLayeredPane mainPane = new JLayeredPane();
        mainPane.setBorder(BorderFactory.createTitledBorder("Main Weapons"));
        mainPane.setPreferredSize(new Dimension(480, 140));
        mainPane.setLayout(new FlowLayout());

        if (equip.gracz.weapon != null) {
            ThingPanel mainwWeapon = new ThingPanel(equip.gracz.weapon.name, equip.gracz.weapon.cost, equip.gracz.weapon.showDetails(),this);
            mainPane.add(mainwWeapon,BorderLayout.NORTH);
        }

        add(mainPane, BorderLayout.NORTH);

        //backpack
        JLayeredPane backpackPane = new JLayeredPane();
        backpackPane.setBorder(BorderFactory.createTitledBorder("Backpack"));
        backpackPane.setPreferredSize(new Dimension(480, 370));

        JPanel bacpackItemsPanel = new JPanel();
        bacpackItemsPanel.setLayout(new FlowLayout());

        backpackPane.add(bacpackItemsPanel);
        add(backpackPane);

        //info&close
        JPanel InfoClosePanel = new JPanel();
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

        InfoClosePanel.add(ItemsPanel,BorderLayout.NORTH);

        //--> extra
        JPanel ExtraPanel = new JPanel();
        ExtraPanel.setLayout(new FlowLayout());
        ExtraPanel.setPreferredSize(new Dimension(480, 70));

        JTextField GoldText = new JTextField("Gold: " + equip.getPlayerGold(), 20);
        GoldText.setEditable(false);

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ExtraPanel.add(GoldText,BorderLayout.WEST);
        ExtraPanel.add(closeButton,BorderLayout.EAST);

        InfoClosePanel.add(ExtraPanel,BorderLayout.SOUTH);

        add(InfoClosePanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
