package calls;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BooksPojo;
import pojos.StatusPojo;


public class GET {
    Gson gson=new Gson();
    @Test
    public void getStatus(){
        /*
        GET CALL for status  (simple call)
        1.validating status code
        2.validating a success message
         */
        Response response=utilities.RequestMethod.getCallStatus();
        response.prettyPrint();
        StatusPojo statusPojo=gson.fromJson(response.getBody().asString(),StatusPojo.class);
        utilities.RespondMethod.verify200Status(response);//validating status code
        utilities.RespondMethod.verifySuccessStatusMSG(statusPojo);//VALIDATING OK MESSAGE
    }
    @Test
    public void getSingleBook(){
        /*
        GET Call for specific book with id 1
        name="The Russian;
         */
        Response response=utilities.RequestMethod.getSingleBook(1);
        response.prettyPrint();
        BooksPojo bookResponse=response.body().as(BooksPojo.class);
        utilities.RespondMethod.verifySingleBookResponse(bookResponse);
        utilities.RespondMethod.verify200Status(response);

    }
    @Test
    public void getListOfBook(){
        /*
        GET CALL for books
         */
        Response response=utilities.RequestMethod.getListBooks();
        response.prettyPrint();
        BooksPojo[] rersponseBook=response.body().as(BooksPojo[].class);
        String actualName="";
        for(int i=0; i<rersponseBook.length; i++){
            actualName+=rersponseBook[i].getName()+",";
        }
        //validate all expected names are in list of  books and size of the list
        utilities.RespondMethod.verifyBookListData(actualName,rersponseBook.length);
        utilities.RespondMethod.verify200Status(response);








    }

}
