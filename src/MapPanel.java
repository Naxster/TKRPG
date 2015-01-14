import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Naxster on 2015-01-12.
 */
public class MapPanel extends JPanel {
    public int[][] textMap;
    public Image[][] map;
    public Image iksu;
    public int playerX;
    public int playerY;
    private int imageWidth;
    private int imageHeight;

    public MapPanel(int[][] tmap) {
        this.textMap = tmap;
        this.playerX = 14;
        this.playerY = 1;
        generateMap();
        imageWidth = map[0][0].getWidth(this);
        imageHeight = map[0][0].getHeight(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int y = 0; y < 35; y++) {
            for (int x = 0; x < 30; x++) {
                g.drawImage(map[x][y], x * imageWidth, (34 - y) * imageHeight, null);
                Image tmp = getThingoOnPos(x,y);
                if(tmp != null)
                    g.drawImage(tmp, x * imageWidth, (34 - y) * imageHeight, null);
            }
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("ikony/extra/player.png"));
        } catch (IOException e) {
        }
        g.drawImage(img, playerX * imageWidth, (34 - playerY) * imageHeight, null);
    }

    private void generateMap() {
        map = new Image[30][35];
        for (int y = 0; y < 35; y++)
            for (int x = 0; x < 30; x++)
                map[x][y] = getMapElemeOnPos(x, y);
    }

    private Image getThingoOnPos(int x, int y) {
        String adres = "ikony/extra/";
        int numer = y * 30 + x;
        switch (textMap[numer][1]) {
            case 3:
                if (textMap[numer][0] == 0)
                    adres += "skarb.png";
                else
                    adres += "skarb_otw.png";
                break;
            case 4:
                adres += "quest.png";
                break;
            case 5:
                adres += "shop.png";
                break;
            case 6:
                adres += "boss.png";
                break;
            default:
                return null;
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(adres));
        } catch (IOException e) {
        }
        return img;
    }

    private Image getMapElemeOnPos(int x, int y) {
        String adres = "ikony/";
        int numer = y * 30 + x;
        switch (textMap[numer][4]) {
            case 0:
                if (textMap[numer][1] == 1)
                    adres += "w_s_0_1.png";
                else
                    adres += "w_n_0_0.png";
                break;
            case 1:
                if (textMap[numer][1] == 1)
                    adres += "j_s_1_1.png";
                else
                    adres += "j_n_1_0.png";
                break;
            case 2:
                if (textMap[numer][1] == 1)
                    adres += "s_s_2_1.png";
                else
                    adres += "s_n_2_0.png";
                break;
            case 3:
                if (textMap[numer][1] == 1)
                    adres += "l_s_3_1.png";
                else
                    adres += "l_n_3_0.png";
                break;
            case 4:
                if (textMap[numer][1] == 1)
                    adres += "r_s_4_1.png";
                else
                    adres += "r_n_4_0.png";
                break;
            case 5:
                if (textMap[numer][1] == 1)
                    adres += "b_s_5_1.png";
                else
                    adres += "b_n_5_0.png";
                break;
            case 6:
                if (textMap[numer][1] == 1)
                    adres += "boss_s_6_1.png";
                else
                    adres += "boss_n_6_0.png";
                break;
            case 7:
                if (textMap[numer][1] == 1)
                    adres += "l_s_7_1.png";
                else
                    adres += "w_n_0_0.png";
                break;
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(adres));
        } catch (IOException e) {
        }
        return img;
    }
}
