/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.java.swing.plaf.windows.resources.windows;
import controller.EstabelecimentoController;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import model.Estabelecimento;
import util.CnpjConverter;
import util.CnpjValidator;
import util.ValidarData;

@WebServlet("/cadEst")
public class EstBean extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean editar = false;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        Estabelecimento estabelecimento = new Estabelecimento();
        EstabelecimentoController estC = new EstabelecimentoController();

        String acao = request.getParameter("acao");

        if (acao.equalsIgnoreCase("delete")) {

            try {
                estC.excluir(Integer.parseInt(request.getParameter("codigo")));
                request.setAttribute("msg", EstabelecimentoController.msg);
                RequestDispatcher view = request
                        .getRequestDispatcher("/index.jsp");
                request.setAttribute("est", estabelecimento);
                view.forward(request, response);

            } catch (Exception erro) {
                throw new RuntimeException("Erro: " + erro);
            }

        } else if (acao.equalsIgnoreCase("editar")) {

            try {
                editar = true;
                estabelecimento = estC.getCodigo(Integer.parseInt(request.getParameter("codigo")));

                RequestDispatcher view = request
                        .getRequestDispatcher("/inserir.jsp");
                request.setAttribute("est", estabelecimento);
                view.forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    protected void doPost( HttpServletRequest request,
        
         HttpServletResponse response) throws ServletException, IOException {
        Estabelecimento estabelecimento = new Estabelecimento();
        EstabelecimentoController estC = new EstabelecimentoController();
        

        CnpjConverter c = new CnpjConverter();
        String cnpj = "" + c.getAsObject(null, null, request.getParameter("cnpj"));

   if (CnpjValidator.validaCNPJ(cnpj) == false || ValidarData.isValid(request.getParameter("datacadastro"))==false) {

            if (editar == true) {
                if(ValidarData.isValid(request.getParameter("datacadastro"))==false){
                    request.setAttribute("msg", "DATA INVÁLIDO!");
                }else{
                request.setAttribute("msg", "CNPJ INVÁLIDO!");
                }
                try {
                    estabelecimento = estC.getCodigo(Integer.parseInt(request.getParameter("codigo")));
                } catch (Exception ex) {
                    Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
                }

                RequestDispatcher view = request
                        .getRequestDispatcher("/inserir.jsp");
                request.setAttribute("est", estabelecimento);
                view.forward(request, response);
                editar=false;
                
                
            } else {
                
                 if(ValidarData.isValid(request.getParameter("datacadastro"))==false){
                    request.setAttribute("msg", "DATA INVÁLIDO!");
                }else{
                request.setAttribute("msg", "CNPJ INVÁLIDO!");
                }
                RequestDispatcher view = request
                        .getRequestDispatcher("/inserir.jsp");
                view.forward(request, response);
            }

        } else {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d = null;
            try {
                d = (new java.sql.Date(format.parse(request.getParameter("datacadastro")).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (request.getParameter("categoria").equalsIgnoreCase("Supermercado") && request.getParameter("telefone").isEmpty()) {
                request.setAttribute("msg", "O preenchimento do telefone é obrigatorio!");
                try {
                    estabelecimento = estC.getCodigo(Integer.parseInt(request.getParameter("codigo")));
                } catch (Exception ex) {
                    Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                RequestDispatcher view = request
                        .getRequestDispatcher("/inserir.jsp");
                request.setAttribute("est", estabelecimento);
                view.forward(request, response);
            } else {

                estabelecimento.setRazaosocial(request.getParameter("razaosocial"));
                estabelecimento.setNomefantasia(request.getParameter("nomefantasia"));
                estabelecimento.setCnpj(request.getParameter("cnpj"));
                estabelecimento.setEmail(request.getParameter("email"));
                estabelecimento.setEndereco(request.getParameter("endereco"));
                estabelecimento.setCidade(request.getParameter("cidade"));
                estabelecimento.setEstado(request.getParameter("estado"));
                estabelecimento.setTelefone(request.getParameter("telefone"));
                estabelecimento.setDatacadastro((java.sql.Date) d);
                estabelecimento.setCategoria(request.getParameter("categoria"));
                estabelecimento.setStatus(request.getParameter("status"));
                estabelecimento.setAgencia(request.getParameter("agencia"));
                estabelecimento.setConta(request.getParameter("conta"));

                if (request.getParameter("codigo").isEmpty()) {
                    try {
                        estC.cadastrar(estabelecimento);
                        request.setAttribute("msg", EstabelecimentoController.msg);
                    } catch (Exception ex) {
                        Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        estC.alterar(estabelecimento, Integer.parseInt(request.getParameter("codigo")));
                        //
                        request.setAttribute("msg", EstabelecimentoController.msg);

                    } catch (Exception ex) {
                        Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                request.setAttribute("est", estabelecimento);
                view.forward(request, response);
            }
        }
    }
}
