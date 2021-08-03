import com.dropbox.core.DbxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static JSP.Constants.COPY_PATH;
import static JSP.Constants.DIR_NAME;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BaseDBApiImplementation.delete(DIR_NAME);
        } catch (DbxException e) {
            e.printStackTrace();
        }

        try {
            BaseDBApiImplementation.delete(COPY_PATH);
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }
}
