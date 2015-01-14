import java.io.*;

public class Spitfire extends Monster {

    public Spitfire(int z, int l) throws IOException {
        //spora obrona, niska �ywotnos�, silne ataki magiczne, slabe normalne
        strenght = (z - 1); //dmg = 5*3; hp = 5*40;
        dexterity = (z + 1);    //def = 3*3; crt = 3*3
        magic_skill = (z + 2); //mdmg = 2*3; mp = 2*30

        lvl = l;

        hp = 20 * strenght + (5 + strenght) * lvl;
        mana = 30 * magic_skill + (10 + strenght) * lvl;
        dmg = 4 * strenght + lvl * 4;
        mdmg = 10 * magic_skill + lvl * 5;
        def = 4 * dexterity + 4 * lvl;
        crit = 4 * dexterity + 10;

        items = new Item[5];
        items[0] = new Item(35, "Stone of fire");
        items[1] = new Item(2, "Dust");
        items[2] = new Item(10, "Piece of ebonite");
        items[3] = new Item(10, "Piece of ebonite");
        items[4] = new Item(10, "Piece of ebonite");

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
            int tmp = this.mdmg - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You get " + tmp + " damage <strong attack>\n\tDEFENCE LOWER & MANA DRAIN");
            p.meta_hp -= tmp;
            p.spoilDEF(this.dmg);
            if (p.meta_mana - 10 >= 0)
                p.meta_mana -= 10;
            else
                p.meta_mana = 0;
            this.mana -= 30;
        } else {
            int tmp = krytyk() - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <normal attac>");
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