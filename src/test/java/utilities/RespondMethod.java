package utilities;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import pojos.BooksPojo;
import pojos.OrdersPojo;
import pojos.StatusPojo;

import java.util.Arrays;
import java.util.List;

public class RespondMethod {
    /*
    In final methods I stored non changeable responses for specific calls
     */
     public static final String AllBookListName="The Russian,Just as I Am,The Vanishing Half,The Midnight Library,Untamed,Viscount Who Loved Me,";
     public static final String OrderErrorMsg="Invalid or missing bookId.";
     public static final String DeleteOrderMsg="No order with id";

    public static void verify200Status(Response response){
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"Unexpected response code");
    }
    public static void verify201Status(Response response){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED,"Unexpected Response Code");
    }
    public static void verify204Status(Response response){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NO_CONTENT,"Unexpected Response Code");
    }
    public static void verify400Status(Response response){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_BAD_REQUEST,"Unexpected Response Code");
    }
    public static void verify404Status(Response response){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NOT_FOUND,"Unexpected Response Code");
    }
    public static void verifySuccessStatusMSG(StatusPojo st){
        Assert.assertEquals(st.getStatus(),"OK","Success message not received!");
    }
    public static void verifyBookListData(String names , int size){
    Assert.assertEquals(names,(AllBookListName),"List of book names does not matches with expected result!");
    Assert.assertEquals(6,size);
    }
    public static void verifyOrderSubmitSuccess(OrdersPojo ordersPojo) {
            Assert.assertEquals(ordersPojo.isCreated(), true);
            Assert.assertNotNull(ordersPojo.getOrderId());
    }
    public static  void verifyOrderError(OrdersPojo ordersPojo){
            Assert.assertEquals(ordersPojo.getError(), OrderErrorMsg);
        }
        public static void verifyGetOrdersData(OrdersPojo ordersPojo, int id, String name){
        Assert.assertEquals(ordersPojo.getBookId(),id);
        Assert.assertEquals(ordersPojo.getCustomerName(),name);
        }
    public static  void verifyDeletedOrderMsg(OrdersPojo ordersPojo){
        Assert.assertTrue(ordersPojo.getError().contains(DeleteOrderMsg));
    }
    public static void verifySingleBookResponse(BooksPojo booksPojo){
        if(booksPojo.getId()==1){
            Assert.assertEquals(booksPojo.getName(),"The Russian");
            Assert.assertEquals(booksPojo.getAuthor(),"James Patterson and James O. Born");
            Assert.assertEquals(booksPojo.isAvailable(),true);
        }else if(booksPojo.getId()==2){
            Assert.assertEquals(booksPojo.getName(),"Just as I Am");
            Assert.assertEquals(booksPojo.isAvailable(),false);
        }else if(booksPojo.getId()==3){
            Assert.assertEquals(booksPojo.getName(),"The Vanishing Half");
            Assert.assertEquals(booksPojo.isAvailable(),true);
        }else if(booksPojo.getId()==4){
            Assert.assertEquals(booksPojo.getName(),"The Midnight Library");
            Assert.assertEquals(booksPojo.isAvailable(),true);
        }else if(booksPojo.getId()==5){
            Assert.assertEquals(booksPojo.getName(),"Untamed");
            Assert.assertEquals(booksPojo.isAvailable(),true);
        }else if (booksPojo.getId()==6){
            Assert.assertEquals(booksPojo.getName(),"Viscount Who Loved Me");
            Assert.assertEquals(booksPojo.isAvailable(),true);
        }else {
            System.out.println("Invalid book id");
        }
    }

}
