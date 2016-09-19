/**
 * Created by Erik on 19-9-2016.
 */
public class POS {
    public static void main(String[] args) {

        Employee john = new Employee("112");
        CashDesk desk1 = new CashDesk(1);

        Session currentSession = new Session(john, desk1);

        System.out.println(currentSession.getStartTimestamp());

        Inventory inventory = Inventory.getInventory();
        inventory.addProduct(new SingleProduct());

    }
}
