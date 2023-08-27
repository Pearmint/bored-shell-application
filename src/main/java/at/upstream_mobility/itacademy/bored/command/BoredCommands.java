package at.upstream_mobility.itacademy.bored.command;

import at.upstream_mobility.itacademy.bored.client.BoredAPIClient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BoredCommands {
    private final BoredAPIClient boredAPIClient;

    public BoredCommands(BoredAPIClient boredAPIClient) {
        this.boredAPIClient = boredAPIClient;
    }

    @ShellMethod(value = "Gets an activity.")
    public String get(@ShellOption(defaultValue = ShellOption.NULL) String type){
        return boredAPIClient.getActivity(type).activity();
    }
}
