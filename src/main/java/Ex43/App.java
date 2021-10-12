/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Newton
 */
package Ex43;
import java.io.*;
import java.util.Scanner;
public class App
{
    public static void main(String[] args)
    {
        // vars to store intermediate and required data
        // creating scanner object
        Scanner scnr = new Scanner(System.in);
        String currentPath, author, siteName;
        char javaScript = 'X';
        char css = 'X';

        // ask to enter website name
        System.out.print("Site name: ");
        siteName = scnr.nextLine();

        // ask to enter author name
        System.out.print("Author: ");
        author = scnr.nextLine();

        // ask for JavaScript folder or not
        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scnr.next().charAt(0);

        // ask for CSS folder or not
        System.out.print("Do you want a folder for CSS? ");
        css = scnr.next().charAt(0);

        // get directory for website folder in current directory
        currentPath = System.getProperty("user.dir");

        // append site name to path of directory
        currentPath += "\\" + siteName;

        // create file object
        File website = new File(currentPath);

        // make directory/folder for siteName
        boolean websiteCreated = website.mkdir();

        // if website folder to not exist then it gets created and if it is created then
        // create its sub folders and files
        if (websiteCreated)
        {
            System.out.println("Created " + currentPath);

            // use try-catch to handle the exception for index.html files and problems
            try
            {
                // create FileWriter
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+"\\index.html"));
                // write required data to the file
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                // close FileWriter
                skeletonWriter.close();

                // print the created message
                System.out.println("Created " + currentPath+"\\index.html");

                // check for JavaScript folder or not
                if (javaScript == 'y' || javaScript == 'Y')
                {
                    // if the user wants then create folder using the mkdir() method
                    File javaScriptFolder = new File(currentPath+"\\js");

                    boolean javaScriptCreated = javaScriptFolder.mkdir();

                    // if JavaScript folder created then printing the success message
                    // else printing not created
                    if (javaScriptCreated)
                        System.out.println("Created " + javaScriptFolder +"\\");
                    else
                        System.out.println("Js folder not created!!");
                }
                // checking if the user wants a CSS folder or not
                if (css == 'y' || css == 'Y')
                {
                    // if the user wants then creating a folder using the mkdir() method of the File class
                    File cssFolder = new File(currentPath + "\\css");

                    boolean cssCreated = cssFolder.mkdir();

                    // if CSS folder created then printing the success message
                    // else printing not created
                    if (cssCreated)
                        System.out.println("Created " + cssFolder + "\\");
                    else
                        System.out.println("CSS folder not created!!");
                }
            }
            // handle exception
            catch (IOException e)
            {
                System.out.println("index.html was not created you idiot!!!!!!");
            }
        }
        // if website exist or cannot be created due to any other errors then printing
        // not created message
        else
            System.out.println("Website folder not created!!");
        // close Scanner
        scnr.close();
    }
}
