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

    public ThingPanel(String name, int cost, String det, EquipmentWindow parent) {
        details = det;
        parentWindow = parent;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400, 40));

        JTextField nameText = new JTextField(name,20);
        nameText.setEditable(false);

        JButton detailsButton = new JButton("Stats");
        detailsButton.setPreferredSize(new Dimension(60, 30));
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStats();
            }
        });

        JTextField costText = new JTextField(Integer.toString(cost),5);
        costText.setEditable(false);

        add(nameText,BorderLayout.WEST);
        add(detailsButton);
        add(costText,BorderLayout.EAST);
    }

    private void showStats(){
        JInternalFrame detailFrame = new JInternalFrame("Details", true, true);
        detailFrame.setPreferredSize(new Dimension(200, 200));
        //detailFrame.setLocation(20, 20);

        JTextArea text = new JTextArea(details);
        text.setEditable(false);

        detailFrame.add(text);
        detailFrame.pack();
        detailFrame.setVisible(true);

        parentWindow.jdpDesktop.add(detailFrame);
        detailFrame.moveToFront();
        parentWindow.validate();
    }
}
