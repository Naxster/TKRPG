public class Weapon extends Thing {

    private int atc_l;
    private int atc_u;
    private int atc_s;
    private String spec;

    public Weapon(int lev, int z, Name n) {
        if (z == 0) {
            atc_l = 10;
            atc_u = 12;
            atc_s = 0;
            name = "Simple novice one-handed sword";
            spec = "";
            cost = 20;
            require = 0;
        } else {
            name = "";
            int rand;
            if (z > 2 && z < 5) {
                rand = (int) (Math.random() * 15);
                name += (n.w1[rand] + " ");
            }
            if (z == 2 || z == 4) {
                rand = (int) (Math.random() * 8);
                name += (n.w2[rand] + " ");
            }
            if (z < 5) {
                rand = (int) (Math.random() * 6);
                name += (n.w3[rand] + " ");
            }
            if (z > 2 && z < 5) {
                rand = (int) (Math.random() * 10);
                name += (n.w4[rand] + " ");
            }
            if (z == 5) {
                rand = (int) (Math.random() * 6);
                name += (n.we[rand] + " ");
                spec = "";
                atc_s = 0;
            }
            if (z > 2 && z < 5) {
                rand = (int) (Math.random() * 5);
                spec = n.spec[rand];
                atc_s = lev * z;
            }
            if (z < 3) {
                spec = "";
                atc_s = 0;
            }

            atc_l = lev * 4 + (int) (Math.random() * ((lev * 4 * z) - (lev * 4) + 1));
            atc_u = atc_l + (lev * z);

            cost = (int) (z * 100 + z * 100 * (1 / 2 * lev));
            require = 2 + lev + z;
        }
    }

    public int atc() {
        int res = atc_l + (int) (Math.random() * (atc_u - atc_l + 1));
        res += atc_s;
        return res;
    }

    public String addition() {
        int a = spec.length();
        if (a > 2) {
            String res = "(+ " + atc_s + " " + spec + ")";
            return res;
        }
        return " ";
    }

    public String show() {
        String sp = addition();
        String res = name + " " + sp + " \t" + atc_l + "-" + atc_u + "\t requires: " + require + " strength";
        return res;
    }

    public ThingType id() {
        return ThingType.WEAPON;
    }

    public void remove_from(Player z) {
    }

    public void add_to(Player z) {
    }

}
