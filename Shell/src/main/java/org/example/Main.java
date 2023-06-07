package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {
    public  static HashMap<String, Command> ComList = new HashMap<>();


    public static void main(String[] args) {

        Command quit = new Quit();
        ComList.put(quit.getName(), quit);

        Command time = new Time();
        ComList.put(time.getName(), time);

        Command date = new Date();
        ComList.put(date.getName(), date);


        while (true){
            System.out.print(">");
            Scanner s = new Scanner(System.in);
            String string = s.nextLine();
            String[] words = string.split("\\s+");
            //if (words.length > 1) {
                //String args1 = string.substring(words[0].length()).trim();
                //args = args1.split("'");
            //}
            if (ComList.containsKey(words[0])) { //проверка на пустоту
                if (2 > words.length) {
                    ComList.get(words[0]).exec(null);  //команда без аргумента
                } else  if (2 < words.length) {
                    ErrorInfo(string); ////команда агрумент -h  ещё аргументы
                } else if (words[1].equals("-h")){
                    ComList.get((words[0])).exec(words[1]); //команда и агрумент -h
                }
                else {
                    ErrorInfo(string); //команда и агрумент не -h
                }
            }
            else {
                ErrorInfo(string); //отсутствие команды
            }
        }
    }
    public static  void  ErrorInfo(String arg){
        System.out.print("'");
        System.out.print(arg);
        System.out.print("'");
        System.out.println("не является внутренней или внешней командой");
        System.out.println("Список команд:");
        for (String command: ComList.keySet()){
            System.out.println(command);
        }
        System.out.println("Чтобы получить информацию о команде, напишите -h после команды.");
    }
}

