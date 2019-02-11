import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static constants.JsonFilePath.JSON_PATH_SAVE;

public class FileModification {
    private String filePath;
    private byte[] fileContent;
    private Logger logger = LoggerFactory.getLogger(FileModification.class);

    public FileModification(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public byte[] readFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.fileContent = Files.readAllBytes((Paths.get(this.filePath)));
            return this.fileContent;
        } catch (IOException e) {
            logger.error("Can't read file from specified path: "
                    + this.filePath);
        }
        return null;
    }

    public <T> String writeToFile(T hamsArray) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileOutputStream(this.filePath, true), hamsArray);
            this.fileContent = Files.readAllBytes(Paths.get(JSON_PATH_SAVE));
        } catch (IOException e) {
            this.logger.error("Can't write content to file from specific path"
                    + this.filePath);
        }
        return new String(this.fileContent);
    }
}
