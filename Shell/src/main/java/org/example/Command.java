package org.example;

public interface Command {
    public String getName();
    public  void exec(String... args);
}
