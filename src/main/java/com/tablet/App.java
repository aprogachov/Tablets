package com.tablet;

import com.tablet.reader.MenuMain;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
   
    public static void main(String[] args) {                          

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(MenuMain.class).menu();

    context.close();
    }
    
}
