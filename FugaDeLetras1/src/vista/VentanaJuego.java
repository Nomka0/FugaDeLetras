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
public class VentanaJuego extends JFrame{
    
    private JLabel jlPalabra;
    private JLabel jlJugador;
    private JLabel jlConsigna;
    private JPanel jpContenido;   
    private JButton jOpcion1, jOpcion2, jOpcion3, jOpcion4, jOpcion5, jOpcion6;
    private JLabel jlNombreJugador;
    private JLabel jlContadorAciertos,jlContadorFallos;
    private String nombreJugador;
    private int posicion;
    private int idTematica;
    private char[] vocales = {'a', 'e', 'i', 'o', 'u'};
    private String palabraCensurada;
    private char vocalCensurada;
    modelo.Tematica palabras = new Tematica();
    Random random = new Random();
    private String palabra;
    private int contadorAciertos,contadorFallos = 0;
        
    public VentanaJuego(Jugador jugador, int idTematica){
       nombreJugador = jugador.getNombre();
       this.idTematica = idTematica;
       IniciarJuego();
       iniciarComponentes();
    }
    
    private void IniciarJuego () {
        posicion = random.nextInt(9);
        CensurarPalabra(); 
        
    }
        private void CensurarPalabra(){
        palabra = palabras.getPalabra(posicion,idTematica);
        vocalCensurada = vocales[random.nextInt(vocales.length)];
        if(palabra.indexOf(vocalCensurada) != -1 ){
        palabraCensurada = palabra.replace(vocalCensurada, '_');}
        else {
            CensurarPalabra();
        }
        System.out.println(palabraCensurada);
        }
    
        private void iniciarComponentes() {
            
        
        
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
        
        jlContadorAciertos = new JLabel("Aciertos: " + String.valueOf(contadorAciertos));
        jlContadorAciertos.setBounds(2,235, 400,30);
        jlContadorAciertos.setForeground( Color.WHITE);
        jlContadorAciertos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlContadorAciertos); 
        
        jlContadorFallos = new JLabel("Fallos: " + String.valueOf(contadorFallos));
        jlContadorFallos.setBounds(200,235, 400,30);
        jlContadorFallos.setForeground( Color.WHITE);
        jlContadorFallos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlContadorFallos);    
        
        jlConsigna = new JLabel("¿Qué vocal falta en la siguiente palabra?:",SwingConstants.CENTER);
        jlConsigna.setBounds(55,40, 400,30);
        jlConsigna.setForeground(Color.WHITE);
        jlConsigna.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlConsigna);
        
        jlPalabra = new JLabel(palabraCensurada,SwingConstants.CENTER);
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
        jOpcion4.addActionListener(manejadorEventos);
        jOpcion5.addActionListener(manejadorEventos);
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
    }
        
    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            
            if(evento.getSource() == jOpcion1 && vocalCensurada == 'a'){
               jlPalabra.setText(palabra);
               JOptionPane.showMessageDialog(null, "Es la vocal correcta");
               IniciarJuego();
               jlPalabra.setText(palabraCensurada);
               contadorAciertos++;
               jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
               
            } else if (evento.getSource() == jOpcion2 && vocalCensurada == 'e' ){
               jlPalabra.setText(palabra);
               JOptionPane.showMessageDialog(null, "Es la vocal correcta"); 
               IniciarJuego();
               jlPalabra.setText(palabraCensurada);
               contadorAciertos++;
               jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
               
            } else if (evento.getSource() == jOpcion3 && vocalCensurada == 'i'){
               jlPalabra.setText(palabra);
               JOptionPane.showMessageDialog(null, "Es la vocal correcta"); 
               IniciarJuego();
               jlPalabra.setText(palabraCensurada);
               contadorAciertos++;
               jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
               
            } else if (evento.getSource() == jOpcion4 && vocalCensurada == 'o'){
               jlPalabra.setText(palabra);
                JOptionPane.showMessageDialog(null, "Es la vocal correcta");    
                IniciarJuego();
                jlPalabra.setText(palabraCensurada);
                contadorAciertos++;
                jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
                
            } else if (evento.getSource() == jOpcion5 && vocalCensurada == 'u'){
               jlPalabra.setText(palabra);
               JOptionPane.showMessageDialog(null, "Es la vocal correcta");    
               IniciarJuego();
               jlPalabra.setText(palabraCensurada);
               contadorAciertos++;
               jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
               
            } else {
                JOptionPane.showMessageDialog(null, "Es la vocal incorrecta, intenta de nuevo");
                contadorFallos++;
                jlContadorFallos.setText("Fallos: " + String.valueOf(contadorFallos));
                TerminarJuego();
            }  
        }
        
    }
    
    
    private void TerminarJuego () {
    if (contadorFallos == 5){
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(
                    null,"Se han acabado tus oportunidades, ¿deseas volver a empezar?", "GAME OVER",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            VentanaNombre ventana = new VentanaNombre();
            dispose();
        } else {
             System.exit(0);
        }
    }
        
    }
    
    
    

    
    private void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
} 
