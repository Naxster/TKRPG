public class Mshield extends Spell {

    private int defence;

    public Mshield(int z) {
        if (z > 0) {
            defence = 25 + (z - 1);
            cost = 20 + ((z - 1) * 3);
        }
        lvl = z;
        name = "Force shield";
        formula = "Prevetio";
    }

    /**
     * funkcja podajaca pdodatkwe informacje
     */
    public String data() {
        String h = (String) (defence + "; " + cost);
        return h;
    }

    /**
     * funkcja podajaca wzmocnienie obrony
     */
    public int protect() {
        return defence;
    }

    /**
     * funkcja uzycia zaklecia na postaci
     *
     * @param z - Postac na ktora rzucane jest zaklecie
     */
    public void use(Character z) {
        int tmp = protect();
        z.spoilDEF(-tmp);
    }

    public void upgrade() {
        if (lvl == 0) {
            defence = 25;
            cost = 20;
            lvl++;
        } else {
            defence++;
            cost += 3;
            lvl++;
        }
    }
}