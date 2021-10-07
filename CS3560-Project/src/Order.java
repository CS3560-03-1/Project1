public class Order {
    private int orderID;
    private boolean confirmation;
    private String delMethod;

    public Order() {
        //Order constructor
    }

    public String getOrderID() {
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
