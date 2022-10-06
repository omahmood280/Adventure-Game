import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /**
     * creating a static LocationMap object
     */
    static LocationMap locationMap = new LocationMap();


    /**
     * creating a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabulary = new HashMap<>();
    /**
     * creating a FileLogger object
     */
    FileLogger fileLogger = new FileLogger();

    /**
     * creating a ConsoleLogger object
     */
    ConsoleLogger consoleLogger = new ConsoleLogger();

    public Mapping() {

        vocabulary.put("QUIT", "Q"); //example
        /**
         * completing the vocabulary HashMap <Key, Value> with all directions.
         * using the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("NORTHWEST", "NW");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("UP", "U");
        vocabulary.put("DOWN", "D");

    }

    public void mapping() {

        /**
         * creating a Scanner object
         */
        Scanner x = new Scanner(System.in);
        /**
         * initialising a location variable with the INITIAL_LOCATION
         */
        Location currentLocation = (locationMap.get(INITIAL_LOCATION));

        while (true) {

            /**
             * getting the location and printing its description to both console and file
             * using the FileLogger and ConsoleLogger objects
             */

            consoleLogger.log(currentLocation.getDescription());
            fileLogger.log(currentLocation.getDescription());

            /**
             * verifying if the location is exit
             */
            if (currentLocation.getLocationId() == 0) {
                break;
            }
            /**
             * getting a map of the exits for the location
             */

            Map<String, Integer> exits = currentLocation.getExits();

            /**
             * printing the available exits (to both console and file)
             * & crosschecking with the ExpectedOutput files
             */


            StringBuilder sc = new StringBuilder();
            for (String i : exits.keySet()) {
                sc.append(i + ", ");
            }
            consoleLogger.log("Available exits are " + sc);
            fileLogger.log("Available exits are " + sc);

            /**
             * inputting a direction and ensuring that the input is converted to uppercase
             */

            String direction;
            direction = x.nextLine();
            direction = direction.toUpperCase();

            /**
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, each word is extracted
             * finding the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, the last one is chosen
             */

            if((direction.split(" ")).length == 2){
                if (vocabulary.containsKey(direction.replaceAll(" ", ""))) {
                    direction = direction.replaceAll(" ", "");
                }

            }
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String j : words) {
                    if (vocabulary.containsKey(j)) {
                        direction = vocabulary.get(j);

                    }
                }
            }


            /**
             * if user can go in that direction, then location is set to that direction
             * otherwise an error message is printed (to both console and file)
             */

            if (exits.containsKey(direction)) {

                currentLocation = locationMap.get(currentLocation.getExits().get(direction));

            }
            else {
                consoleLogger.log("You cannot go in that direction");
                fileLogger.log("You cannot go in that direction");
            }


        }
    }

    public static void main(String[] args) {
        /**
         * run the program from here
         * Mapping object is created
         * Game is started
         */

        Mapping mapping = new Mapping();
        mapping.mapping();
    }

}

