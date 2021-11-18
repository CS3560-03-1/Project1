public class Transaction {
    private int transID;
    private int transDate; //MMDDYYYY
    private String transType;
    private double transAmount;

    public Transaction()
    {
        //Transaction constructor
        //maybe use getCreditCard from Customer object
        transID = 0;
        transDate = 0;
        transType = "";
        transAmount = 0;
    }

    public void transAmt(double tax, double shipping, double totalCost) {
        //totalCost taken from shoppingCart object
        //shipping taken from external shipping database
        transAmount = tax + shipping + totalCost;
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

    public double getTransAmount() {
        return transAmount;
    }



}