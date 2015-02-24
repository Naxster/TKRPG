import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-02-24.
 */
public class EquipPositionChangeWindow extends JDialog {
    public int selectedSlot;
    private JComboBox slotList;

    public EquipPositionChangeWindow() {
        this.setTitle("Position Change");
        setPreferredSize(new Dimension(300, 230));
        this.setResizable(false);
        setLayout(new FlowLayout());
        setModal(true);

        JTextArea textLabel = new JTextArea("Choose which position in your\ninventory to change. Beware, item\non that position will be lost!");
        textLabel.setEditable(false);
        textLabel.setPreferredSize(new Dimension(250, 100));

        String[] choices = { "Slot: 1", "Slot: 2", "Slot: 3", "Slot: 4", "Slot: 5", "Slot: 6", "Slot: 7", "Slot: 8" };
        slotList = new JComboBox(choices);
        slotList.setPreferredSize(new Dimension(250, 40));
        slotList.setSelectedIndex(0);
        selectedSlot = 0;
        //slotList.addActionListener(this);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(100, 40));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSlot = slotList.getSelectedIndex();
                setVisible(false);
            }
        });

        add(textLabel,BorderLayout.NORTH);
        add(slotList);
        add(confirmButton,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
