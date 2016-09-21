package app;

import java.util.Scanner;

/**
 * Created by Erik on 20-9-2016.
 */
public class InputReader {

    private Scanner reader;

    public InputReader(){
        this.reader = new Scanner(System.in);  // Reading from System.in
    }

    public String readInput(){
        return this.reader.next(); // Get what the user types.
    }

}

