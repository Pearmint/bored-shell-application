package at.upstream_mobility.itacademy.bored.command;

import at.upstream_mobility.itacademy.bored.client.BoredAPIClient;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent
public class BoredCommands {
    private final BoredAPIClient boredAPIClient;

    public BoredCommands(BoredAPIClient boredAPIClient) {
        this.boredAPIClient = boredAPIClient;
    }

    @ShellMethod(value = "Gets an activity.")
    public String get(@ShellOption(defaultValue = ShellOption.NULL, valueProvider = TypeValuesProvider.class) String type){
        return boredAPIClient.getActivity(Optional.ofNullable(type)).activity();
    }
}

@Component
class TypeValuesProvider implements ValueProvider {

    private final static String[] TYPES = new String[]{
            "education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"
    };

    @Override
    public List<CompletionProposal> complete(CompletionContext completionContext) {
        return Arrays.stream(TYPES).map(CompletionProposal::new).collect(Collectors.toList());
    }
}


