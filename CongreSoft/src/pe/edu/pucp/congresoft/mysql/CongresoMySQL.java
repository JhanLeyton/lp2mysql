package pe.edu.pucp.congresoft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;

/**
 *
 * @author Jhan Leyton
 */
public class CongresoMySQL implements CongresoDAO {

    @Override
    public int insertar(Congreso congreso) {
        try{
            //Registrar el JAR de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer una conexión a la BD
            Connection con = DriverManager.
          getConnection("jdbc:mysql://"+
         "lp2mysql1.cqucq8j60l7z.us-east-1.rds.amazonaws.com"+
                  ":3306/inf282", "admin", "abcd1234");
            //Ejecutar una sentencia
            String sentencia = "INSERT INTO CONGRESO(NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO) VALUES('HCI INTERNATIONAL 2020','2020-07-19','2020-07-24','DINAMARCA',1);";
            Statement st = con.createStatement();
            //executeQuery -> SELECT
            //executeUpdate -> INSERT, UPDATE, DELETE
            int rs = st.executeUpdate(sentencia);
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Congreso> listar() {
        ArrayList<Congreso> congresos = new ArrayList<>();
        try{
            //Registrar el JAR de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer una conexión a la BD
            Connection con = DriverManager.
          getConnection("jdbc:mysql://"+
         "lp2mysql1.cqucq8j60l7z.us-east-1.rds.amazonaws.com"+
                  ":3306/inf282", "admin", "abcd1234");
            //Ejecutar una sentencia
            String sentencia = "SELECT * FROM CONGRESO";
            Statement st = con.createStatement();
            //executeQuery -> SELECT
            //executeUpdate -> INSERT, UPDATE, DELETE
            ResultSet rs = st.executeQuery(sentencia);
            while(rs.next()){
                Congreso congreso = new Congreso();
                congreso.setID(rs.getInt("ID_CONGRESO"));
                congreso.setNombre(rs.getString("NOMBRE"));
                congreso.setFechaFin(rs.getDate("FECHA_FIN"));
                congreso.setFechaIni(rs.getDate("FECHA_INICIO"));
                congreso.setPais(rs.getString("PAIS"));
                congreso.setEstado(rs.getInt("ACTIVO"));
                congresos.add(congreso);
            }
            //cerrar conexion
            con.close();
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return congresos;
    }
    
}
