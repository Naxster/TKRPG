import javax.swing.*;
import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Game {

    private Quest q1;
    private Quest q2;
    private Quest q3;
    public Name names;
    public MapWindow window;
    WorldGenerator world;
    Player play;
    Shop sklep;

    public Game() throws IOException {
        q1 = null;
        q2 = null;
        q3 = null;
        names = new Name();
        world = new WorldGenerator();
        play = null;
    }

    public void CheckTerritory() {
        int cord = play.y * 30 + play.x;
        String msg = "";
        switch (world.map[cord][4]) {
            case 0:
                msg = "You are in: VILLAGE OF KER'BHINAK";
                break;
            case 1:
                msg = "You are in: ANCIENT CAVE";
                break;
            case 2:
                msg = "You are in: TREASURE ZONE";
                break;
            case 3:
                msg = "You are in: GREAT LABIRYNTH";
                break;
            case 4:
                msg = "You are in: ABANDONED HOUSE";
                break;
            case 5:
                msg = "You are in: SWAMP OF DECAY";
                break;
            case 6:
                msg = "You are in: BOSS ZONE";
                break;
            case 7:
                msg = "You are in: FOREST";
                break;
            default:
                break;
        }
        System.out.println(msg);
        window.ChangeTerritory(msg);
    }

    public int movement() throws IOException {
        int cord = play.y * 30 + play.x;
        Scanner sc = new Scanner(System.in);
        switch (world.map[cord][1]) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                if (world.map[cord][0] == 0) {
                    Fight f = new Fight(play, world.map[cord][2], world.map[cord][3], names);
                    if (f.Mortal_Kombat() == true)
                        return 0;
                    else
                        return 2;
                } else
                    return 0;
            case 3:
                if (world.map[cord][0] == 0) {
                    Treasure t = new Treasure(play.getLVL(), world.map[cord][3], names);
                    t.getemall(play);
                }
                return 0;
            case 4:
                if (world.map[cord][0] == 0) {
                    switch (world.map[cord][3]) {
                        case 1:
                            q1 = new Quest(1);
                            q1.checkQuest(play, 0);
                            break;
                        case 2:
                            q2 = new Quest(2);
                            q2.checkQuest(play, 0);
                            break;
                        case 3:
                            q3 = new Quest(3);
                            q3.checkQuest(play, 0);
                            break;
                    }
                } else {
                    switch (world.map[cord][3]) {
                        case 1:
                            q1.checkQuest(play, 1);
                            break;
                        case 2:
                            q2.checkQuest(play, 1);
                            break;
                        case 3:
                            q3.checkQuest(play, 1);
                            break;
                    }
                }
                return 0;
            case 5:
                if (world.map[cord][0] == 0) {
                    sklep = new Shop(play.getLVL(), names, play);
                    sklep.show(play.getEquip());
                } else {
                    System.out.println("Do you want to reload shop (y-n), to make it more adjusted?");
                    int n = JOptionPane.showConfirmDialog(window,"Do you want to reload shop's inventory?\nIt will provide new items","Shop reload",JOptionPane.YES_NO_OPTION);
                    if (n == 0)
                        sklep = new Shop(play.getLVL(), names, play);
                    sklep.show(play.getEquip());
                }
                return 0;
            case 6:
                Fight f = new Fight(play, 1, 0, names);
                if (f.Mortal_Kombat() == true)
                    return 3;
                else
                    return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Game g = new Game();
        //MainWindow w = new MainWindow();
        g.window = new MapWindow(g.world.map,g);
        Object[] options = {"Mage", "Warrior"};
        int chosenClass = JOptionPane.showOptionDialog(g.window,
                "Choose your class:",
                "Class Choice",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, options, null);
        switch (chosenClass) {
            case 0:
                System.out.println("\n Creating Mage \n");
                g.play = new Mage(g.names);
                break;
            case 1:
                System.out.println("\n Creating Warrior \n");
                g.play = new Warrior(g.names);
                break;
            default:
                System.out.println("\n No such class, creating Warrior \n");
                g.play = new Warrior(g.names);
                break;
        }

        g.CheckTerritory();
        g.world.show(g.play.y * 30 + g.play.x);
        //g.map = new MapWindow(g.world.map);

        while(true) { }
    }

    private void DetermineExit(int obstacle) {
        if (obstacle == 1)
            play.y -= 1;
        if (obstacle == 2) {
            System.out.println("\n\n\t YOU HAVE LOST... WE ARE ALL DOOMED...");
            return;
        }
        if (obstacle == 3) {
            System.out.println("\n\n\t YOU HAVE WIN!... WE ARE ALL SAVED FROM DRAGON...");
            return;
        }
        world.map[play.y * 30 + play.x][0] = 1;
        CheckTerritory();
        world.show(play.y * 30 + play.x);
        window.repaintPlayer(play.x, play.y);
    }

    public void MoveUp() throws IOException{
        int obstacle;
        if (play.y + 1 <= 34) {
            play.y += 1;
            obstacle = movement();
            DetermineExit(obstacle);
        }
    }

    public void MoveDown() throws IOException {
        int obstacle;
        if (play.y - 1 >= 0) {
            play.y -= 1;
            obstacle = movement();
            DetermineExit(obstacle);
        }
    }

    public void MoveRight() throws IOException {
        int obstacle;
        if (play.x + 1 < 30) {
            play.x += 1;
            obstacle = movement();
            DetermineExit(obstacle);
        }
    }

    public void MoveLeft() throws IOException {
        int obstacle;
        if (play.x - 1 >= 0) {
            play.x -= 1;
            obstacle = movement();
            DetermineExit(obstacle);
        }
    }

    public void ShowEquipment(){
        play.equip.show();
    }

    public void ShowStats(){
        play.identify();
    }
}
