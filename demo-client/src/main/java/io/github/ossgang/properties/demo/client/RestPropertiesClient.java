package io.github.ossgang.properties.demo.client;

import io.gihub.ossgang.properties.web.client.RestClient;
import io.gihub.ossgang.properties.web.client.RestRemoteProperty;
import io.gihub.ossgang.properties.web.client.WebSocketFlux;
import io.gihub.ossgang.properties.web.client.rbac.DemoRbacTokenProvider;
import io.gihub.ossgang.properties.web.client.rbac.RbacTokenProvider;
import io.github.ossgang.properties.core.JsonConversions;
import io.github.ossgang.properties.demo.client.components.FluxTunesView;
import io.github.ossgang.properties.demo.client.components.SettingsView;
import io.github.ossgang.properties.demo.commons.domain.Tune;
import org.minifx.fxcommons.MiniFxSceneBuilder;
import org.minifx.workbench.annotations.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class RestPropertiesClient {

    @View
    @Bean
    public SettingsView propertiesSettingsView() {
        return new SettingsView();
    }

    @View
    @Bean
    public FluxTunesView propertiesFluxTunesView() {
        return new FluxTunesView();
    }

    @Bean
    public RestRemoteProperty<Double> standardDevProperty(RestClient restClient) {
        return new RestRemoteProperty<>(restClient, "ws://" + Constants.HOST + ":" + Constants.HTTP_PORT, Double.class, "standardDev");
    }

    @Bean
    public Flux<Tune> measuredTunes() {
        return WebSocketFlux.fluxFrom("ws://" + Constants.HOST + ":" + Constants.HTTP_PORT + "/measuredTunes")
                .map(s -> JsonConversions.defaultDeserialization(s, Tune.class));
    }

    @Bean
    public RestClient restClient() {
        return new RestClient("http://" + Constants.HOST + ":" + Constants.HTTP_PORT);
    }

    @Bean
    public RbacTokenProvider rbacTokenProvider() {
        return new DemoRbacTokenProvider();
    }

    @Bean
    public MiniFxSceneBuilder miniFxSceneBuilder() {
        return MiniFxSceneBuilder.miniFxSceneBuilder().withSize(640, 380);
    }

}
