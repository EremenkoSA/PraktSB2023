package org.example;

import java.time.LocalTime;

public class Quit implements Command{

    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public void exec(String... args) {
        if (args == null) {
            System.exit(0);
        }
        else{
            System.out.println("Выход из командной строки");
        }
    }
}
