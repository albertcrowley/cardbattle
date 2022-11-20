package net.bwnj.cardbattle.Engine;

public class CardArchitype {
    public String Name;
    public int Cost;

    public CardArchitype(String name) {
        this.Name = name;
        this.Cost = 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(Name + " [" + Cost + "]" );
        return sb.toString();
    }

}
