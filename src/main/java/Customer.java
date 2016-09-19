/**
 * Created by Erik on 19-9-2016.
 */
public class Customer extends User {
    private Card card;

    public Customer(String code, Card card) {
        super(code);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
