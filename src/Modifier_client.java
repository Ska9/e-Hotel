import PackageBase.Metier;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Modifier_client extends JFrame {
    JPanel p ;
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JLabel label4 ;
    JLabel label5 ;
    JLabel label6 ;
    JLabel label7 ;
    JRadioButton h ;
    JRadioButton f ;
    ButtonGroup b ;
    JTextField t2 ;
    JTextField t3 ;
    JTextField t4 ;
    JTextField t5 ;
    JTextField t6 ;
    JTextField t7 ;
    JButton b1 ;
    JButton b2 ;
    Connection myConn = null;
    EspaceClients c;

    public Modifier_client( EspaceClients c,List<Client> clients,int row) {
        this.c=c;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student" , "student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1050,500); //La taille de la fenêtre
        setLocationRelativeTo(null);
        setResizable(false); // Désactiver le boutton agrandir
        setTitle("Modifier client"); // Nom de la fenêtre

        
        
        
        p = (JPanel)this.getContentPane(); // Panel pour écriver,ajouter...




        label1 = new JLabel("Statut:");
        label1.setFont(new Font("",0,18));
        label1.setBounds(50,50, 100, 20);
        p.add(label1);

        h = new JRadioButton("Mr");
        h.setFont(new Font("",0,16));
        h.setBounds(230, 50, 100, 20);
        h.isSelected();
        p.add(h);

        f = new JRadioButton("Mme");
        f.setFont(new Font("",0,16));
        f.setBounds(330, 50, 100, 20);
        p.add(f);

        b = new ButtonGroup();
        b.add(h);
        b.add(f);




        label2 = new JLabel("Nom:");
        label2.setFont(new Font("",0,18));
        label2.setBounds(50,96, 100,20);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(230, 100, 200, 20);
        p.add(t2);




        label3 = new JLabel("Prénom:");
        label3.setFont(new Font("",0,18));
        label3.setBounds(50,146, 100, 20);
        p.add(label3);

        t3 = new JTextField();
        t3.setBounds(230, 150, 200, 20);
        p.add(t3);




        label4 = new JLabel("CIN / Passport:");
        label4.setFont(new Font("",0,18));
        label4.setBounds(50,196, 250, 20);
        p.add(label4);

        t4 = new JTextField();
        t4.setBounds(230, 200, 200, 20);
        p.add(t4);




        label5 = new JLabel("Adresse:");
        label5.setFont(new Font("",0,18));
        label5.setBounds(50,246, 100,20);
        p.add(label5);

        t5 = new JTextField();
        t5.setBounds(230, 250, 200, 20);
        p.add(t5);




        label6 = new JLabel("Numéro téléphone:");
        label6.setFont(new Font("",0,18));
        label6.setBounds(50,296, 200,20);
        p.add(label6);

        t6 = new JTextField();
        t6.setBounds(230, 300, 200, 20);
        p.add(t6);




        label7 = new JLabel("E-mail:");
        label7.setFont(new Font("",0,18));
        label7.setBounds(50,345, 100,20);
        p.add(label7);

        t7 = new JTextField();
        t7.setBounds(230, 350, 200, 20);
        p.add(t7);
        
                t2.setText(clients.get(row).getNom());
                 t3.setText(clients.get(row).getPrénom());
                 t5.setText(clients.get(row).getAdresse());
                 t6.setText(clients.get(row).getTéléphone());
                 t7.setText(clients.get(row).getEmail());
                 t4.setText(clients.get(row).getID());
        
        
        b1 = new JButton("Enregistrer");
        b1.setBounds(730, 400, 110, 20);
        p.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Metier m=new Metier();
                    m.updateClient(t2.getText(), t3.getText(),t5.getText(),t6.getText(),t7.getText(),t4.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(Modifier_client.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            }
        });
        rootPane.setDefaultButton(b1);
        
        setVisible(true);
    
    }
    
}