package one;

public interface Creature {

    //Der skal være en boolean her der bliver til true, så vi kan sende den videre til Quest
    // og bruge den der over til at se om player'eren har fuldført quest'en
void monsterReward(
);

boolean ifPlayerFriendly();

boolean ifPlayerHostile();
}
