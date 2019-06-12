package io.github.ossgang.properties.demo.client.components;

import io.github.ossgang.properties.demo.commons.domain.Tune;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

import static io.github.ossgang.properties.fx.util.JavaFxFlux.fxScheduler;

public class FluxTunesView extends BorderPane {

    @Autowired
    private Flux<Tune> measuredTunes;

    @PostConstruct
    public void init() {
        TextArea textArea = new TextArea();
        setCenter(textArea);

        measuredTunes
                .map(t -> "received " + t + ".\n")
                .publishOn(fxScheduler())
                .subscribe(textArea::appendText);
    }
}
