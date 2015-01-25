import java.util.Scanner;
import java.io.*;

public abstract class Player implements Character {

    protected int strenght;    //sila (dmg + hp)
    protected int dexterity;    //zrecznosc (def + crit)
    protected int magic_skill;        //umiejetnosci magiczne (mdmg + mp)
    protected String playerName;

    protected int hp;    //zycie
    protected int ex_hp;
    protected int mana;        //mana
    protected int ex_mana;
    protected int dmg;        //obrazenia podstawowe
    protected int ex_dmg;
    protected int mdmg;        //obrazenia magiczne
    protected int ex_mdmg;
    protected int def;        //obrona podstawowa
    protected int ex_def;
    protected int crit;        //szansa na krytyczne
    protected int ex_crit;
    protected int h_pot;        //mikstury zycia
    protected int m_pot;        //mikstury many
    protected int gold;        //zloto
    protected int exp;        //doswiadczenie
    protected int lvl;        //poziom
    public Thing weapon;    //slot na bron
    public Amulet amulet;    //slot na amulet
    public Shield shield;
    protected Book spell_book;    //ksiega zaklec
    protected Equipment equip;    //ekwipunek
    protected Name names; //katalog nazw

    public int x;            //pozycja x i y
    public int y;
    protected int exp_nxt;        //doswiadczenie do nastepnego poziomu

    public int meta_hp;
    public int meta_mana;
    protected int meta_dmg;
    protected int meta_def;


//FUNKCJE DO WYSWIETLANIA

    /**
     * funkcja podajaca zycie
     * do: kopiowania przy walce, wyswietlania w glownym oknie
     */
    public int getHP() {
        return (this.hp + this.ex_hp);
    }

    /**
     * funkcja podajaca mane
     * do: kopiowania przy walce, wyswietlania w glownym oknie
     */
    public int getMANA() {
        return this.meta_mana;
    }

    /**
     * funkcja zmieniajaca zycie
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgHP(int z) {
        this.ex_hp += z;
    }

    /**
     * funkcja zmieniajaca mane
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgMAN(int z) {
        this.ex_mana += z;
    }

    /**
     * funkcja uzywania potionow zycia
     * do: uzycia w walce, znalezienia na mapie
     *
     * @param t - true to uzycie, false to dodanie
     * @param z - ilosc znalezionych
     */
    public void useHPOT(boolean t, int z) {
        if (t == true) {
            this.h_pot -= 1;
            this.meta_hp += 150;
            System.out.println("<healing potion used>");
        } else
            this.h_pot += z;
    }

    /**
     * funkcja podajaca ilosc potionow zycia
     * do: wyswietlania w glownym oknie, wyswietlania w walce
     */
    public int getHPOT() {
        return this.h_pot;
    }

    /**
     * funkcja uzywania potionow many
     * do: uzycia w walce, znalezienia na mapie
     *
     * @param t - true to uzycie, false to dodanie
     * @param z - ilosc znalezionych
     */
    public void useMPOT(boolean t, int z)  //true to uzycie, false to dodanie
    {
        if (t == true) {
            this.m_pot -= 1;
            this.meta_mana += 120;
            System.out.println("<mana potion used>");
        } else
            this.m_pot += z;
    }

    /**
     * funkcja podajaca ilosc potionow many
     * do: wyswietlania w glownym oknie, wyswietlania w walce
     */
    public int getMPOT() {
        return this.m_pot;
    }

    /**
     * funkcja podajaca ilosc gotowki
     * do: wyswietlania w glownym oknie
     */
    public int getGOLD() {
        return this.gold;
    }

    /**
     * funkcja zmieniajaca gotowke
     * do: zmiany po walce, w sklepie
     */
    public void chgGOLD(int z) {
        this.gold += z;
    }

//FUNKCJE PODAWANIA W WALCE

    /**
     * funkcja zmieniajaca krytyczne
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgCRIT(int z) {
        this.ex_crit += z;
    }

    /**
     * funkcja podajaca szanse na krytyczne
     * do: obliczen w walce
     */
    public int getCRIT() {
        return (this.crit + this.ex_crit);
    }

    /**
     * funkcja podajaca obrone
     * do: obliczen w walce
     */
    public int getDEF() {
        return (this.def + this.ex_def);
    }

    /**
     * funkcja zmieniajaca obrone
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgDEF(int z) {
        this.ex_def += z;
    }

    /**
     * funkcja zmieniajaca obrone
     * do: zmiany wartosci od ataku
     *
     * @param z - warotsc zmiany
     */
    public void spoilDEF(int z) {
        if (this.def - z > 0)
            this.def -= z;
        else
            this.def = 0;
    }

    /**
     * funkcja podajaca obrazenia
     * do: obliczen funkcji slash
     */
    public int getDMG() {
        return (this.dmg + this.ex_dmg);
    }

    /**
     * funkcja zmieniajaca atak
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgDMG(int z) {
        this.ex_dmg += z;
    }

    /**
     * funkcja zmieniajaca atak
     * do: zmiany wartosci od ataku
     *
     * @param z - warotsc zmiany
     */
    public void spoilDMG(int z) {
        if (this.dmg - z > 0)
            this.dmg -= z;
        else
            this.dmg = 0;
    }

