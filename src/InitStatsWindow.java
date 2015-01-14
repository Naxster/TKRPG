import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-01-12.
 */
public class InitStatsWindow extends JDialog {
    public boolean finished;
    public int strenght;
    public int dexterity;
    public int magic;
    private int all;

    public JTextField StrField;
    public JTextField DexField;
    public JTextField MgcField;
    public JTextField HeadField;

    public InitStatsWindow() {
        finished = false;
        strenght = 0;
        dexterity = 0;
        magic = 0;
        all = 10;
        this.setTitle("Stats Window");
        setPreferredSize(new Dimension(300, 250));
        this.setResizable(false);
        setLayout(new FlowLayout());
        setModal(true);

        HeadField = new JTextField("Points to spent: 10",20);
        HeadField.setEditable(false);
        StrField = new JTextField("STRENGHT: 0",13);
        StrField.setEditable(false);
        DexField = new JTextField("DEXTERITY: 0",13);
        DexField.setEditable(false);
        MgcField = new JTextField("MAGIC SKILL: 0",13);
        MgcField.setEditable(false);

        JButton AddStrButton = new JButton("+");
        JButton RemStrButton = new JButton("-");
        JButton AddDexButton = new JButton("+");
        JButton RemDexButton = new JButton("-");
        JButton AddMgcButton = new JButton("+");
        JButton RemMgcButton = new JButton("-");
        JButton ConfirmButton = new JButton("Confirm");

        AddStrButton.setPreferredSize(new Dimension(50, 30));
        AddStrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(all>0) {
                    strenght += 1;
                    all--;
                    updateStrenght();
                }
            }
        });

        RemStrButton.setPreferredSize(new Dimension(50, 30));
        RemStrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(strenght>0) {
                    strenght -= 1;
                    all++;
                    updateStrenght();
                }
            }
        });

        AddDexButton.setPreferredSize(new Dimension(50, 30));
        AddDexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(all>0) {
                    dexterity += 1;
                    all--;
                    updateDexterity();
                }
            }
        });

        RemDexButton.setPreferredSize(new Dimension(50, 30));
        RemDexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dexterity>0) {
                    dexterity -= 1;
                    all++;
                    updateDexterity();
                }
            }
        });

        AddMgcButton.setPreferredSize(new Dimension(50, 30));
        AddMgcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(all>0) {
                    magic += 1;
                    all--;
                    updateMagic();
                }
            }
        });

        RemMgcButton.setPreferredSize(new Dimension(50, 30));
        RemMgcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(magic>0) {
                    magic -= 1;
                    all++;
                    updateMagic();
                }
            }
        });

        ConfirmButton.setPreferredSize(new Dimension(100, 50));
        ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((strenght + dexterity + magic) == 10) {
                    finished = true;
                    setVisible(false);
                }
            }
        });

        add(HeadField);
        JPanel StrPanel = new JPanel();
        StrPanel.setPreferredSize(new Dimension(300, 40));
        StrPanel.add(StrField, BorderLayout.WEST);
        JPanel Buttons1 = new JPanel();
        Buttons1.add(AddStrButton, BorderLayout.WEST);
        Buttons1.add(RemStrButton, BorderLayout.EAST);
        StrPanel.add(Buttons1,BorderLayout.EAST);
        add(StrPanel);

        JPanel DexPanel = new JPanel();
        DexPanel.setPreferredSize(new Dimension(300, 40));
        DexPanel.add(DexField, BorderLayout.WEST);
        JPanel Buttons2 = new JPanel();
        Buttons2.add(AddDexButton, BorderLayout.WEST);
        Buttons2.add(RemDexButton, BorderLayout.EAST);
        DexPanel.add(Buttons2,BorderLayout.EAST);
        add(DexPanel);

        JPanel MgcPanel = new JPanel();
        MgcPanel.setPreferredSize(new Dimension(300, 40));
        MgcPanel.add(MgcField, BorderLayout.WEST);
        JPanel Buttons3 = new JPanel();
        Buttons3.add(AddMgcButton, BorderLayout.WEST);
        Buttons3.add(RemMgcButton, BorderLayout.EAST);
        MgcPanel.add(Buttons3,BorderLayout.EAST);
        add(MgcPanel);

        add(ConfirmButton,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateStrenght(){
        StrField.setText("STRENGHT: " + Integer.toString(strenght));
        HeadField.setText("Points to spent: " + Integer.toString(all));
    }

    private void updateDexterity(){
        DexField.setText("DEXTERITY: " + Integer.toString(dexterity));
        HeadField.setText("Points to spent: " + Integer.toString(all));
    }

    private void updateMagic(){
        MgcField.setText("MAGIC SKILL: " + Integer.toString(magic));
        HeadField.setText("Points to spent: " + Integer.toString(all));
    }
}
