package twp;

public class Consumables extends Item {
    private int healingStrength;

    public Consumables(String itemDescription, String itemName) {
        super(itemDescription, itemName);
    }

    protected int healingCalc() {

        return healingStrength;
    }
}
