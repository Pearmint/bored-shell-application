package at.upstream_mobility.itacademy.bored.client;

import at.upstream_mobility.itacademy.bored.entity.Activity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Component
public class BoredAPIClient {

    private final String BASEURL = "https://www.boredapi.com/api/";
    private final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);
    private final WebClient apiClient;

    public BoredAPIClient() {
        this.apiClient = WebClient.create(BASEURL);
    }

    public BoredAPIClient(WebClient apiClient){
        this.apiClient = apiClient;
    }

    public Activity getActivity(String type){
            return apiClient.get().uri(uriBuilder -> uriBuilder.path("activity").queryParam("type",type).build()).retrieve().bodyToMono(Activity.class).block(REQUEST_TIMEOUT);
    }
}
