public class Treasure {

    private Thing toy;
    private int level;

    public Treasure(int lev, int z, Name n) {
        level = z;
        int los = (int) (Math.random() * 4);
        switch (los) {
            case 0:
                toy = new Amulet(lev, z, n);
                break;
            case 1:
                if (z == 4)
                    toy = new Weapon(lev, z + 1, n);
                else
                    toy = new Weapon(lev, z, n);
                break;
            case 2:
                if (z == 4)
                    toy = new Staff(lev, z - 1, n);
                else
                    toy = new Staff(lev, z, n);
                break;
            case 3:
                if (z == 4)
                    toy = new Shield(lev, z + 1, n);
                else
                    toy = new Shield(lev, z, n);
                break;
            default:
                toy = null;
                break;
        }
    }

    public void getemall(Player p) {
        System.out.println("Found treasure, level: " + level + " !");
        p.equip.found(toy);
        System.out.println("Added " + level + " mana&health potions");
        p.useHPOT(false, level);
        p.useMPOT(false, level);
    }
}