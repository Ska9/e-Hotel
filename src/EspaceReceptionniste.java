import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;




public class EspaceReceptionniste extends JFrame {
    JPanel p ;
    JMenuBar BarreMenu ;
    JMenuItem Changer_Utilisateur ;
    JMenuItem Quitter ;
    JButton Acceuil ;
    JButton Clients ;
    JButton Chambres ;
    JButton Factures ;
    JButton Planning ;
    JLabel Wallpaper ;

    public  EspaceReceptionniste() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Mövenpick Hotels & Resorts");




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
        Planning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Planning();
                dispose();}
        });
        p2.add(Planning);




        Wallpaper = new JLabel();
        ImageIcon image = new ImageIcon("Recep.jpg");
        Wallpaper.setIcon(image);
        getContentPane().add(Wallpaper);
        Wallpaper.setBounds(0,0,1500,900);

        setVisible(true);

    }

}
