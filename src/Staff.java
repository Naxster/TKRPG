public class Staff extends Thing {

    private int atc_l;
    private int atc_u;

    private int ex_hp;
    private int ex_mana;
    private int ex_dmg;
    private int ex_mdmg;
    private int ex_def;
    private int ex_crit;

    public Staff(int lev, int z, Name n) {
        if (z == 0) {
            atc_l = 2;
            atc_u = 7;
            name = "Simple novice staff";
            ex_hp = 10;
            ex_mana = 5;
            ex_dmg = 0;
            ex_mdmg = 7;
            ex_def = 0;
            ex_crit = 0;
            cost = 20;
            require = 0;
        } else {
            name = "";
            int rand;
            if (z > 1) {
                rand = (int) (Math.random() * 11);
                name += (n.l1[rand] + " ");
            }
            name += "Staff ";
            if (z == 3) {
                rand = (int) (Math.random() * 17);
                name += (n.l2[rand] + " ");
            }

            atc_l = lev + (int) (Math.random() * ((lev * z) - lev + 1));
            atc_u = atc_l + lev;

            ex_hp = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 30)));
            ex_mana = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 30)));
            ex_dmg = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_mdmg = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_def = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 6)));
            ex_crit = ((int) (Math.random() * 2)) * ((int) (Math.random() * (z * 10)));

            cost = (int) (z * 100 + z * 100 * (1 / 2 * lev));
            require = 2 + lev + z;
        }
    }

    public int atc() {
        int res = atc_l + (int) (Math.random() * (atc_u - atc_l + 1));
        return res;
    }

    public String show() {
        String res = name + " \t" + atc_l + "-" + atc_u + " \t(hp:" + ex_hp + " mp:" + ex_mana + " dmg:" + ex_dmg + " mdmg:" + ex_mdmg + " def:" + ex_def + " crt:" + ex_crit + ")" + "\t requires: " + require + " magic";
        return res;
    }

    public ThingType id() {
        return ThingType.STAFF;
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
}