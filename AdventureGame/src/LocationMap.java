import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME = "locations.txt";
    private static final String DIRECTIONS_FILE_NAME = "directions.txt";

    /**
     *
     * creates a static locations HashMap
     */
    static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    static {


        FileLogger fileLogger = new FileLogger();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        /**
         * Reads from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * uses try-with-resources/catch block for the FileReader
         * extracts the location and the description on each line
         * prints all locations.txt and descriptions to both console and file
         * checks the ExpectedOutput files
         * puts each location in the locations.txt HashMap using temporary empty hashmaps for exits
         */




        try (BufferedReader x = new BufferedReader(new FileReader(LOCATIONS_FILE_NAME))) {
            String line;
            consoleLogger.log("Available locations:");
            fileLogger.log("Available locations:");
            for (int i = 0; (line = x.readLine()) != null; i++) {

                consoleLogger.log(line.replaceFirst(",", ": "));
                fileLogger.log(line.replaceFirst(",", ": "));

                Location location = new Location(Integer.parseInt(line.split(",", 2)[0]), line.split(",", 2)[1], null);
                locations.put(Integer.parseInt(line.split(",", 2)[0]), location);

            }


        } catch (Exception e) {

        }


        /**
         * This reads from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * uses try-with-resources/catch block for the FileReader
         * extracts the 3 elements  on each line: location, direction, destination
         * prints all locations, directions and destinations to both console and file
         * checks the ExpectedOutput files
         * for each location, creates a new location object and add its exit
         */

        try (BufferedReader y = new BufferedReader(new FileReader(DIRECTIONS_FILE_NAME))) {
            String line1;
            consoleLogger.log("Available directions:");
            fileLogger.log("Available directions:");
            for (int i = 0; (line1 = y.readLine()) != null; i++) {
                consoleLogger.log(line1.replaceAll(",", ": "));
                fileLogger.log(line1.replaceAll(",", ": "));
                int location1 = Integer.parseInt(line1.split(",")[0]);
                String direction = line1.split(",")[1];
                Location location = locations.get(location1);
                location.addExit(direction, Integer.parseInt(line1.split(",")[2]));

            }


        } catch (Exception e) {

        }


    }

    /**
     * implements all methods for Map
     * @return
     */



    @Override
    public int size() {


        return locations.size();
    }

    @Override
    public boolean isEmpty() {

        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {

        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {

        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {


        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {


        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {

        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {

        locations.clear();
    }


    @Override
    public Set<Integer> keySet() {

        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {

        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {


        return locations.entrySet();
    }
}






