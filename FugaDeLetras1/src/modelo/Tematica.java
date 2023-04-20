/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Juanjo
 */
public class Tematica {
    private String[] palabrasFrutas ={"Manzana","Pera","Uva","Banano","Durazno","Fresa","Melón", "Cereza", "Mango", "Ciruela"};
    private String[] palabrasColores ={"Rojo","Amarillo","Naranja","Verde","Rosa","Negro", "Morado", "Azul","Gris", "Blanco"};
    private String[] palabrasAnimales ={"Leon","Perro","Gato","Tigre","Hormiga","Tortuga", "Vaca", "Raton", "Conejo", "Pato"};

    public Tematica() {
        
    }
    
    public int getLength(int modo){
        switch (modo) {
            case 1:
                return palabrasAnimales.length-1;
            case 2:
                return palabrasColores.length-1;
            case 3:
                return palabrasFrutas.length-1;
            default:
                return 0;
        }
        
    }
    
    public String getPalabra(int posicion,int modo){
        return switch (modo) {
            case 1 -> palabrasAnimales[posicion];
            case 2 -> palabrasColores[posicion];
            case 3 -> palabrasFrutas[posicion];
            default -> null;
        };
    }
    
   
    
}
