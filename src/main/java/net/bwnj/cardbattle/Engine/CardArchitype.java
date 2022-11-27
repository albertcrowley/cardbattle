package net.bwnj.cardbattle.Engine;

public class CardArchitype {
    public String Name;
    public int Cost;
    public int Power;
    public int Toughness;
    public String Suit;

    public CardArchitype(String name) {
        this.Name = name;
        this.Cost = 0;
    }

    public String toString() {
        return "%s [ (%d) %d/%d ]".formatted(Name, Cost, Power, Toughness);   // Name + " [" + Cost + "]";
    }

}
