public class Meteor extends Spell {

    private int dmg_l;
    private int dmg_u;

    public Meteor(int z) {
        if (z > 0) {
            dmg_l = 200 + ((z - 1) * 10);
            dmg_u = 230 + ((z - 1) * 15);
            cost = 250 + ((z - 1) * 20);
        }
        lvl = z;
        name = "Meteor";
        formula = "Krav naheris dran klamere";
    }

    /**
     * funkcja podajaca pdodatkwe informacje
     */
    public String data() {
        String h = (String) (dmg_l + "-" + dmg_u + "; " + cost);
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
     * funkcja uzycia zaklecia na postaci
     *
     * @param z - Postac na ktora rzucane jest zaklecie
     */
    public void use(Character z) {
        int tmp = dmg();
        z.hide(tmp);
    }

    public void upgrade() {
        if (lvl == 0) {
            dmg_l = 200;
            dmg_u = 230;
            cost = 250;
            lvl++;
        } else {
            dmg_l += 10;
            dmg_u += 15;
            cost += 20;
            lvl++;
        }
    }
}