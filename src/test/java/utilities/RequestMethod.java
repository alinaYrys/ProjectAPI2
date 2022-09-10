package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.OrdersPojo;
import pojos.Token;

import static io.restassured.RestAssured.given;

public class RequestMethod {
    public static Response postToken(Token token){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().contentType(ContentType.JSON).and().body(token).post(ConfigReader.getInstance().getTokenBasePath());
    }
    public static Response getCallStatus(){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().contentType(ContentType.JSON).and().get("/status");
    }
    public static Response getSingleBook(int id){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().contentType(ContentType.JSON).and().get("/books/"+id);
    }
    public static Response getListBooks(){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().contentType(ContentType.JSON).and().get("/books");
    }
    public static Response postAnOrder(OrdersPojo ordersPojo){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().header("Authorization","Bearer "+ConfigReader.getInstance().getAccessToken())
                .and().contentType(ContentType.JSON).body(ordersPojo).post("/orders");
    }
    public static Response getOrderId(OrdersPojo ordersPojo){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().header("Authorization","Bearer "+ConfigReader.getInstance().getAccessToken()).and().contentType(ContentType.JSON).and().get("/orders/"+ordersPojo.getOrderId());

    }
    public static Response deleteOrderId(OrdersPojo ordersPojo){
        return given().baseUri(ConfigReader.getInstance().getUrl()).and().header("Authorization","Bearer "+ConfigReader.getInstance().getAccessToken()).and().contentType(ContentType.JSON).and().delete("/orders/"+ordersPojo.getOrderId());

    }
}
