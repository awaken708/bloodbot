package bloodbot;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Point;
import java.lang.Math;
import java.io.File;
import java.awt.Rectangle;
import java.util.Random;
import javax.imageio.ImageIO;

public class bot {

    public int get_tupe(BufferedImage sc, int x, int y) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = -30; i <= 30; i++) {
            for (int j = -30; j <= 30; j++) {
                int color = sc.getRGB(x + i, y + j);
                r = r + ((color >> 16) & 0xff);
                g = g + ((color >> 8) & 0xff);
                b = b + (color & 0xff);
            }
        }
        r = r / 3721;
        g = g / 3721;
        b = b / 3721;

        if ((Math.abs(r - 58) < 15) && (Math.abs(g - 58) < 15) && (Math.abs(b - 58) < 15)) {
            return 0;
        }
        if ((Math.abs(r - 101) < 15) && (Math.abs(g - 81) < 15) && (Math.abs(b - 46) < 15)) {
            return 0;
        }
        if ((Math.abs(r - 152) < 15) && (Math.abs(g - 173) < 15) && (Math.abs(b - 184) < 15)) {
            return 1;
        }
        if ((Math.abs(r - 73) < 15) && (Math.abs(g - 175) < 15) && (Math.abs(b - 184) < 15)) {
            return 2;
        }
        if ((Math.abs(r - 97) < 15) && (Math.abs(g - 83) < 15) && (Math.abs(b - 171) < 15)) {
            return 3;
        }
        if ((Math.abs(r - 175) < 15) && (Math.abs(g - 170) < 15) && (Math.abs(b - 128) < 15)) {
            return 4;
        }
        if ((Math.abs(r - 128) < 15) && (Math.abs(g - 136) < 15) && (Math.abs(b - 70) < 15)) {
            return 5;
        }
        if ((Math.abs(r - 180) < 15) && (Math.abs(g - 97) < 15) && (Math.abs(b - 162) < 15)) {
            return 6;
        }
        if ((Math.abs(r - 200) < 15) && (Math.abs(g - 144) < 15) && (Math.abs(b - 49) < 15)) {
            return 7;
        }
        if ((Math.abs(r - 69) < 15) && (Math.abs(g - 140) < 15) && (Math.abs(b - 94) < 15)) {
            return 8;
        }
        if ((Math.abs(r - 74) < 15) && (Math.abs(g - 134) < 15) && (Math.abs(b - 168) < 15)) {
            return 9;
        }
        if ((Math.abs(r - 186) < 15) && (Math.abs(g - 166) < 15) && (Math.abs(b - 58) < 15)) {
            return 10;
        }
        if ((Math.abs(r - 121) < 15) && (Math.abs(g - 111) < 15) && (Math.abs(b - 55) < 15)) {
            return 11;
        }
        if ((Math.abs(r - 128) < 15) && (Math.abs(g - 40) < 15) && (Math.abs(b - 161) < 15)) {
            return 12;
        }
        if ((Math.abs(r - 162) < 15) && (Math.abs(g - 101) < 15) && (Math.abs(b - 53) < 15)) {
            return 13;
        }
        System.out.println(r+" "+g+" "+b+"     ");
        return 404;
    }

    public int num_del(int[][] map) {
        int N = 0;
        int[][] temp_map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                temp_map[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (temp_map[i][j] != 0) {
                    int kx = 0, dx = 0;
                    int color = temp_map[i][j];
                    for (int i1 = i + 1; i1 < 7; i1++) {
                        if (temp_map[i1][j] == color) {
                            kx++;
                        } else {
                            break;
                        }
                    }
                    for (int i1 = i - 1; i1 >= 0; i1--) {
                        if (temp_map[i1][j] == color) {
                            dx++;
                        } else {
                            break;
                        }
                    }
                    if ((kx + dx + 1) >= 3) {
                        N = N + kx + dx;
                        for (int i1 = i + 1; i1 < 7; i1++) {
                            if (temp_map[i1][j] == color) {
                                temp_map[i1][j] = 0;
                            } else {
                                break;
                            }
                        }
                        for (int i1 = i - 1; i1 >= 0; i1--) {
                            if (temp_map[i1][j] == color) {
                                temp_map[i1][j] = 0;
                            } else {
                                break;
                            }
                        }
                    }
                    int ky = 0, dy = 0;
                    for (int j1 = j + 1; j1 < 7; j1++) {
                        if (temp_map[i][j1] == color) {
                            ky++;
                        } else {
                            break;
                        }
                    }
                    for (int j1 = j - 1; j1 >= 0; j1--) {
                        if (temp_map[i][j1] == color) {
                            dy++;
                        } else {
                            break;
                        }
                    }
                    if ((ky + dy + 1) >= 3) {
                        N = N + ky + dy;
                        for (int j1 = i + 1; j1 < 7; j1++) {
                            if (temp_map[i][j1] == color) {
                                temp_map[i][j1] = 0;
                            } else {
                                break;
                            }
                        }
                        for (int j1 = i - 1; j1 >= 0; j1--) {
                            if (temp_map[i][j1] == color) {
                                temp_map[i][j1] = 0;
                            } else {
                                break;
                            }
                        }
                    }
                    if (((kx + dx + 1) >= 3) | ((ky + dy + 1) >= 3)) {
                        temp_map[i][j] = 0;
                    }
                }

            }
        }
        return N;
    }

    private void swap(int[][] map, int i, int j, int i1, int j1) {
        int temp = map[i1][j1];
        map[i1][j1] = map[i][j];
        map[i][j] = temp;
    }

    public int one_turn() throws AWTException {
        Robot r = new Robot();
        int h = 90;
        int dx = 80;
        int dy = 400;
        //Thread.sleep(3000);
        BufferedImage sc = r.createScreenCapture(new Rectangle(0, 0, 800, 1000));
        int[][] map = new int[7][7];
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 7; i++) {
                map[i][j] = get_tupe(sc, i * h + dx, j * h + dy);
                if (map[i][j] == 404) {
                    //System.out.println("404");
                    return 404;
                }
                //System.out.print( map[i][j] + " ");
            }
            //System.out.println();
        }

        int i1 = 0, i2 = 0, j1 = 0, j2 = 0, max = 0;

        for (int i = 0; i < 6; i++) { //верхняя строка
            int j = 0;
            if (map[i][j] != 0) {
                if (map[i + 1][j] != 0) {
                    swap(map, i, j, i + 1, j);
                    if (num_del(map) > max) {
                        max = num_del(map);
                        i1 = i;
                        i2 = i + 1;
                        j1 = j;
                        j2 = j;
                    }
                    swap(map, i, j, i + 1, j);
                }
            }
        }

        for (int i = 0; i < 6; i++) { //нижняя строка
            int j = 6;
            if (map[i][j] != 0) {
                if (map[i + 1][j] != 0) {
                    swap(map, i, j, i + 1, j);
                    if (num_del(map) > max) {
                        max = num_del(map);
                        i1 = i;
                        i2 = i + 1;
                        j1 = j;
                        j2 = j;
                    }
                    swap(map, i, j, i + 1, j);
                }
            }
        }
        
        for (int j = 0; j < 6; j++) { //левая строка
            int i = 0;
            if (map[i][j] != 0) {
                if (map[i][j+1] != 0) {
                    swap(map, i, j, i, j + 1);
                    if (num_del(map) > max) {
                        max = num_del(map);
                        i1 = i;
                        i2 = i;
                        j1 = j;
                        j2 = j + 1;
                    }
                    swap(map, i, j, i, j + 1);
                }
            }
        }

        for (int j = 0; j < 6; j++) { //правая строка
            int i = 6;
            if (map[i][j] != 0) {
                if (map[i][j+1] != 0) {
                    swap(map, i, j, i, j + 1);
                    if (num_del(map) > max) {
                        max = num_del(map);
                        i1 = i;
                        i2 = i;
                        j1 = j;
                        j2 = j + 1;
                    }
                    swap(map, i, j, i, j + 1);
                }
            }
        }
        
        
        

        for (int i = 1; i < 6; i++) {  //все остальное
            for (int j = 1; j < 6; j++) {
                if (map[i][j] != 0) {
                    if (map[i + 1][j] != 0) {
                        swap(map, i, j, i + 1, j);
                        if (num_del(map) > max) {
                            max = num_del(map);
                            i1 = i;
                            i2 = i + 1;
                            j1 = j;
                            j2 = j;
                        }
                        swap(map, i, j, i + 1, j);
                    }

                    if (map[i - 1][j] != 0) {
                        swap(map, i, j, i - 1, j);
                        if (num_del(map) > max) {
                            max = num_del(map);
                            i1 = i;
                            i2 = i - 1;
                            j1 = j;
                            j2 = j;
                        }
                        swap(map, i, j, i - 1, j);
                    }

                    if (map[i][j + 1] != 0) {
                        swap(map, i, j, i, j + 1);
                        if (num_del(map) > max) {
                            max = num_del(map);
                            i1 = i;
                            i2 = i;
                            j1 = j;
                            j2 = j + 1;
                        }
                        swap(map, i, j, i, j + 1);
                    }

                    if (map[i][j - 1] != 0) {
                        swap(map, i, j, i, j - 1);
                        if (num_del(map) > max) {
                            max = num_del(map);
                            i1 = i;
                            i2 = i;
                            j1 = j;
                            j2 = j - 1;
                        }
                        swap(map, i, j, i, j - 1);
                    }
                }
            }
        }
        if (max > 0) {
            r.mouseMove(i1 * h + dx, j1 * h + dy);
            r.delay(20);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.delay(40);
            //System.out.println(max);

            /* int temp = i1;
             i1 = j1;
             j1 = temp;
           
             temp = i2;
             i2 = j2;
             j2 = temp;*/
            //System.out.println(i1 + " " + j1 + " " + i2 + " " + j2);

            if (i1 > i2) { //вправо
                for (int i = 0; i < 90; i++) {
                    r.mouseMove(i1 * h + dx - i, j1 * h + dy);
                    r.delay(2);
                }
            }

            if (i1 < i2) { //влево
                for (int i = 0; i < 90; i++) {
                    r.mouseMove(i2 * h + dx - i, j1 * h + dy);
                    r.delay(2);
                }
            }

            if (j1 > j2) { //вниз
                for (int i = 0; i < 90; i++) {
                    r.mouseMove(i1 * h + dx, j1 * h + dy - i);
                    r.delay(2);
                }
            }

            if (j1 < j2) { //вверх
                for (int i = 0; i < 90; i++) {
                    r.mouseMove(i1 * h + dx, j2 * h + dy - i);
                    r.delay(2);
                }
            }
            r.delay(20);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            r.delay(20);
            r.mouseMove(1195, 70);
            return 1;
        } else {
            return -1;
        }

    }

}
