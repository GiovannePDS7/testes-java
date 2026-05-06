package school.sptech;

public class Calculadora {

    public Double somar(Double numeroA, Double numeroB) {
        // Seguindo o TDD, primeiro criamos o método sem lógica
        // para dar falha
//        return null;

        if(numeroA == null || numeroB == null) {
            throw new IllegalArgumentException("Numero nao pode ser nulo!");
        }

        return numeroA + numeroB;
    }


    // todo: fazer os testes (siga o TDD)
    // Testar 3 cenários felizes
    // Testar dividir por zero
    // Testar numeros null
    public Double dividir(Double numeroA, Double numeroB) {
        if(numeroA == null || numeroB == null) {
            throw new IllegalArgumentException("Numero não pode ser nulo");
        }

        if(numeroB == 0) {
            throw new IllegalArgumentException("Não pode dividir por zero!");
        }

        return numeroA / numeroB;
    }

    public boolean isPalindrome(String text){
        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Texto não pode ser nulo");
        }

        String textoSemEspaco = text.replaceAll(" ", "").toLowerCase();
        String textoInvertido = new StringBuilder(textoSemEspaco).reverse().toString();

        return textoSemEspaco.equals(textoInvertido);
    }
}
