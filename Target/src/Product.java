public class Product {
    private int prodID;
    private float prodPrice, prodWeight;
    private boolean prodPerishable;
    private String prodDescription;
    private String prodName;

    public Product()
    {
        prodID = 0;
        prodPrice = 0.0F;
        prodWeight = 0.0F;
        prodPerishable = false;
        prodDescription = "";
        prodName = "";
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

    public String displayProdName()
    {
        return prodName;
    }

}