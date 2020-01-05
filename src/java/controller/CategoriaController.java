package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Categoria;

public class CategoriaController {

    public static String msg = "";

    private ArrayList<Categoria> lista;

    public void cadCategoria(Categoria categoria) throws Exception //Create
    {

        String sql = "insert into cadCategoria (categoria) values (?) ";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, categoria.getCategoria());
        ps.execute();
        msg = "Categoria cadastrada com sucesso!";

    }

    public void alterarCategoria(Categoria categoria, Integer cod) throws Exception { //Update

        String sql = "update cadCategoria set categoria = ? where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, categoria.getCategoria());
        ps.setInt(2, cod);
        ps.execute();

        msg = "Categoria alterada com sucesso!";
    }

    public void excluirCategoria(Integer cod) throws Exception { //Delete
        String sql = "delete from cadCategoria where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, cod);
        ps.execute();

        msg = "Categoria deletada com sucesso!";
    }

    public ArrayList<Categoria> getCategoria() throws Exception {
        lista = new ArrayList<Categoria>();

        String sql = "select * from cadCategoria";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
          Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt("codigo"));
            categoria.setCategoria(rs.getString("categoria"));
            lista.add(categoria);
        }
        return lista;
    }

    public Categoria getCatCodigo(int codigo) throws Exception {

        Categoria categoria = new Categoria();

        String sql = "select * from cadCategoria where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            categoria.setCodigo(rs.getInt("codigo"));
            categoria.setCategoria(rs.getString("categoria"));

        } else {
            categoria = null;
        }

        return categoria;

    }

}
