import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import static java.awt.event.ActionEvent.CTRL_MASK;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;




public class Planning extends JFrame {
    JPanel p ;
    JMenuBar BarreMenu ;
    JMenuItem Changer_Utilisateur ;
    JMenuItem Quitter ;
    JButton Acceuil ;
    JButton Clients ;
    JButton Chambres ;
    JButton Factures ;
    JButton Planning ;
    JLabel label1 ;
    JLabel label2 ;
    JTextField t1 ;
    JTextField t2 ;
    JButton b1 ;
    JButton b2 ;
    JTable Tableau_Planning ;

    public Planning() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Planning");

        
        
        
        p=(JPanel)this.getContentPane();
        JPanel p2 = new JPanel();
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
                JOptionPane.showMessageDialog(null, "Veuillez changer l'utilisateur ?");
                new Connexion();
                dispose();}
        });
        Fichier.add(Changer_Utilisateur);
        Quitter = new JMenuItem("Quitter");
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Veuillez quitter ?");
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
        p2.add(Planning);




        label1 = new JLabel("Entrer la premi??re date :");
        label1.setFont(new Font("",0,18));
        label1.setBounds(50,80,200,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(255,83,100,20);
        p.add(t1);



        label2 = new JLabel("Entrer la deuxi??me date :");
        label2.setFont(new Font("",0,18));
        label2.setBounds(400,80,200,20);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(610,83,100,20);
        p.add(t2);




        b1 = new JButton("Rechercher");
        b1.setBounds(730,80,110,20);
        p.add(b1);



        String[][] donn??es = {
        };
        String[] ent??te = {"Date","","","",""," ",""};
        Tableau_Planning = new JTable(donn??es,ent??te);
        JScrollPane scrollPane = new JScrollPane(Tableau_Planning);
        scrollPane.setBounds(50,120,1400,700);
        p.add(scrollPane);

        setVisible(true);

    }

}
