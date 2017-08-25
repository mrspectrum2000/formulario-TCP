/*
Impimportaciones a usar
*/
package tcp;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *Esta clase es la que combina tanto los componentes como lógica del programa, para hacer un TCP.
 * @author Sachiro & Elliot
 * @version 1.0
 * @date 25-08-2017
 */
//Se le declara así para que la clase se muestre en JFrame
public class Calculo extends JFrame{
    JTextField n1,n2,oup;
    //componentes gráficas
    
    Calculo()
            //parte lógica/gráfica del programa
    {
        //Estas JLabels sirven para indicar los números, dos en input y uno en output
        JLabel start = new JLabel("Inserte sus dos numeros");
        JLabel one = new JLabel("Inserte el primer número");
        JLabel two = new JLabel("Inserte el segundo número");
        JLabel finale = new JLabel("trinomio");
        //Los Textfields para insertar los números.
        n1 = new JTextField(20);
        n2 = new JTextField(20);
        oup = new JTextField(20);
        //Un JPanel para acomodar todo 
        JPanel p = new JPanel(new GridLayout(5, 4));
        //Un botón pára realizar todo de un solo clic.
	JButton b = new JButton("Trinomio");
        /*Esta clase se personalizó a modo de que el botón tenga implementado el action listener
        el cual hará todo el proceso, además de tener toda la lógica del programa*/
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Declaramos inicialmente nuestros numeros en String, para que entren en el cuadro de texto
                String number1 = n1.getText();
                String number2 = n2.getText();
                //Para después convertirlos en valores realmente numericos
		int ichi = Integer.parseInt(number1);
                int ni = Integer.parseInt(number2);
                /*Variables del TCP, basandonos en su arquitectura principal:
                A^2 + 2AB + B^2
                en este caso:
                k = a^2
                z = 2ab
                y = b^2
                
                y finalmente, el resultado es desplegado como x, la cual suma todas las variables derivadas
                */
                int k=ichi*ichi;
                int y=ni*ni;
                int z=2*ichi*ni;
                int x=k+y+z;
                //Imprime en el tercer cuadro de texto el resultado del binomio
                oup.setText(k + "+" + z + "+" + y + "=" + x);
            }
        });
        //Añade al panel los componentes
        p.add(one);
        p.add(n1);
        p.add(two);
        p.add(n2);
	p.add(finale);
	p.add(oup);
        p.add(b);
	add(p);
	setVisible(true);
	pack();
    }
    public static void main(String[] args) {
            //visionaliza la clase
		Calculo f = new Calculo();
	}
}
