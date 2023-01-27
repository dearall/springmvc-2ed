package org.sansovo.demo.springmvc.chapter02.filter;

import org.sansovo.demo.springmvc.chapter02.action.SaveProductAction;
import org.sansovo.demo.springmvc.chapter02.form.ProductForm;
import org.sansovo.demo.springmvc.chapter02.model.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;

@WebFilter(filterName = "DispatcherFilter",
        urlPatterns = { "/*" })
public class DispatcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, for
         * example /appdesign2/input-product. However, in the
         * case of a default context, the context name is empty,
         * and uri has this form /resourceName, e.g.:
         * /input-product
         */
        // action processing
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String dispatchUrl = null;
        if ("input-product".equals(action)) {
            // do nothing
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else if ("save-product".equals(action)) {
            // create form
            ProductForm productForm = new ProductForm();
            // populate action properties
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(
                    request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            
            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(new BigDecimal(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            // execute action method
            SaveProductAction saveProductAction = 
                    new SaveProductAction();
            saveProductAction.save(product);
            
            // store model in a scope variable for the view
            request.setAttribute("product", product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }
        // forward to a view
        if (dispatchUrl != null) {
            RequestDispatcher rd = request
                    .getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        } else {
            // let static contents pass
            filterChain.doFilter(request, response);
        }
    }
}