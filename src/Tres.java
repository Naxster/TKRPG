
import java.util.*;
import java.io.*;

public class Tres {

    public int[][][] t1;
    public int[][][] t2;
    public int[][][] t3;

    public Tres() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("tres_1_1.txt");
        Scanner wczytaj = new Scanner(fr);
        t1 = new int[3][16][6];
        int i;

        for (i = 0; i < 16; i++) {
            t1[0][i][0] = wczytaj.nextInt();
            t1[0][i][1] = wczytaj.nextInt();
            t1[0][i][2] = wczytaj.nextInt();
            t1[0][i][3] = wczytaj.nextInt();
            t1[0][i][4] = wczytaj.nextInt();
            t1[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_2_1.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t1[1][i][0] = wczytaj.nextInt();
            t1[1][i][1] = wczytaj.nextInt();
            t1[1][i][2] = wczytaj.nextInt();
            t1[1][i][3] = wczytaj.nextInt();
            t1[1][i][4] = wczytaj.nextInt();
            t1[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_3_1.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t1[2][i][0] = wczytaj.nextInt();
            t1[2][i][1] = wczytaj.nextInt();
            t1[2][i][2] = wczytaj.nextInt();
            t1[2][i][3] = wczytaj.nextInt();
            t1[2][i][4] = wczytaj.nextInt();
            t1[2][i][5] = wczytaj.nextInt();
        }

        //Drugie miejsce

        fr = new FileReader("tres_1_2.txt");
        wczytaj = new Scanner(fr);
        t2 = new int[3][16][6];

        for (i = 0; i < 16; i++) {
            t2[0][i][0] = wczytaj.nextInt();
            t2[0][i][1] = wczytaj.nextInt();
            t2[0][i][2] = wczytaj.nextInt();
            t2[0][i][3] = wczytaj.nextInt();
            t2[0][i][4] = wczytaj.nextInt();
            t2[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_2_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t2[1][i][0] = wczytaj.nextInt();
            t2[1][i][1] = wczytaj.nextInt();
            t2[1][i][2] = wczytaj.nextInt();
            t2[1][i][3] = wczytaj.nextInt();
            t2[1][i][4] = wczytaj.nextInt();
            t2[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_3_2.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t2[2][i][0] = wczytaj.nextInt();
            t2[2][i][1] = wczytaj.nextInt();
            t2[2][i][2] = wczytaj.nextInt();
            t2[2][i][3] = wczytaj.nextInt();
            t2[2][i][4] = wczytaj.nextInt();
            t2[2][i][5] = wczytaj.nextInt();
        }

        //Trzecie miejsce

        fr = new FileReader("tres_1_3.txt");
        wczytaj = new Scanner(fr);
        t3 = new int[3][16][6];

        for (i = 0; i < 16; i++) {
            t3[0][i][0] = wczytaj.nextInt();
            t3[0][i][1] = wczytaj.nextInt();
            t3[0][i][2] = wczytaj.nextInt();
            t3[0][i][3] = wczytaj.nextInt();
            t3[0][i][4] = wczytaj.nextInt();
            t3[0][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_2_3.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t3[1][i][0] = wczytaj.nextInt();
            t3[1][i][1] = wczytaj.nextInt();
            t3[1][i][2] = wczytaj.nextInt();
            t3[1][i][3] = wczytaj.nextInt();
            t3[1][i][4] = wczytaj.nextInt();
            t3[1][i][5] = wczytaj.nextInt();
        }

        fr = new FileReader("tres_3_3.txt");
        wczytaj = new Scanner(fr);

        for (i = 0; i < 16; i++) {
            t3[2][i][0] = wczytaj.nextInt();
            t3[2][i][1] = wczytaj.nextInt();
            t3[2][i][2] = wczytaj.nextInt();
            t3[2][i][3] = wczytaj.nextInt();
            t3[2][i][4] = wczytaj.nextInt();
            t3[2][i][5] = wczytaj.nextInt();
        }
    }

    public int los() {
        return (int) (Math.random() * 2);
    }

    public void add(int[][] map) {
        int n1 = (int) (Math.random() * 3);
        int n2 = (int) (Math.random() * 3);
        int n3 = (int) (Math.random() * 3);
        int i;
        int l, num;
        //wgrywanie 1
        for (i = 0; i < 16; i++) {
            num = t1[n1][i][0];
            l = los();
            map[num][0] = t1[n1][i][1];
            if (t1[n1][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = t1[n1][i][3];
                map[num][3] = t1[n1][i][4];
            } else if (t1[n1][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = t1[n1][i][2];
                map[num][2] = t1[n1][i][3];
                map[num][3] = t1[n1][i][4];
            }
            map[num][4] = t1[n1][i][5];
        }

        //wgrywanie 2
        for (i = 0; i < 16; i++) {
            num = t2[n2][i][0];
            l = los();
            map[num][0] = t2[n2][i][1];
            if (t2[n2][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = t2[n2][i][3];
                map[num][3] = t2[n2][i][4];
            } else if (t2[n2][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = t2[n2][i][2];
                map[num][2] = t2[n2][i][3];
                map[num][3] = t2[n2][i][4];
            }
            map[num][4] = t2[n2][i][5];
        }

        //wgrywanie 3
        for (i = 0; i < 16; i++) {
            num = t3[n3][i][0];
            l = los();
            map[num][0] = t3[n3][i][1];
            if (t3[n3][i][2] == -1 && l == 1) {
                map[num][1] = 2;
                map[num][2] = t3[n3][i][3];
                map[num][3] = t3[n3][i][4];
            } else if (t3[n3][i][2] == -1 && l == 0) {
                map[num][1] = 0;
                map[num][2] = 0;
                map[num][3] = 0;
            } else {
                map[num][1] = t3[n3][i][2];
                map[num][2] = t3[n3][i][3];
                map[num][3] = t3[n3][i][4];
            }
            map[num][4] = t3[n3][i][5];
        }
    }
}