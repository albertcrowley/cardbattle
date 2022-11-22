package net.bwnj.cardbattle.Engine;

import java.util.List;

public class Game {
    public List<Location> Locations;

    public Game(List<Location> locations) {
        this.Locations = locations;
    }

    public Location getLocationByName(String name){
        for (Location loc : this.Locations) {
            if (loc.Name.equals(name)) {
                return loc;
            }
        }
        return null;
    }

    public Location get(String name) {
        return this.getLocationByName(name);
    }

    /***
     * Moves a card from the top of the pile in one location to the
     * top of the pile in another locaiton.
     *
     * @param count number of cards to move
     * @param sourceLocation Source location of the card
     * @param destLocation Dest location of the card
     * @return Number of cards moved
     */
    public int moveCards(int count, String sourceLocation, String destLocation){

        int i = 0;
        for (; i< count; i++) {
            Pile source = get(sourceLocation).Cards;
            Pile dest = get(destLocation).Cards;
            Card card = source.remove(0);
            dest.add(0, card);
        }





        return i;
    }

}
