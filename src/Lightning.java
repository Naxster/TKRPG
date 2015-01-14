public class Lightning extends Spell {

    private int dmg_l;
    private int dmg_u;

    public Lightning(int z) {
        if (z > 0) {
            dmg_l = 21 + ((z - 1) * 2);
            dmg_u = 80 + ((z - 1) * 6);
            cost = 20 + ((z - 1) * 5);
        }
        lvl = z;
        name = "Lightning";
        formula = "Ramare Kere";
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
        z.drain(this.cost());
    }

    public void upgrade() {
        if (lvl == 0) {
            dmg_l = 21;
            dmg_u = 80;
            cost = 20;
            lvl++;
        } else {
            dmg_l += 2;
            dmg_u += 6;
            cost += 5;
            lvl++;
        }
    }
}