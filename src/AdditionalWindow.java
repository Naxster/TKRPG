import javax.swing.*;
import java.awt.*;

public class AdditionalWindow extends JFrame {
    AdditionalWindow(String nazwa) {
        super("Okno wewnętrzne");
        JTextArea text = new JTextArea();
        text.setText(nazwa);
        add(text);
        pack();
        setVisible(true);
    }
}