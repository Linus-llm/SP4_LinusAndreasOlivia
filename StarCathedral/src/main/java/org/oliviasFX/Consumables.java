package org.oliviasFX;


public class Consumables extends Item {
    private int healingStrength;


    protected int healingCalc() {
        return healingStrength;
    }


    public Consumables(String itemDescription, int healingStrength) {
        super(itemDescription);
        this.healingStrength = healingStrength;
    }


    public Consumables(String itemDescription, String itemName, int healingStrength) {
        super(itemDescription, itemName);
        this.healingStrength = healingStrength;
    }


    @Override
    public String toString() {
        return super.toString() + " (Heals: " + healingStrength + ")";
    }
}


