

import java.util.*;
import java.io.*;

public class Cave {

    public int[][][] c1;

    public Cave() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("cave_1.txt");
        Scanner wczytaj = new Scanner(fr);
        c1 = new int[4][187][6];
        int i;

        for (i = 0; i < 187; i++) {
            c1[0][i][0] = wczytaj.nextInt();
            c1[0][i][1] = wczytaj.nextInt();
            c1[0][i][2] = wczytaj.nextInt();
            c1[0][i][3] = wczytaj.nextInt();
            c1[0][i][4] = wczytaj.nextInt();
            c1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("cave_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 187; i++) {
            c1[1][i][0] = wczytaj.nextInt();
            c1[1][i][1] = wczytaj.nextInt();
            c1[1][i][2] = wczytaj.nextInt();
            c1[1][i][3] = wczytaj.nextInt();
            c1[1][i][4] = wczytaj.nextInt();
            c1[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("cave_3.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 187; i++) {
            c1[2][i][0] = wczytaj.nextInt();
            c1[2][i][1] = wczytaj.nextInt();
            c1[2][i][2] = wczytaj.nextInt();
            c1[2][i][3] = wczytaj.nextInt();
            c1[2][i][4] = wczytaj.nextInt();
            c1[2][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("cave_4.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 187; i++) {
            c1[3][i][0] = wczytaj.nextInt();
            c1[3][i][1] = wczytaj.nextInt();
            c1[3][i][2] = wczytaj.nextInt();
            c1[3][i][3] = wczytaj.nextInt();
            c1[3][i][4] = wczytaj.nextInt();
            c1[3][i][5] = wczytaj.nextInt();
        }
    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n = (int) (Math.random() * 4);
        int i;
        int l, num;

        for (i = 0; i < 187; i++) {
            num = c1[n][i][0];
            l = los();
            map[num][0] = c1[n][i][1];
            if (c1[n][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = c1[n][i][3];
                map[num][3] = c1[n][i][4];
            } else if (c1[n][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = c1[n][i][2];
                map[num][2] = c1[n][i][3];
                map[num][3] = c1[n][i][4];
            }
            map[num][4] = c1[n][i][5];
        }
    }

}