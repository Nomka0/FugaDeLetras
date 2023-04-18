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
 * @author jhon
 */
public class VentanaPrincipal extends JFrame {

    private JLabel jlMensaje;
    private JLabel jlMensaje2;
    private JPanel jpContenido;   
    private JButton btnJugar; 
    private JButton btnInstrucciones; 
    
    public VentanaPrincipal(){
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
        
        jlMensaje = new JLabel("Una vocal se ha fugado de la palabra",SwingConstants.CENTER);
        jlMensaje.setBounds(55,40, 400,30);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje);
        
        jlMensaje2 = new JLabel("¿Nos ayudas a encontrarla?",SwingConstants.CENTER);
        jlMensaje2.setBounds(55,70, 400,30);
        jlMensaje2.setForeground(Color.WHITE);
        jlMensaje2.setFont(new Font("arial", Font.BOLD, 20));
        jpContenido.add(jlMensaje2);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(155,120, 180,35);
        jpContenido.add(btnJugar);
        
        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(155,170, 180,35);
        jpContenido.add(btnInstrucciones);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnInstrucciones.addActionListener(manejadorEventos);
        
        
    }
    
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){                
               VentanaNombre ventana = new VentanaNombre();
               dispose();
            } else if (evento.getSource() == btnInstrucciones) {
               JOptionPane.showMessageDialog(null, "A la palabra que te damos le falta una vocal, debes seleccionar la correcta", "Instrucciones", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
       
        
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
            //if(e.getKeyCode() == e.VK_ENTER){
               // btnJugar.doClick();
            //}
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
    }
}
