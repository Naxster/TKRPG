import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Naxster on 2015-02-23.
 */
public class BuyButtonListener implements ActionListener {
    private Shop shop;
    private ShopWindow parent;

    public BuyButtonListener(Shop s, ShopWindow p) {
        shop = s;
        parent = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source){
            case "1":
                shop.sell(0, parent);
                break;
            case "2":
                shop.sell(1, parent);
                break;
            case "3":
                shop.sell(2, parent);
                break;
            case "4":
                shop.sell(3,parent);
                break;
            case "5":
                shop.sell(4,parent);
                break;
            case "6":
                shop.sell(5, parent);
                break;
            case "7":
                shop.sell(6, parent);
                break;
            case "8":
                shop.sell(7,parent);
                break;
            case "9":
                shop.sell(8,parent);
                break;
            case "10":
                shop.sell(9,parent);
                break;
            case "11":
                shop.sell(10,parent);
                break;
            case "12":
                shop.sell(11,parent);
                break;
            case "13":
                shop.sell(12,parent);
                break;
            case "14":
                shop.sell(13,parent);
                break;
            case "15":
                shop.sell(14,parent);
                break;
            case "16":
                shop.sell(15,parent);
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
