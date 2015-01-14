import java.util.Scanner;

public class Shop {

    private Thing[] items;
    private int hpotions;
    private int mpotions;
    private Name namez;

    public Shop(int lvl, Name names) {
        namez = names;
        hpotions = 999;
        mpotions = 999;
        items = new Thing[16];

        items[0] = new Weapon(lvl, 4, namez);
        items[1] = new Weapon(lvl, 5, namez);
        items[2] = new Weapon(lvl + 2, 4, namez);
        items[3] = new Weapon(lvl + 5, 4, namez);
        items[4] = new Shield(lvl, 4, namez);
        items[5] = new Shield(lvl, 5, namez);
        items[6] = new Shield(lvl + 2, 4, namez);
        items[7] = new Shield(lvl + 5, 4, namez);
        items[8] = new Amulet(lvl, 3, namez);
        items[9] = new Amulet(lvl, 4, namez);
        items[10] = new Amulet(lvl + 2, 3, namez);
        items[11] = new Amulet(lvl + 5, 3, namez);
        items[12] = new Staff(lvl, 3, namez);
        items[13] = new Staff(lvl, 3, namez);
        items[14] = new Staff(lvl + 2, 3, namez);
        items[15] = new Staff(lvl + 5, 3, namez);
    }

    public void show() {
        int i, j;
        String info;
        int c;
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 4; i++) {
                info = items[(j * 4) + i].show();
                c = items[(j * 4) + i].costing();
                System.out.println("\t" + ((j * 4) + i + 1) + ". " + info + " cost: " + c);
            }
            System.out.println("");
        }
    }

    public void goShopin(Player p) {
        Scanner sc = new Scanner(System.in);
        String chos;
        int ile = 0;

        p.equip.show();

        System.out.println("\n You want to: (b)uy something, get (h)ealt potions (50g), get (m)agic potions (40g) or (e)xit");
        chos = sc.nextLine();

        switch (chos) {
            case "e":
                return;
            case "h":
                System.out.println("How many potions?");
                ile = sc.nextInt();
                if (p.getGOLD() >= 50 * ile) {
                    p.useHPOT(false, ile);
                    p.chgGOLD(-50 * ile);
                    System.out.println("Added " + ile + " health potions");
                } else
                    System.out.println("Not enought money!");
                break;
            case "m":
                System.out.println("How many potions?");
                ile = sc.nextInt();
                if (p.getGOLD() >= 40 * ile) {
                    p.useHPOT(false, ile);
                    p.chgGOLD(-40 * ile);
                    System.out.println("Added " + ile + " mana potions");
                } else
                    System.out.println("Not enought money!");
                break;
            case "b":
                System.out.println("Here, choose: \n");
                this.show();
                System.out.println("\nWhich number (1-16) do you like?: ");
                ile = sc.nextInt() - 1;

                if (p.getGOLD() >= items[ile].costing()) {
                    p.equip.found(items[ile]);
                    p.chgGOLD(-items[ile].costing());
                    System.out.println("Added item");
                } else
                    System.out.println("Not enought money!");
                break;
            default:
                break;
        }
    }
}

		
		