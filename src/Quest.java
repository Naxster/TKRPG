import java.util.Scanner;
import java.io.*;

public class Quest {

    public int claws;
    public int ebonite;
    public int dusts;
    public int venoms;

    public Quest(int n) {
        switch (n) {
            case 1:
                claws = 10;
                ebonite = 6;
                dusts = 3;
                venoms = 0;
                break;
            case 2:
                claws = 3;
                ebonite = 10;
                dusts = 6;
                venoms = 0;
                break;
            case 3:
                claws = 0;
                ebonite = 3;
                dusts = 0;
                venoms = 10;
                break;
            default:
                break;
        }
    }

    public void checkQuest(Player p, int byl) {
        if (byl == 0) {
            System.out.println("Hello traveller! May I stop you for a moment? \nI need a favor, well paid favor... \nCould you bring me some items? Here's the list: ");
            if (claws > 0) ;
            System.out.println("Claws: " + claws);
            if (ebonite > 0) ;
            System.out.println("Ebonite: " + ebonite);
            if (dusts > 0) ;
            System.out.println("Dust: " + dusts);
            if (venoms > 0) ;
            System.out.println("Venom: " + venoms);
            System.out.println("Please, hurry up!");
            System.out.println("\n<type anything to continue>");
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
        } else {
            if (p.equip.claw >= claws && p.equip.ebon >= ebonite && p.equip.dust >= dusts && p.equip.venom >= venoms) {
                System.out.println("Thank you traveller! \nYou have saved me from much trouble, take this gold for your reward. \nGood luck on your journey!");
                p.chgGOLD(p.getLVL() * 200);
                p.addEXP(p.getLVL() * 1000);
                System.out.println("\n<type anything to continue>");
                Scanner sc = new Scanner(System.in);
                String c = sc.next();
            } else {
                System.out.println("Sorry, we need to collect more...");
                System.out.println("\n<type anything to continue>");
                Scanner sc = new Scanner(System.in);
                String c = sc.next();
            }
        }
    }
}