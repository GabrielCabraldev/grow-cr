package calabreso.corp;


public class Grow {
    private Integer quantidade;
    private String nome;
    private Double preco;

    public Grow(Integer quantidade, String nome, Double preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Grow{" +
                "quantidade=" + quantidade +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
