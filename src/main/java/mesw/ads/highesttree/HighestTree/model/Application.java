package mesw.ads.highesttree.HighestTree.model;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    private static final int VIEW_MODE = 1;
    private static final int EDIT_MODE = 2;

    public static void main(String[] args) {
        System.out.println("Application loading up");

        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Select a mode:");
            System.out.println("View (" + VIEW_MODE + ") | Edit (" + EDIT_MODE + ") | 0 to exit");
            choice = input.nextInt();
            try {
                switch (choice) {
                    case 0 -> {
                        System.out.println("Exiting Program...");
                        System.exit(0);
                    }
                    case 1 ->
                            // do something
                            System.out.println("You have selected " + VIEW_MODE);
                    case 2 ->
                            // ..something else
                            System.out.println("You have selected " + EDIT_MODE);
                    default -> System.out.println("ONE or TWO!!! ٩(º_º)۶");
                }
            } catch (InputMismatchException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.println("ONE or TWO!!! ٩(º_º)۶ !!! No characters allowed !!!");
            }
        }

    }
}