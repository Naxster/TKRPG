

import java.util.*;
import java.io.*;


public class WorldGenerator {

    public int[][] map;
    public Swamp s;
    public Lab l;
    public Cave c;
    public Rest r;
    public Vil v;
    public Tres t;
    public House h;

    public WorldGenerator() throws IOException, FileNotFoundException {
        map = new int[1050][5];
        int i;

        s = new Swamp();
        l = new Lab();
        c = new Cave();
        r = new Rest();
        v = new Vil();
        t = new Tres();
        h = new House();

        s.add(map);
        l.add(map);
        c.add(map);
        v.add(map);
        t.add(map);
        h.add(map);
        r.add(map);

    }

    public char w(int p, int c) {
        char w;
        switch (map[p][1]) {
            case 0:
                w = ' ';
                break;
            case 1:
                w = 'X';
                break;
            case 3:
                w = 'T';
                break;
            case 6:
                w = 'B';
                break;
            default:
                w = ' ';
                break;
        }
        if (map[p][0] == 1)
            w = 'O';
        if (map[p][1] == 4)
            w = 'Q';
        if (map[p][1] == 5)
            w = 'S';
        if (map[p][1] == 6)
            w = 'B';
        if (p == c)
            w = 'P';
        return w;
    }

    public void show(int c) {
        int i, j;
        char[] tmp = new char[30];
        for (i = 34; i >= 0; i--) {
            for (j = 0; j < 30; j++)
                tmp[j] = this.w((i * 30) + j, c);
            System.out.println(tmp[0] + "" + tmp[1] + "" + tmp[2] + "" + tmp[3] + "" + tmp[4] + "" + tmp[5] + "" + tmp[6] + "" + tmp[7] + "" + tmp[8] + "" + tmp[9] + "" + tmp[10] + "" + tmp[11] + "" + tmp[12] + "" + tmp[13] + "" + tmp[14] + "" + tmp[15] + "" + tmp[16] + "" + tmp[17] + "" + tmp[18] + "" + tmp[19] + "" + tmp[20] + "" + tmp[21] + "" + tmp[22] + "" + tmp[23] + "" + tmp[24] + "" + tmp[25] + "" + tmp[26] + "" + tmp[27] + "" + tmp[28] + "" + tmp[29]);
        }
    }
}