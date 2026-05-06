package school.sptech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import school.sptech.provider.DividirProvider;
import school.sptech.provider.PalindromoProvider;

class CalculadoraTest {

    // Possíveis retornos dos testes:
    // sucesso: deu tudo certo (check verde)
    // falha: quando não passa no cenário (x amarelo)
    // erro: houve algum problema (exception) pra rodar o teste

    // Classes dentro de classes de Teste, serve pra agrupar cenários
    // Temos que utilizar o @Nested
    @Nested
    @DisplayName("Cenários do método somar")
    class SomarTests {

        // Todo teste tem um @Test e é void
        @Test
        // @DisplayName: é como o cenário irá aparecer
        @DisplayName("Deve somar dois numeros corretamente")
        void deveSomarDoisNumerosCorretamente() {
            // AAA (triple A)
            // arrange (preparar os dados pro teste)
            Calculadora calculadora = new Calculadora();

            // act (atuar, por exemplo, chamar o método)
            Double resultado = calculadora.somar(10.0, 5.0);

            // assert (verificar se o cenário está correto)
            Assertions.assertEquals(15.0, resultado);
        }

        @Test
        @DisplayName("Deve retornar exception quando valor é null")
        void deveRetornarExceptionQuandoValorEhNull() {
            // BDD -> behaviour driven development
            // desenvolvimento orientado a comportamento

            // Arrange -> Given
            Calculadora calculadora = new Calculadora();

            // Act -> When | Assert -> Then
            // assertThrows:
            // 1: qual exception
            // 2: qual método tem que chamar
            // 3: (opcional) Mensagem caso o teste não passe
            IllegalArgumentException exception = Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculadora.somar(10.0, null),
                    "Deve retornar exception quando divido por null");

            Assertions.assertEquals("Numero nao pode ser nulo!",
                    exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Cenários no método dividir")
    class DividirTestes {

        @Test
        @DisplayName("Deve retornar IllegalException quando numero é "
                + "dividido por zero")
        void deveRetornarExceptionDivididoPorZero() {
            // arrange
            Calculadora calculadora = new Calculadora();

            // act | assert
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculadora.dividir(10.0, 0.0));
        }

        @Test
        @DisplayName("Deve retornar exception quando numero é nulo")
        void deveRetornarExceptionQuandoNumeroEhNulo() {
            // arrange
            Calculadora calculadora = new Calculadora();

            // act | assert
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculadora.dividir(10.0, null));
        }

        // @ParameterizedTest: teste que vai receber parametros
        @ParameterizedTest
        @DisplayName("Deve dividir corretamente")
        // @ArgumentsSource: onde virá os parametros
        @ArgumentsSource(DividirProvider.class)
        void deveDividirCorretamente(Double numeroA, Double numeroB,
                Double resultadoEsperado) {
            // arrange
            Calculadora calculadora = new Calculadora();

            // act
            Double resultado = calculadora.dividir(numeroA, numeroB);

            // assert
            Assertions.assertEquals(resultadoEsperado, resultado);
        }

    }

    @ParameterizedTest
    @ArgumentsSource(PalindromoProvider.class)
    @DisplayName("Deve retornar true para palindromo")
    void deveRetornarTrueParaPalindromo(String text, Object resultadoEsperado) {
        // arrange
        Calculadora calculadora = new Calculadora();

        if(resultadoEsperado instanceof Boolean) {
            // act
            boolean resultado = calculadora.isPalindrome(text);

            // assert
            Assertions.assertEquals(resultadoEsperado, resultado);
        } else if(resultadoEsperado instanceof Class) {
            // act | assert
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculadora.isPalindrome(text));
        } else if(resultadoEsperado instanceof String) {
            IllegalArgumentException exception = Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculadora.isPalindrome(text));

            Assertions.assertEquals(resultadoEsperado, exception.getMessage());
        }
    }
}