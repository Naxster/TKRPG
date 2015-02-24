import javax.swing.*;
import java.util.Scanner;

public class Shop {

    public Thing[] items;
    private int hpotions;
    private int mpotions;
    private Name namez;
    private Player player;

    public Shop(int lvl, Name names, Player p) {
        namez = names;
        hpotions = 999;
        mpotions = 999;
        items = new Thing[16];
        player = p;

        items[0] = new Weapon(lvl, 4, namez);
        items[1] = new Weapon(lvl, 5, namez);
        items[2] = new Weapon(lvl + 2, 4, namez);
        items[3] = new Weapon(lvl + 5, 4, namez);
        items[4] = new Shield(lvl, 4, namez);
        items[5] = new Shield(lvl, 5, namez);
        items[6] = new Shield(lvl + 2, 4, namez);
        items[7] = new Shield(lvl + 5, 4, namez);
        items[8] = new Amulet(lvl, 3, namez);
        items[9] = new Amulet(lvl, 4, namez);
        items[10] = new Amulet(lvl + 2, 3, namez);
        items[11] = new Amulet(lvl + 5, 3, namez);
        items[12] = new Staff(lvl, 3, namez);
        items[13] = new Staff(lvl, 3, namez);
        items[14] = new Staff(lvl + 2, 3, namez);
        items[15] = new Staff(lvl + 5, 3, namez);
    }

    public void show(Equipment e) {
        ShopWindow window = new ShopWindow(this,e);

        int i, j;
        String info;
        int c;
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 4; i++) {
                info = items[(j * 4) + i].show();
                c = items[(j * 4) + i].costing();
                System.out.println("\t" + ((j * 4) + i + 1) + ". " + info + " cost: " + c);
            }
            System.out.println("");
        }
    }

    public void sellHPPotion(JDialog source){
        if (player.getGOLD() >= 50) {
            player.useHPOT(false, 1);
            player.chgGOLD(-50);
            System.out.println("Added health potion");
            JOptionPane.showMessageDialog(source, "Added health potion");
        } else {
            System.out.println("Not enought money!");
            JOptionPane.showMessageDialog(source, "Not enought money!");
        }
    }

    public void sellMPPotion(JDialog source){
        if (player.getGOLD() >= 50) {
            player.useMPOT(false, 1);
            player.chgGOLD(-50);
            System.out.println("Added mana potion");
            JOptionPane.showMessageDialog(source, "Added mana potion");
        } else {
            System.out.println("Not enought money!");
            JOptionPane.showMessageDialog(source, "Not enought money!");
        }
    }

    public void sell(int num, JDialog source){
        if (player.getGOLD() >= items[num].costing()) {
            player.equip.ItemBought(items[num]);
            player.chgGOLD(-items[num].costing());
            System.out.println("Added item");
        } else {
            System.out.println("Not enought money!");
            JOptionPane.showMessageDialog(source, "Not enough money!");
        }
    }
}

		
		