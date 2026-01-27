package com.trainee.controller;

import java.util.Scanner;

import com.trainee.dto.Trainee;
import com.trainee.service.TraineeService;

public class TraineeController {

    public static void main(String[] args) {

        TraineeService service = new TraineeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Trainee");
            System.out.println("2. Find Trainee by ID");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Trainee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Branch: ");
                String branch = sc.nextLine();

                System.out.print("Enter Percentage: ");
                double percentage = sc.nextDouble();

                Trainee t = new Trainee(0, name, branch, percentage);

                try {
                    service.addTrainee(t);
                    System.out.println("Trainee added");
                } catch (Exception e) {
                    System.out.println("Some problem while adding trainee");
                }

            } else if (choice == 2) {

                System.out.print("Enter Trainee ID: ");
                int id = sc.nextInt();

                try {
                    Trainee t = service.findTraineeById(id);
                    if (t != null)
                        System.out.println(t);
                    else
                        System.out.println("No trainee found");
                } catch (Exception e) {
                    System.out.println("Error while fetching trainee");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Wrong option");
            }
        }
        sc.close();
    }
}
