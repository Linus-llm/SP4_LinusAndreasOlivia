package org.oliviasFX;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int health;
    private ArrayList<Item> inventory;
    private int playerDamage;
    private Room currentRoom;

    public Player() {
        inventory = new ArrayList<>();
        health = 100; // Start HP
        playerDamage = 10; // Startskade
    }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room startRoom) { this.currentRoom = startRoom; }

    public boolean move(Direction direction) {
        Room requestedRoom = null;

        switch (direction) {
            case Forward:
                requestedRoom = currentRoom.getForwardRoom(); break;
            case Backwards:
                requestedRoom = currentRoom.getBackwardRoom(); break;
            case UP:
                requestedRoom = currentRoom.getUpstairsRoom(); break;
            case DOWN:
                requestedRoom = currentRoom.getDownstairsRoom(); break;
        }

        if (requestedRoom != null) {
            setCurrentRoom(requestedRoom);
            return true;
        }
        return false;
    }

    public List<Item> getInventory() { return inventory; }

    // Saml item op fra rum
    protected boolean getItem(String itemName) {
        Item pickup = currentRoom.removeItem(itemName);
        if (pickup != null) {
            inventory.add(pickup);
            System.out.println("You picked up the item: " + pickup.getItemName());
            return true;
        }
        System.out.println("No such item found in this room.");
        return false;
    }

    // Brug et consumable item
    public boolean useConsumable(String itemName) {
        for (Item item : inventory) {
            if (item instanceof Consumables && item.getItemName().equalsIgnoreCase(itemName)) {
                int heal = ((Consumables) item).healingCalc();
                this.health += heal;
                inventory.remove(item);
                System.out.println("You used " + itemName + " and healed " + heal + " HP.");
                System.out.println("Current health: " + this.health);
                return true;
            }
        }
        System.out.println("No consumable named '" + itemName + "' found in inventory.");
        return false;
    }

    public int getHealth() { return health; }

    public int getPlayerDamage() { return playerDamage; }

    public String getName() { return playerName; }

    // (Valgfri) Udskriv inventory
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item);
            }
        }
    }
}
