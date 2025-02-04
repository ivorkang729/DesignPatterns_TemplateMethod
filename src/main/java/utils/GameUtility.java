package utils;

import java.util.List;
import java.util.stream.IntStream;

public class GameUtility {

    public static String formate(List<?> cards){
        return IntStream.range(0, cards.size())
                .mapToObj(index -> "[" + index + "]" + cards.get(index))
                .reduce((a, b) -> a + ", " + b).orElse("");
    }

}
