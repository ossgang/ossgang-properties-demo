package io.github.ossgang.properties.demo.server.chroma.conf;

import io.github.ossgang.properties.demo.commons.domain.Tune;
import io.github.ossgang.properties.demo.server.chroma.simulate.ChromaSimulator;
import io.github.ossgang.properties.demo.server.chroma.simulate.PayloadSimulator;
import io.github.ossgang.properties.demo.server.chroma.simulate.PublicationSimulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TuneBaseConfiguration {

    @Bean
    public ChromaSimulator chromaSimulator() {
        return new ChromaSimulator();
    }

    @Bean
    public PayloadSimulator payloadSimulator() {
        return new PayloadSimulator();
    }

    @Bean
    public PublicationSimulator<Tune> tunePublicationSimulator(ChromaSimulator chromaSimulator, PayloadSimulator payloadSimulator) {
        return PublicationSimulator.generatedBy(() -> new Tune(chromaSimulator.actualTune(), chromaSimulator.getNoiseStandardDev(), payloadSimulator.nextPayload()));
    }


}
