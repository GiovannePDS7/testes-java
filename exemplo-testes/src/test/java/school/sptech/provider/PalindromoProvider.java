package school.sptech.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class PalindromoProvider implements ArgumentsProvider{

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        // TODO Auto-generated method stub
        return Stream.of(
            Arguments.of("arara", true),
            Arguments.of("anA", true),
            Arguments.of("Teste", false),
            Arguments.of("", IllegalArgumentException.class),
            Arguments.of(null, "Texto não pode ser nulo"),
            Arguments.of("socorram me subi no onibus em marrocos", true)
        );
    }

    
    
}
