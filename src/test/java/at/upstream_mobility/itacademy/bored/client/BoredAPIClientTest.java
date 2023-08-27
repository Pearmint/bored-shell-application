package at.upstream_mobility.itacademy.bored.client;

import at.upstream_mobility.itacademy.bored.entity.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
public class BoredAPIClientTest {
    BoredAPIClient apiClient;

    @BeforeEach
    public void beforeEach() {
        this.apiClient = new BoredAPIClient();
    }

    @Test
    public void getActivity() {
        Activity activity = apiClient.getActivity(Optional.ofNullable(null));
        assertThat(activity).isNotNull();
    }

    @Test
    public void getActivityWithType() {
        Activity activity = apiClient.getActivity(Optional.ofNullable("music"));
        assertThat(activity.type()).isEqualTo("music");
    }

}
