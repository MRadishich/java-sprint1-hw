package Main;

import CommandManager.CommandLineManager;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CommandLineManager commandLineManager = new CommandLineManager(in);
        commandLineManager.printMenuAndHandleCommandInfinity();
    }
}
