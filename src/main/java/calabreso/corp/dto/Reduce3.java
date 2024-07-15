package calabreso.corp.dto;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce3 {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", 7.1);
        Aluno a2 = new Aluno("Fabi", 6.1);
        Aluno a3 = new Aluno("Clara", 8.1);
        Aluno a4 = new Aluno("Gui", 10);

        List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

        Predicate<Aluno> aprovado = a -> a.nota >= 7;
        Predicate<Aluno> reprovado = a -> a.nota < 7;
        Function<Aluno, Double> getNota = a -> a.nota;

        BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);

        BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);

        Media mediaAprovados = alunos.parallelStream()
                .filter(aprovado)
                .map(getNota)
                .reduce(new Media(), calcularMedia, combinarMedia);

        Media mediaReprovados = alunos.parallelStream()
                .filter(reprovado)
                .map(getNota)
                .reduce(new Media(), calcularMedia, combinarMedia);

        Media mediaTotal = alunos.stream()
                .map(getNota)
                .reduce(new Media(), calcularMedia, combinarMedia);

        System.out.println(" A média da turma de aprovados é " + mediaAprovados.getValor() +
                 "\n A média da turma reprovados é " + mediaReprovados.getValor() +
                 "\n A media total da turma foi " + mediaTotal.getValor());
    }
}
