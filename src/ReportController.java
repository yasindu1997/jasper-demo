import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.HashMap;

public class ReportController {
    public void printReport() {
        try {
            InputStream is = getClass().getResourceAsStream("Customer_Report.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);
            HashMap hs = new HashMap();
            hs.put("role", "ADMIN");
            hs.put("status", "ACTIVE");

            JasperPrint jp = JasperFillManager.fillReport(jr, hs, DBConnection.getConnection());
            JasperViewer.viewReport(jp, false);
//            JasperPrintManager.printReport(jp, false);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
