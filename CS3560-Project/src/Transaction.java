public class Transaction {
    private int transID;
    private int transDate; //MMDDYYYY
    private String transType;
    private float transAmount;

    public Transaction() {
        //Transaction constructor
        //maybe use getCreditCard from Customer object
    }

    public void transAmt(float tax, float shipping, float totalCost) {
        //totalCost taken from shoppingCart object
        //shipping taken from external shipping database
    }

    public int getTransID() {
        return transID;
    }

    public int getTransDate() {
        return transDate;
    }

    public String getTransType() {
        return transType;
    }

    public float getTransAmount() {
        return transAmount;
    }
}
