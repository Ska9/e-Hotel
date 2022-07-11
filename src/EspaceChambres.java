import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;




public class EspaceChambres extends JFrame {
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
    JTable Tableau_Chambres ;
    JLabel Wallpaper ;
    Ajouter_chambre ch ;
    EspaceChambres ECH ;
    List<Chambre> chambres ;
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public  EspaceChambres() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Espace Chambres");




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
        p2.add(Chambres);




        Factures = new JButton("Factures");
        Factures.setFont(new Font("Montserrat",0,24));
        Factures.setIcon(new ImageIcon("Facture.png"));
        Factures.setOpaque(false);
        Factures.setBorderPainted(false);
        Factures.setBackground(Color.WHITE);
        Factures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EspaceFactures();
                dispose();}
        });
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
        Ajouter.setBounds(1000,100,175,50);
        Ajouter.setIcon(new ImageIcon("Ajouter.png"));
        Ajouter.setOpaque(false);
        Ajouter.setBorderPainted(true);
        Ajouter.setBackground(Color.WHITE);
        Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ch = new Ajouter_chambre();
            }
        });
        p.add(Ajouter);




        Modifier = new JButton("Modifier");
        Modifier.setFont(new Font("Montserrat",0,16));
        Modifier.setBounds(1000,160,175,50);
        Modifier.setIcon(new ImageIcon("Modifier.png"));
        Modifier.setOpaque(false);
        Modifier.setBorderPainted(true);
        Modifier.setBackground(Color.WHITE);
        p.add(Modifier);




        Supprimer = new JButton("Supprimer");
        Supprimer.setFont(new Font("Montserrat",0,16));
        Supprimer.setBounds(1000,220,175,50);
        Supprimer.setIcon(new ImageIcon("Supprimer.png"));
        Supprimer.setOpaque(false);
        Supprimer.setBorderPainted(true);
        Supprimer.setBackground(Color.WHITE);
        p.add(Supprimer);




        String[][] données = {
        };
        String[] entête = {"Numéro Chambre","Type","Etage","Caractéristiques","Prix"};
        Tableau_Chambres = new JTable(données,entête);
        JScrollPane scrollPane = new JScrollPane(Tableau_Chambres);
        scrollPane.setBounds(750,300,700,500);
        p.add(scrollPane);

        ch = new Ajouter_chambre();
        ch.dispose();
        chambres = null;
        try {
            chambres = ch.getAllChambres();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        ChambreTableModel model = new ChambreTableModel(chambres);
        Tableau_Chambres.setModel(model);
        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row=Tableau_Chambres.getSelectedRow();
                Modifier_chambre mc= new Modifier_chambre(ECH);
                String tp = mc.type.getSelectedItem().toString();
                String eg = mc.etage.getSelectedItem().toString();
               // try {
                    mc.t1.setText(chambres.get(row).getNuméro_chambre());
                    mc.type.setSelectedItem(tp);
                    mc.etage.setSelectedItem(eg);
                    mc.t4.setText(chambres.get(row).getCaractéristiques());
                    mc.t5.setText(chambres.get(row).getPrix());
    }
        });
        
        
        
        
        Wallpaper = new JLabel();
        ImageIcon image = new ImageIcon("Chambre.jpg");
        Wallpaper.setIcon(image);
        getContentPane().add(Wallpaper);
        Wallpaper.setBounds(0,0,1500,900);
        
        setVisible(true);

    }
    public JTable getTableau_Chambres() {
        return Tableau_Chambres;
    }
    
 }
                
