/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;


public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int anopublicacion;
    private String editorial;
    private int cantidaddis;

    public Libro(String ISBN, String titulo, String autor, int anopublicacion, String editorial, int cantidaddis) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacion = anopublicacion;
        this.editorial = editorial;
        this.cantidaddis = cantidaddis;
    }

    Libro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnopublicacion() {
        return anopublicacion;
    }

    public void setAnopublicacion(int anopublicacion) {
        this.anopublicacion = anopublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidaddis() {
        return cantidaddis;
    }

    public void setCantidaddis(int cantidaddis) {
        this.cantidaddis = cantidaddis;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", anopublicacion=" + anopublicacion + ", editorial=" + editorial + ", cantidaddis=" + cantidaddis + '}';
    }
    
}

