/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lfari
 */
public class ClienteDB {
    
    Connection conn;
    
    public ClienteDB() {
        conn = ConexionBD.getConnection();
    }
    
    public void create(Cliente e) {
        
    PreparedStatement st = null;
    try {
            String sql = """
                         INSERT INTO Cliente (identificacion, nombre, direccion, telefono) 
                                            VALUES (?, ?, ?, ?)
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, e.getIdentificacion());
            st.setString(2, e.getNombre());
            st.setString(3, e.getDireccion());
            st.setString(4, e.getTelefono());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
public void actualizar(Cliente e) {
            PreparedStatement st = null;
    
        try {
            String sql = """
                         UPDATE Cliente SET  nombre = ?, direccion = ?, telefono = ? 
                                            WHERE identificacion = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, e.getNombre());
            st.setString(2, e.getDireccion());
            st.setString(3, e.getTelefono());
            st.setString(4, e.getIdentificacion());
           
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
public void eliminar(String identificacion) {
            PreparedStatement st = null;
    
        try {
            String sql = """
                         DELETE FROM Cliente 
                         WHERE identificacion = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, identificacion);
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
public Cliente read(String identificacion) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente e = new Cliente();
        
        try {
            String sql = """
                         SELECT * 
                         FROM Cliente 
                         WHERE identificacion = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, identificacion);
            rs = st.executeQuery();
            
            while (rs.next()) {
                e.setIdentificacion(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setDireccion(rs.getString(3));
                e.setTelefono(rs.getString(4));
        
                
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

public ArrayList<Cliente> obtenerTodos() {
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Cliente> a = new ArrayList();
        
        try {
            String sql = """
                         SELECT * 
                         FROM Cliente 
                         """;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Cliente e = new Cliente();
                
                e.setIdentificacion(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setDireccion(rs.getString(3));
                e.setTelefono(rs.getString(5));
                
                a.add(e);
            }
            
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
}