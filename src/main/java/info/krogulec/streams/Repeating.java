package info.krogulec.streams;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repeating {

    public static void main(String[] args) {
        System.out.println(findFirstRepeatingChar("AABFGBAT"));
    }

    private static Character findFirstRepeatingChar(String characters) {
        Map<Character, List<Integer>> indicesOfChars = findIndicesOfChars(characters)
                .entrySet().stream()
                .filter(es -> es.getValue().size()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map.Entry<Character, List<Integer>> candidate = null;

        for (Map.Entry<Character, List<Integer>> entry : indicesOfChars.entrySet()){
            if (candidate == null){
                candidate = entry;
            } else if (entry.getValue().get(1) < candidate.getValue().get(1)){
                candidate = entry;
            }
        }

        return candidate.getKey();

    }

    private static Map<Character, List<Integer>> findIndicesOfChars(String characters) {

        Map<Character, List<Integer>> indicesOfChars = new HashMap<>();

        for (int i = 0; i< characters.length(); i++){
            indicesOfChars.put(characters.charAt(i), findAllIndicesOfCharInString(characters.charAt(i), characters));
        }

        return indicesOfChars;
    }

    private static List<Integer> findAllIndicesOfCharInString(char c, String characters) {

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i<characters.length(); i++){
            if(characters.charAt(i) == c){
                indices.add(i);
            }
        }

        return indices;

    }
}
