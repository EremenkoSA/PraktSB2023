package Task1;

import java.time.LocalDate;

public class Date implements Command {

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String getHelp() {
        return "Выводит или устанавливает текущую дату";
    }

    @Override
    public void exec(String... args) {
        if (args.length < 2) {
            System.out.println("Текущая дата: " + (LocalDate.now()));
        } else if (args.length > 2) {
            System.out.println("не является внутренней или внешней командой");
        } else if (args[1].equals  ("-h")){
            System.out.println(getHelp());
        } else {
            System.out.println("не является внутренней или внешней командой");
        }
    }
}