

import java.util.*;
import java.io.*;

public class House {

    public int[][][] h1;

    public House() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("house_1.txt");
        Scanner wczytaj = new Scanner(fr);
        h1 = new int[3][64][6];
        int i;

        for (i = 0; i < 64; i++) {
            h1[0][i][0] = wczytaj.nextInt();
            h1[0][i][1] = wczytaj.nextInt();
            h1[0][i][2] = wczytaj.nextInt();
            h1[0][i][3] = wczytaj.nextInt();
            h1[0][i][4] = wczytaj.nextInt();
            h1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("house_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 64; i++) {
            h1[1][i][0] = wczytaj.nextInt();
            h1[1][i][1] = wczytaj.nextInt();
            h1[1][i][2] = wczytaj.nextInt();
            h1[1][i][3] = wczytaj.nextInt();
            h1[1][i][4] = wczytaj.nextInt();
            h1[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("house_3.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 64; i++) {
            h1[2][i][0] = wczytaj.nextInt();
            h1[2][i][1] = wczytaj.nextInt();
            h1[2][i][2] = wczytaj.nextInt();
            h1[2][i][3] = wczytaj.nextInt();
            h1[2][i][4] = wczytaj.nextInt();
            h1[2][i][5] = wczytaj.nextInt();
        }
    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n = (int) (Math.random() * 3);
        int i;
        int l, num;

        for (i = 0; i < 64; i++) {
            num = h1[n][i][0];
            l = los();
            map[num][0] = h1[n][i][1];
            if (h1[n][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = h1[n][i][3];
                map[num][3] = h1[n][i][4];
            } else if (h1[n][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = h1[n][i][2];
                map[num][2] = h1[n][i][3];
                map[num][3] = h1[n][i][4];
            }
            map[num][4] = h1[n][i][5];
        }
    }
}