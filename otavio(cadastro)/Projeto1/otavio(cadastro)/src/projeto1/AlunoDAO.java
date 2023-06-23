package projeto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AlunoDAO {

    public void salvarAluno(Aluno aluno) {
        
        String url = "jdbc:mysql://localhost:3306/escola";
        String usuario = "root";
        String senha = "";
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            String sql ="INSERT INTO aluno (nome, matricula, turma, foto) VALUES (?, ?, ?, ?)";
            PreparedStatement atmt = conexao.prepareStatement(sql);
            atmt.setString(1, aluno.getNome());
            atmt.setInt(2, aluno.getMatricula());
            atmt.setString(3, aluno.getTurma());
            atmt.setBytes(4, aluno.getFoto());
            
            atmt.executeUpdate();
            
            atmt.close();
            conexao.close();
                    
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
    }

        public void atualizarAluno(Aluno aluno) {
        
        Connection conexao = null;
    
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/escola";
            String usuario = "root";
            String senha = "";
            
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            String sql ="UPDATE aluno set nome= ? , matricula= ? , turma= ? , foto= ? where id= ?";
            
            PreparedStatement atmt = conexao.prepareStatement(sql);
            atmt.setString(1, aluno.getNome());
            atmt.setInt(2, aluno.getMatricula());
            atmt.setString(3, aluno.getTurma());
            atmt.setBytes(4, aluno.getFoto());
            atmt.setInt(5, aluno.getId());
            
            atmt.executeUpdate();
            
            atmt.close();
            conexao.close();
                    
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
    }
        
    public void DeletarAluno(Aluno aluno) {
        
        Connection conexao = null;
    
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/escola";
            String usuario = "root";
            String senha = "";
            
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            String sql ="DELETE from aluno where id= ?";
            
            PreparedStatement atmt = conexao.prepareStatement(sql);

            atmt.setInt(1, aluno.getId());
            
            atmt.executeUpdate();
            
            atmt.close();
            conexao.close();
                    
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
    }


    
}