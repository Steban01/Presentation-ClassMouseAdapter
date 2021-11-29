
package proyecto;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Titulos extends JLabel {
    public Titulos(String titulo, Color colorFondo) {
        this.setText(titulo);
        this.setBackground(colorFondo);
        this.setForeground(Color.BLUE);
        this.setFont(new Font("Dialog", 3, 25));
        this.setHorizontalAlignment(0);
    }
}