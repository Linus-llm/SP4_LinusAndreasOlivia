// Tess - prøver lige hurtigt at ændre package one til main.one på flere klasser, skifter tilbage med det samme hvis det ikke virker, men jeg kan ikke compile - package one;

package main.one;

public abstract class Item {
    protected String itemName;
    protected String itemDescription;

    protected String getItemName() {
        return itemName;
    }

    protected String getItemDescription() {
        return itemDescription;
    }

    protected void monsterReward() {

    }
}
