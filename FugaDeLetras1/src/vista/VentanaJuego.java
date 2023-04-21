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
import java.util.concurrent.TimeUnit;
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
    private JButton jOpcion1, jOpcion2, jOpcion3, jOpcion4, jOpcion5, jContinuar;
    private JLabel jlNombreJugador;
    private JLabel jlIntentosFallidos;
    private JLabel jlFallos;
    private JLabel jlIntentosAciertos;
    private JLabel jlAciertos;
    private String nombreJugador;
    private int posicionActual;
    private int idTematica;
    private int aciertos;
    private int intentosFail;
    String palabraActual;
    modelo.Tematica palabras;
        
    public VentanaJuego(Jugador jugador, int idTematica){
       nombreJugador = jugador.getNombre();
       palabras = new Tematica();
       palabraActual = palabras.getPalabra(posicionActual,idTematica); 
       posicionActual = 0;
       this.idTematica = idTematica;
       iniciarComponentes();
       //System.out.println(posicionActual);
       //System.out.println(idTematica);
       aciertos = 0;
       intentosFail = 0;
     
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
        jlJugador.setBounds(12,0, 400,30);
        jlJugador.setForeground( Color.WHITE);
        jlJugador.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlJugador);
        
        
        jlNombreJugador = new JLabel(nombreJugador);
        jlNombreJugador.setBounds(80,0, 400,30);
        jlNombreJugador.setForeground( Color.WHITE);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlNombreJugador);
      
        jlIntentosFallidos = new JLabel("Intentos fallidos: ");
        jlIntentosFallidos.setBounds(12,233, 400,30);
        jlIntentosFallidos.setForeground( Color.RED);
        jlIntentosFallidos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlIntentosFallidos);

        jlFallos = new JLabel(String.valueOf(intentosFail));
        jlFallos.setBounds(133,233, 400,30);
        jlFallos.setForeground( Color.WHITE);
        jlFallos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlFallos);
        
        jlIntentosAciertos = new JLabel("Aciertos: ");
        jlIntentosAciertos.setBounds(160,233, 400,30);
        jlIntentosAciertos.setForeground( Color.YELLOW);
        jlIntentosAciertos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlIntentosAciertos);

        jlAciertos = new JLabel(String.valueOf(intentosFail));
        jlAciertos.setBounds(226,233, 400,30);
        jlAciertos.setForeground( Color.WHITE);
        jlAciertos.setFont(new Font("arial", Font.BOLD, 15));
        jpContenido.add(jlAciertos);
        
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
        

        
        jOpcion1 = new JButton("a");
        jOpcion1.setBounds(70,140, 50,50);
        jpContenido.add(jOpcion1);
        
        jOpcion2 = new JButton("e");
        jOpcion2.setBounds(146,140, 50,50);
        jpContenido.add(jOpcion2);
        
        jOpcion3 = new JButton("i");
        jOpcion3.setBounds(222 ,140, 50,50);
        jpContenido.add(jOpcion3);

        jOpcion4 = new JButton("o");
        jOpcion4.setBounds(298,140, 50,50);
        jpContenido.add(jOpcion4);    
        
        jOpcion5 = new JButton("u");
        jOpcion5.setBounds(374,140, 50,50);
        jpContenido.add(jOpcion5);
        
        jContinuar = new JButton("Continuar");
        jContinuar.setBounds(374,200, 100,50);
        //jpContenido.add(jContinuar);
        
        System.out.println(nombreJugador);
        
        ManejadorDeEventos manejadorEventos = new VentanaJuego.ManejadorDeEventos();
        
        jOpcion1.addActionListener(manejadorEventos);
        jOpcion2.addActionListener(manejadorEventos);
        jOpcion3.addActionListener(manejadorEventos);
        jOpcion4.addActionListener(manejadorEventos);
        jOpcion5.addActionListener(manejadorEventos);
        jContinuar.addActionListener(manejadorEventos);
         //no funciona del todo bien, ni idea de porqué
    }
    
    private void siguientePalabra(){
       posicionActual++;
       jlPalabra.setText(palabras.getPalabra(posicionActual,idTematica));
    }    
    
    private void checkerOpcion(String botonAnalizar){
       modelo.Tematica palabras = new Tematica();
       //String palabraActual = palabras.getPalabra(posicionActual,idTematica); 
       
       String palabraRevisada = palabras.concatenar(posicionActual, idTematica);
       char cadenaRevisar = palabras.getChar(posicionActual, idTematica);
       int posicionRevisar = palabras.posicionLetra(posicionActual,idTematica);
       char letraBoton = (botonAnalizar.toCharArray())[0];
       
       if(letraBoton == cadenaRevisar){
           
            if(posicionActual <= palabras.getLength(idTematica)-1){
                
                System.out.println( "Posicion Actual: "+ posicionActual);
                jlPalabra.setText(palabraRevisada);
                System.out.println("Posicion Actual: " + posicionActual);
                System.out.println("Tematica: " + idTematica);
                System.out.println("Palabra Actual: " + palabraActual);
                System.out.println("Palabra Revisada: " + palabraRevisada);
                aciertos++;
                jpContenido.add(jContinuar);
                jpContenido.revalidate();
                jpContenido.repaint();
                //aquí iría el método que verificaría si es la opción correcta
                //Jugador jugador = new Jugador(super.savedNombre); 
                //VentanaJuego ventanaJuego = new VentanaJuego(jugador);
                
            } else {
                jlPalabra.setText(palabraRevisada);
                aciertos++;
                JOptionPane.showMessageDialog(null,"El juego ha terminado", 
                    "GAME OVER", JOptionPane.ERROR_MESSAGE);
              }
       }else{
            JOptionPane.showMessageDialog(null,"¡Vocal equivocada! vuelve a intentarlo", 
              "¡Oops!", JOptionPane.ERROR_MESSAGE);
            System.out.println("Boton: " + letraBoton);
            System.out.println("Letra respuesta: " + cadenaRevisar);
            intentosFail++;
             }
    }
    

    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            String botonAnalizar;
            if(evento.getSource() == jOpcion1){
                botonAnalizar = jOpcion1.getText();
                checkerOpcion(botonAnalizar);
                jlFallos.setText(String.valueOf(intentosFail));
                jlAciertos.setText(String.valueOf(aciertos));
                
            } else if (evento.getSource() == jOpcion2){
                botonAnalizar = jOpcion2.getText();
                checkerOpcion(botonAnalizar);
                jlFallos.setText(String.valueOf(intentosFail));
                jlAciertos.setText(String.valueOf(aciertos));
               //posicionActual++;
               //jlPalabra.setText(palabras.getPalabra(posicionActual,idTematica));
               //aquí iría el método que verificaría si es la opción correcta
               //Jugador jugador = new Jugador(super.savedNombre); 
               //VentanaJuego ventanaJuego = new VentanaJuego(jugador); 
            } else if (evento.getSource() == jOpcion3){
                botonAnalizar = jOpcion3.getText();
                checkerOpcion(botonAnalizar);
                jlFallos.setText(String.valueOf(intentosFail));
                jlAciertos.setText(String.valueOf(aciertos));
            } else if (evento.getSource() == jOpcion4){
                botonAnalizar = jOpcion4.getText();
                checkerOpcion(botonAnalizar);
                jlFallos.setText(String.valueOf(intentosFail));
                jlAciertos.setText(String.valueOf(aciertos));
            } else if (evento.getSource() == jOpcion5){
                botonAnalizar = jOpcion5.getText();
                checkerOpcion(botonAnalizar);
                jlFallos.setText(String.valueOf(intentosFail));
                jlAciertos.setText(String.valueOf(aciertos));
            } else if (evento.getSource() == jContinuar){
                siguientePalabra();
                jpContenido.remove(jContinuar);
                jpContenido.revalidate();
                jpContenido.repaint();
            }
        }
    }
} 