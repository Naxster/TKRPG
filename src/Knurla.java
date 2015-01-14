import java.io.*;

public class Knurla extends Monster {

    protected int ex_hp;
    protected int ex_mana;
    protected int ex_dmg;
    protected int ex_mdmg;
    protected int ex_def;
    protected int ex_crit;
    protected int h_pot;        //mikstury zycia
    public int gold;        //zloto
    public Weapon weapon;    //slot na bron
    public Shield shield;
    public Amulet amulet;    //slot na amulet
    protected Name names; //katalog nazw

    public void useHPOT(boolean t, int z) {
        if (t == true) {
            this.h_pot -= 1;
            this.hp += 50;
            System.out.println("<healing potion used>");
        } else
            this.h_pot += z;
    }

    public void chgHP(int z) {
        this.ex_hp += z;
    }

    public void chgMAN(int z) {
        this.ex_mana += z;
    }

    public void chgCRIT(int z) {
        this.ex_crit += z;
    }

    public void chgDEF(int z) {
        this.ex_def += z;
    }

    public void chgDMG(int z) {
        this.ex_dmg += z;
    }

    public void chgMDMG(int z) {
        this.ex_mdmg += z;
    }

    public int attack() {
        int res = this.weapon.atc();
        res += this.dmg;
        return res;
    }

    public Knurla(int z, int l, Name names) throws IOException {
        strenght = ((z + 1) + (l - 1)); //dmg = 5*3; hp = 5*40;
        dexterity = ((z + 1) + (l - 1));    //def = 3*3; crt = 3*3
        magic_skill = 0; //mdmg = 2*3; mp = 2*30

        lvl = l;
        this.names = names;

        weapon = new Weapon(l, z, names);
        amulet = new Amulet(l, z, names);
        shield = new Shield(l, z, names);

        amulet.add_to_k(this);

        hp = 40 * strenght;
        mana = 30 * magic_skill;
        dmg = 8 * strenght;
        mdmg = 3 * magic_skill;
        def = 3 * dexterity;
        crit = 3 * dexterity;
        h_pot = 4;
        gold = 20 * z;

        items = new Thing[4];
        items[0] = new Item(5, "Claws");
        items[1] = new Item(10, "Piece of ebonite");
        items[2] = new Weapon(l, 2, names);
        items[3] = new Shield(l, 1, names);

        x = 0;
        y = 0;
    }

    public int krytyk() {
        int los = (int) (Math.random() * 101);
        if (los <= this.crit)
            return this.attack() * 2;
        else
            return this.attack();
    }

    public void slash(Player p) {
        if (hp < 60 && h_pot > 0)
            this.useHPOT(true, 0);
        else if (hp >= 80) {
            int tmp = krytyk() - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <normal attack>");
            p.meta_hp -= tmp;
        } else {
            int tmp = (int) (this.attack() * 1.5 - p.getDEF());
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <strong attack>");
            p.meta_hp -= tmp;
        }
    }

    public void hide(int n) {
        int obr = n - (this.def + this.ex_def);
        if (obr > 0)
            this.hp -= obr;
        System.out.println("Enemy take " + obr + " damage");
    }
}
