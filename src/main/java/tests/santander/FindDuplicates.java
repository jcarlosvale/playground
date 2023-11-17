package tests.santander;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindDuplicates {

    private static String findDuplicates(List<Integer> integers) {
        Set<Integer> elements = new HashSet<>();
        return integers.stream()
                .filter(i -> !elements.add(i))
                .collect(Collectors.toCollection(TreeSet::new))
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(List.of(9, 9, 1, 3, 2, 1)));
        System.out.println(findDuplicates(List.of(9, 1, 5, 3, 2, 1, 9, 5)));
    }
}
