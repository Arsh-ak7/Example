package com.company;

import java.util.Scanner;

public class Addition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String cmd = sc.nextLine();
            String[] parts = cmd.split(" ");
            if (parts[0].equals("add") || parts[0].equals("Add")) {
                if (parts.length < 2)
                    System.out.println("Error: No Numbers to Add!");
                else if (parts.length < 3)
                    System.out.println("Error: Add requires atleast 2 arguments!");
                else {
                    int sum = 0;
                    for (int i = 1; i < parts.length; i++) {
                        sum += Integer.parseInt(parts[i]);
                    }
                    System.out.println(sum);
                }
            }
            else if (parts[0].equals("Exit") || parts[0].equals("exit") || parts[0].equals("EXIT"))
                System.exit(0);
            else
                System.out.println("ENTER CORRECT COMMAND");
        }
    }
}
