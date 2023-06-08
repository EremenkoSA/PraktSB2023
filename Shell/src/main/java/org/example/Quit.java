package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
public class Quit implements Command{

    @Override
    public String getName() {
        return "quit";
    }
    @Override
    public String getHelp() {
        return "Выход из командной строки";
    }

    @Override
    public void exec(String... args) {
        if (args.length < 2) {
            System.exit(0);
        } else if (args.length > 2) {
            System.out.println("не является внутренней или внешней командой");
        } else if (args[1].equals  ("-h")){
            System.out.println(getHelp());
        } else {
            System.out.println("не является внутренней или внешней командой");
        }
    }
}
