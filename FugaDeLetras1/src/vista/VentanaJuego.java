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
public class VentanaJuego extends JFrame{
    
    private JLabel jlPalabra;
    private JLabel jlJugador;
    private JLabel jlConsigna;
    private JPanel jpContenido;   
    private JButton jOpcion1, jOpcion2, jOpcion3, jOpcion4, jOpcion5;
    private JLabel jlNombreJugador;
    private String nombreJugador;
    private int posicionActual;
    private int idTematica;
        
    public VentanaJuego(Jugador jugador, int idTematica){
       nombreJugador = jugador.getNombre();
       iniciarComponentes();
       posicionActual = 0;
       this.idTematica = idTematica;
    }
    
        private void iniciarComponentes() {
            
        modelo.Tematica palabras = new Tematica();
        
        setTitle("Fuga de Letras");
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
        
        jlJugador = new JLabel("Jugador: ");
        jlJugador.setBounds(2,0, 400,30);
        jlJugador.setForeground( Color.WHITE);
        jlJugador.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlJugador);
        
        
        jlNombreJugador = new JLabel(nombreJugador);
        jlNombreJugador.setBounds(70,0, 400,30);
        jlNombreJugador.setForeground( Color.WHITE);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlNombreJugador);

        
        jlConsigna = new JLabel("¿Qué letra falta en la siguiente palabra?:",SwingConstants.CENTER);
        jlConsigna.setBounds(55,40, 400,30);
        jlConsigna.setForeground(Color.WHITE);
        jlConsigna.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlConsigna);
        
        jlPalabra = new JLabel(palabras.getPalabra(posicionActual,idTematica),SwingConstants.CENTER);
        jlPalabra.setBounds(40,70, 440,50);
        jlPalabra.setForeground(Color.WHITE);
        jlPalabra.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlPalabra);
        

        
        jOpcion1 = new JButton("A");
        jOpcion1.setBounds(70,140, 50,50);
        jpContenido.add(jOpcion1);
        
        jOpcion2 = new JButton("E");
        jOpcion2.setBounds(146,140, 50,50);
        jpContenido.add(jOpcion2);
        
        jOpcion3 = new JButton("I");
        jOpcion3.setBounds(222 ,140, 50,50);
        jpContenido.add(jOpcion3);

        jOpcion4 = new JButton("O");
        jOpcion4.setBounds(298,140, 50,50);
        jpContenido.add(jOpcion4);    
        
        jOpcion5 = new JButton("U");
        jOpcion5.setBounds(374,140, 50,50);
        jpContenido.add(jOpcion5);
        
        System.out.println(nombreJugador);
        
        ManejadorDeEventos manejadorEventos = new VentanaJuego.ManejadorDeEventos();
        
        jOpcion1.addActionListener(manejadorEventos);
        jOpcion2.addActionListener(manejadorEventos);
        jOpcion3.addActionListener(manejadorEventos);
         //no funciona del todo bien, ni idea de porqué
    }
        
    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            
            modelo.Tematica palabras = new Tematica();
            
            if(evento.getSource() == jOpcion1){
               posicionActual++;
               if(posicionActual <= palabras.getLength(idTematica)){
                    System.out.println(posicionActual);
                    jlPalabra.setText(palabras.getPalabra(posicionActual,idTematica));
                    //aquí iría el método que verificaría si es la opción correcta
                    //Jugador jugador = new Jugador(super.savedNombre); 
                    //VentanaJuego ventanaJuego = new VentanaJuego(jugador);
               } else {
                    JOptionPane.showMessageDialog(null,"El juego ha terminado", 
                    "GAME OVER", JOptionPane.ERROR_MESSAGE);
                    

               }

               

            } else if (evento.getSource() == jOpcion2){
               posicionActual++;
               jlPalabra.setText(palabras.getPalabra(posicionActual,idTematica));
               //aquí iría el método que verificaría si es la opción correcta
               //Jugador jugador = new Jugador(super.savedNombre); 
               //VentanaJuego ventanaJuego = new VentanaJuego(jugador); 
            } else if (evento.getSource() == jOpcion3){
               posicionActual++;
               jlPalabra.setText(palabras.getPalabra(posicionActual,idTematica));
               //aquí iría el método que verificaría si es la opción correcta
               //Jugador jugador = new Jugador(super.savedNombre); 
               //VentanaJuego ventanaJuego = new VentanaJuego(jugador); 
            } else if (evento.getSource() == jOpcion4){
               //aquí iría el método que verificaría si es la opción correcta
               dispose();
            } else if (evento.getSource() == jOpcion5){
               //aquí iría el método que verificaría si es la opción correcta
               dispose();
            }  
        }
    }
} 