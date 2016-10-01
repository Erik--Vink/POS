package service;

import app.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sessions")
public class SessionResource {

    @POST @Produces(MediaType.APPLICATION_JSON)
    public Session createSession(@FormParam("employee") String employeeCode, @FormParam("desk") int deskNumber){
        try{
            if(employeeCode != null && deskNumber != 0){
                if(Employee.matches(employeeCode)){
                    if(CashDesk.matches(deskNumber)){
                        return new Session(new Employee("112"), new CashDesk(1));
                    }
                    else throw new Exception("invalid desk number");
                }
                else throw new Exception("invalid employee");
            }
            else throw new Exception("invalid parameters");
        }
        catch (Exception e){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
