package org.example;

import java.time.LocalDate;
import org.example.Command;
public class Date implements Command {

    @Override
    public String getName() {
        return "date";
    }
    @Override
    public void exec(String... args) {
        if (args == null) {
            System.out.println("Текущая дата: " + (LocalDate.now()));
        }
        else {
            System.out.println("Выводит или устанавливает текущую дату");
        }
    }
}