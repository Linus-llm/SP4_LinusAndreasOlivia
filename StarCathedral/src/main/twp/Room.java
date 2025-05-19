package twp;

import java.util.ArrayList;

public class Room {

    private Room upstairsRoom;
    private Room downstairsRoom;
    private Room forwardRoom;
    private Room backwardRoom;
    private Riddle riddle;
    private String name;
    private String description;
    private boolean isLocked;


    private ArrayList<Item> items;
    private ArrayList<Creature> creatures;



    public Room(String name, String description, boolean isLockedtmp){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        creatures = new ArrayList<>();
        isLocked = isLockedtmp;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(String description, String name) {
        this.addItem(new Consumables(description, name));
    }


    public void addCreature(Creature creature) {
        creatures.add(creature);
    }
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public Room getUpstairsRoom(){

        return upstairsRoom;
    }

    public void setUpstairsRoom(Room upstairsRoom){

        this.upstairsRoom = upstairsRoom;
    }

    public Room getDownstairsRoom(){

        return downstairsRoom;
    }

    public void setDownstairsRoom(Room downstairsRoom){

        this.downstairsRoom = downstairsRoom;
    }

    public Room getForwardRoom(){

        return forwardRoom;
    }

    public void setForwardRoom(Room forwardRoom){
        this.forwardRoom = forwardRoom;
    }

    public Room getBackwardRoom(){

        return backwardRoom;
    }

    public void setBackwardRoom(Room backwardRoom){

        this.backwardRoom = backwardRoom;
    }

    public String getName(){

        return name;
    }

    public String getDescription(){

        return description;
    }

    public ArrayList<Item> getItem(){
        return items;
    }

    public Item removeItem(String itemName) {
        Item itemToBeRemoved = findItem(itemName);
        if (itemToBeRemoved != null) {
            return itemToBeRemoved;


        }
        return null;
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public void setRiddle(Riddle r) {
        this.riddle = r;
    }
    public Riddle getRiddle() {
        return riddle;
    }
    public boolean getIsLocked(){
        return isLocked;
    }
    public void setIsLockedFalse(){
        isLocked = false;
    }


}
