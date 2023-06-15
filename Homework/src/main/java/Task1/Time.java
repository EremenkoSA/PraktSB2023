package Task1;

import java.time.LocalTime;

public class Time implements Command {

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getHelp() {
        return "Выводит или устанавливает системное время";
    }

    @Override
    public void exec(String... args) {
        if (args.length < 2) {
            System.out.println("Текущее время: " + (LocalTime.now()));
        } else if (args.length > 2) {
            System.out.println("не является внутренней или внешней командой");
        } else if (args[1].equals  ("-h")){
            System.out.println(getHelp());
        } else {
            System.out.println("не является внутренней или внешней командой");
        }
    }
}
