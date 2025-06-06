package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDAO {

    private Connection conn;

    public CategoriaDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());
            stmt.executeUpdate();
        }
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTamanho(rs.getString("tamanho"));
                c.setEmbalagem(rs.getString("embalagem"));
                categorias.add(c);
            }
        }
        return categorias;
    }

    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());
            stmt.setInt(4, categoria.getId());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}