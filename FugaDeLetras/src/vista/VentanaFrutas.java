/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

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
public class VentanaFrutas extends JFrame{
   
    private JLabel jlPalabra;
    private JLabel jlConsigna;
    private JPanel jpContenido;   
    private JButton jOpcion1, jOpcion2, jOpcion3, jOpcion4;
    
    public VentanaFrutas(){
       iniciarComponentes();
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

        
        jlConsigna = new JLabel("¿Qué letra falta en la siguiente palabra?:",SwingConstants.CENTER);
        jlConsigna.setBounds(55,40, 400,30);
        jlConsigna.setForeground(Color.WHITE);
        jlConsigna.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlConsigna);
        
        jlPalabra = new JLabel("M_NZANA",SwingConstants.CENTER);
        jlPalabra.setBounds(40,70, 440,50);
        jlPalabra.setForeground(Color.WHITE);
        jlPalabra.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlPalabra);
        

        
        jOpcion1 = new JButton("E");
        jOpcion1.setBounds(70,140, 50,50);
        jpContenido.add(jOpcion1);
        
        jOpcion2 = new JButton("A");
        jOpcion2.setBounds(170,140, 50,50);
        jpContenido.add(jOpcion2);
        
        jOpcion3 = new JButton("I");
        jOpcion3.setBounds(270,140, 50,50);
        jpContenido.add(jOpcion3);

        jOpcion4 = new JButton("U");
        jOpcion4.setBounds(370,140, 50,50);
        jpContenido.add(jOpcion4);
    }
        
}
