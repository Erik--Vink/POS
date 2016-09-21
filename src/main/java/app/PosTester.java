package app;

/**
 * Created by Erik on 20-9-2016.
 */
public class PosTester {

    public static void main(String[] args) {

        PosService.fillInventory();

        Session currentSession;

        InputReader reader = new InputReader();

        while(true){
            System.out.println("Enter an employee code to log in.");
            if((currentSession = PosService.login(reader.readInput(), 1)) != null){
                break;
            }
            else{
                System.out.println("Invalid employee code.");
            }
        }

        while(currentSession != null){
            Transaction transaction = PosService.createTransaction();

            while(true){
                System.out.println("Which product do you want to add? Enter the digit code or press 'q' to finish the transaction or press 'Q' to sign out.");

                String input = reader.readInput();

                if(input.equals("Q")){
                    currentSession = null;
                    break;
                }
                else if(input.equals("q")){
                    PosService.finishTransaction(currentSession, transaction);
                    break;
                }
                else{
                    PosService.addProductToTransaction(transaction, input);
                }
            }
        }
    }

}
