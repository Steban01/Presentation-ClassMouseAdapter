package proyecto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * This class is used to give a basic customization to our header, create and command the listening events with the mouse and the keyboard.
 *
 * @version @version v 0.5 date:21/28/2021
 * @autor Esteban Andres Hernandez Cortes-esteban.cortes@correounivalle.edu.co
 */

class Ventana1 extends JFrame {
    private JButton miFoto;
    private JButton miHobbie;
    private JButton misExpectativas;
    private JPanel panelBotones;
    private JPanel panelDatos;
    private proyecto.Titulos titulo;
    private Escucha escucha;
    private JLabel labelimage;
    private JTextArea textoExpectativas;

    /**
     * GUI_Ventana class constructor
     */
    public Ventana1() {
        //Default JFrame configuration
        this.initGUI();
        this.setTitle("Mi presentacion");
        this.setSize(800, 700);
        this.setLocationRelativeTo((Component) null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * this method is used to configure the JComponents, listeners and control objects
     */

    private void initGUI() {

        this.escucha = new Escucha();
        titulo = new Titulos("Hola soy Esteban Cortés", Color.white);

        this.add(titulo, BorderLayout.NORTH);
        panelDatos = new JPanel();


        panelDatos.setBackground(Color.gray);
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Arial", Font.PLAIN, 15), Color.BLACK));
        this.add(panelDatos, BorderLayout.CENTER);


        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);


        miHobbie = new JButton("Mi hobby");
        miHobbie.addMouseListener(escucha);


        misExpectativas = new JButton("Mis expectativas");
        misExpectativas.addKeyListener(escucha);


        panelBotones = new JPanel();


        panelBotones.add(miHobbie);
        panelBotones.add(miFoto);
        panelBotones.add(misExpectativas);
        this.add(panelBotones, BorderLayout.SOUTH);
        labelimage = new JLabel();
        labelimage.setSize(800, 700);
        labelimage.setVerticalAlignment(JLabel.CENTER);
        labelimage.setHorizontalAlignment(JLabel.CENTER);


        textoExpectativas = new JTextArea(12, 5);
    }

    /**
     * Main process of the java program
     *
     * @param args object used in order to send input data from command line when this program is executed by console
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1();
            }
        });
    }

    /**
     * inner class that extends over the implements listener used by the GUI class
     */

    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getComponent() == miHobbie && e.getClickCount() == 1) {
                panelDatos.removeAll();

                image = new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                labelimage.setIcon(image);
                panelDatos.add(labelimage);
            } else {
                if (e.getComponent() == miFoto && e.getClickCount() == 2) {
                    panelDatos.removeAll();
                    image = new ImageIcon(getClass().getResource("/recursos/yo.png"));
                    labelimage.setIcon(image);
                    panelDatos.add(labelimage);
                } else {

                }


            }

            revalidate();
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'm') {
                panelDatos.removeAll();
                textoExpectativas.setText("Conozco un poco de java, pero no soy experto en hacer programas con este\n" +
                        " lenguaje.Espero que con este curso me permitea desarrollar y crear programas \n" +
                        "con el lenguaje, espero que con este aprendizaje que adquirirá,me ayude en mi\n" +
                        " carrera profesional y en mi futuro como programador.");
                panelDatos.add(textoExpectativas);
                textoExpectativas.setBackground(null);
                textoExpectativas.setFont(new Font("Dialog", 3, 20));

            }
            revalidate();
            repaint();

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}