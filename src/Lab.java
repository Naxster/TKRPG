

import java.util.*;
import java.io.*;

public class Lab {

    public int[][][] l1;

    public Lab() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("lab_1.txt");
        Scanner wczytaj = new Scanner(fr);
        l1 = new int[3][232][6];
        int i;

        for (i = 0; i < 232; i++) {
            l1[0][i][0] = wczytaj.nextInt();
            l1[0][i][1] = wczytaj.nextInt();
            l1[0][i][2] = wczytaj.nextInt();
            l1[0][i][3] = wczytaj.nextInt();
            l1[0][i][4] = wczytaj.nextInt();
            l1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("lab_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 232; i++) {
            l1[1][i][0] = wczytaj.nextInt();
            l1[1][i][1] = wczytaj.nextInt();
            l1[1][i][2] = wczytaj.nextInt();
            l1[1][i][3] = wczytaj.nextInt();
            l1[1][i][4] = wczytaj.nextInt();
            l1[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("lab_3.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 232; i++) {
            l1[2][i][0] = wczytaj.nextInt();
            l1[2][i][1] = wczytaj.nextInt();
            l1[2][i][2] = wczytaj.nextInt();
            l1[2][i][3] = wczytaj.nextInt();
            l1[2][i][4] = wczytaj.nextInt();
            l1[2][i][5] = wczytaj.nextInt();
        }

    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n = (int) (Math.random() * 2);
        int i;
        int l, num;

        for (i = 0; i < 232; i++) {
            num = l1[n][i][0];
            l = los();
            map[num][0] = l1[n][i][1];
            if (l1[n][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = l1[n][i][3];
                map[num][3] = l1[n][i][4];
            } else if (l1[n][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = l1[n][i][2];
                map[num][2] = l1[n][i][3];
                map[num][3] = l1[n][i][4];
            }
            map[num][4] = l1[n][i][5];
        }
    }
}