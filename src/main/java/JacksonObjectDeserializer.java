
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static constants.JsonFilePath.JSON_PATH;

public class JacksonObjectDeserializer {
    private BaseHamburger[] hamburgers;
    private FileModification fileModification;
    private Logger logger = LoggerFactory.getLogger(JacksonObjectDeserializer.class);

    public JacksonObjectDeserializer() {
        this.hamburgers = null;
        fileModification = new FileModification(JSON_PATH);
    }

    public BaseHamburger[] getHamburgers() {
        try {
            return new ObjectMapper()
                    .readValue(this.fileModification.readFromFile(), BaseHamburger[].class);
        } catch (IOException e) {
            logger.error("Could not read values from the specified file "
                    + fileModification.getFilePath()
                    + e.getMessage()
                    + e.getCause());
        }
        return null;
    }
}
