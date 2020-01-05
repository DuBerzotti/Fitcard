package beans;

import controller.CategoriaController;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

@WebServlet("/cadCat")
public class CatBean extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean editar = false;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        Categoria categoria = new Categoria();
        CategoriaController catC = new CategoriaController();

        String acao = request.getParameter("acao");

        if (acao.equalsIgnoreCase("delete")) {

            try {
                catC.excluirCategoria(Integer.parseInt(request.getParameter("codigo")));
                request.setAttribute("msg", CategoriaController.msg);
                RequestDispatcher view = request
                        .getRequestDispatcher("/categoria.jsp");
                request.setAttribute("cat", categoria);
                view.forward(request, response);

            } catch (Exception erro) {
                throw new RuntimeException("Erro: " + erro);
            }

        } else if (acao.equalsIgnoreCase("editar")) {

            try {
                editar = true;
                categoria = catC.getCatCodigo(Integer.parseInt(request.getParameter("codigo")));

                RequestDispatcher view = request
                        .getRequestDispatcher("/opCategoria.jsp");
                request.setAttribute("cat", categoria);
                view.forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(EstBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        Categoria categoria = new Categoria();
        CategoriaController catC = new CategoriaController();
        
        categoria.setCategoria(request.getParameter("categoria"));

        if (request.getParameter("codigo").isEmpty()) {
            try {
                
                catC.cadCategoria(categoria);
                request.setAttribute("msg", CategoriaController.msg);
                RequestDispatcher view = request.getRequestDispatcher("/categoria.jsp");
                request.setAttribute("cat", categoria);
                view.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(CatBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                catC.alterarCategoria(categoria, Integer.parseInt(request.getParameter("codigo")));
                request.setAttribute("msg", CategoriaController.msg);
                 RequestDispatcher view = request.getRequestDispatcher("/categoria.jsp");
                request.setAttribute("cat", categoria);
                view.forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(CatBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
