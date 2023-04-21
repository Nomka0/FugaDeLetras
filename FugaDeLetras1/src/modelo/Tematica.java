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
    private String[] palabrasFrutas ={"M_nzana","Per_","Uv_","B_nano","D_razno","Fr_sa"};
    private String[] palabrasColores ={"Roj_","Amar_llo","Nar_nja","Verd_","Ros_","N_gro"};
    private String[] palabrasAnimales ={"Le_n","P_rro","G_to","Tigr_","Hormig_","Tortug_"};
    
    private char[] respuestasAnimales ={'o','e','a','e','a','a'};
    private char[] respuestasColores ={'o','i','a','e','a','e'};
    private char[] respuestasFrutas ={'a','a','a','a','u','e'};
    
    
   
    
    public int posicionLetra(int posicion,int modo){
        String palabraAnalizada = getPalabra(posicion,modo);
        int aux = 0;
        char[] cadenaLetras =palabraAnalizada.toCharArray();
        for(int i = 0; i < palabraAnalizada.length()-1; i++){
            if(cadenaLetras[i] == '_'){
                aux = i;
            }
        }
        return aux;
    }
    public String concatenar(int posicion,int modo){
        String palabraAnalizada = getPalabra(posicion,modo);
        char[] cadenaLetras =palabraAnalizada.toCharArray();
        for(int i = 0; i < palabraAnalizada.length(); i++){
            if(cadenaLetras[i] == '_'){
                cadenaLetras[i] = getChar(posicion,modo);
            }
        }
        return String.valueOf(cadenaLetras);
    }
    
    public Tematica() {
        
    }
    
    public char getChar(int posicion, int modo){
        return switch (modo) {
            case 1 -> respuestasAnimales[posicion]; //aquí coloqué "-1", pero es porque siempre se va al caso default, en lugar de al q le corresponde
            case 2 -> respuestasColores[posicion];
            case 3 -> respuestasFrutas[posicion];
            default -> 'a';
        };
    }
    
    public int getLength(int modo){
        return switch (modo) {
            case 1 -> palabrasAnimales.length-1;
            case 2 -> palabrasColores.length-1;
            case 3 -> palabrasFrutas.length-1;
            default -> 0;
        };
        
    }
    
    public String getPalabra(int posicion,int modo){
        return switch (modo) {
            case 1 -> palabrasAnimales[posicion]; //aquí coloqué "-1", pero es porque siempre se va al caso default, en lugar de al q le corresponde
            case 2 -> palabrasColores[posicion];
            case 3 -> palabrasFrutas[posicion];
            default -> null;
        };
    }
    
    
    /**
    public void verificaPalabra(int modo){
        if(modo == 1){
            for(int i = 0; i < palabrasFrutas.length-1;i++){
                
            }   
        }
    
        

    }*/
    
}
