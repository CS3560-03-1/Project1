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

    public Order(int ID, boolean confirm, String delMet){
        orderID = ID;
        confirmation = confirm;
        delMethod = delMet;
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

    public void setConfirmation(boolean status){
        //change the status of order confirmation
        this.confirmation = status;
    }

    public void setDelMethod(String delMethod) {
        this.delMethod = delMethod;
    }
}