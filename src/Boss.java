import java.io.*;

public class Boss extends Monster {

    protected int h_pot;        //mikstury zycia
    public int gold;        //zloto
    protected Name names; //katalog nazw

    public void useHPOT(boolean t, int z) {
        if (t == true) {
            this.h_pot -= 1;
            this.hp += 200;
            System.out.println("<healing aura casted>");
        } else
            this.h_pot += z;
    }

    public Boss(int l, Name names) throws IOException {
        //Ostateczny boss. Hiperpotężny smok
        strenght = (20 + (l - 1)); //dmg = 5*3; hp = 5*40;
        dexterity = (10 + (l - 1));    //def = 3*3; crt = 3*3
        magic_skill = 7; //mdmg = 2*3; mp = 2*30

        lvl = l;

        hp = 40 * strenght;
        mana = 30 * magic_skill;
        dmg = 8 * strenght;
        mdmg = 5 * magic_skill;
        def = 3 * dexterity;
        crit = 6 * dexterity;
        h_pot = 4;
        gold = 200 * l;

        this.names = names;

        items = new Thing[5];
        items[0] = new Item(85, "Dragon Claws");
        items[1] = new Item(100, "Dragon Scale");
        items[2] = new Item(10000, "Dragon Bones");
        items[3] = new Weapon(l, 4, names);
        items[4] = new Shield(l, 4, names);

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
        if (hp < 60 && h_pot > 0)
            this.useHPOT(true, 0);
        else if (mana >= 30) {
            int tmp = this.mdmg + (int) (this.dmg * 0.5) - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You get " + tmp + " damage <fire breath>\n\tDEFENCE LOWER");
            p.meta_hp -= tmp;
            p.spoilDEF(10);
            this.mana -= 30;
        } else if (hp >= 180) {
            int tmp = krytyk() - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <precise paw attack>");
            p.meta_hp -= tmp;
        } else {
            int tmp = (int) (this.dmg * 1.5 - p.getDEF());
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <strong tail attack>");
            p.meta_hp -= tmp;
        }
    }

    public void hide(int n) {
        int obr = n - (this.def);
        if (obr > 0)
            this.hp -= obr;
        System.out.println("Dragon take " + obr + " damage");
    }
}
