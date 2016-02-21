package bloodbot;
import java.awt.AWTException;
public class Bloodbot {
    
    public static void main(String[] args) throws AWTException, InterruptedException{
        
        long t = System.currentTimeMillis();
        long dt = 0;
        status stat = new status();
        
        bot bb = new bot();
        while(dt<6){
            Thread.sleep(10);
            if(bb.one_turn()==1){
                t = System.currentTimeMillis();
            } else
                if(stat.update_status(stat.get_status())){
                    t = System.currentTimeMillis();
                }
            dt = System.currentTimeMillis() - t;
        }
             
}
}
