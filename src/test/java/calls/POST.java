package calls;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.OrdersPojo;


public class POST extends DataStorage{
    /*
    Post order by using data Provider
     1.With  multiple Positive values
     2.Validate status code
     3.Validate Body
     4.Make GET call to validate that data is created
     */
    @Test(dataProvider = "AddDataForOrderPositive")
    public void postOrder(int orderId, String customerName){
        OrdersPojo ordersPojo=new OrdersPojo(orderId,customerName);
        Response response=utilities.RequestMethod.postAnOrder(ordersPojo);
        response.prettyPrint();
        OrdersPojo ordersResponse=response.body().as(OrdersPojo.class);
        utilities.RespondMethod.verifyOrderSubmitSuccess(ordersResponse);
        utilities.RespondMethod.verify201Status(response);

      //  Get order id in order to validate that data is created and it is matching
       response=utilities.RequestMethod.getOrderId(ordersResponse);
       response.prettyPrint();
       ordersResponse=response.body().as(OrdersPojo.class);
       utilities.RespondMethod.verifyGetOrdersData(ordersResponse,orderId,customerName);
       utilities.RespondMethod.verify200Status(response);
    }
    /*
   Post order by using data Provider
    1.With  multiple Negative values (invalid id)
    Expected response: Invalid or missing bookId.
    validate status code
    */
    @Test(dataProvider = "AddDataForOrderNegative")
    public void postOrderNegativeScenario(int Id, String Name){
        OrdersPojo ordersPojo=new OrdersPojo(Id, Name);
        Response response=utilities.RequestMethod.postAnOrder(ordersPojo);
        response.prettyPrint();
        OrdersPojo ordersResponse=response.body().as(OrdersPojo.class);
        utilities.RespondMethod.verifyOrderError(ordersResponse);
        utilities.RespondMethod.verify400Status(response);
    }
}
