package pe.com.sanchez.extensions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        List.of("1", "2", "3", "a", "4", "b", "5")
                .stream()
                .map(Either.liftWithValue(Integer::parseInt))
                .filter(Either::isLeft)
                .map(Either::getLeft)
                .flatMap(Optional::stream)
                .map(Pair::getSecond)
                .flatMap(Optional::stream)
                .forEach(System.out::println);


        final List<Pair<Exception, String>> errors = List.of("1", "2", "3", "a", "4", "b", "5")
                .stream()
                .map(Either.liftWithValue(Main::toString))
                .filter(Either::isLeft)
                .map(Either::getLeft)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        errors
                .stream()
                .map(Pair::getFirst)
                .flatMap(Optional::stream)
                .forEach(e -> log.error(e.getMessage(), e));

        errors
                .stream()
                .map(Pair::getSecond)
                .flatMap(Optional::stream)
                .forEach(System.out::println);
    }

    public static String toString(String dato) {
        return dato;
    }
}
