package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import modelo.Categoria;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, preco_unitario, unidade, qtd_estoque, qtd_minima, qtd_maxima, categoria_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQtdEstoque());
            stmt.setInt(5, produto.getQtdMinima());
            stmt.setInt(6, produto.getQtdMaxima());
            stmt.setInt(7, produto.getCategoria().getId());
            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem FROM produto p JOIN categoria c ON p.categoria_id = c.id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria(
                    rs.getInt("categoria_id"),
                    rs.getString("cat_nome"),
                    rs.getString("tamanho"),
                    rs.getString("embalagem")
                );
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco_unitario"),
                    rs.getString("unidade"),
                    rs.getInt("qtd_estoque"),
                    rs.getInt("qtd_minima"),
                    rs.getInt("qtd_maxima"),
                    c
                );
                produtos.add(p);
            }
        }
        return produtos;
    }

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem FROM produto p JOIN categoria c ON p.categoria_id = c.id WHERE p.id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria c = new Categoria(
                        rs.getInt("categoria_id"),
                        rs.getString("cat_nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                    );
                    return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("qtd_estoque"),
                        rs.getInt("qtd_minima"),
                        rs.getInt("qtd_maxima"),
                        c
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, preco_unitario = ?, unidade = ?, qtd_estoque = ?, qtd_minima = ?, qtd_maxima = ?, categoria_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQtdEstoque());
            stmt.setInt(5, produto.getQtdMinima());
            stmt.setInt(6, produto.getQtdMaxima());
            stmt.setInt(7, produto.getCategoria().getId());
            stmt.setInt(8, produto.getId());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}