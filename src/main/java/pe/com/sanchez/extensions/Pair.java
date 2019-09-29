package pe.com.sanchez.extensions;

import java.util.Optional;

public class Pair<F,S> {
    private final F f;
    private final S s;

    private Pair(F f, S s) {
        this.f = f;
        this.s = s;
    }

    public static <F,S> Pair<F,S> of(F fst, S snd) {
        return new Pair<>(fst,snd);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + f +
                ", second=" + s +
                '}';
    }

    public Optional<S> getSecond() {
        return Optional.ofNullable(s);
    }
    public Optional<F> getFirst() {
        return Optional.ofNullable(f);
    }
}
