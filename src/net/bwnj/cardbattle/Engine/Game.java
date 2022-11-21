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



}
