import java.io.*;

public class Spiderpion extends Monster {

    public Spiderpion(int z, int l) throws IOException {
        //srednia zywotnosc, spora obrona. Specjalny atak z uzyciem jadu i w�. kryt
        strenght = (z + 1); //dmg = 5*3; hp = 5*40;
        dexterity = (z + 1);    //def = 3*3; crt = 3*3
        magic_skill = (z - 1); //mdmg = 2*3; mp = 2*30

        lvl = l;

        hp = 20 * strenght + (10 + strenght) * lvl;
        mana = 30 * magic_skill;
        dmg = 4 * strenght + lvl * 4;
        mdmg = 2 * magic_skill + lvl * 2;
        def = 4 * dexterity + 4 * lvl;
        crit = 4 * dexterity + 10;

        items = new Item[3];
        items[0] = new Item(20, "Scorpider's sting");
        items[1] = new Item(30, "Scorpider's carapace");
        items[2] = new Item(5, "Venom");

        x = 0;
        y = 0;
    }

    public int krytyk() {
        int los = (int) (Math.random() * 101);
        if (los <= this.crit)
            return this.dmg * 2;
        else
            return this.dmg;
    }

    public void slash(Player p) {
        this.mana += 5;
        if (mana >= 30) {
            int tmp = krytyk() + this.mdmg - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <strong attack> \n\tDEFENCE LOWER");
            p.meta_hp -= tmp;
            p.spoilDMG(this.mdmg);
            this.mana -= 30;
        } else {
            int tmp = this.dmg - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <normal attack>");
            p.meta_hp -= tmp;
        }
    }

    public void hide(int n) {
        int obr = n - this.def;
        if (obr > 0)
            this.hp -= obr;
        System.out.println("Enemy take " + obr + " damage");
    }
}
