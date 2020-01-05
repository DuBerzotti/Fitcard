package model;

import java.sql.Date;


public class Estabelecimento{
    
    private int codigo;
    private String razaosocial;
    private String nomefantasia;
    private String cnpj;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    private Date datacadastro;
    private String categoria;
    private String status;
    private String agencia;
    private String conta;

    public Estabelecimento() {
    }

    public Estabelecimento(String razaosocial, String cnpj) {
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
 
    }   

   public Estabelecimento(String razaosocial, String nomefantasia, String cnpj, String email, String endereco, String cidade, String estado, String telefone, Date datacadastro, String categoria, String status, String agencia, String conta) {
        this.codigo = 0;
        this.razaosocial = razaosocial;
        this.nomefantasia = nomefantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.datacadastro = datacadastro;
        this.categoria = categoria;
        this.status = status;
        this.agencia = agencia;
        this.conta = conta;
    }

  

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

  
 
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "codigo=" + codigo + ", razaosocial=" + razaosocial + ", nomefantasia=" + nomefantasia + ", cnpj=" + cnpj + ", email=" + email + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + ", datacadastro=" + datacadastro + ", categoria=" + categoria + ", status=" + status + ", agencia=" + agencia + ", conta=" + conta + '}';
    }
    
    
    
}

