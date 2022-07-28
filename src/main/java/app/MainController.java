package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private FoodData foodData;

    @Autowired
    private RandomGenerator generator;

    @GetMapping(value = {"/", "/home"})
    public String getHomePage(
            @RequestParam(required = false, defaultValue = "zöldség") String type,
            @RequestParam(required = false, defaultValue = "Anonim") String name,
            Model model) {

        switch (type) {
            case "zöldség":
                model.addAttribute("foods", foodData.getVegetables());
                break;
            case "gyümölcs":
                model.addAttribute("foods", foodData.getFruits());
                break;
            case "fűszer":
                model.addAttribute("foods", foodData.getSpices());
        }

        model.addAttribute("number", 1);
        model.addAttribute("name", name);

        return "index";
    }

    @GetMapping(value = {"/dice"})
    public String getDicePage(
            @RequestParam(required = false, defaultValue = "Senkise") String userName,
            @RequestParam(required = false, defaultValue = "6") int side,
            Model model
    ) {
        String greeting = "Üdv itt, kedves " + userName + "!";
        int randomNumber = (int) (Math.random() * side + 1);

        model.addAttribute("greeting", greeting);
        model.addAttribute("randomNum", randomNumber);

        return "dice";
    }

    @PostMapping(value = {"/dice"})
    public String postDicePage(
            @RequestParam(required = false, defaultValue = "Senkise") String userName,
            @RequestParam(required = false, defaultValue = "6") int side,
            Model model
    ) {
        String greeting = "Üdv itt, kedves " + userName + "!";
        int randomNumber = (int) (Math.random() * side + 1);

        model.addAttribute("greeting", greeting);
        model.addAttribute("randomNum", randomNumber);

        return "dice";
    }


}
