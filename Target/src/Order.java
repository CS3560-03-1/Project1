public class Order {
    private int orderID;
    private boolean confirmation;
    private String delMethod;

    public Order()
    {
        orderID = 0;
        confirmation = false;
        delMethod = "in-person";
    }

    public int getOrderID() {
        return orderID;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public String getDelMethod() {
        return delMethod;
    }

    public void setConfirmation(){
        //change the status of order confirmation
    }

    public void setDelMethod(String delMethod) {
        this.delMethod = delMethod;
    }
}