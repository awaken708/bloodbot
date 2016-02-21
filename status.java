/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbot;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.util.Random;
public class status {
    
    public int get_status() throws AWTException{
    Robot rob = new Robot();
    BufferedImage sc = rob.createScreenCapture(new Rectangle(0, 0, 800, 1000));
        int r = 0;
        int g = 0;
        int b = 0;
        int k = 0;
        for (int x = 300; x <= 425; x++) {
            for (int y = 710; y <= 775; y++) {
                int color = sc.getRGB(x, y);
                r = r + ((color >> 16) & 0xff);
                g = g + ((color >> 8) & 0xff);
                b = b + (color & 0xff);
                k++;
            }
        }
        r = r / k;
        g = g / k;
        b = b / k;
        if ((Math.abs(r - 218) < 10) && (Math.abs(g - 161) < 10) && (Math.abs(b - 18) < 10)) {
            return 1;
        }
        
        r = 0;
        g = 0;
        b = 0;
        k = 0;
        for (int x = 520; x <= 560; x++) {
            for (int y = 310; y <= 350; y++) {
                int color = sc.getRGB(x, y);
                r = r + ((color >> 16) & 0xff);
                g = g + ((color >> 8) & 0xff);
                b = b + (color & 0xff);
                k++;
            }
        }
        r = r / k;
        g = g / k;
        b = b / k;
        if ((Math.abs(r - 195) < 25) && (Math.abs(g - 155) < 25) && (Math.abs(b - 15) < 10)) {
            return 2;
        }
    //System.out.println(r+" "+g+" "+b);
    return 0;
    }
    
    public boolean update_status(int stat) throws AWTException{
        if(stat == 1){
            Robot r = new Robot();
            Random rand = new Random();
            r.mouseMove(300 + rand.nextInt(100), 710+rand.nextInt(50));
            r.delay(20);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.delay(20);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            r.delay(20);
            r.mouseMove(1195, 70);
            r.delay(3000);
            return true;
        }
        
        if(stat == 2){
            Robot r = new Robot();
            Random rand = new Random();
            r.mouseMove(530 + rand.nextInt(20), 320+rand.nextInt(20));
            r.delay(20);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.delay(20);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            r.delay(20);
            r.mouseMove(1195, 70);
            r.delay(3000);
            return true;
        }
        
        
        return false;
    }
}
