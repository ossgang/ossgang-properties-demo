package io.github.ossgang.properties.demo.server.mains;

import cern.lhc.commons.web.PropertiesServiceConfiguration;
import io.github.ossgang.properties.demo.server.chroma.conf.TuneBaseConfiguration;
import io.github.ossgang.properties.demo.server.conf.PropertiesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({TuneBaseConfiguration.class, PropertiesConfiguration.class, PropertiesServiceConfiguration.class})
public class RestPropertiesServerMain {

    public static void main(String... args) {
        SpringApplication.run(RestPropertiesServerMain.class, args);
    }

}
