package app;

/**
 * Created by Erik on 20-9-2016.
 */
public enum ProductType {
    SINGLE, COMBINATION;

    public String toString() {
        switch(this) {
            case SINGLE: return "single";
            case COMBINATION: return "combination";
            default: return "Unspecifed";
        }
    }

    public static ProductType fromString(String string) {
        if(string.equals("single")){return SINGLE;}
        else if(string.equals("combination")){return COMBINATION;}
        else return null;
    }
}
