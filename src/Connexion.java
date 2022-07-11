import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;




public class Connexion extends JFrame implements ActionListener{
    JPanel p ;
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JTextField t2 ;
    JPasswordField t3 ;
    private final  JLabel Wallpaper ;
    private final  JButton Suivant ;
    private final  JButton Annuler ;

    public  Connexion() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1050 , 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Login");

        p = (JPanel)this.getContentPane();




        label1 = new JLabel("Connexion");
        label1.setFont(new Font("",0,40));
        label1.setBounds(660,40,270,70);
        p.add(label1);




        label2 = new JLabel("Nom Utilisateur :");
        label2.setFont(new Font("",0,20));
        label2.setBounds(550,135,250,70);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(550,190,200,30);
        p.add(t2);




        label3=new JLabel("Mot de passe :");
        label3.setFont(new Font("",0,20));
        label3.setBounds(550,205,250,70);
        p.add(label3);

        t3 = new JPasswordField();
        t3.setBounds(550,260,200,30);
        p.add(t3);




        Suivant = new JButton("Suivant");
        Suivant.setFont(new Font("",0,17));
        Suivant.setBounds(640,350,100,50);
        Suivant.addActionListener(this);
        p.add(Suivant) ;
        rootPane.setDefaultButton(Suivant);




        Annuler = new JButton("Annuler");
        Annuler.setFont(new Font("",0,17));
        Annuler.setBounds(770,350,100,50);
        Annuler.addActionListener(this);
        p.add(Annuler) ;




        Wallpaper = new JLabel();
        ImageIcon img = new ImageIcon("Movenpick.jpg");
        Wallpaper.setIcon(img);
        getContentPane().add(Wallpaper);
        Wallpaper.setBounds(0,0,1050,500);

    }

    public static void main (String[] args) {
        Connexion connexion = new Connexion() ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] password = t3.getPassword();
        char[] OK1 = new char[]{'d','i','r','e','c','t','e','u','r'};
        char[] OK2 = new char[]{'r','e','c','e','p','t','i','o','n'};
        if ((Suivant == (JButton) e.getSource())){
            if ((t2.getText().equals("admin")) && ((Arrays.equals(OK1, password)))) {
                dispose();
                new EspaceDirecteur();}
            else if ((t2.getText().equals("admin")) && ((Arrays.equals(OK2, password)))) {
                dispose();
                new EspaceReceptionniste();}

            else if (  (password.length == 0) && (  (t2.getText().isEmpty()) )  )
                JOptionPane.showMessageDialog(null, "Nom utilisateur et mot de passe sont obligatoire","Error",JOptionPane.ERROR_MESSAGE);

            else if(password.length == 0)
                JOptionPane.showMessageDialog(null, "Mot de passe est obligatoire","Error",JOptionPane.ERROR_MESSAGE);

            else if (t2.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Nom utlisateur est obligatoire","Error",JOptionPane.ERROR_MESSAGE);

            else
                JOptionPane.showMessageDialog(null, "Mot de passe incorrect","Error",JOptionPane.ERROR_MESSAGE);

        }
        else if ((Annuler == (JButton) e.getSource())) {
            System.exit(0);
        }

    }
    
}