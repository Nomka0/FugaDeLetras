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
            case 1 -> palabrasAnimales[posicion-1]; //aquí coloqué "-1", pero es porque siempre se va al caso default, en lugar de al q le corresponde
            case 2 -> palabrasColores[posicion-1];
            case 3 -> palabrasFrutas[posicion-1];
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
