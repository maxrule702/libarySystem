package com.company;
//You need to print out the file. Good variable names. Pretty clean.
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    private static File bookfile = new File("bookList.txt");

    private static ArrayList<String> students = new ArrayList<>();

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void CreateFile() {
        try {
            if (bookfile.createNewFile()) {
                System.out.println("File created: " + bookfile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String WritingToFile() {
        String bookTitle = getInput("Enter your book's name");
        int ISBN = Integer.parseInt(getInput("ISBN"));
        String Author = getInput("Enter your Author's name");
        String genre = getInput("Enter your genre type");
        return (bookTitle + "," + ISBN +  "," + Author +  "," +  genre);
    }

    public static void printStudentEmails() {
        for (int i = 0; i < students.size(); i++) {
            String[] studentDetails = students.get(i).split(",");
            System.out.println(studentDetails[2]);
        }
    }

        public static void main (String[]args){
            students.add(WritingToFile());
        }
    }






