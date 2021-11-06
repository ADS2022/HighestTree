import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Helloooooooooooooooooooooo World!");



        // User selects View or Edit mode
        Boolean userLoop = true;
        Boolean editMode = false;
        int view = 1;
        int edit = 2;

        while (userLoop){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a mode:");
            System.out.println("View (" + view + ") | Edit (" + edit + ")");

            // Retrieve the user's input
            // DEFECT : if input not in [0-9] interval, there is an error
            int input = scanner.nextInt();
            try {
                if ( true ) {
                    if (input == view ){
                        System.out.println("You have selected " + view);
                        userLoop = false;
                    } else if ( input == edit ){
                        System.out.println("You have selected " + edit);
                        editMode = true;
                        userLoop = false;
                    }
                } else {
                    System.out.println("ONE or TWO!!! ٩(º_º)۶");
                }
            } catch (InputMismatchException e){
                System.out.println("ONE or TWO!!! ٩(º_º)۶ !!! No characters allowed !!!");
            }

        }//userLoop = 0


    }
}