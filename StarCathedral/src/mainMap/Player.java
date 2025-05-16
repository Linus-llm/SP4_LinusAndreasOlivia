package mainMap;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private static int health;
    private ArrayList<Item> inventory;
    private int playerDamage;
    private Room currentRoom;

    public Player(){ inventory = new ArrayList<>();}

    public Room getCurrentRoom(){return currentRoom;}

    public void setCurrentRoom(Room startRoom){currentRoom = startRoom;}

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
                requestedRoom = currentRoom.getUpstairsRoom();

                break;
            case DOWN:
                requestedRoom = currentRoom.getDownstairsRoom();

                break;
        }



        if(requestedRoom!=null){
            setCurrentRoom(requestedRoom);
            return true;
        } else {
            return false;
        }
    }

    public List<Item> getInventory(){return inventory;}

    protected boolean getItem(String itemName){
        //should take item from the room the player is standing in and put it into inventory arraylist
        Item pickupFromRoom = currentRoom.removeItem(itemName);
        if (pickupFromRoom != null) {

            inventory.add(pickupFromRoom);
            System.out.println("you picked up the item");
            return true;
        }
        return false;
    }
    protected void dropItem(){
        //should take item from inventory and drop it into the room

    }
    public String getName(){return playerName;}

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    }



