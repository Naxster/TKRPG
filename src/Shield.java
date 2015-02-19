public class Shield extends Thing {

    private int def_l;
    private int def_u;

    public Shield(int lev, int z, Name n) {
        if (z == 0) {
            def_l = 5;
            def_u = 7;
            name = "Simple novice wooden shield";
            cost = 20;
            require = 0;
        } else {
            name = "";
            int rand;
            if (z > 2 && z < 5) {
                rand = (int) (Math.random() * 9);
                name += (n.s1[rand] + " ");
            }
            if (z == 2 || z == 4) {
                rand = (int) (Math.random() * 7);
                name += (n.s2[rand] + " ");
            }
            if (z < 5) {
                rand = (int) (Math.random() * 4);
                name += (n.s3[rand] + " ");
            }
            if (z > 2 && z < 5) {
                rand = (int) (Math.random() * 7);
                name += (n.s4[rand] + " ");
            }
            if (z == 5) {
                rand = (int) (Math.random() * 5);
                name += (n.se[rand] + " ");
            }

            def_l = lev * 2 + (int) (Math.random() * ((lev * 2 * z) - (lev * 2) + 1));
            def_u = def_l + (lev * 2);

            cost = (int) (z * 100 + z * 100 * (1 / 2 * lev));
            require = 2 + lev + z;
        }
    }

    public int def() {
        int res = def_l + (int) (Math.random() * (def_u - def_l + 1));
        return res;
    }

    public String show() {
        String res = name + "  \t" + def_l + "-" + def_u + "\t requires: " + require + " dexterity";
        return res;
    }

    public String showDetails() {
        return "Defence: " + def_l + "-" + def_u + "\n\nRequires: " + require + " dexterity";
    }

    public ThingType id() {
        return ThingType.SHIELD;
    }

    public void remove_from(Player z) {
    }

    public void add_to(Player z) {
    }
}
