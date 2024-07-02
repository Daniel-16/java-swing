import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("Physics");
    JTextField tfMass = new JTextField("Enter mass");
    JTextField tfAcceleration = new JTextField("Enter acceleration");
    JButton button = new JButton("Calculate");

    void drawUI() {
        //Textfields
        window.add(tfMass);
        window.add(tfAcceleration);
        //Button
        window.add(button);
        button.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                Physics physics = new Physics();
                try {                    
                    float mass = Float.valueOf(tfMass.getText());
                    float acceleration = Float.valueOf(tfAcceleration.getText());
                    JOptionPane.showMessageDialog(null, physics.calculateForce(mass, acceleration));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter only numeric values");
                    nfe.printStackTrace();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Something else happened!");   
                }
            }
        });
        //Close on exit
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3, 1));
        window.setSize(400, 500);
        window.setVisible(true);
    }
}
