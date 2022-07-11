import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Creer_Type extends JFrame {
    JLabel label1 ;
    JTextField t1 ;
    JButton b1 ;

    public Creer_Type() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(300,250); //La taille de la fenêtre
        setLocationRelativeTo(null);
        setResizable(false); // Désactiver le boutton agrandir
        setTitle("Créer type"); // Nom de la fenêtre

        JPanel p=(JPanel)this.getContentPane(); // Panel pour écriver,ajouter...




        label1 = new JLabel("Entrer un type :");
        label1.setBounds(50,80,100,20);
        p.add(label1);



        t1 = new JTextField();
        t1.setBounds(150,80,100,20);
        p.add(t1);



        b1 = new JButton("Valider");
        b1.setBounds(85,150,110,20);
        p.add(b1);
        rootPane.setDefaultButton(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

        setVisible(true);

    }
}