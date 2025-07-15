import java.util.List;

public class Inventory {
    private String itemName;
    private String itemDescription;
    private int quanity;
    private int increaseFromItem;


    public Inventory(String itemName, String itemDescription, int quanity, int increaseFromItem) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.quanity = quanity;
        this.increaseFromItem = increaseFromItem;
    }

    // get/set
    public String getItemName() { return itemName; }
    public String getItemDescription() { return itemDescription; }
    public int getQuanity() { return quanity; }
    public int getIncreaseFromItem() { return increaseFromItem; }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public void setIncreaseFromItem(int increaseFromItem) {
        this.increaseFromItem = increaseFromItem;
    }

    public void printInventory() {
        System.out.println(itemName + ", " + itemDescription + ", Quanity: " + quanity);
    }
}
