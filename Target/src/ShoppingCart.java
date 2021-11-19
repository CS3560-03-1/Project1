public class ShoppingCart {
    private int cartID;
    private int prodQuantity;
    private float totalCost;

    public ShoppingCart()
    {
        cartID = 0;
        prodQuantity = 0;
        totalCost = 0.0F;
    }

    public void addProductItem(InventoryItem item) //helper method
    {
        prodQuantity++;
        totalCost += item.getCost();
    }

    public int getCartID() {
        return cartID;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}