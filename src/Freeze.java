public class Freeze extends Spell {

    private int dmg_l;
    private int dmg_u;
    private int def_low;
    private int chance;

    public Freeze(int z) {
        if (z > 0) {
            dmg_l = 27 + ((z - 1) * 3);
            dmg_u = 40 + ((z - 1) * 3);
            cost = 20 + ((z - 1) * 5);
            def_low = 4 + (z - 1);
            chance = 60 + ((z - 1) * 2);
        }
        lvl = z;
        name = "Frezee bolt";
        formula = "Mov Ka Rem";
    }

    /**
     * funkcja podajaca pdodatkwe informacje
     */
    public String data() {
        String h = (String) (dmg_l + "-" + dmg_u + "; lower def: " + def_low + " " + chance + "%; " + cost);
        return h;
    }

    /**
     * funkcja podajaca obrazenia
     */
    public int dmg() {
        int res = dmg_l + (int) (Math.random() * (dmg_u - dmg_l + 1));
        return res;
    }

    /**
     * funkcja podajaca obnizenie pancerza
     */
    public int lower() {
        int res = (int) (Math.random() * 101);
        if (res <= chance)
            return def_low;
        else
            return 0;
    }

    /**
     * funkcja uzycia zaklecia na postaci
     *
     * @param z - Postac na ktora rzucane jest zaklecie
     */
    public void use(Character z) {
        int tmp = dmg();
        int tmp2 = lower();
        z.hide(tmp);
        z.spoilDEF(tmp2);
    }

    public void upgrade() {
        if (lvl == 0) {
            dmg_l = 27;
            dmg_u = 40;
            cost = 20;
            def_low = 4;
            chance = 60;
            lvl++;
        } else {
            dmg_l += 3;
            dmg_u += 4;
            cost += 5;
            def_low++;
            chance += 2;
            lvl++;
        }
    }
}
