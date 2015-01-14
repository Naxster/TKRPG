import java.util.Scanner;
import java.io.*;

public class Book {

    private Spell[] spells;
    public int[] costs;

    public Book(int z) {
        spells = new Spell[6];
        costs = new int[6];

        switch (z) {
            case 1:
                spells[0] = new Fball(1);
                spells[1] = new Lightning(0);
                spells[2] = new Freeze(0);
                spells[3] = new Heal(1);
                spells[4] = new Mshield(0);
                spells[5] = new Meteor(0);
                break;
            case 2:
                spells[0] = new Fball(2);
                spells[1] = new Lightning(0);
                spells[2] = new Freeze(1);
                spells[3] = new Heal(2);
                spells[4] = new Mshield(1);
                spells[5] = new Meteor(0);
                break;
            case 0:
                break;
            default:
                spells[0] = new Fball(z);
                spells[1] = new Lightning(z);
                spells[2] = new Freeze(z);
                spells[3] = new Heal(z - 1);
                spells[4] = new Mshield(z + 1);
                break;
        }
        for (int i = 0; i < 6; i++)
            if (spells[i] != null)
                costs[i] = spells[i].cost();
            else
                costs[i] = 0;
    }

    /**
     * funkcja rzucenia zaklecia. Dostanie wroga(i moze gracza) i numer zaklecia
     * potem wywola use() konkretnego zaklecia, na konkretnej posstaci
     */
    public void cast(Character w, Character p, String n) {
        //n = n.substring(0,n.lenght()-1);
        switch (n) {
            case "Khar neramas":
                if (spells[0].level() > 0 && p.getMANA() >= costs[0]) {
                    System.out.println("<Fireball casted>");
                    spells[0].use(w);
                    p.drain(costs[0]);
                } else
                    System.out.println("<Failed casting>");
                break;
            case "Ramare Kere":
                if (spells[1].level() > 0 && p.getMANA() >= costs[1]) {
                    System.out.println("<Lightning casted>");
                    spells[1].use(w);
                    p.drain(costs[1]);
                } else
                    System.out.println("<Failed casting>");
                break;
            case "Mov Ka Rem":
                if (spells[2].level() > 0 && p.getMANA() >= costs[2]) {
                    System.out.println("<Freeze casted>");
                    spells[2].use(w);
                    p.drain(costs[2]);
                } else
                    System.out.println("<Failed casting>");
                break;
            case "Harme":
                if (spells[3].level() > 0 && p.getMANA() >= costs[3]) {
                    System.out.println("<Heal casted>");
                    spells[3].use(p);
                    p.drain(costs[3]);
                } else
                    System.out.println("<Failed casting>");
                break;
            case "Prevetio":
                if (spells[4].level() > 0 && p.getMANA() >= costs[4]) {
                    System.out.println("<Magic shield casted>");
                    spells[4].use(p);
                    p.drain(costs[4]);
                } else
                    System.out.println("<Failed casting>");
                break;
            case "Krav naheris dran klamere":
                if (spells[5].level() > 0 && p.getMANA() >= costs[5]) {
                    System.out.println("<Meteor casted>");
                    spells[5].use(w);
                    p.drain(costs[5]);
                } else
                    System.out.println("<Failed casting>");
                break;
            default:
                break;
        }
    }

    /**
     * funkcja pokazujaca spelle
     * do: pokazania na rozkaz, przy awansie
     */
    public void show() {
        Spell z;
        String name;
        String formula;
        String ex;
        int lev, i;

        for (i = 0; i < 6; i++) {
            z = spells[i];
            name = z.name();
            formula = z.formula();
            lev = z.level();
            ex = z.data();
            System.out.println(name + " " + lev + ",\t (" + ex + ") \t\t: " + formula);
        }
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        int chos;
        show();
        System.out.println("Type number [0-5] of spell to upgrade: ");
        do {
            chos = sc.nextInt();
        } while (chos > 5 || chos < 0);
        Spell z = spells[chos];
        z.upgrade();
        System.out.println("Done");
    }
}