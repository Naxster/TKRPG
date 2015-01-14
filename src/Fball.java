public class Fball extends Spell {

    private int dmg_l;
    private int dmg_u;

    public Fball(int z) {
        if (z > 0) {
            dmg_l = 48 + ((z - 1) * 3);
            dmg_u = 52 + ((z - 1) * 4);
            cost = 20 + ((z - 1) * 5);
        }
        lvl = z;
        name = "Fireball";
        formula = "Khar neramas";
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
            dmg_l = 48;
            dmg_u = 52;
            cost = 20;
            lvl++;
        } else {
            dmg_l += 3;
            dmg_u += 4;
            cost += 5;
            lvl++;
        }
    }
}