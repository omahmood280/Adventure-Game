import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Location {


    /**
     *
     * declaring private final locationId, description, exits
     */
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;


    public Location(int locationId, String description, Map<String, Integer> exits) {
        /** TODO
         * setting the locationId and the description
         */
        this.locationId = locationId;
        this.description = description;
        /** TODO
         * if exits are not null, this sets the exit
         * otherwise, it sets the exit HashMap to (Q,0)
         */
        if (exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>();
            this.exits.put("Q", 0);

        }

    }


    protected void addExit(String direction, int location) {
        /**
         * putting the direction and the location in the exits HashMap
         */
        exits.put(direction, location);
    }

    public int getLocationId() {

        return locationId;
    }

    public String getDescription() {

        return description;
    }

    public Map<String, Integer> getExits() {
        /**
         * completing the getter to return a copy of exits
         * (preventing modification of exits from outside the Location instance)
         */
        return new LinkedHashMap<String, Integer>(exits);

    }
}

