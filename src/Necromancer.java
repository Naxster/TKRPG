import java.io.*;

public class Necromancer extends Monster {

    protected int ex_hp;
    protected int ex_mana;
    protected int ex_dmg;
    protected int ex_mdmg;
    protected int ex_def;
    protected int ex_crit;
    protected int h_pot;        //mikstury zycia
    protected int m_pot;        //mikstury many
    public int gold;        //zloto
    public Staff staff;    //slot na bron
    public Amulet amulet;    //slot na amulet
    protected Book spell_book;    //ksiega zaklec
    protected Name names; //katalog nazw

    public void useMPOT(boolean t, int z)  //true to uzycie, false to dodanie
    {
        if (t == true) {
            this.m_pot -= 1;
            this.mana += 90;
            System.out.println("<mana potion used>");
        } else
            this.m_pot += z;
    }

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
        int res = this.staff.atc();
        res += this.dmg;
        return res;
    }

    public Necromancer(int z, int l, Name names) throws IOException {
        //Nekromanta
        strenght = (z + (l - 1)); //dmg = 5*3; hp = 5*40;
        dexterity = ((z - 1) + (l - 1));    //def = 3*3; crt = 3*3
        magic_skill = ((z + 1) + (l - 1)); //mdmg = 2*3; mp = 2*30

        lvl = l;
        this.names = names;

        staff = new Staff(l, z, names);
        amulet = new Amulet(l, z, names);
        spell_book = new Book(z);

        amulet.add_to_n(this);
        staff.add_to_n(this);

        hp = 30 * strenght;
        mana = 30 * magic_skill;
        dmg = 3 * strenght;
        mdmg = 3 * magic_skill;
        def = 3 * dexterity;
        crit = 3 * dexterity;
        h_pot = 4;
        m_pot = 4;
        gold = 20 * z;
        spell_book = new Book(z - 1 + l);

        items = new Thing[5];
        items[0] = new Item(13, "Necromancer's hand");
        items[1] = new Staff(l, 1, names);
        items[2] = new Amulet(l, 1, names);
        items[3] = new Amulet(l, 2, names);
        items[4] = new Item(2, "Dust");


        x = 0;
        y = 0;
    }

    public void slash(Player p) {
        this.mana += 5;
        if (hp < 60 && h_pot > 0)
            this.useHPOT(true, 0);
        else if (hp < 60 && h_pot == 0 && mana >= spell_book.costs[3])
            spell_book.cast(p, this, "Harme");
        else if (mana < spell_book.costs[0] && m_pot > 0)
            this.useMPOT(true, 0);
        else if (spell_book.costs[5] != 0 && mana >= spell_book.costs[5])
            spell_book.cast(p, this, "Krav naheris dran klamere");
        else if (spell_book.costs[2] != 0 && mana >= spell_book.costs[2])
            spell_book.cast(p, this, "Mov Ka Rem");
        else if (spell_book.costs[1] != 0 && mana >= spell_book.costs[1])
            spell_book.cast(p, this, "Ramare Kere");
        else if (spell_book.costs[4] != 0 && mana >= spell_book.costs[4])
            spell_book.cast(p, this, "Prevetio");
        else if (spell_book.costs[0] != 0 && mana >= spell_book.costs[0])
            spell_book.cast(p, this, "Khar neramas");
        else {
            int tmp = this.attack() - p.getDEF();
            if (tmp < 0)
                tmp = 0;
            System.out.println("You take " + tmp + " damage <staff attack>");
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
