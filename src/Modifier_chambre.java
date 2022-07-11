import PackageBase.Metier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Modifier_chambre extends JFrame {
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JLabel label4 ;
    JLabel label5 ;
    JTextField t1 ;
    JTextField t4 ;
    JTextField t5 ;
    JComboBox type ;
    JComboBox etage ;
    JButton b1 ;
    JButton b2 ;
    JButton b3 ;
    Connection myConn = null ;
    EspaceChambres ECH ;

    public Modifier_chambre(EspaceChambres ECH) {
        this.ECH=ECH;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student" , "student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1050,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Modifier chambre");

        JPanel p=(JPanel)this.getContentPane();




        label1 = new JLabel("Numéro chambre :");
        label1.setBounds(50,50,200,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(160,50,100,20);
        p.add(t1);




        label2 = new JLabel("Type :");
        label2.setBounds(50,100,200,20);
        p.add(label2);

        String[] Type = {"Single"};
        type = new JComboBox(Type);
        type.setBounds(160,100,100,20);
        p.add(type);


        
        
        label3 = new JLabel("Etage :");
        label3.setBounds(50,150,100,20);
        p.add(label3);

        String[] Etage = {"01","02","03","04","05"};
        etage = new JComboBox(Etage);
        etage.setBounds(160,150,100,20);
        p.add(etage);
        
        
        
        
        label4 = new JLabel("Caractéristiques");
        label4.setBounds(50,200, 100,20);
        p.add(label4);

        t4 = new JTextField();
        t4.setBounds(160,200,200,20);
        p.add(t4);
  



        label5 = new JLabel("Prix :");
        label5.setBounds(50,250,100,20);
        p.add(label5);

        t5 = new JTextField();
        t5.setBounds(160,250, 200, 20);
        p.add(t5);


   
        
        b1 = new JButton("Enregistrer");
        b1.setBounds(730, 400, 110, 20);
        p.add(b1);
        rootPane.setDefaultButton(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Metier mc = new Metier();
                    mc.updateChambre(t1.getText(),type.getSelectedItem().toString(),etage.getSelectedItem().toString(),t4.getText(),t5.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(Modifier_chambre.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            }
        });
        rootPane.setDefaultButton(b1);

        
        
        
        b2 = new JButton("Annuler");
        b2.setBounds(850,400,110,20);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
        setVisible(true);

    }
    
}