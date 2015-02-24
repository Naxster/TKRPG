import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-02-23.
 */
public class SellButtonListener implements ActionListener {
    private Equipment equip;
    private ShopWindow parent;

    public SellButtonListener(Equipment e, ShopWindow p) {
        equip = e;
        parent = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source){
            case "1":
                equip.sell(0, parent);
                break;
            case "2":
                equip.sell(1, parent);
                break;
            case "3":
                equip.sell(2, parent);
                break;
            case "4":
                equip.sell(3,parent);
                break;
            case "5":
                equip.sell(4,parent);
                break;
            case "6":
                equip.sell(5, parent);
                break;
            case "7":
                equip.sell(6, parent);
                break;
            case "8":
                equip.sell(7,parent);
                break;
            default:
                break;
        }
        parent.drawElements();
        parent.invalidate();
        parent.validate();
        parent.repaint();
    }
}
