package net.bwnj.cardbattle.Engine;

public class CardArchitype {
    public String Name;
    public Integer Cost;
    public Integer Power;
    public Integer Toughness;
    public String Suit = "";

    public CardArchitype(String name) {
        this.Name = name;
        this.Cost = 0;
    }
    public CardArchitype(String name, String suit, int cost, int power, int toughness) {
        Name = name;
        Suit = suit;
        Cost = cost;
        Power = power;
        Toughness = toughness;
    }

    public String toString() {
        return "%s [ (%d) %d/%d ]".formatted(Name, Cost, Power, Toughness);   // Name + " [" + Cost + "]";
    }

}
