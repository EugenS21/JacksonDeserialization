import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static constants.JsonFilePath.JSON_PATH;

public class JacksonObjectDeserializer {
    private BaseHamburger[] hamburgers;

    public JacksonObjectDeserializer() {
        this.hamburgers = null;
    }

    public BaseHamburger[] getHamburgers() {
        try {
            byte[] jsonData =
                    Files.readAllBytes(Paths.get(JSON_PATH));
            ObjectMapper objectMapper = new ObjectMapper();
            this.hamburgers = objectMapper.readValue(jsonData, BaseHamburger[].class);
        } catch (IOException e) {
            System.out.println("Cant open the file");
        }
        return hamburgers;
    }
}
