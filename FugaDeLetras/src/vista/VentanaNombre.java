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

public class VentanaNombre extends JFrame {
    
    private JLabel jlMensaje;
    private JLabel jlMensaje2;
    private JPanel jpContenido;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnAnimales; 
    private JButton btnColores; 
    private JButton btnFrutas; 
    
    public VentanaNombre(){
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
        
        jlMensaje = new JLabel("Por favor, Ingresa tu nombre",SwingConstants.CENTER);
        jlMensaje.setBounds(55,40, 400,30);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje);
        
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.PINK);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        txtNombre.setBounds(55,80,400, 30);
        jpContenido.add(txtNombre);
              
        jlMensaje2 = new JLabel("Ahora escoge una temática",SwingConstants.CENTER);
        jlMensaje2.setBounds(55,130, 400,30);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje2);
        
        btnAnimales = new JButton("Animales");
        btnAnimales.setBounds(50,180, 120,35);
        jpContenido.add(btnAnimales);
        
        btnColores = new JButton("Colores");
        btnColores.setBounds(190,180, 120,35);
        jpContenido.add(btnColores);
        
        btnFrutas = new JButton("Frutas");
        btnFrutas.setBounds(330,180, 120,35);
        jpContenido.add(btnFrutas);
        
        ManejadorDeEventos manejadorEventos = new VentanaNombre.ManejadorDeEventos();
        
        btnAnimales.addActionListener(manejadorEventos);
        btnColores.addActionListener(manejadorEventos);
        btnFrutas.addActionListener(manejadorEventos);
        
    }
    
     private void obtenerNombre(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Jugador jugador = new Jugador(nombre);        
            dispose(); 
            VentanaJuego ventanaJuego = new VentanaJuego();              
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    
    class ManejadorDeEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento){
            
          
            }
        }
    }

