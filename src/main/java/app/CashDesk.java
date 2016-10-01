package app;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Erik on 19-9-2016.
 */
@NoArgsConstructor
@Data
public class CashDesk {
    private int id;
    private int number;

    public CashDesk(int number){
        this.number = number;
    }

    public static boolean matches(int number){
        if(number == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
