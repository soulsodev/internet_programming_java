import com.dropbox.core.DbxException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static JSP.Constants.*;

@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {

    @Override
    public void init() {
        BaseDBApiImplementation.init();
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) {

        String task = req.getParameter("TASK");

        switch(task){
            case "1": {
                try {
                    BaseDBApiImplementation.createDirectory(DIR_NAME);
                } catch (DbxException e) {
                    e.printStackTrace();
                }
            }
                break;
            case "2": {
                try {
                    BaseDBApiImplementation.upload(LOCAL_FILE_PATH, FILE_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (DbxException e) {
                    e.printStackTrace();
                }
                }
                break;

            case "3":
                try {
                    BaseDBApiImplementation.download(FILE_PATH);
                } catch (DbxException e) {
                    e.printStackTrace();
                }
                break;

            case "4": {
                try {
                    System.out.println("FROM: " + FILE_PATH + ";" + "TO: " + COPY_PATH );
                    BaseDBApiImplementation.copyFile(FILE_PATH, COPY_PATH); //from, to
                } catch (DbxException e) {
                    e.printStackTrace();
                }
            }
                break;
            }
    }
}