    /**
     * funkcja podajaca obrazenia magiczne
     * do: obliczen zaklec
     */
    public int getMDMG() {
        return (this.mdmg + this.ex_mdmg);
    }

    /**
     * funkcja zmieniajaca atak magiczny
     * do: zmiany wartosci od przedmiotu
     *
     * @param z - warotsc zmiany
     */
    public void chgMDMG(int z) {
        this.ex_mdmg += z;
    }


//FUNKCJE ZWIAZANE Z POZIOMEM

    /**
     * funkcja podajaca poziom
     * do: wyswietlania w glownym oknie
     */
    public int getLVL() {
        return this.lvl;
    }

    /**
     * funkcja podajaca doswiadczenie
     * do: wyswietlania w glownym oknie
     */
    public int getEXP() {
        return this.exp;
    }

    /**
     * funkcja dodajaca doswiadczenie
     * do: zmiany wartosci po walce, obsluga inicjacji zmiany poziomu
     *
     */
    public void levelup() {
        Scanner sc = new Scanner(System.in);
        String chos;
        System.out.println("LEVEL UP! Choose option to modify: \n[s]trenght\n[d]exterity\n[m]agic skill\n[l]earn or improve spell");
        chos = sc.nextLine();

        switch (chos) {
            case "s":
                this.strenght += 1;
                this.hp += 40;
                this.dmg += 8;
                break;
            case "d":
                this.dexterity += 1;
                this.crit += 3;
                this.def += 6;
                break;
            case "m":
                this.magic_skill += 1;
                this.mana += 30;
                this.mdmg += 7;
                break;
            case "l":
                this.spell_book.update();
                break;
            default:
                System.out.println("Blad");
        }
    }

    public void addEXP(int z) {
        this.exp += z;
        while (this.exp >= this.exp_nxt) {
            this.exp -= this.exp_nxt;
            this.chgEXPNXT();
            levelup();
            this.lvl++;
        }
    }

    /**
     * funkcja podajaca dosw. do nastepnego poziomu
     * do: wyswietlania w glownym oknie
     */
    public int getEXPNXT() {
        return this.exp_nxt;
    }

    /**
     * funkcja zmieniajaca dosw. do nastepnego poziomu
     * do: dzialan przy zmianie poziomu
     */
    public void chgEXPNXT() {
        int tmp;
        if (this.lvl < 6) {
            tmp = (int) (this.exp_nxt * (2 - (0.15 * this.lvl - 1)));
            this.exp_nxt = tmp;
        } else {
            tmp = (int) (this.exp_nxt * 1.4);
            this.exp_nxt = tmp;
        }
    }


//FUNKCJE OBLICZENIOWE DO WALKI

    /**
     * funkcja wyliczajaca watosc ataku (ABSTAKCJA)
     * do: walki
     */
    public abstract int slash();

    /**
     * funkcja wyliczajaca watosc aobrony
     * do: walki
     */
    public abstract void hide(int n);

    /**
     * funkcja podajaca zycie
     * do: kopiowania przy walce, wyswietlania w glownym oknie
     */
    public void stFight() {
        this.meta_hp = this.hp + this.ex_hp;
        this.meta_mana = this.mana + this.ex_mana;
        this.meta_dmg = this.dmg;
        this.meta_def = this.def;
    }

    public void endFight() {
        this.dmg = this.meta_dmg;
        this.def = this.meta_def;
    }

    public void identify() {

        String head = playerName + ", lvl." + lvl;
        String text = "";

        text += "Strenght: \t\t" + strenght + "\n";
        text += "Dexterity: \t\t" + dexterity + "\n";
        text += "Magic: \t\t" + magic_skill + "\n\n";
        text += "Health: \t\t" + hp + "\n";
        text += "Mana: \t\t" + mana + "\n\n";
        text += "Damage: \t\t" + dmg + "\n";
        text += "Magical damage: \t" + mdmg + "\n";
        text += "Defence: \t\t" + def + "\n";
        text += "Chance for critical: \t" + crit + "\n\n";
        text += "ADDITIONAL:" + "\n";
        text += "Additional Health: \t" + ex_hp + "\n";
        text += "Additional Mana: \t" + ex_mana + "\n";
        text += "Additional Damage: \t" + ex_dmg + "\n";
        text += "Additional Magical damage: \t" + ex_mdmg + "\n";
        text += "Additional Defence: \t" + ex_def + "\n";
        text += "Additional chance for Critical: \t" + ex_crit + "\n";

        StatsWindow window = new StatsWindow(gold, exp, exp_nxt, head, text);
        window.dispose();
    }

    public Name getNames() {
        return names;
    }

    public int s_strenght() {
        return strenght;
    }

    public int s_dexterity() {
        return dexterity;
    }

    public int s_magic_skill() {
        return magic_skill;
    }

    public void drain(int n) {
        this.meta_mana -= n;
    }

    public void help(int n) {
        this.meta_hp += n;
    }
}
