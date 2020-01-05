/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Categoria {
    

    private int codigo;
    private String categoria;

    public Categoria() {
    }

    public Categoria(int codigo, String categoria) {
        this.codigo = 0;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codigo=" + codigo + ", categoria=" + categoria + '}';
    }
    
    
    
}
