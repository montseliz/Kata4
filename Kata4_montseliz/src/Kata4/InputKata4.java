package Kata4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputKata4 {
	
	static Scanner sc = new Scanner(System.in); 
	
    public static String inputString(String message){
        String input = "";
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextLine();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("ERROR. Input type requires length > 1.\n");
            }
        } while(!correct);
        return input;
    }

}
