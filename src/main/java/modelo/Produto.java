package modelo;


public class Produto {
    private int id;
    private String nome;
    private double precoUnitario;
    private String unidade;
    private int qtdEstoque;
    private int qtdMinima;
    private int qtdMaxima;
    private Categoria categoria;

    public Produto() {}

    public Produto(int id, String nome, double precoUnitario, String unidade,
                   int qtdEstoque, int qtdMinima, int qtdMaxima, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.qtdEstoque = qtdEstoque;
        this.qtdMinima = qtdMinima;
        this.qtdMaxima = qtdMaxima;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public int getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(int qtdEstoque) { this.qtdEstoque = qtdEstoque; }

    public int getQtdMinima() { return qtdMinima; }
    public void setQtdMinima(int qtdMinima) { this.qtdMinima = qtdMinima; }

    public int getQtdMaxima() { return qtdMaxima; }
    public void setQtdMaxima(int qtdMaxima) { this.qtdMaxima = qtdMaxima; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return nome;
    }
}
