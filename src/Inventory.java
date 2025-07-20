public class Inventory {
    private String itemName;
    private String itemDescription;
    private int itemQuantity;
    private int increaseFromItem;

    // constructor
    public Inventory(String itemName, String itemDescription, int itemQuantity, int increaseFromItem) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.increaseFromItem = increaseFromItem;
    }

    // get/set
    public String getItemName() { return itemName; }
    public String getItemDescription() { return itemDescription; }
    public int getItemQuantity() { return itemQuantity; }
    public int getIncreaseFromItem() { return increaseFromItem; }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    public void setIncreaseFromItem(int increaseFromItem) {
        this.increaseFromItem = increaseFromItem;
    }

    // output
    public String toString() {
        return this.itemName + ": \"" + this.itemDescription + "\"\t Quantity: " + this.itemQuantity;
    }
}
