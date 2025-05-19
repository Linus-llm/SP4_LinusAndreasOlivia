// Tess - prøver lige hurtigt at ændre package one til main.one på flere klasser, skifter tilbage med det samme hvis det ikke virker, men jeg kan ikke compile - package one;
package main.one;

public class Friendly implements Creature {
    public void monsterReward() {}
    public boolean ifPlayerFriendly() { return true; }
    public boolean ifPlayerHostile() { return false; }
}
