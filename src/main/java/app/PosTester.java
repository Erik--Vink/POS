package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Erik on 20-9-2016.
 */
public class PosTester {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        PosService.fillInventory();

        Session currentSession;

        InputReader reader = new InputReader();

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/api/products");
        try {
            httpPost.setEntity(new StringEntity(mapper.writeValueAsString(new SingleProduct("1", "kip", 99))));
            httpclient.execute(httpPost);
            httpclient.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
