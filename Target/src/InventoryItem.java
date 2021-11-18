public class InventoryItem
{
    private int inventoryID;
    private int quantity;
    private float cost;
    private String color;
    private float weight;
    private String size;
    private String description;

    public InventoryItem()
    {
        inventoryID = 0;
        quantity = 0;
        cost = 0.0F;
        color = "";
        weight = 0.0F;
        size = "";
        description = "";
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public int getQuantity(){
        return quantity;
    }

    public float getCost()
    {
        return cost;
    }

    public String getColor()
    {
        return color;
    }

    public float getWeight()
    {
        return weight;
    }

    public String getSize()
    {
        return size;
    }

    public String getDescription()
    {
        return description;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
