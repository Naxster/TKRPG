import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-01-28.
 */
public class ThingPanel extends JPanel {

    private String details;
    private EquipmentWindow parentWindow;

    public ThingPanel(String num, String name, int cost, String det, EquipmentWindow parent) {
        details = det;
        parentWindow = parent;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(420, 36));

        JLabel number = new JLabel(num);
        number.setPreferredSize(new Dimension(30, 30));

        JTextField nameText = new JTextField(name,20);
        nameText.setEditable(false);

        JButton detailsButton = new JButton("Stats");
        detailsButton.setPreferredSize(new Dimension(70, 25));
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStats();
            }
        });

        JTextField costText = new JTextField(Integer.toString(cost),5);
        costText.setEditable(false);

        JPanel front = new JPanel();
        front.add(number, BorderLayout.WEST);
        front.add(nameText, BorderLayout.EAST);

        add(front, BorderLayout.WEST);
        add(detailsButton);
        add(costText,BorderLayout.EAST);
    }

    public ThingPanel(String num, EquipmentWindow parent) {
        parentWindow = parent;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(420, 36));

        JLabel number = new JLabel(num);
        number.setPreferredSize(new Dimension(30, 30));

        JTextField nameText = new JTextField("< NO ITEM FOUND >",33);
        nameText.setEditable(false);

        JPanel front = new JPanel();
        front.add(number, BorderLayout.WEST);
        front.add(nameText, BorderLayout.EAST);

        add(front, BorderLayout.WEST);
    }

    private void showStats(){
        JInternalFrame detailFrame = new JInternalFrame("Details", true, true);
        detailFrame.setPreferredSize(new Dimension(200, 200));
        detailFrame.setLocation(20, 20);

        JTextArea text = new JTextArea(details);
        text.setEditable(false);

        detailFrame.add(text);
        detailFrame.pack();
        detailFrame.setVisible(true);

        parentWindow.getContentPane().add(detailFrame);
        detailFrame.moveToFront();
        //parentWindow.validate();
    }
}
