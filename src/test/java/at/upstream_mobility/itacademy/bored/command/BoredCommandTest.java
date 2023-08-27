package at.upstream_mobility.itacademy.bored.command;

import at.upstream_mobility.itacademy.bored.client.BoredAPIClient;
import at.upstream_mobility.itacademy.bored.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BoredCommandTest {

    private BoredCommands boredCommands;

    @Test
    public void getMockedActivityWithoutType(){
        BoredAPIClient boredAPIClient = mock(BoredAPIClient.class);
        Activity activity = new Activity("Develop a spring shell app.", 0.5d,"education",1,0,12345678);
        when(boredAPIClient.getActivity(Optional.empty())).thenReturn(activity);
        boredCommands = new BoredCommands(boredAPIClient);

        String result = boredCommands.get(null);
        assertThat(result).isEqualTo(activity.activity());
    }

    @Test
    public void getMockedActivityWithType(){
        BoredAPIClient boredAPIClient = mock(BoredAPIClient.class);
        Activity activity = new Activity("Develop a spring shell app.", 0.5d,"education",1,0,12345678);
        when(boredAPIClient.getActivity(Optional.ofNullable("education"))).thenReturn(activity);
        boredCommands = new BoredCommands(boredAPIClient);

        String result = boredCommands.get("education");
        assertThat(result).isEqualTo(activity.activity());
    }

    @Test
    public void getActivityWithoutType(){
        boredCommands = new BoredCommands(new BoredAPIClient());

        String result = boredCommands.get(null);
        assertThat(result).isNotEmpty();
    }

    @Test
    public void getActivityWithType(){
        boredCommands = new BoredCommands(new BoredAPIClient());

        String result = boredCommands.get("education");
        assertThat(result).isNotEmpty();
    }


}
