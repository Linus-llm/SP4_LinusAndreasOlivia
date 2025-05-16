package one;

public abstract class Item {
    protected String itemName;
    protected String itemDescription;

    public Item(String itemDescription) {
        this(itemDescription, extractNameFromDescription(itemDescription));
    }

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

    protected void monsterReward() {

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
