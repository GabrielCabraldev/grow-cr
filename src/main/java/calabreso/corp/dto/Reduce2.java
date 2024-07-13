package calabreso.corp.dto;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reduce2 {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", 7.1);
        Aluno a2 = new Aluno("Fabi", 6.1);
        Aluno a3 = new Aluno("Clara", 8.1);
        Aluno a4 = new Aluno("Gui", 10);
        Aluno a5 = new Aluno("Rubens", 5.0);

        List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);

        Predicate<Aluno> aprovado = a -> a.nota >= 7;
        Predicate<Aluno> recuperacao = a -> a.nota <= 7 && a.nota >=5;
        Function<Aluno, Double> getNota = a -> a.nota;
        Function<Aluno, String> getNome = a -> a.nome;
        BinaryOperator<Double> somatorio = (a, b) -> a + b;

        alunos.parallelStream()
                .filter(aprovado)
                .map(getNota)
                .reduce(somatorio)
                .ifPresent(System.out::println);

        alunos.stream()
                .filter(recuperacao)
                .map(getNota)
                .reduce(somatorio)
                .ifPresent(System.out::println);

        List<String> nomesAprovados = alunos.stream()
                .filter(aprovado)
                .map(getNome)
                .toList();

        System.out.println("Alunos aprovados: " + nomesAprovados);


    }

}
