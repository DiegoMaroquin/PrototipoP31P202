/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.maestro;
import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class maestroDAO {

    private static final String SQL_SELECT = "SELECT id_maestro, nombre, edad,grado FROM maestro";
    private static final String SQL_INSERT = "INSERT INTO maestro(nombre, edad, grado) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestro SET nombre=?, edad=?, grado=? WHERE id_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestro WHERE id_appmaestro=?";
    private static final String SQL_QUERY = "SELECT id_maestro, nombre, edad, grado FROM maestro WHERE id_maestro = ?";

    public List<Vendedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_maestro = rs.getInt("id_maestro");
                String nombre = rs.getString("nombre");
                String edades = rs.getString("edad");
                 String clases = rs.getString("grado");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_maestro);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(edades);
               vendedor.setDireVendedor(clases);

                
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores;
    }

    public int insert(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getId_vendedor());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Vendedor query(Vendedor vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.getId_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_maestro");
                String nombre = rs.getString("nombre");
                String edades = rs.getString("edad");
                 String clases = rs.getString("grado");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(edades);
                  vendedor.setDireVendedor(clases);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vendedor;
    }
        
}
