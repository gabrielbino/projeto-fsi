public class Produto {
    private static int proximoIdProduto = 1;

    private int id;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.id = proximoIdProduto++;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
