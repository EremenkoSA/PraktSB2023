package org.example;

import java.time.LocalTime;
import org.example.Command;
public class Time implements Command {

    @Override
    public String getName() {
        return "time";
    }
    @Override
    public void exec(String... args) {
        if (args == null) {
            System.out.println("Текущее время: " + (LocalTime.now()));
        }
        else {
            System.out.println("Выводит или устанавливает системное время");
        }
    }
}
