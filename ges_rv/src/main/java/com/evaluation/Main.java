package com.evaluation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1- Create medecin");
            System.out.println("2- List medecin");
            System.out.println("3- Create rv");
            System.out.println("4- List rv");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
    }while( choice != 4);
}
}