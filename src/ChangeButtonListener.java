import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-02-19.
 */
public class ChangeButtonListener implements ActionListener {
    private Equipment equip;
    private EquipmentWindow parent;

    public ChangeButtonListener(Equipment e, EquipmentWindow p) {
        equip = e;
        parent = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source){
            case "1":
                equip.swap(0,parent);
                break;
            case "2":
                equip.swap(1,parent);
                break;
            case "3":
                equip.swap(2,parent);
                break;
            case "4":
                equip.swap(3,parent);
                break;
            case "5":
                equip.swap(4,parent);
                break;
            case "6":
                equip.swap(5,parent);
                break;
            case "7":
                equip.swap(6,parent);
                break;
            case "8":
                equip.swap(7,parent);
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
