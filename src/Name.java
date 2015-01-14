import java.io.*;

public class Name {

    public String[] w1;
    public String[] w2;
    public String[] w3;
    public String[] w4;
    public String[] we;
    public String[] spec;

    public String[] s1;
    public String[] s2;
    public String[] s3;
    public String[] s4;
    public String[] se;

    public String[] a1;
    public String[] a2;
    public String[] a3;
    public String[] ae;

    public String[] l1;
    public String[] l2;

    public Name() throws IOException, FileNotFoundException {
        int i;
        System.out.println("Loading weapon names library...\n");
        BufferedReader name1 = new BufferedReader(new FileReader("w_1.txt"));
        w1 = new String[15];
        BufferedReader name2 = new BufferedReader(new FileReader("w_2.txt"));
        w2 = new String[8];
        BufferedReader name3 = new BufferedReader(new FileReader("w_3.txt"));
        w3 = new String[6];
        BufferedReader name4 = new BufferedReader(new FileReader("w_4.txt"));
        w4 = new String[10];
        BufferedReader namee = new BufferedReader(new FileReader("w_e.txt"));
        we = new String[6];

        for (i = 0; i < 15; i++)
            w1[i] = name1.readLine();

        for (i = 0; i < 8; i++)
            w2[i] = name2.readLine();

        for (i = 0; i < 6; i++)
            w3[i] = name3.readLine();

        for (i = 0; i < 10; i++)
            w4[i] = name4.readLine();

        for (i = 0; i < 6; i++)
            we[i] = namee.readLine();

        spec = new String[5];
        spec[0] = "fire";
        spec[1] = "ice";
        spec[2] = "lightning";
        spec[3] = "wind";
        spec[4] = "damnation";

        System.out.println("Loading shield names library...\n");
        name1 = new BufferedReader(new FileReader("s_1.txt"));
        s1 = new String[9];
        name2 = new BufferedReader(new FileReader("s_2.txt"));
        s2 = new String[7];
        name3 = new BufferedReader(new FileReader("s_3.txt"));
        s3 = new String[4];
        name4 = new BufferedReader(new FileReader("s_4.txt"));
        s4 = new String[7];
        namee = new BufferedReader(new FileReader("s_e.txt"));
        se = new String[5];

        for (i = 0; i < 9; i++)
            s1[i] = name1.readLine();

        for (i = 0; i < 7; i++)
            s2[i] = name2.readLine();

        for (i = 0; i < 4; i++)
            s3[i] = name3.readLine();

        for (i = 0; i < 7; i++)
            s4[i] = name4.readLine();

        for (i = 0; i < 5; i++)
            se[i] = namee.readLine();


        System.out.println("Loading amulet names library...\n");
        name1 = new BufferedReader(new FileReader("a_1.txt"));
        a1 = new String[10];
        name2 = new BufferedReader(new FileReader("a_2.txt"));
        a2 = new String[4];
        name3 = new BufferedReader(new FileReader("a_3.txt"));
        a3 = new String[18];
        namee = new BufferedReader(new FileReader("a_e.txt"));
        ae = new String[11];

        for (i = 0; i < 10; i++)
            a1[i] = name1.readLine();

        for (i = 0; i < 4; i++)
            a2[i] = name2.readLine();

        for (i = 0; i < 18; i++)
            a3[i] = name3.readLine();

        for (i = 0; i < 11; i++)
            ae[i] = namee.readLine();


        System.out.println("Loading staff names library...\n");
        name1 = new BufferedReader(new FileReader("l_1.txt"));
        l1 = new String[11];
        name2 = new BufferedReader(new FileReader("l_2.txt"));
        l2 = new String[17];

        for (i = 0; i < 11; i++)
            l1[i] = name1.readLine();

        for (i = 0; i < 17; i++)
            l2[i] = name2.readLine();
    }
}