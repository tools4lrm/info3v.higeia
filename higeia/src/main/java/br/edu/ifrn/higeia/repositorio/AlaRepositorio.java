package br.edu.ifrn.higeia.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.higeia.modelo.Ala;

public class AlaRepositorio {

    private Connection getConnection() throws SQLException {
        return GerenciadorDeConexao.getConnection();
    }

    // [C] - INSERIR (INSERT)
    public void inserir(Ala ala) {
        String sql = "INSERT INTO ala (nome, capacidade_max, leitos_ocupados) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, ala.getNome());
            stmt.setInt(2, ala.getCapacidadeMax());
            stmt.setInt(3, ala.getLeitosOcupados());
            stmt.executeUpdate();

            // Recupera o ID gerado pelo auto_increment do MySQL e guarda no objeto Java
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ala.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no MySQL", e);
        }
    }

    // [R] - SELECIONAR / LISTAR (SELECT)
    public List<Ala> selecionarTodas() {
        List<Ala> alas = new ArrayList<>();
        String sql = "SELECT * FROM ala";

        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Ala ala = new Ala();
                ala.setId(rs.getLong("id"));
                ala.setNome(rs.getString("nome"));
                ala.setCapacidadeMax(rs.getInt("capacidade_max"));
                ala.setLeitosOcupados(rs.getInt("leitos_ocupados"));
                alas.add(ala);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar dados do MySQL", e);
        }
        return alas;
    }

    // [U] - ATUALIZAR (UPDATE)
    public void atualizar(Ala ala) {
        String sql = "UPDATE ala SET nome = ?, capacidade_max = ?, leitos_ocupados = ? WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, ala.getNome());
            stmt.setInt(2, ala.getCapacidadeMax());
            stmt.setInt(3, ala.getLeitosOcupados());
            stmt.setLong(4, ala.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no MySQL", e);
        }
    }

    // [D] - EXCLUIR (DELETE)
    public void excluir(Long id) {
        String sql = "DELETE FROM ala WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir dados do MySQL", e);
        }
    }

}
