    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Map;
import java.util.HashMap;
import modelo.Tematica;
import modelo.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    private JLabel jlIlustracion;
    private JPanel jpContenido, jpRectanguloColor;   
    private JButton jOpcion1, jOpcion2, jOpcion3, jOpcion4, jOpcion5, jTerminar;
    private JLabel jlNombreJugador; 
    private JLabel jlContadorAciertos,jlContadorFallos;
    private String nombreJugador;
    private int posicion;
    private int idTematica;
    private char[] vocales = {'a', 'e', 'i', 'o', 'u'};
    private String[] animalesImg = {"img/animales/leon.png", "img/animales/perro.png",
        "img/animales/gato.png", "img/animales/tigre.png", "img/animales/hormiga.png", "img/animales/tortuga.png",
        "img/animales/vaca.png", "img/animales/raton.png", "img/animales/conejo.png", "img/animales/pato.png"};
    private String[] frutasImg = {"img/frutas/manzana.png", "img/frutas/pera.png", "img/frutas/uva.png", 
        "img/frutas/banano.png", "img/frutas/durazno.png", "img/frutas/fresa.png", "img/frutas/melon.png", 
        "img/frutas/cereza.png", "img/frutas/mango.png", "img/frutas/ciruela.png"};
    private HashMap<Integer, String> imagenesPrint = new HashMap<>();
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
       HashmapImagenes();
       ColocarImagenes();
        System.out.println(posicion);
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
        
//{"Rojo","Amarillo","Naranja","Verde","Rosa","Negro", "Morado", "Azul","Gris", "Blanco"       
        private void CambiaColor(int color){
            jpContenido.add(jpRectanguloColor);
            switch(color){
                case 0:
                    jpRectanguloColor.setBackground(Color.RED);
                    break;
                case 1:
                    jpRectanguloColor.setBackground(Color.YELLOW);
                    break;
                case 2:
                    jpRectanguloColor.setBackground(Color.ORANGE);
                    break;
                case 3:
                    jpRectanguloColor.setBackground(Color.GREEN);
                    break;
                case 4:
                    jpRectanguloColor.setBackground(Color.MAGENTA);
                    break;
                case 5:
                    jpRectanguloColor.setBackground(Color.BLACK);
                    break;
                case 6:
                    jpRectanguloColor.setBackground(Color.MAGENTA);
                    break;
                case 7:
                    jpRectanguloColor.setBackground(Color.BLUE);
                    break;
                case 8:
                    jpRectanguloColor.setBackground(Color.GRAY);
                    break;
                case 9:
                    jpRectanguloColor.setBackground(Color.WHITE);
                    jlPalabra.setForeground(Color.BLACK);
                    break;
            }
            
        }

        private void HashmapImagenes(){//un hashmap, para cambiar facilmente al set de archivos de frutas o animales         
            switch (idTematica) {
                case 1:
                    for(int i = 0; i < palabras.getLength(idTematica); i++){
                        imagenesPrint.put(i, animalesImg[i]);
                        System.out.println(imagenesPrint.get(i)); 
                    }
                    break;
                case 3:
                    for(int i = 0; i < palabras.getLength(idTematica); i++){
                        imagenesPrint.put(i, frutasImg[i]);
                        System.out.println(imagenesPrint.get(i));
                    }
                    break;
                default:
                    System.out.println("Colores"); 
                    break;
            }
        }
        
        private void ColocarImagenes(){
            switch(idTematica){
                case 1: case 3://ya con el hashmap aquí cambia a frutas o animales, según ese anterior método
                    ImageIcon imagen = new ImageIcon(imagenesPrint.get(posicion));
                    Image imagenTransformar = imagen.getImage();//un ImageIcon, que se transforma con getImage para darle un tamaño moderado y poner la imagen en en el canvas
                    Image nuevaImagen = imagenTransformar.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
                    imagen = new ImageIcon(nuevaImagen);
                    jlIlustracion = new JLabel(imagen); //un jlabel en donde ponemos la imagen ImageIcon
                    jlIlustracion.setBounds(115,74, 60,60);
                    jpContenido.add(jlIlustracion);    
                    //return palabrasAnimales.length-1;
                    break;
                case 2:
                    CambiaColor(posicion);
                    break;
            }               
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
        
        jpRectanguloColor = new JPanel();
        jpRectanguloColor.setSize(519,35);        
        jpRectanguloColor.setBounds(0,77, 519, 35);
        jpRectanguloColor.setLayout(null);
        //jpRectanguloColor.setBackground(Color.RED);
        //jpContenido.add(jpRectanguloColor);
        
        jTerminar = new JButton("Terminar ...");
        jTerminar.setBounds(374,200, 100,50);
        jpContenido.add(jTerminar);
        
        
        System.out.println(nombreJugador);
        
        ManejadorDeEventos manejadorEventos = new VentanaJuego.ManejadorDeEventos();
        
        jOpcion1.addActionListener(manejadorEventos);
        jOpcion2.addActionListener(manejadorEventos);
        jOpcion3.addActionListener(manejadorEventos);
        jOpcion4.addActionListener(manejadorEventos);
        jOpcion5.addActionListener(manejadorEventos);
        jTerminar.addActionListener(manejadorEventos);
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                CerrarVentana();
            }
        });
    }
     
        
    private void VocalCorrecta(){
        if(idTematica != 2){
            jpContenido.remove(jlIlustracion);
        }
        jlPalabra.setText(palabra);
        JOptionPane.showMessageDialog(null, "Es la vocal correcta");
        IniciarJuego();
        ColocarImagenes();
        jlPalabra.setText(palabraCensurada);
        contadorAciertos++;
        jlContadorAciertos.setText("Aciertos: " + String.valueOf(contadorAciertos));
        jpContenido.revalidate();
        jpContenido.repaint(); 
    }    

    private void TerminarJuego () {
        if (contadorFallos == 5){
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(
                    null,"Se han acabado tus oportunidades, ¿deseas volver a empezar?", "GAME OVER",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION){
                VentanaEstadisticas ventanaEstadistica = new VentanaEstadisticas(contadorAciertos,contadorFallos,nombreJugador);
                VentanaNombre ventana = new VentanaNombre();
                dispose();
        }   else {
            VentanaEstadisticas ventana = new VentanaEstadisticas(contadorAciertos,contadorFallos,nombreJugador);
             //System.exit(0);
            }
        }   
    }
    
    private void CerrarVentana(){
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente desea abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            VentanaEstadisticas ventana = new VentanaEstadisticas(contadorAciertos,contadorFallos,nombreJugador);
            dispose();
            //System.exit(0);
        }
    }
        
    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            
            if(evento.getSource() == jOpcion1 && vocalCensurada == 'a'){
                VocalCorrecta();
               
            } else if (evento.getSource() == jOpcion2 && vocalCensurada == 'e' ){
                VocalCorrecta();
               
            } else if (evento.getSource() == jOpcion3 && vocalCensurada == 'i'){
                VocalCorrecta();
               
            } else if (evento.getSource() == jOpcion4 && vocalCensurada == 'o'){
                VocalCorrecta();
                
            } else if (evento.getSource() == jOpcion5 && vocalCensurada == 'u'){
                VocalCorrecta();
               
            } else if (evento.getSource() == jTerminar){
                CerrarVentana();
            
            } else {
                JOptionPane.showMessageDialog(null, "Es la vocal incorrecta, intenta de nuevo");
                contadorFallos++;
                jlContadorFallos.setText("Fallos: " + String.valueOf(contadorFallos));
                TerminarJuego();
            }  
        }
        
    }
    
} 