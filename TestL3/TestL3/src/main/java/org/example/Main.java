package org.example;

import org.example.data.bd.ClientRepositoryBdImpl;
import org.example.data.entities.Article;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.data.enums.Role;
import org.example.data.repositories.ClientRepositoryImpl;
import org.example.data.services.ArticleServiceImpl;
import org.example.data.services.ClientService;
import org.example.data.services.ClientServiceImpl;
import org.example.data.services.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

           // Crée une instance du repository
           
        ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();
        // ClientRepositoryBdImpl clientRepositoryBdImpl=new ClientRepositoryBdImpl();

        // Injecte le repository dans le service
        ClientService clientService = new ClientServiceImpl(
            clientRepository
            // clientRepositoryBdImpl
            );


        // ArticleServiceImpl articleServiceImpl = new ArticleServiceImpl();


        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1- Create client");
            System.out.println("2- List client");
            System.out.println("3- Find client by phone");
            System.out.println("4- Create USER");
            System.out.println("5-Create a user account with a Shopkeeper or Admin role");
            System.out.println("6-Disable/Enable a user account");
            System.out.println("7- Create article");
            System.out.println("8- List available articles");
            System.out.println("9- Update article stock");
            System.out.println("10- Archive settled debts");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    Client client = new Client();

                    System.out.println("Enter surname: ");
                    client.setSurname(scanner.nextLine());
                    System.out.println("Enter phone: ");
                    client.setPhone(scanner.nextLine());
                    System.out.println("Enter address: ");
                    client.setAddress(scanner.nextLine());

                    clientRepository.insert(client);
                }
                case 2 -> {
                    List<Client> listClients = clientService.findAll();
                    listClients.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Enter phone to search: ");
                    String phone = scanner.nextLine();
                    Client client = clientService.search(phone);
                    if (client != null) {
                        System.out.println("Client found: " + client);
                    } else {
                        System.out.println("Client not found.");
                    }
                }
            //     case 4 -> {
            //         User user = new User();

            //         System.out.println("Enter name: ");
            //         user.setName(scanner.nextLine());
            //         System.out.println("Enter surname: ");
            //         user.setSurname(scanner.nextLine());
            //         System.out.println("Enter login: ");
            //         user.setLogin(scanner.nextLine());
            //         System.out.println("Enter password: ");
            //         user.setPassword(scanner.nextLine());
            //         System.out.println("Enter phone to correspondant person: ");
            //         String phone = scanner.nextLine();
            //         Client client = clientServiceImpl.search(phone);
            //         if (client != null && client.getUser() == null) {
            //             user.setClient(client);
            //             client.setUser(user);
            //             userServiceImpl.create(user);
            //         } else {
            //             System.out.println("This person has a compte ");
            //         }
            //     }
            //     case 5 -> {
            //         User user = new User();
            //         System.out.println("Enter name: ");
            //         String name = scanner.nextLine();
            //         System.out.println("Enter surname: ");
            //         String surname = scanner.nextLine();
            //         System.out.println("Enter login: ");
            //         String login = scanner.nextLine();
            //         System.out.println("Enter password: ");
            //         String password = scanner.nextLine();

            //         System.out.println("Choose role (1 for Boutiquier, 2 for Admin): ");
            //         int roleChoice = scanner.nextInt();
            //         scanner.nextLine(); 

            //         Role role;
            //         if (roleChoice == 1) {
            //             role = Role.boutiquier;
            //         } else if (roleChoice == 2) {
            //             role = Role.admin;
            //         } else {
            //             System.out.println("Invalid role choice. Please enter 1 for Boutiquier or 2 for Admin.");
            //             return;
            //         }

            //         // user.setRole(role);
            //         userServiceImpl.create(user);
            //     }
            //     case 6 -> {
            //         System.out.println("Enter phone of the user to activate/deactivate: ");
            //         String phone = scanner.nextLine();
            //         Client client = clientServiceImpl.search(phone);

            //         if (client != null && client.getUser() != null) {
            //             User user = client.getUser(); 
            //             System.out.println("Do you want to (1) Disable or (2) Enable the user?");
            //             int actionChoice = scanner.nextInt();
            //             scanner.nextLine(); 
            //             if (actionChoice == 1) {
            //                 userServiceImpl.disableUser(user);
            //             } else if (actionChoice == 2) {
            //                 userServiceImpl.enableUser(user);
            //             } else {
            //                 System.out.println("Invalid choice.");
            //             }
            //         } else {
            //             System.out.println("This client doesn't exist or has no associated user account.");
            //         }
            //     }
            //     default -> System.out.println("Invalid choice. Please select a valid option.");
            //     case 7 -> {
            //         System.out.println("Enter article name: ");
            //         String name = scanner.nextLine();
            //         System.out.println("Enter article stock quantity: ");
            //         int qteStock = scanner.nextInt();
            //         Article article = new Article();
            //         article.setName(name);
            //         article.setQteStock(qteStock);
            //         articleServiceImpl.createArticle(article);
            //     }
            //     case 8 -> {
            //         List<Article> availableArticles = articleServiceImpl.findAvailableArticles();
            //         availableArticles.forEach(System.out::println);
            //     }
            //     case 9 -> {
            //         System.out.println("Enter article name to update: ");
            //         String name = scanner.nextLine();
            //         System.out.println("Enter new stock quantity: ");
            //         int newStock = scanner.nextInt();
            //         articleServiceImpl.updateArticleStock(name, newStock);
            //     }
            //     case 10 -> {
            //         System.out.println("Archiving debts is not implemented.");
            //     }
             }
        } while (choice != 12);

    }
}