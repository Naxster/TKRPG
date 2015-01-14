public abstract class Monster implements Character {

    protected int strenght;    //sila (dmg + hp)
    protected int dexterity;    //zrecznosc (def + crit)
    protected int magic_skill;        //umiejetnosci magiczne (mdmg + mp)

    protected int hp;    //zycie
    protected int mana;        //mana
    protected int dmg;        //obrazenia podstawowe
    protected int mdmg;        //obrazenia magiczne
    protected int def;        //obrona podstawowa
    protected int crit;        //szansa na krytyczne
    protected int lvl;        //poziom
    public int x;            //pozycja x i y
    public int y;
    protected Thing[] items;


//FUNKCJE DO WYSWIETLANIA

    /**
     * funkcja podajaca zycie
     * do: kopiowania przy walce, wyswietlania w glownym oknie
     */
    public int getHP() {
        return (this.hp);
    }

    /**
     * funkcja podajaca mane
     * do: kopiowania przy walce, wyswietlania w glownym oknie
     */
    public int getMANA() {
        return (this.mana);
    }

//FUNKCJE PODAWANIA W WALCE

    /**
     * funkcja podajaca szanse na krytyczne
     * do: obliczen w walce
     */
    public int getCRIT() {
        return (this.crit);
    }

    /**
     * funkcja podajaca obrone
     * do: obliczen w walce
     */
    public int getDEF() {
        return (this.def);
    }

    /**
     * funkcja podajaca obrazenia
     * do: obliczen funkcji slash
     */
    public int getDMG() {
        return (this.dmg);
    }

    /**
     * funkcja podajaca obrazenia magiczne
     * do: obliczen zaklec
     */
    public int getMDMG() {
        return (this.mdmg);
    }


//FUNKCJE ZWIAZANE Z POZIOMEM

    /**
     * funkcja podajaca poziom
     * do: wyswietlania w glownym oknie
     */
    public int getLVL() {
        return this.lvl;
    }
//FUNKCJE OBLICZENIOWE DO WALKI

    /**
     * funkcja wyliczajaca watosc ataku (ABSTAKCJA)
     * do: walki
     */
    public abstract void slash(Player p);

    /**
     * funkcja wyliczajaca watosc aobrony
     * do: walki
     */
    public abstract void hide(int n);

    public void identify() {
        int data;

        data = strenght;
        System.out.println("Strenght: \t\t" + data);
        data = dexterity;
        System.out.println("Dexterity: \t\t" + data);
        data = magic_skill;
        System.out.println("Magic: \t\t\t" + data);
        data = hp;
        System.out.println("Health: \t\t" + data);
        data = mana;
        System.out.println("Mana: \t\t\t" + data);
        data = dmg;
        System.out.println("Damage: \t\t" + data);
        data = mdmg;
        System.out.println("Magical damage: \t" + data);
        data = def;
        System.out.println("Defence: \t\t" + data);
        data = crit;
        System.out.println("Chance for critical: \t" + data);
    }

    public Thing[] loot() {
        return items;
    }

    public boolean isDead() {
        if (this.hp <= 0)
            return true;
        else
            return false;
    }

    public void drain(int n) {
        this.mana -= n;
    }

    public void spoilDEF(int z) {
        this.def -= z;
        if (this.def < 0)
            this.def = 0;
    }

    public void help(int n) {
        this.hp += n;
    }
}
