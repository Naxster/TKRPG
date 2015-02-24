import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Equipment {

    public Thing[] things;
    public Player gracz;
    public int claw;
    public int ebon;
    public int dust;
    public int venom;

    public Equipment(Player z, int n) {
        gracz = z;
        things = new Thing[8];
        claw = 0;
        ebon = 0;
        dust = 0;
        venom = 0;

        if (n == 0) //Dla Warriora
        {
            gracz.weapon = new Weapon(0, 0, gracz.getNames());    //przy konstruktorze dla itemu dal "0" da bazowy predefiniowany startowy zestaw
            gracz.shield = new Shield(0, 0, gracz.getNames());
            gracz.amulet = null;
        }
        if (n == 1) //dla Maga
        {
            gracz.weapon = new Staff(0, 0, gracz.getNames());    //przy konstruktorze dla itemu dal "0" da bazowy predefiniowany startowy zestaw
            gracz.shield = null;
            gracz.amulet = new Amulet(0, 0, gracz.getNames());
            gracz.amulet.add_to(gracz);
        }
        if(n == 2)
        {
            gracz.weapon = new Weapon(1, 4, gracz.getNames());    //przy konstruktorze dla itemu dal "0" da bazowy predefiniowany startowy zestaw
            gracz.shield = new Shield(1, 4, gracz.getNames());
            gracz.amulet = new Amulet(0, 4, gracz.getNames());
            gracz.amulet.add_to(gracz);
            things[0] = new Weapon(1, 4, gracz.getNames());
            things[5] = new Amulet(1, 4, gracz.getNames());
        }
    }

    /**
     * funkcja wyswietlajaca ekwipunek
     */
    public void show() {
        EquipmentWindow wind = new EquipmentWindow(this);
    }

    /**
     * funkcja zakladajaca przedmiot z pozycji
     */
    public void swap(int num, JDialog source) {
        ThingType type;
        if (things[num] != null)
            type = things[num].id();
        else
            return;
        Thing tmp;

        switch (type) {
            case WEAPON:
                if (gracz.s_strenght() < things[num].requirements()) {
                    System.out.println("Too low strenght!");
                    JOptionPane.showMessageDialog(source, "Too low strenght!");
                    break;
                }
                tmp = gracz.weapon;
                if (gracz.weapon != null)
                    gracz.weapon.remove_from(gracz);
                gracz.weapon = (things[num]);
                things[num].add_to(gracz);
                things[num] = tmp;
                break;
            case SHIELD:
                if (gracz.s_dexterity() < things[num].requirements()) {
                    System.out.println("Too low dexterity!");
                    JOptionPane.showMessageDialog(source, "Too low dexterity!");
                    break;
                }
                tmp = gracz.shield;
                if (gracz.shield != null)
                    gracz.shield.remove_from(gracz);
                gracz.shield = (Shield) (things[num]);
                things[num].add_to(gracz);
                things[num] = tmp;
                break;
            case AMULET:
                if (gracz.s_magic_skill() < things[num].requirements()) {
                    System.out.println("Too low magic skill!");
                    JOptionPane.showMessageDialog(source, "Too low magic skill!");
                    break;
                }
                tmp = gracz.amulet;
                if (gracz.amulet != null)
                    gracz.amulet.remove_from(gracz);
                gracz.amulet = (Amulet) (things[num]);
                things[num].add_to(gracz);
                things[num] = tmp;
                break;
            case STAFF:
                if (gracz.s_magic_skill() < things[num].requirements()) {
                    System.out.println("Too low magic skill!");
                    JOptionPane.showMessageDialog(source, "Too low magic skill!");
                    break;
                }
                tmp = gracz.weapon;
                if (gracz.weapon != null)
                    gracz.weapon.remove_from(gracz);
                gracz.weapon = (things[num]);
                things[num].add_to(gracz);
                things[num] = tmp;
                break;
            default:
                break;
        }
    }

    public void foundItem(Thing f) {
        if (f.show() == "Claws") {
            claw += 1;
            f.add_to(gracz);
        } else if (f.show() == "Piece of ebonite") {
            ebon += 1;
            f.add_to(gracz);
        } else if (f.show() == "Dust") {
            dust += 1;
            f.add_to(gracz);
        } else if (f.show() == "Venom") {
            venom += 1;
            f.add_to(gracz);
        } else
            f.add_to(gracz);
    }

    /**
     * funkcja dodajaca przedmiot do ekwipunku
     */
    public void found(Thing f) {
        Scanner sc = new Scanner(System.in);
        String line;
        char dec = 'a';
        int num = 0;

        System.out.println("Found something! :");
        String info = f.show();
        System.out.println("\t" + info + "\n");
        if (f.id() == ThingType.ITEM) {
            foundItem(f);
            return;
        }

        show();
        System.out.println("Wanna add? (y/n)");
        while (dec != 'y' && dec != 'n') {
            line = sc.nextLine();
            dec = line.charAt(0);
            if (dec != 'y' && dec != 'n')
                System.out.println("Only y/n answer Idjit!");
        }
        /*int n = JOptionPane.showConfirmDialog(source,"Do you want to reload shop's inventory?\nIt will provide new items","Shop reload",JOptionPane.YES_NO_OPTION);
        if (n == 1)
            return;*/
        if (dec == 'n')
            return;


        System.out.println("Which position change? (1-8)");
        while (num < 1 || num > 8) {
            num = sc.nextInt();
            if (num > 0 && num < 9)
                things[num - 1] = f;
            else
                System.out.println("Wrong number Idjit!");
        }
        System.out.println("Added!");
    }

    public void ItemBought(Thing f) {
        int num = 0;

        EquipPositionChangeWindow questionWindow = new EquipPositionChangeWindow();
        num = questionWindow.selectedSlot;
        things[num] = f;
        System.out.println("Added!");
    }

    public void sell(int num, JDialog source){
        if (things[num] != null) {
            gracz.chgGOLD(things[num].cost);
            things[num] = null;
            JOptionPane.showMessageDialog(source, "Item Sold!");
        }
    }

    public int getPlayerGold(){
        return gracz.gold;
    }
    public int getPlayerHPot(){
        return gracz.h_pot;
    }
    public int getPlayerMPot(){
        return gracz.m_pot;
    }
}