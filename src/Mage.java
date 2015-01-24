import java.util.Scanner;
import java.io.*;

public class Mage extends Player {

    public Mage(Name names) throws IOException {
        InitStatsWindow choice= new InitStatsWindow();
        strenght = choice.strenght; //dmg = 5*3; hp = 5*40;
        dexterity = choice.dexterity;    //def = 9*3; crt = 3*3
        magic_skill = choice.magic; //mdmg = 2*3; mp = 2*30
        playerName = choice.name;
        choice.dispose();

        hp = 40 * strenght;
        ex_hp = 10;
        mana = 30 * magic_skill;
        ex_mana = 15;
        dmg = 8 * strenght;
        ex_dmg = 0;
        mdmg = 7 * magic_skill;
        ex_mdmg = 9;
        def = 6 * dexterity;
        ex_def = 0;
        crit = 3 * dexterity;
        ex_crit = 0;
        h_pot = 4;
        m_pot = 4;
        gold = 0;
        exp = 0;
        lvl = 1;
        spell_book = new Book(2);
        this.names = names;
        equip = new Equipment(this, 1);

        x = 14;
        y = 1;
        exp_nxt = 500;
    }

    public int slash() {
        int res;
        if (this.weapon.id() == ThingType.WEAPON) {
            Weapon w = (Weapon) (this.weapon);
            res = w.atc();
            res += this.getDMG();
            return res;
        } else if (this.weapon.id() == ThingType.STAFF) {
            Staff s = (Staff) (this.weapon);
            res = s.atc();
            res += this.getDMG();
            return res;
        }
        return 0;
    }

    public void hide(int n) {
        int obr = n - this.getDEF();
        if (obr > 0)
            this.meta_hp -= obr;
        System.out.println("You take " + obr + " damage");
    }
}