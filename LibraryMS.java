package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryMS
{
    private static int MAX_BOOKS = 100;

    private int bookCount = 0;
    Scanner sc = new Scanner(System.in);

    String[] bookTitle = new String[MAX_BOOKS];
    String[] bookAuthor = new String[MAX_BOOKS];
    String searchBook;

    public static void main(String[] args) {
        LibraryMS lb = new LibraryMS();
        lb.run();
    }
    public void run() {
        while (true) {
            System.out.println("-----The Library Management System----- ");
            System.out.println("1. Add a New Book");
            System.out.println("2. Search for a Book by Title");
            System.out.println("3. Display All Books");
            System.out.println("4. Remove a Book by Title");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int chooseNo = sc.nextInt();

            switch (chooseNo) {
                case 1:
                    if (bookCount == MAX_BOOKS)
                    {
                        System.out.println("Library is full.can't add more books.");
                        return;
                    }
                    System.out.print("Enter the book title: ");
                    String title = sc.next();
                    System.out.print("Enter the book author: ");
                    String author = sc.next();

                    bookTitle[bookCount]=title;
                    bookAuthor[bookCount]=author;
                    bookCount++;
                    System.out.println("Book added successfully");
//                    System.out.println(bookCount);
                    break;
                case 2:
                    System.out.print("Enter the title to search book: ");
                    searchBook = sc.next();

                    for (int i = 0; i < bookCount; i++)
                    {
                        if (bookTitle[i].equalsIgnoreCase(searchBook))
                        {
                            System.out.println("Book Found:");
                            System.out.println("Title: "+bookTitle[i]);
                            System.out.println("Author: "+bookAuthor[i]);
                            run();
                            return;
                        }
                    }
                    System.out.println("Book not found.");
                    break;
                case 3:
                    if (bookCount == 0)
                    {
                        System.out.println("No books in the library");
                        run();
                        return;
                    }
                    System.out.println("Books in the library");
                    for (int i = 0; i < bookCount; i++)
                    {
                        System.out.println("Title: "+bookTitle[i]+","+"\t"+"Author:"+bookAuthor[i]);
                    }
                    run();
                    break;
                case 4:
                    if (bookCount == 0)
                    {
                        System.out.println("Library is Empty..");
                        return;
                    }
                    System.out.print("Enter the book title to remove: ");
                    String remove = sc.next();

                    for (int i = 0; i < bookCount; i++) {
                        if (bookTitle[i].equalsIgnoreCase(remove))
                        {
                            for (int j = i; j < bookCount - 1; j++)
                            {
                                bookTitle[j] = bookTitle[j + 1];
                                bookAuthor[j] = bookAuthor[j + 1];
                            }
                            bookCount--;
                            System.out.println("Book removed successfully.");
                            return;
                        }
                    }
                    System.out.println("Book not found.");
                    break;
                case 5:
                    System.out.println("Exiting System...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
