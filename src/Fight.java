import java.util.*;
import java.io.*;
import java.lang.*;

public class Fight {

    private Player player;
    private Vector<Monster> enemy;

    public Fight(Player gracz, int num, int z, Name names) throws IOException {
        player = gracz;
        enemy = new Vector<Monster>();

        int lvl = player.getLVL();
        int i;
        if (z == 0) {
            enemy.add(new Boss(lvl, names));
            System.out.println("Wild and furious enemy flies from the heavens: Massive Red Dragon");
        } else {
            for (i = 0; i < num; i++) {
                switch ((int) (Math.random() * 5)) {
                    case 0:
                        enemy.add(new Werewolf(z, lvl));
                        System.out.println("Wild enemy appears: Werewolf");
                        break;
                    case 1:
                        enemy.add(new Spiderpion(z, lvl));
                        System.out.println("Wild enemy appears: Spiderpion");
                        break;
                    case 2:
                        enemy.add(new Spitfire(z, lvl));
                        System.out.println("Wild enemy appears: Spitfire");
                        break;
                    case 3:
                        enemy.add(new Knurla(z, lvl, names));
                        System.out.println("Wild enemy appears: Knurla");
                        break;
                    case 4:
                        enemy.add(new Necromancer(z, lvl, names));
                        System.out.println("Wild enemy appears: Necromancer");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void MAttack(int e) {
        Monster mon = enemy.get(e);
        mon.slash(player);
    }

    public void PAtcMag(int e) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        player.spell_book.show();

        System.out.println("\nType formula: \n");
        String form = sc.next();
        //form = form.substring(0,(form.length())-1);

        Monster mon = enemy.get(e);
        player.spell_book.cast(mon, player, form);
    }

    public int krytyk(int atc, int c) {
        int los = (int) (Math.random() * 101);
        if (los <= c) {
            System.out.println("CRITICAL HIT");
            return atc * 2;
        } else
            return atc;
    }

    public void PAtcWea(int e) {
        Scanner sc = new Scanner(System.in);
        int form;
        Monster mon = enemy.get(e);
        int crit = player.getCRIT();
        int atc = player.slash();
        Monster mon2;

        System.out.println("Normal attack(1)\nStrong attack(2)\nPrecise attack(3)\nGroup attack(4)");
        System.out.println("Type number of attack: ");
        do {
            form = sc.nextInt();
        } while (form > 4 || form < 1);
        System.out.println(" ");
        switch (form) {
            case 1:
                mon.hide((int) (krytyk(atc, crit)));
                break;
            case 2:
                mon.hide((int) (atc * 1.5));
                break;
            case 3:
                mon.hide((int) (krytyk((int) (atc * 0.7), (int) (crit * 1.5))));
                break;
            case 4:
                mon.hide((int) (krytyk((int) (atc * 0.7), crit)));
                for (int i = 0; i < enemy.size(); i++) {
                    if (i == e)
                        continue;
                    mon2 = enemy.get(i);
                    mon2.hide((int) (krytyk((int) (atc * 0.5), (int) (crit * 0.5))));
                }
                break;
            default:
                break;
        }
    }

    public void PAttack() {
        Scanner sc = new Scanner(System.in);
        int e;

        System.out.println("Choose enemy: (0-" + (enemy.size() - 1) + ")");
        do {
            e = sc.nextInt();
        } while (e >= enemy.size() || e < 0);
        System.out.println("Choose form of attack: (m)agic or (w)eapon");
        String ch = sc.next();
        if (ch.charAt(0) == 'm')
            PAtcMag(e);
        else if (ch.charAt(0) == 'w')
            PAtcWea(e);
    }

    public void grabDaStuff() {
        int i, j;
        Thing[] lut;
        for (i = 0; i < enemy.size(); i++) {
            lut = enemy.get(i).loot();
            for (j = 0; j < lut.length; j++)
                player.equip.found(lut[j]);
        }
    }

    public boolean Mortal_Kombat() {
        Scanner sc = new Scanner(System.in);
        int i;
        boolean finishim = true;

        player.stFight();
        do {
            System.out.println("\nYou have " + player.meta_hp + " health and " + player.meta_mana + " mana");
            for (i = 0; i < enemy.size(); i++)
                System.out.println("Enemy " + i + " has " + enemy.get(i).getHP() + " health");
            System.out.println("\nWill you: (a)ttack, (h)eal with potion or increase(m)ana with potion");
            String ch = sc.next();
            if (ch.charAt(0) == 'a')
                PAttack();
            else if (ch.charAt(0) == 'h')
                player.useHPOT(true, 0);
            else if (ch.charAt(0) == 'm')
                player.useMPOT(true, 0);

            finishim = true;
            for (i = 0; i < enemy.size(); i++)
                if (enemy.get(i).isDead() == false)
                    finishim = false;
            if (finishim == true) {
                System.out.println("\n\n YOU HAVE WON");
                player.endFight();
                grabDaStuff();
                for (i = 0; i < enemy.size(); i++)
                    player.addEXP(enemy.get(i).getLVL() * 50);
                return true;
            }

            System.out.println("");

            for (i = 0; i < enemy.size(); i++)
                if (enemy.get(i).isDead() == false)
                    MAttack(i);
        } while (player.meta_hp > 0);

        player.endFight();
        return false;
    }
/*	
public static void main(String[] args) throws IOException{
Name name = new Name();
Fight turnament = new Fight(new Warrior(name), 2,3, name);
boolean t = turnament.Mortal_Kombat();
}
*/
}