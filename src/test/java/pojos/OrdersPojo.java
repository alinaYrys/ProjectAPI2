package pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdersPojo {
    @SerializedName("bookId")
    @Expose
    private int bookId;

    @SerializedName("customerName")
    @Expose
    private String customerName;

    @SerializedName("created")
    @Expose
    private boolean created;

    @SerializedName("orderId")
    @Expose
    private String orderId;

    @SerializedName("error")
    @Expose String error;

    public OrdersPojo(int bookId, String customerName) {
        this.bookId = bookId;
        this.customerName = customerName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
