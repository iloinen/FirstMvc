package app;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomGenerator {

    public String getRandom(List<String> list) {
        return list.get(0);
    }

    public String getRealRandom(List<String> list) {
        int randomIndex = (int) (Math.random() * list.size());

        return list.get(randomIndex);
    }

}
