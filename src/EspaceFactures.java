import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;




public class EspaceFactures extends JFrame {
    JPanel p ;
    JMenuBar BarreMenu ;
    JMenuItem Changer_Utilisateur ;
    JMenuItem Quitter ;
    JButton Acceuil ;
    JButton Clients ;
    JButton Chambres ;
    JButton Factures ;
    JButton Planning ;
    JButton Ajouter ;
    JButton Modifier ;
    JButton Supprimer ;
    JButton b1 ;
    JButton b2 ;
    JLabel label1 ;
    JLabel label2 ;
    JTextField t1 ;
    JTextField t2 ;
    JTable Tableau_Factures ;
    JLabel Wallpaper ;
    Ajouter_facture f ;
    EspaceFactures EF ;
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public  EspaceFactures() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Espace Factures");
        EF=this;
        
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student" , "student");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        p = (JPanel)this.getContentPane();
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setBounds(0,0,1500,65);
        p.add(p2);




        BarreMenu = new JMenuBar();
        JMenu Fichier = new JMenu("Fichier");
        Fichier.setMnemonic('F');
        Changer_Utilisateur = new JMenuItem("Changer l'Utilisateur");
        Changer_Utilisateur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));
        Changer_Utilisateur.setToolTipText("Permet de changer l'utilisateur");
        Changer_Utilisateur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Voulez vous changer l'utilisateur ?");
                new Connexion();
                dispose();}
        });
        Fichier.add(Changer_Utilisateur);
        Quitter = new JMenuItem("Quitter");
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Voulez vous quitter ?");
                dispose();
            }
        });
        Fichier.add(Quitter);
        BarreMenu.add(Fichier);
         setJMenuBar(BarreMenu); 



         
        Acceuil = new JButton("Acceuil");
        Acceuil.setFont(new Font("Montserrat",0,24));
        Acceuil.setIcon(new ImageIcon("Home.png"));
        Acceuil.setOpaque(false);
        Acceuil.setBorderPainted(false);
        Acceuil.setBackground(Color.WHITE);
        Acceuil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EspaceReceptionniste();
                dispose();}
        });
        p2.add(Acceuil);




        Clients = new JButton("Clients");
        Clients.setFont(new Font("Montserrat",0,24));
        Clients.setIcon(new ImageIcon("Client.png"));
        Clients.setOpaque(false);
        Clients.setBorderPainted(false);
        Clients.setBackground(Color.WHITE);
        Clients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EspaceClients();
                dispose();}
        });
        p2.add(Clients);




        Chambres = new JButton("Chambres");
        Chambres.setFont(new Font("Montserrat",0,24));
        Chambres.setIcon(new ImageIcon("Chambre.png"));
        Chambres.setOpaque(false);
        Chambres.setBorderPainted(false);
        Chambres.setBackground(Color.WHITE);
        Chambres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EspaceChambres();
                dispose();}
        });
        p2.add(Chambres);




        Factures = new JButton("Factures");
        Factures.setFont(new Font("Montserrat",0,24));
        Factures.setIcon(new ImageIcon("Facture.png"));
        Factures.setOpaque(false);
        Factures.setBorderPainted(false);
        Factures.setBackground(Color.WHITE);
        p2.add(Factures);



        
        Planning = new JButton("Planning");
        Planning.setFont(new Font("Montserrat",0,24));
        Planning.setIcon(new ImageIcon("Planning.png"));
        Planning.setOpaque(false);
        Planning.setBorderPainted(false);
        Planning.setBackground(Color.WHITE);
        Planning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Planning();
                dispose();}
        });
        p2.add(Planning);




        Ajouter = new JButton("Ajouter");
        Ajouter.setFont(new Font("Montserrat",0,16));
        Ajouter.setBounds(750,100,175,50);
        Ajouter.setIcon(new ImageIcon("Ajouter.png"));
        Ajouter.setOpaque(false);
        Ajouter.setBorderPainted(true);
        Ajouter.setBackground(Color.WHITE);
        Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f = new Ajouter_facture(EF);
            }
        });
        p.add(Ajouter);




        Modifier = new JButton("Modifier");
        Modifier.setFont(new Font("Montserrat",0,16));
        Modifier.setBounds(750,160,175,50);
        Modifier.setIcon(new ImageIcon("Modifier.png"));
        Modifier.setOpaque(false);
        Modifier.setBorderPainted(true);
        Modifier.setBackground(Color.WHITE);
        p.add(Modifier);




        Supprimer = new JButton("Supprimer");
        Supprimer.setFont(new Font("Montserrat",0,16));
        Supprimer.setBounds(750,220,175,50);
        Supprimer.setIcon(new ImageIcon("Supprimer.png"));
        Supprimer.setOpaque(false);
        Supprimer.setBorderPainted(true);
        Supprimer.setBackground(Color.WHITE);
        p.add(Supprimer);




        label1 = new JLabel("Recherche par ID :");
        label1.setFont(new Font("Montserrat",0,17));
        label1.setBounds(1000,120,280,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(1000,145,280,20);
        p.add(t1);

        b1 = new JButton("Rechercher");
        b1.setBounds(1310,145,110,20);
        p.add(b1);


        label2 = new JLabel("Recherche par numéro facture :");
        label2.setFont(new Font("Montserrat",0,17));
        label2.setBounds(1000,200,300,20);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(1000,225,280,20);
        p.add(t2);

        b2 = new JButton("Rechercher");
        b2.setBounds(1310,225,110,20);
        p.add(b2);
        


        String[][] données = {
        };
        String[] entête = {"Numéro facture","ID Client","Date","Nombre personne","Total"};
        Tableau_Factures = new JTable(données,entête);
        JScrollPane scrollPane = new JScrollPane(Tableau_Factures);
        scrollPane.setBounds(750,300,700,500);
        p.add(scrollPane);

        f = new Ajouter_facture(this);
        f.dispose();
        List<Facture> factures = null;
        try {
            factures = f.getAllFactures();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        FactureTableModel model = new FactureTableModel(factures);

        Tableau_Factures.setModel(model);

        Wallpaper = new JLabel();
        ImageIcon image = new ImageIcon("Facture.jpg");
        Wallpaper.setIcon(image);
        getContentPane().add(Wallpaper);
        Wallpaper.setBounds(0,0,1500,900);
        setVisible(true);

    }
    public JTable getTableau_Factures() {
        return Tableau_Factures;
    }
}