package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Estabelecimento;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

public class EstabelecimentoController {
    
    public static String msg="";

    private ArrayList<Estabelecimento> lista;

    public void cadastrar(Estabelecimento estabelecimento) throws Exception //Create
    {

        String sql = "insert into estabelecimento(razaosocial , nomefantasia , cnpj , email,"
                + "endereco , cidade , estado , telefone , datacadastro , categoria,"
                + "status, agencia, conta) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, estabelecimento.getRazaosocial());
        ps.setString(2, estabelecimento.getNomefantasia());
        ps.setString(3, estabelecimento.getCnpj());
        ps.setString(4, estabelecimento.getEmail());
        ps.setString(5, estabelecimento.getEndereco());
        ps.setString(6, estabelecimento.getCidade());
        ps.setString(7, estabelecimento.getEstado());
        ps.setString(8, estabelecimento.getTelefone());
        ps.setDate(9, estabelecimento.getDatacadastro());
        ps.setString(10, estabelecimento.getCategoria());
        ps.setString(11, estabelecimento.getStatus());
        ps.setString(12, estabelecimento.getAgencia());
        ps.setString(13, estabelecimento.getConta());
        ps.execute();
        msg="Cadastrado com sucesso!";

    }

    public void alterar(Estabelecimento estabelecimento, Integer cod) throws Exception { //Update

        String sql = "update estabelecimento set razaosocial = ?, nomefantasia = ?, "
                + "cnpj = ?, email = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?,"
                + "datacadastro = ?, categoria = ?, status = ?, agencia = ?,"
                + "conta = ? where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, estabelecimento.getRazaosocial());
        ps.setString(2, estabelecimento.getNomefantasia());
        ps.setString(3, estabelecimento.getCnpj());
        ps.setString(4, estabelecimento.getEmail());
        ps.setString(5, estabelecimento.getEndereco());
        ps.setString(6, estabelecimento.getCidade());
        ps.setString(7, estabelecimento.getEstado());
        ps.setString(8, estabelecimento.getTelefone());
        ps.setDate(9, estabelecimento.getDatacadastro());
        ps.setString(10, estabelecimento.getCategoria());
        ps.setString(11, estabelecimento.getStatus());
        ps.setString(12, estabelecimento.getAgencia());
        ps.setString(13, estabelecimento.getConta());
        ps.setInt(14, cod);
        ps.execute();

        msg = "Alterado com sucesso!";
    }

    public void excluir(Integer cod) throws Exception { //Delete
        String sql = "delete from estabelecimento where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, cod);
        ps.execute();

       msg = "Deletado com sucesso!";
    }

    public ArrayList<Estabelecimento> getTodos() throws Exception {
        lista = new ArrayList<Estabelecimento>();

        String sql = "select * from estabelecimento";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Estabelecimento estabelecimento = new Estabelecimento();
            estabelecimento.setCodigo(rs.getInt("codigo"));
            estabelecimento.setRazaosocial(rs.getString("razaosocial"));
            estabelecimento.setNomefantasia(rs.getString("nomefantasia"));
            estabelecimento.setCnpj(rs.getString("cnpj"));
            estabelecimento.setEmail(rs.getString("email"));
            estabelecimento.setEndereco(rs.getString("endereco"));
            estabelecimento.setCidade(rs.getString("cidade"));
            estabelecimento.setEstado(rs.getString("estado"));
            estabelecimento.setTelefone(rs.getString("telefone"));
            estabelecimento.setDatacadastro(rs.getDate("datacadastro"));
            estabelecimento.setCategoria(rs.getString("categoria"));
            estabelecimento.setStatus(rs.getString("status"));
            estabelecimento.setAgencia(rs.getString("agencia"));
            estabelecimento.setConta(rs.getString("conta"));
            lista.add(estabelecimento);
        }
        return lista;
    }

    public Estabelecimento getCodigo(int codigo) throws Exception {

        Estabelecimento estabelecimento;

        String sql = "select * from estabelecimento where codigo = ?";

        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            estabelecimento = new Estabelecimento(
                    rs.getString("razaosocial"),
                    rs.getString("nomefantasia"),
                    rs.getString("cnpj"),
                    rs.getString("email"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getDate("datacadastro"),
                    rs.getString("categoria"),
                    rs.getString("status"),
                    rs.getString("agencia"),
                    rs.getString("conta"));

            estabelecimento.setCodigo(rs.getInt("codigo"));
        } else {
            estabelecimento = null;
        }

        return estabelecimento;

    }
  
    

}
