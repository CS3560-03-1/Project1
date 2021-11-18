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

    public boolean addProduct(ProductItem product) {
        //method to add products to maybe linked list?
        //make sure to take into account inventory
        return false; //return if adding product to cart is successful or not
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
}