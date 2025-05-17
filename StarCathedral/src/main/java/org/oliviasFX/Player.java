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
        health = 100; // Standard startværdi, kan justeres
        playerDamage = 10; // Standard skade
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room startRoom) {
        currentRoom = startRoom;
    }

    public boolean move(Direction direction) {
        Room requestedRoom = null;

        switch (direction) {
            case Forward:
                requestedRoom = currentRoom.getForwardRoom();
                break;
            case Backwards:
                requestedRoom = currentRoom.getBackwardRoom();
                break;
            case UP:
                requestedRoom = currentRoom.getUpstairsRoom(); // rettet fra currentRoom()
                break;
            case DOWN:
                requestedRoom = currentRoom.getDownstairsRoom();
                break;
        }

        if (requestedRoom != null) {
            setCurrentRoom(requestedRoom);
            return true;
        } else {
            return false;
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    protected boolean getItem(String itemName) {
        // Hent item fra nuværende rum og læg i inventory
        Item pickupFromRoom = currentRoom.removeItem(itemName);
        if (pickupFromRoom != null) {
            inventory.add(pickupFromRoom);
            System.out.println("You picked up the item: " + pickupFromRoom.getItemName());
            return true;
        }
        return false;
    }

    protected void dropItem() {
        // Skal implementeres: fjern item fra inventory og tilføj til currentRoom
    }

    public String getName() {
        return playerName;
    }

    /**
     * Brug et consumable fra inventory.
     * Forventer at item er af typen Consumables og matcher navnet.
     */
    public boolean useConsumable(String itemName) {
        for (Item item : inventory) {
            if (item instanceof Consumables && item.getItemName().equalsIgnoreCase(itemName)) {
                int heal = ((Consumables) item).healingCalc();
                this.health += heal;
                inventory.remove(item);
                System.out.println("You used " + itemName + " and healed " + heal + " health.");
                System.out.println("Current health: " + this.health);
                return true;
            }
        }
        System.out.println("No consumable named '" + itemName + "' found in inventory.");
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }
}
