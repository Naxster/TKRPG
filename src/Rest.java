

import java.util.*;
import java.io.*;

public class Rest {

    public int[][] r1;

    public Rest() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("world.txt");
        Scanner wczytaj = new Scanner(fr);
        r1 = new int[280][6];
        int i;

        for (i = 0; i < 280; i++) {
            r1[i][0] = wczytaj.nextInt();
            r1[i][1] = wczytaj.nextInt();
            r1[i][2] = wczytaj.nextInt();
            r1[i][3] = wczytaj.nextInt();
            r1[i][4] = wczytaj.nextInt();
            r1[i][5] = wczytaj.nextInt();
        }

    }

    public void add(int[][] map) {
        int i;
        int l, num;

        for (i = 0; i < 280; i++) {
            num = r1[i][0];
            map[num][0] = r1[i][1];
            map[num][1] = r1[i][2];
            map[num][2] = r1[i][3];
            map[num][3] = r1[i][4];
            map[num][4] = r1[i][5];
        }
    }
}