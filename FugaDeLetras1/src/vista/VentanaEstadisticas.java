/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Tematica;
import modelo.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author Juanjo
 */

public class VentanaEstadisticas extends JFrame {
    private JLabel jlContadorAciertos,jlContadorFallos, jlEstadistica, jlPalabras;
    private int contadorAciertos,contadorFallos, porcentajeAcierto, porcentajeFallos;
    private JPanel jpContenido;   
    private String nombreJugador;
    
    public VentanaEstadisticas(int contadorAciertos, int contadorFallos, String nombreJugador){
        this.contadorAciertos = contadorAciertos;
        this.contadorFallos = contadorFallos;
        this.nombreJugador = nombreJugador;
        calcularAcierto();
        calcularFallos();
        iniciarComponentes();
        //System.out.println(contadorAciertos);
    }
    
        private void calcularAcierto(){
            if(contadorAciertos != 0 || contadorFallos != 0){
                porcentajeAcierto = (contadorAciertos*100)/(contadorAciertos+contadorFallos);
            } else porcentajeAcierto = 0;      
        }
        
        private  void calcularFallos(){
            if(contadorAciertos != 0 || contadorFallos != 0){
                porcentajeFallos = (contadorFallos*100)/(contadorAciertos+contadorFallos);
            } else porcentajeFallos = 0;      
        }
    
        private void iniciarComponentes() {
        
        
           
        setTitle("Estadisticas de juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(519,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
        jpContenido = new JPanel();
        jpContenido.setSize(519,300);        
        jpContenido.setBounds(0,0, 519, 300);
        jpContenido.setLayout(null);
        jpContenido.setBackground(Color.PINK);
        add(jpContenido);
        
        jlEstadistica = new JLabel("Resumen de juego de " + nombreJugador + ":");
        jlEstadistica.setBounds(10,5, 400,30);
        jlEstadistica.setForeground( Color.WHITE);
        jlEstadistica.setFont(new Font("arial", Font.BOLD, 25));
        jpContenido.add(jlEstadistica);
        
        
        jlContadorAciertos = new JLabel("Cantidad de aciertos: " + contadorAciertos +  " (" + porcentajeAcierto + "%).");
        jlContadorAciertos.setBounds(20,70, 400,30);
        jlContadorAciertos.setForeground( Color.WHITE);
        jlContadorAciertos.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlContadorAciertos);
        
        jlContadorFallos = new JLabel("Cantidad de fallos: " + contadorFallos + " (" + porcentajeFallos + "%).");
        jlContadorFallos.setBounds(20,120, 400,30);
        jlContadorFallos.setForeground( Color.WHITE);
        jlContadorFallos.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlContadorFallos);
        
        jlPalabras = new JLabel("Palabras desplegadas: " + contadorAciertos + ".");
        jlPalabras.setBounds(20,170, 400,30);
        jlPalabras.setForeground( Color.WHITE);
        jlPalabras.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlPalabras);

    }
}
