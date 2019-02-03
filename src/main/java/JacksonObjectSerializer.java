import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Additions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.JsonFilePath.JSON_PATH_SAVE;


public class JacksonObjectSerializer {
    public static void main(String[] args) {
        List<BaseHamburger> hambsList = new ArrayList<>();
        BaseHamburger baseHamburger = new BaseHamburger();
        baseHamburger.addAdditions(Additions.LETTUCE);
        baseHamburger.getDetailedInfo();
        HealthyBurger healthyBurger = new HealthyBurger();
        healthyBurger.addAdditions(Additions.ONION);
        healthyBurger.addAdditions(Additions.CARROT);
        healthyBurger.getDetailedInfo();
        DeluxeHamburger deluxeHamburger = new DeluxeHamburger();
        deluxeHamburger.addAdditions(Additions.CHIPS);
        deluxeHamburger.addAdditions(Additions.COCA_COLA);
        deluxeHamburger.addAdditions(Additions.COCA_COLA);
        deluxeHamburger.getDetailedInfo();
        hambsList.add(baseHamburger);
        hambsList.add(healthyBurger);
        hambsList.add(deluxeHamburger);

        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileOutputStream(JSON_PATH_SAVE), hambsList);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("InputOutput exception");

        }

    }
}
