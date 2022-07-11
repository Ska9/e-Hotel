import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




public class EspaceClients extends JFrame {
    JPanel p ;
    JMenuBar BarreMenu ;
    JMenu Outils ;
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
    JTable Tableau_Clients ;
    Ajouter_client c;
    EspaceClients a;
    List<Client> clients ;
    private final  JLabel Wallpaper ;
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;
    
    private Client convertRowToClient(ResultSet myRs) throws SQLException {
        String  Statut = myRs.getString("Statut");
        String  Nom = myRs.getString("Nom");
        String Prénom = myRs.getString("Prénom");
        String ID = myRs.getString("ID");
        String Adresse = myRs.getString("Adresse");
        String Téléphone = myRs.getString("Téléphone");
        String Email = myRs.getString("mail");
        String Nationnalité = myRs.getString("Nationnalité");
        
        Client tempClient = new Client(Statut,Nom,Prénom,ID,Adresse,Téléphone,Email,Nationnalité);
        return tempClient;
    }

    
    public List<Client> getAllClients() throws Exception {
        List<Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from Client");
            while (myRs.next()) {
                Client tempClient = convertRowToClient(myRs);
                list.add(tempClient);
            }} catch(Exception e)
                    {e.printStackTrace();}
            return list;
        
    }
    
    public  EspaceClients() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Espace Clients");
        a=this;
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
                JOptionPane.showMessageDialog(null, "Sur ?");
                new Connexion();
                dispose();}
        });
        Fichier.add(Changer_Utilisateur);
        Quitter = new JMenuItem("Quitter");
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sur ?");
                dispose();
            }
        });
        Fichier.add(Quitter);
        BarreMenu.add(Fichier);
        Outils = new JMenu("Outils");
        Outils.setMnemonic('O');
        BarreMenu.add(Outils);
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
        p2.add(Clients);




        Chambres = new JButton("Chambres");
        Chambres.setFont(new Font("Montserrat",0,24));
        Chambres.setIcon(new ImageIcon("Chambre.png"));
        Chambres.setOpaque(false);
        Chambres.setBorderPainted(false);
        Chambres.setBackground(Color.WHITE);
        Chambres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        Factures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        Ajouter.setBounds(50,100,175,50);
        Ajouter.setIcon(new ImageIcon("Ajouter.png"));
        Ajouter.setOpaque(false);
        Ajouter.setBorderPainted(true);
        Ajouter.setBackground(Color.WHITE);
        Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c = new Ajouter_client(a);
            }
        });
        p.add(Ajouter);




        Modifier = new JButton("Modifier");
        Modifier.setFont(new Font("Montserrat",0,16));
        Modifier.setBounds(50,160,175,50);
        Modifier.setIcon(new ImageIcon("Modifier.png"));
        Modifier.setOpaque(false);
        Modifier.setBorderPainted(true);
        Modifier.setBackground(Color.WHITE);
        p.add(Modifier);
        

     

        Supprimer = new JButton("Supprimer");
        Supprimer.setFont(new Font("Montserrat",0,16));
        Supprimer.setBounds(50,220,175,50);
        Supprimer.setIcon(new ImageIcon("Supprimer.png"));
        Supprimer.setOpaque(false);
        Supprimer.setBorderPainted(true);
        Supprimer.setBackground(Color.WHITE);
        p.add(Supprimer);
        Supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TableModel model = Tableau_Clients.getModel();
                int row = Tableau_Clients.getSelectedRow();
                String fname = Tableau_Clients.getModel().getValueAt(row, 0).toString();
                String sname = Tableau_Clients.getModel().getValueAt(row, 1).toString();
                Statement myStmt;
                ResultSet myRs;
                try {
                    myStmt = myConn.createStatement();
                    myStmt.executeUpdate("Delete from client where `Nom`='"+fname+"' and `Prénom`='"+sname+"';");
                    
                    

                } catch(Exception e){
                    e.printStackTrace();
            }
            }
        });



        label1 = new JLabel("Recherche le client par le nom :");
        label1.setFont(new Font("Montserrat",0,17));
        label1.setBounds(250,120,280,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(250,145,280,20);
        p.add(t1);

        b1 = new JButton("Rechercher");
        b1.setBounds(560,145,110,20);
        p.add(b1);



        label2 = new JLabel("Recherche le client par ID :");
        label2.setFont(new Font("Montserrat",0,17));
        label2.setBounds(250,200,300,20);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(250,225,280,20);
        p.add(t2);

        b2 = new JButton("Rechercher");
        b2.setBounds(560,225,110,20);
        p.add(b2);

        
        String[][] données = {
        };
        String[] entête = {"Statut","Nom","Prénom","ID","Adresse","Téléphone","E-mail","Nationnalité"};
        Tableau_Clients = new JTable(données,entête);
        JScrollPane scrollPane = new JScrollPane(Tableau_Clients);
        scrollPane.setBounds(50,300,1400,500);
        p.add(scrollPane);



        
        c = new Ajouter_client(this);
        c.dispose();
        clients = null;
        try {
            clients = c.getAllClients();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        ClientTableModel model = new ClientTableModel(clients);
        Tableau_Clients.setModel(model);
        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
           
                int row=Tableau_Clients.getSelectedRow();
                 
                Modifier_client m =new Modifier_client(a,clients,row);
                
                    
               
                //try {
                    
                    

                    //c.updateClient(clients.get(row).getNom(), clients.get(row).getPrénom(),clients.get(row).getAdresse(),clients.get(row).getTéléphone(),clients.get(row).getEmail(),clients.get(row).getID());
                  
                //} catch (SQLException ex) {
                   // Logger.getLogger(EspaceClients.class.getName()).log(Level.SEVERE, null, ex);
               //}
                }
        });
        
        
        
        
        Wallpaper = new JLabel();
        ImageIcon image = new ImageIcon("Client.jpg");
        Wallpaper.setIcon(image);
        getContentPane().add(Wallpaper);
        Wallpaper.setBounds(0,0,1500,900);

        setVisible(true); // Rendre la fenêtre visible

    }
    public JTable getTableau_Clients() {
        return Tableau_Clients;
    }

}

