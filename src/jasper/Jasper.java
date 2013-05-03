/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author inoue
 */
public class Jasper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // iReportで作成したjrxmlファイルへのパス
        String jrxmlPath = "./jasperreports/report1.jrxml";

        // 出力するPDFファイルのパス
        String PdfPath = "./t.pdf";

        //Connection con = null;

    try{
        // ＰＤＦで出力
        // (1-1）jrxmlファイルをjasperファイルへコンパイル
        JasperReport jasper = JasperCompileManager.compileReport(jrxmlPath);

        // (1-2）jrxmlファイルをコンパイルせず、iReportでコンパイルして作られたjasperファイルのパスを指定
        //String jasper = "./Template/Rep_売上帳.jasper";

        //（2）パラメータの生成（今回は使わないのでコメントアウトデータのバインド時はnullを転送します）
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("TextTitle", "dfdfdfd");

        // (3）データソースの生成
        //Class.forName("com.mysql.jdbc.Driver");
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohsaki", "root","root");

        // (4）データの動的バインド
        JasperPrint print = JasperFillManager.fillReport(jasper, paramMap, new JREmptyDataSource());

        // (5）PDFへ出力
        JasperExportManager.exportReportToPdfFile(print, PdfPath);

    }catch (Exception ex) {
        ex.printStackTrace();
   }
    }
}
