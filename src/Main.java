
import controller.Controller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long ss = System.currentTimeMillis();
        Controller.start();
        System.out.println((System.currentTimeMillis() - ss)/1000);
        Date date = new Date((System.currentTimeMillis() - ss)*1000);
    }
}
