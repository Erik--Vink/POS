package app;

/**
 * Created by Erik on 20-9-2016.
 */
public enum TransactionType {
    SALE, RESERVATION, REFUND;

    public String toString() {
        switch(this) {
            case SALE: return "sale";
            case RESERVATION: return "reservation";
            case REFUND: return "refund";
            default: return "Unspecifed";
        }
    }

    public static TransactionType fromString(String string) {
        if(string.equals("sale")){return SALE;}
        else if(string.equals("reservation")){return RESERVATION;}
        else if(string.equals("refund")){return REFUND;}
        else return null;
    }
}
