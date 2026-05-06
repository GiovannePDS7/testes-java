package school.sptech.provider;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class DividirProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              // cenário 1
              Arguments.of(10.0, 5.0, 2.0),

              // Cenário 2
              Arguments.of(10.0, 2.0, 5.0),

              // Cenário 3
              Arguments.of(20.0, 10.0, 2.0)
        );
    }
}
