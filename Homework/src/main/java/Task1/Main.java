package Task1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Command> ComList = new HashMap<>();


    public static void main(String[] args) {

        Command quit = new Quit();
        ComList.put(quit.getName(), quit);

        Command time = new Time();
        ComList.put(time.getName(), time);

        Command date = new Date();
        ComList.put(date.getName(), date);


        while (true) {
            System.out.print(">");
            Scanner s = new Scanner(System.in);
            String string = s.nextLine();
            String[] words = string.split("\\s+");
            if (ComList.containsKey(words[0])) {
                ComList.get(words[0]).exec(words);
            } else {
                System.out.println("не является внутренней или внешней командой");
            }
        }
    }
}