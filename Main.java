import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    static ArrayList<String> historyCheck = new ArrayList<>();
    static String currentDirectory = System.getProperty("user.dir");
    public static void main (String args[])
    {
        /* Create a Scanner object to read in command line */
        Scanner getCommandLine = new Scanner(System.in);

        /* String to store command line input */
        String commandLine;
        boolean grepInd = false;
        boolean grepNum = false;


        /* Flag to allow looping for additional command lines */
        boolean loopFlag = true;
        String [] identifier;
        String [] grep;
        String searcher;
        String[] searchFind = null;

        boolean grepCheck = false;


        /* Loop through commands on command line */



        while(loopFlag == true) {
            String com1 = null;
            String com2 = null;
            String com3 = null;
            String com4 = null;
            /* Display Shell cursor */
            System.out.print("\nmyShell> ");

            /* Get new command line input */
            commandLine = getCommandLine.nextLine();
            historyCheck.add(commandLine);


            if(commandLine.equals("exit")) {
                System.out.println("myShell> Exit command found. myShell closing.\n");
                System.exit(0);
            }
            if (commandLine.startsWith("cat")){

                identifier = commandLine.split(" ");
                grep = commandLine.split("\\|");
                if (grep.length == 3){
                    grepNum = true;
                }

                if (grep.length>1){
                    searcher = grep[1];
                    searchFind = searcher.split(" ");
                    grepInd =true;

                }


                com1 = identifier[0];

                if (identifier.length > 1  && com1.equals("cat")) {
                    com2 = identifier[1];
                    String [] selection = com2.split("\\|");
                    String decider = selection[0];
                    if (grepInd == false) {
                        ReadTextFile.main(decider);
                    }
                }
                if (identifier.length > 2  && com1.equals("cat")) {
                    com3 = identifier[2];
                    if (grepInd == false) {
                        String selection = com3;
                        ReadTextFile.main(selection);

                    }


                }
                if (identifier.length > 3  && com1.equals("cat")) {


                }


                if (searchFind!=null){
                    String val = searchFind[1];
                    SearchWord.main(com2,val);

                }

            }
            if (commandLine.startsWith("history")) {
                printCommandHistory();
            }
            if (commandLine.startsWith("!")) {
                if (commandLine.endsWith(String.valueOf(2))){
                    selectiveExecution(2);
                }
                if (commandLine.endsWith(String.valueOf(3))){
                    selectiveExecution(3);
                }
                if (commandLine.endsWith(String.valueOf(4))){
                    selectiveExecution(4);
                }
                if (commandLine.endsWith(String.valueOf(5))){
                    selectiveExecution(5);
                }

            }
            if (commandLine.startsWith("pwd")) {
                printDirectory();
            }
            if (commandLine.startsWith("ls")) {
                filesindirectory();
            }
            if (commandLine.startsWith("cd")) {
                directorychange(commandLine);
            }
            if (commandLine.startsWith("exit")) {
                System.out.println("myShell> Exit command found. myShell closing.\n");
                System.exit(0);
            }

            grepInd = false;
        }}
    public static void printCommandHistory(){
        for (int i = 0; i < historyCheck.size(); i++) {
            System.out.println(i + ": " + historyCheck.get(i));
        }
    }
    public static void selectiveExecution(int val){
        System.out.println(historyCheck.get(val));

    }
    public static void printDirectory(){
        System.out.println(currentDirectory);
    }
    public static void filesindirectory(){
        File directory = new File(currentDirectory);
        String[] files = directory.list();
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
    public static void directorychange(String line){
        String[] tokens = line.split(" ");
        if (tokens.length != 2) {
            System.out.println("Usage: cd directory");
            return;
        }
        String targetDirectory = tokens[1];
        File newDir = new File(targetDirectory);
        if (newDir.isDirectory()) {
            currentDirectory = newDir.getAbsolutePath();
        } else {
            System.out.println("Directory not found: " + targetDirectory);
        }

    }
}



