import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private static final String FILE_LOGGER_NAME = "StudentFileOutput.txt";

    static {

        /**
         * creating a new File object for FILE_LOGGER_NAME
         * if the file already exists, deletes it first
         * uses try/catch block
         */
        File fileObj = new File(FILE_LOGGER_NAME);
        try {
            fileObj.delete();
        } catch (Exception e) {

        }

    }


    @Override
    public void log(String message) {
        /**
         * creates a new FileWriter in append mode
         * writes the message to file
         * checks the ExpectedOutput files
         * uses try-with-resources/catch block
         */
        try (FileWriter fw = new FileWriter(FILE_LOGGER_NAME, true)){
            fw.write(message +"\n");

        } catch (Exception e) {
        }
    }
}
