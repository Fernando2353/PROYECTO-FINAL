/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Biblioteca;

import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author miguelcatalan
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LibroDB libroDb = new LibroDB();
      
        
        //Insertar registro
        Libro e1 = new Libro("0000001-01", "Blanca Nieves", "Guillermo del toro", 2000, "Sabantino", 25);
        libroDb.create(e1);
        System.out.println(e1);
        
        //Obtener un registro
        Libro e2 = libroDb.read("7590-23-100000");
        System.out.println(e2);
        
        //Actualizar registro
        e1.setTitulo("Blanca Nieves");
        libroDb.actualizar(e1);
        System.out.println("Se actualizó registro...");
        
        //Eliminar registro
        libroDb.eliminar("0000001-01");
        System.out.println("Se eliminó registro...");
        
        //Listar todos los registros
        ArrayList<Estudiante> a = libroDb.obtenerTodos();
        System.out.println(a.size());
*/
    }
    
}
