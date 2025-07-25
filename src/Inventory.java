public class Inventory {
    public enum ItemType {
        heal, buff, debuff, restore
    }
    private String itemName;
    private ItemType itemType;
    private int itemQuantity;
    private int increaseFromItem;

    // constructor
    public Inventory(String itemName, ItemType itemType, int itemQuantity, int increaseFromItem) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemQuantity = itemQuantity;
        this.increaseFromItem = increaseFromItem;
    }

    // get/set
    public String getItemName() { return itemName; }
    public ItemType getItemType() { return itemType; }
    public int getItemQuantity() { return itemQuantity; }
    public int getIncreaseFromItem() { return increaseFromItem; }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    public void setIncreaseFromItem(int increaseFromItem) {
        this.increaseFromItem = increaseFromItem;
    }

    // output
    @Override
    public String toString() {
        return this.itemName + ": " + "\t Quantity: " + this.itemQuantity;
    }
}
