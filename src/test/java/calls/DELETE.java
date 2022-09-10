package calls;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.OrdersPojo;

public class DELETE {
    Response response;
    @Test
    public void deleteOrder(){
    /*
    1st Create a single order and
    Delete order that has been created
    validate status code
    get deleted order
     */
    OrdersPojo ordersPojo=new OrdersPojo(6,"Lina");
    response=utilities.RequestMethod.postAnOrder(ordersPojo);
    response.prettyPrint();
    OrdersPojo ordersPojoResponse=response.body().as(OrdersPojo.class);
    utilities.RespondMethod.verifyOrderSubmitSuccess(ordersPojoResponse);
    utilities.RespondMethod.verify201Status(response);

    //now Delete created order it should give status code 204
    response=utilities.RequestMethod.deleteOrderId(ordersPojoResponse);
    utilities.RespondMethod.verify204Status(response);

    //now get call to validate it is deleted

    response=utilities.RequestMethod.getOrderId(ordersPojoResponse);
    ordersPojoResponse=response.body().as(OrdersPojo.class);
    response.prettyPrint();
    utilities.RespondMethod.verifyDeletedOrderMsg(ordersPojoResponse);
    utilities.RespondMethod.verify404Status(response);



}
}
