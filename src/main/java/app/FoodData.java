package app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodData {

    public String getYourName() {
        return "A neved";
    }

    public List<String> getVegetables() {
        List<String> vegetables = new ArrayList<>();

        vegetables.add("krumpli");
        vegetables.add("répa");
        vegetables.add("brokkoli");

        return vegetables;
    }

    public List<String> getFruits() {
        List<String> fruits = new ArrayList<>();

        fruits.add("alma");
        fruits.add("körte");
        fruits.add("barack");

        return fruits;
    }

    public List<String> getSpices() {
        List<String> spices = new ArrayList<>();

        spices.add("só");
        spices.add("bors");
        spices.add("majoranna");

        return spices;
    }

}
