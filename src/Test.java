import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String useless;
        Name ok = new Name();
        int i;

        System.out.println("\n Creating Mage \n");
        Player gram = new Mage(ok);
        gram.identify();
        System.out.println("\n Creating Warrior \n");
        Player gram2 = new Warrior(ok);
        gram2.identify();
        System.out.println("\n Creating Werewolf: \n");
        Monster gram3 = new Werewolf(4, 1);
        gram3.identify();
        System.out.println("\n Creating Necromancer: \n");
        Monster gram4 = new Necromancer(4, 1, ok);
        gram4.identify();
        System.out.println("\n Creating Spiderpion: \n");
        Monster gram5 = new Spiderpion(4, 1);
        gram5.identify();
        System.out.println("\n Creating Spitfire: \n");
        Monster gram6 = new Spitfire(4, 1);
        gram6.identify();
        System.out.println("\n Creating Knurla: \n");
        Monster gram7 = new Knurla(4, 1, ok);
        gram7.identify();


        useless = sc.nextLine();

        System.out.println("\n Werewolf's items: ");
        Thing[] it = gram3.loot();
        for (i = 0; i < it.length; i++)
            System.out.println(it[i].show());

        System.out.println("\n Necromancer's items: ");
        it = gram4.loot();
        for (i = 0; i < it.length; i++)
            System.out.println(it[i].show());

        System.out.println("\n Spiderpion's items: ");
        it = gram5.loot();
        for (i = 0; i < it.length; i++)
            System.out.println(it[i].show());

        System.out.println("\n Spitfire's items: ");
        it = gram6.loot();
        for (i = 0; i < it.length; i++)
            System.out.println(it[i].show());

        System.out.println("\n Knurla's items: ");
        it = gram7.loot();
        for (i = 0; i < it.length; i++)
            System.out.println(it[i].show());

        useless = sc.nextLine();

        System.out.println("\n Mage spells \n");
        gram.spell_book.show();
        System.out.println("\n Warrior spells \n");
        gram2.spell_book.show();

        useless = sc.nextLine();

        System.out.println("\n Mage things \n");
        gram.equip.show();
        System.out.println("\n Warrior things \n");
        gram2.equip.show();

        useless = sc.nextLine();

        System.out.println("\n now Mage will found something and something... \n");
        Thread.currentThread().sleep(1500);
        Staff something = new Staff(1, 3, ok);
        gram.equip.found(something);
        Weapon something2 = new Weapon(1, 4, ok);
        gram.equip.found(something2);
        Shield something3 = new Shield(1, 4, ok);
        gram.equip.found(something3);
        Amulet something4 = new Amulet(1, 3, ok);
        gram.equip.found(something4);

        useless = sc.nextLine();

        System.out.println("\n Mage stats: \n");
        gram.identify();
        System.out.println("\n changing Mage things \n");
        gram.equip.change();

        System.out.println("\n changed things: \n");
        gram.equip.show();
        System.out.println("\n changed stats: \n");
        gram.identify();
    }
}
