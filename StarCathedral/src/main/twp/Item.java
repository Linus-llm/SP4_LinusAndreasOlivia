package twp;

public abstract class Item {
    protected String itemName;
    protected String itemDescription;

    public Item(String itemDescription) {
        this(itemDescription, extractNameFromDescription(itemDescription));
    }
   //andreas commit
    public Item(String itemDescription, String itemName) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    protected String getItemName() {
        return itemName;
    }

    protected String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return itemDescription;
    }

    private static String extractNameFromDescription(String description) {
        int lastSpace = description.lastIndexOf(' ');
        if (lastSpace == -1) {
            return description;
        }
        return description.substring(lastSpace + 1);
    }
}
