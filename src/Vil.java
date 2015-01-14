

import java.util.*;
import java.io.*;

public class Vil {

    public int[][][] v1;

    public Vil() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("vil_1.txt");
        Scanner wczytaj = new Scanner(fr);
        v1 = new int[2][83][6];
        int i;

        for (i = 0; i < 83; i++) {
            v1[0][i][0] = wczytaj.nextInt();
            v1[0][i][1] = wczytaj.nextInt();
            v1[0][i][2] = wczytaj.nextInt();
            v1[0][i][3] = wczytaj.nextInt();
            v1[0][i][4] = wczytaj.nextInt();
            v1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("vil_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 83; i++) {
            v1[1][i][0] = wczytaj.nextInt();
            v1[1][i][1] = wczytaj.nextInt();
            v1[1][i][2] = wczytaj.nextInt();
            v1[1][i][3] = wczytaj.nextInt();
            v1[1][i][4] = wczytaj.nextInt();
            v1[1][i][5] = wczytaj.nextInt();
        }

    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n = (int) (Math.random() * 2);
        int i;
        int l, num;

        for (i = 0; i < 83; i++) {
            num = v1[n][i][0];
            l = los();
            map[num][0] = v1[n][i][1];
            if (v1[n][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = v1[n][i][3];
                map[num][3] = v1[n][i][4];
            } else if (v1[n][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = v1[n][i][2];
                map[num][2] = v1[n][i][3];
                map[num][3] = v1[n][i][4];
            }
            map[num][4] = v1[n][i][5];
        }
    }
}