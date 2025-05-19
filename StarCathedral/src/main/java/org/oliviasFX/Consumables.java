package org.oliviasFX;

public class Consumables extends Item {
    private int healingStrength;

    // Konstruktorer
    public Consumables(String itemDescription, int healingStrength) {
        super(itemDescription);
        this.healingStrength = healingStrength;
    }

    public Consumables(String itemDescription, String itemName, int healingStrength) {
        super(itemDescription, itemName);
        this.healingStrength = healingStrength;
    }

    // Bruges til at give healing-værdi videre
    public int healingCalc() {
        return healingStrength;
    }

    @Override
    public String toString() {
        return super.toString() + " (Heals: " + healingStrength + ")";
    }

    // === STATIC PREDEFINED CONSUMABLES ===
    public static final Consumables HEALTH_POTION = new Consumables(
            "A glowing red potion in a glass bottle", "Health Potion", 20);

    public static final Consumables GREATER_HEALTH_POTION = new Consumables(
            "A large glowing red potion with golden trim", "Greater Health Potion", 40);

    public static final Consumables SMALL_BANDAGE = new Consumables(
            "A small cloth bandage", "Bandage", 10);

    public static final Consumables MAGIC_BERRY = new Consumables(
            "A strange blue berry with magical scent", "Magic Berry", 15);

    public static final Consumables HERBAL_TEA = new Consumables(
            "A warm cup of herbal tea", "Herbal Tea", 25);

    public static final Consumables ENERGY_DRINK = new Consumables(
            "A fizzy can with unknown branding", "Energy Drink", 15);

    public static final Consumables MYSTIC_SOUP = new Consumables(
            "A steaming bowl of shimmering soup", "Mystic Soup", 30);

    public static final Consumables FIRST_AID_KIT = new Consumables(
            "A compact medical kit with supplies", "First Aid Kit", 50);

    public static final Consumables FRUIT_SALAD = new Consumables(
            "A colorful mix of chopped fruits", "Fruit Salad", 18);

    public static final Consumables ENCHANTED_HONEY = new Consumables(
            "A golden jar of magically infused honey", "Enchanted Honey", 35);
}
