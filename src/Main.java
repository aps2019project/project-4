import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        while (true) {
            commandLine.setCommand(scanner.nextLine());

        }
    }
}
