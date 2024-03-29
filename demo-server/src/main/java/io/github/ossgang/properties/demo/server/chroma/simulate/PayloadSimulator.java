package io.github.ossgang.properties.demo.server.chroma.simulate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

public class PayloadSimulator {

    private final AtomicInteger length = new AtomicInteger(0);

    private final Random random = new Random();

    public List<Double> nextPayload() {
        return random.doubles(length.get())
                .mapToObj(Double::new)
                .collect(toList());
    }

    public void setLength(int length) {
        this.length.set(length);
    }

    public int getLength() {
        return this.length.get();
    }
}
