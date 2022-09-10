package calls;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Token;
import utilities.ConfigReader;
import utilities.RespondMethod;

public class AuthenticationCall {
@Test
    public void generateToken(){
    /*
Token will be available 7 days
Only one call is enough to get token and store value in config file
Note: If I will do multiple calls with same credentials it will throw error email in use
Important to do one call only in order to avoid this error
     */
    Token token=new Token(ConfigReader.getInstance().getClientName(),ConfigReader.getInstance().getClientEmail());
    Response response=utilities.RequestMethod.postToken(token);
    response.prettyPrint();
    Token tokenResponse=response.body().as(Token.class);
    System.out.println(tokenResponse.getAccessToken());


}
}
