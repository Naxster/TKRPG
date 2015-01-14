

import java.util.*;
import java.io.*;

public class Swamp {

    public int[][][] s1;

    public Swamp() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("swamp_1.txt");
        Scanner wczytaj = new Scanner(fr);
        s1 = new int[2][156][6];
        int i;

        for (i = 0; i < 156; i++) {
            s1[0][i][0] = wczytaj.nextInt();
            s1[0][i][1] = wczytaj.nextInt();
            s1[0][i][2] = wczytaj.nextInt();
            s1[0][i][3] = wczytaj.nextInt();
            s1[0][i][4] = wczytaj.nextInt();
            s1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("swamp_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 156; i++) {
            s1[1][i][0] = wczytaj.nextInt();
            s1[1][i][1] = wczytaj.nextInt();
            s1[1][i][2] = wczytaj.nextInt();
            s1[1][i][3] = wczytaj.nextInt();
            s1[1][i][4] = wczytaj.nextInt();
            s1[1][i][5] = wczytaj.nextInt();
        }

    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n = (int) (Math.random() * 2);
        int i;
        int l, num;

        for (i = 0; i < 156; i++) {
            num = s1[n][i][0];
            l = los();
            map[num][0] = s1[n][i][1];
            if (s1[n][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = s1[n][i][3];
                map[num][3] = s1[n][i][4];
            } else if (s1[n][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = s1[n][i][2];
                map[num][2] = s1[n][i][3];
                map[num][3] = s1[n][i][4];
            }
            map[num][4] = s1[n][i][5];
        }
    }
}