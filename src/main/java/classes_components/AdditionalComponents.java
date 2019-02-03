package classes_components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Additions;

import java.util.ArrayList;
import java.util.List;

import static constants.GeneralConstants.MAX_NUMBER_OF_ADDITIONS;

public class AdditionalComponents {
    private List<Additions> addonsList;

    public AdditionalComponents() {
        this.addonsList = new ArrayList<Additions>();
    }

    public List<Additions> getAddonsList() {
        return addonsList;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return (this.addonsList.isEmpty());
    }

    @JsonIgnore
    public int size() {
        return this.addonsList.size();
    }

    public void add(Additions itemToAdd) {
        if (!this.addonsList.contains(itemToAdd)
                && this.addonsList.size() < MAX_NUMBER_OF_ADDITIONS) {
            this.addonsList.add(itemToAdd);
        } else
            System.out.println("No more available additions are allowed");
    }

    public void remove(Additions itemToRemove) {
        if (this.addonsList.size() > 0) {
            this.addonsList.remove(itemToRemove);
        } else
            System.out.println("You don't have any addition to remove");
    }
}
