import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-01-25.
 */
public class StatsWindow extends JDialog {
    private int gold;
    private int exp;
    private int expToNext;
    private String headline;
    private String text;

    public StatsWindow(int g, int e, int eNext, String head, String txt) {
        gold = g;
        exp = e;
        expToNext = eNext;
        headline = head;
        text = txt;

        this.setTitle("Stats Window");
        setPreferredSize(new Dimension(320, 500));
        this.setResizable(false);
        setLayout(new FlowLayout());
        setModal(true);

        JTextField headText = new JTextField("name", 25);
        headText.setEditable(false);
        headText.setText(headline);

        JTextField expText = new JTextField("exp", 13);
        expText.setEditable(false);
        expText.setText("Exp: " + Integer.toString(exp));

        JTextField expNText = new JTextField("expNext", 13);
        expNText.setEditable(false);
        expNText.setText("Exp to next lvl: " + Integer.toString(expToNext));

        JPanel expPanel = new JPanel();
        expPanel.setPreferredSize(new Dimension(160, 60));
        expPanel.add(expText, BorderLayout.NORTH);
        expPanel.add(expNText, BorderLayout.SOUTH);

        JTextField goldText = new JTextField("gold", 8);
        goldText.setEditable(false);
        goldText.setText("Gold: " + Integer.toString(gold));

        JPanel quickStatsPanel = new JPanel();
        quickStatsPanel.setPreferredSize(new Dimension(280, 70));
        quickStatsPanel.add(expPanel, BorderLayout.WEST);
        quickStatsPanel.add(goldText, BorderLayout.EAST);

        JPanel headPanel = new JPanel();
        headPanel.setPreferredSize(new Dimension(280, 90));
        headPanel.add(headText, BorderLayout.NORTH);
        headPanel.add(quickStatsPanel, BorderLayout.SOUTH);

        JTextArea mainText = new JTextArea("tekst", 20,25);
        mainText.setEditable(false);
        mainText.setText(text);

        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(280, 420));
        content.add(headPanel, BorderLayout.NORTH);
        content.add(mainText, BorderLayout.SOUTH);

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(70, 40));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(content,BorderLayout.NORTH);
        add(closeButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
