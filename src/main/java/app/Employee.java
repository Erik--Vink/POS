package app;

import lombok.NoArgsConstructor;

/**
 * Created by Erik on 19-9-2016.
 */
@NoArgsConstructor
public class Employee extends User {
    public Employee(String code) {
        super(code);
    }

    public static boolean matches(String code){
        //todo replace with DB connection

        if(code.equals("112")){
            return true;
        }
        else{
            return false;
        }
    }
}
