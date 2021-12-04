package com.company;
//You need to print out the file. Good variable names. Pretty clean.
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static String WritingToFile() throws IOException {
        String bookTitle = getInput("Enter your book's name");
        int ISBN = Integer.parseInt(getInput("ISBN"));
        String Author = getInput("Enter your Author's name");
        String genre = getInput("Enter your genre type");
        String info = (bookTitle + "," + ISBN + "," + Author + "," + genre);
        FileWriter writer = new FileWriter("bookList.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        writer.write(info);
        writer.write("\n");
        writer.close();
        return info;
    }

    public static String ReadingFromFile() throws IOException {
        String data = null;
        try {
            File myObj = new File("bookList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    public static String searchingFile() throws IOException {
        Scanner in = null;
        try {
            String userSearch = getInput("Enter your search");
            File file = new File("bookList.txt");
            in = new Scanner(file);
            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.contains(userSearch))
                    System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }









    public static void main (String[]args) throws IOException {

            //CreateFile();
            //WritingToFile();
            //ReadingFromFile();
            //searchingFile();

        }
    }






