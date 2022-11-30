package net.bwnj.cardbattle.Engine;

public class Card {

    public CardArchitype Architype;
    public String Format = "$n [ $p/$t ]\n";

    public Card(CardArchitype cardArchitype) {
        this.Architype = cardArchitype;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
            String cardstring = new String(Format);
            cardstring = cardstring.replace("$n", Architype.Name);
            cardstring = cardstring.replace("$s", defaultStr(Architype.Suit, ""));
            cardstring = cardstring.replace("$c", defaultStr(Architype.Cost, ""));
            cardstring = cardstring.replace("$p", defaultStr(Architype.Power, ""));
            cardstring = cardstring.replace("$t", defaultStr(Architype.Toughness, ""));
            sb.append(cardstring);
        return sb.toString();
    }
    String defaultStr(Object o, String def) {
        if (o == null) {
            return def;
        }
        return o.toString();
    }


}
