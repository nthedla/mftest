import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {


    public Object[] topThreeWords(String input) {
        if (input.replaceAll("[^a-zA-Z]", "").isEmpty())
            return new String[0];
        else {
            Stream<String> streamOfWords = Arrays.stream(input.trim().replaceAll("[^a-zA-Z' ]", "").split(" "));
            Map<String, Long> map = streamOfWords
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));


            return map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .collect(Collectors.toList())
                    .stream().map(Map.Entry::getKey).toArray();
        }
    }
}
