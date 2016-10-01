package app;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Erik on 19-9-2016.
 */
@NoArgsConstructor
@Data
public abstract class User {

    protected int id;
    protected String code;

    public User(String code){
        this.code = code;
    }
}
