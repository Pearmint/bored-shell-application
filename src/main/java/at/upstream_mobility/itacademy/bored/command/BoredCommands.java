package at.upstream_mobility.itacademy.bored.command;

import at.upstream_mobility.itacademy.bored.client.BoredAPIClient;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.ValueProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ShellComponent
public class BoredCommands {
    private final BoredAPIClient boredAPIClient;

    public BoredCommands(BoredAPIClient boredAPIClient) {
        this.boredAPIClient = boredAPIClient;
    }

    @ShellMethod(value = "Gets an activity.")
    public String get(@ShellOption(defaultValue = ShellOption.NULL, valueProvider = TypeProvider.class) String type){
        return boredAPIClient.getActivity(Optional.ofNullable(type)).activity();
    }

    static class TypeProvider implements ValueProvider {
        @Override
        public List<CompletionProposal> complete(CompletionContext completionContext) {
            return Stream.of("education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork")
                    .map(CompletionProposal::new)
                    .collect(Collectors.toList());
        }
    }
}
