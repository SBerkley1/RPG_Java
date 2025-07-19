import java.util.List;

public class Inventory {
    private String itemName;
    private String itemDescription;
    private int itemQuantity;
    private int increaseFromItem;


    public Inventory(String itemName, String itemDescription, int quanity, int increaseFromItem) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = quanity;
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

    public void setQuanity(int quantity) {
        this.itemQuantity = quantity;
    }

    public void setIncreaseFromItem(int increaseFromItem) {
        this.increaseFromItem = increaseFromItem;
    }

    public String toString() {
        return this.itemName + ": \"" + this.itemDescription + "\"\t Quantity: " + this.itemQuantity;
    }
}
