public class Amulet extends Thing {

    private int ex_hp;
    private int ex_mana;
    private int ex_dmg;
    private int ex_mdmg;
    private int ex_def;
    private int ex_crit;

    public Amulet(int lev, int z, Name n) {
        if (z == 0) {
            ex_hp = 0;
            ex_mana = 10;
            ex_dmg = 0;
            ex_mdmg = 2;
            ex_def = 0;
            ex_crit = 0;
            name = "Simple steel amulet of novice";
            cost = 20;
            require = 0;
        } else if (lev == 0) {
            ex_hp = 100;
            ex_mana = 200;
            ex_dmg = 10;
            ex_mdmg = 40;
            ex_def = 20;
            ex_crit = 30;
            name = "Extremely fortunately found shiny object";
            cost = 2000;
            require = 0;
        } else {
            name = "";
            int rand;
            if (z > 1 && z < 4) {
                rand = (int) (Math.random() * 10);
                name += (n.a1[rand] + " ");
            }
            if (z < 4) {
                rand = (int) (Math.random() * 4);
                name += (n.a2[rand] + " ");
            }
            if (z == 3) {
                rand = (int) (Math.random() * 18);
                name += (n.a3[rand] + " ");
            }
            if (z == 4) {
                rand = (int) (Math.random() * 11);
                name += (n.ae[rand] + " ");
            }

            ex_hp = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 30)));
            ex_mana = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 30)));
            ex_dmg = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_mdmg = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_def = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_crit = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 10)));
            cost = (int) (z * 100 + z * 100 * (1 / 2 * lev));
            require = lev + z;
        }
    }

    public String show() {
        String res = name + " \t(hp:" + ex_hp + " mp:" + ex_mana + " dmg:" + ex_dmg + " mdmg:" + ex_mdmg + " def:" + ex_def + " crt:" + ex_crit + ")" + "\t requires: " + require + " magic";
        return res;
    }

    public String showDetails() {
        String res = "Health: +" + ex_hp + "\nMana: +" + ex_mana + "\nDamage: +" + ex_dmg + "\nMagical Damage: +" + ex_mdmg + "\nDefence: +" + ex_def + "\nCritical: +" + ex_crit + "\n\nRequires: " + require + " magic";
        return res;
    }

    public ThingType id() {
        return ThingType.AMULET;
    }

    public void remove_from(Player z) {
        z.chgHP(-ex_hp);
        z.chgMAN(-ex_mana);
        z.chgDMG(-ex_dmg);
        z.chgMDMG(-ex_mdmg);
        z.chgDEF(-ex_def);
        z.chgCRIT(-ex_crit);
    }

    public void add_to(Player z) {
        z.chgHP(ex_hp);
        z.chgMAN(ex_mana);
        z.chgDMG(ex_dmg);
        z.chgMDMG(ex_mdmg);
        z.chgDEF(ex_def);
        z.chgCRIT(ex_crit);
    }

    public void add_to_n(Necromancer z) {
        z.chgHP(ex_hp);
        z.chgMAN(ex_mana);
        z.chgDMG(ex_dmg);
        z.chgMDMG(ex_mdmg);
        z.chgDEF(ex_def);
        z.chgCRIT(ex_crit);
    }

    public void add_to_k(Knurla z) {
        z.chgHP(ex_hp);
        z.chgMAN(ex_mana);
        z.chgDMG(ex_dmg);
        z.chgMDMG(ex_mdmg);
        z.chgDEF(ex_def);
        z.chgCRIT(ex_crit);
    }
}