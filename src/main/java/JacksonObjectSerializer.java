import static constants.JsonFilePath.JSON_PATH_SAVE;


public class JacksonObjectSerializer {
    private FileModification fileModification;

    public JacksonObjectSerializer() {
        this.fileModification = new FileModification(JSON_PATH_SAVE);
    }

    public String getJsonContent(BaseHamburger hambsList) {
//        ObjectMapper objectMapper;
//        objectMapper = new ObjectMapper();
//        try {
//            // add boolean append in case need to show all the content
//            objectMapper.writeValue(new FileOutputStream(JSON_PATH_SAVE), hambsList);
//            this.JsonContent = new String(Files.readAllBytes(Paths.get(JSON_PATH_SAVE)));
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//        } catch (IOException e) {
//            System.out.println("InputOutput exception");
//        }
//        return this.JsonContent;
        return this.fileModification.writeToFile(hambsList);
    }
}
