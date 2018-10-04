package server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;
import server.reader.*;

public class App {
   
    public static void main(String[] args) {                          

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(MenuMain.class).menu();

    context.close();
    }
    
}
