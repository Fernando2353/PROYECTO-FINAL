/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelcatalan
 */
public class LibroDB {
    
    Connection conn;
    
    public LibroDB() {
        conn = ConexionBD.getConnection();
    }
    
    public void create(Libro e) {
        
    PreparedStatement st = null;
    
        try {
            String sql = """
                         INSERT INTO libro (ISBN, titulo, autor, anopublicacion, editorial, cantidaddisp) 
                                            VALUES (?, ?, ?, ?, ?, ?)
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, e.getISBN());
            st.setString(2, e.getAutor());
            st.setInt(3, e.getAnopublicacion());
            st.setString(4, e.getEditorial());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void actualizar(Libro e) {
            PreparedStatement st = null;
    
        try {
            String sql = """
                         UPDATE Libro SET titulo = ?, autor = ?, anopublicacion = ?, editorial = ?, cantidaddis = ?
                                            WHERE ISBN = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, e.getTitulo());
            st.setString(2, e.getAutor());
            st.setInt(3, e.getAnopublicacion());
            st.setString(4, e.getEditorial());
            st.setInt(5, e.getCantidaddis());
            st.setString(6, e.getISBN());
            
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminar(String ISBN) {
            PreparedStatement st = null;
    
        try {
            String sql = """
                         DELETE FROM Libro 
                         WHERE ISBN = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, ISBN);
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Libro read(String ISBN) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Libro e = new Libro();
        
        try {
            String sql = """
                         SELECT * 
                         FROM Libro 
                         WHERE ISBN = ?
                         """;
            st = conn.prepareStatement(sql);
            st.setString(1, ISBN);
            rs = st.executeQuery();
            
            while (rs.next()) {
                e.setISBN(rs.getString(1));
                e.setTitulo(rs.getString(2));
                e.setAutor(rs.getString(3));
                e.setAnopublicacion(rs.getInt(4));
                e.setEditorial(rs.getString(5));
                e.setCantidaddis(rs.getInt(6));
                
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    public ArrayList<Libro> obtenerTodos() {
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Libro> a = new ArrayList();
        
        try {
            String sql = """
                         SELECT * 
                         FROM Libro 
                         """;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Libro e = new Libro();
                
                e.setISBN(rs.getString(1));
                e.setTitulo(rs.getString(2));
                e.setAutor(rs.getString(3));
                e.setAnopublicacion(rs.getInt(4));
                e.setEditorial(rs.getString(5));
                e.setCantidaddis(rs.getInt(6));
                
                a.add(e);
            }
            
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibroDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
}
