package Task1;

public interface Command {
    public String getName();
    public String getHelp();
    public  void exec(String... args);
}
