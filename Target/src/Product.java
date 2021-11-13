public class Product {
    private int prodID;
    private float prodPrice, prodWeight;
    private boolean prodPerishable;
    private String prodDescription;

    public Product()
    {
        prodID = 0;
        prodPrice = 0.0;
        prodWeight = 0.0;
        prodPerishable = false;
        prodDescription = "";
    }

    public int getProdID(){
        return prodID;
    }

    public float getProdPrice(){
        return prodPrice;
    }

    public float getProdWeight(){
        return prodWeight;
    }

    public boolean isProdPerishable(){
        return prodPerishable;
    }

    public String displayProdDescript(){
        return prodDescription;
    }

}