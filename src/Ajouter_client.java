import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Ajouter_client extends JFrame {
    JPanel p ;
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JLabel label4 ;
    JLabel label5 ;
    JLabel label6 ;
    JLabel label7 ;
    JLabel label8 ;
    JLabel label9 ;
    JLabel label10 ;
    JLabel label11 ;
    JRadioButton h ;
    JRadioButton f ;
    ButtonGroup b ;
    JTextField t2 ;
    JTextField t3 ;
    JTextField t4 ;
    JTextField t5 ;
    JTextField t6 ;
    JTextField t7 ;
    JComboBox nationnalité ;
    JComboBox jour_naissance ;
    JComboBox mois_naissance ;
    JComboBox année_naissance ;
    JComboBox jour_arrivée ;
    JComboBox mois_arrivée ;
    JComboBox année_arrivée ;
    JComboBox jour_sortie ;
    JComboBox mois_sortie ;
    JComboBox année_sortie ;
    JButton b1 ;
    JButton b2 ;
    Connection myConn = null;
    EspaceClients c;

    public Ajouter_client( EspaceClients c) {
        this.c=c;
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
        setTitle("Ajouter client");

        
        
        
        p = (JPanel)this.getContentPane();




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




        label8 = new JLabel("Nationnalité:");
        label8.setFont(new Font("",0,18));
        label8.setBounds(470,96, 250,20);
        p.add(label8);

        String[] Nationnalité = {"Tunisienne","Chinoise","Américaine","Mexicaine","Française","Allemande","Espagnole"};
        nationnalité = new JComboBox(Nationnalité);
        nationnalité.setFont(new Font("",0,14));
        nationnalité.setBounds(610,100, 100, 20);
        p.add(nationnalité);




        label9 = new JLabel("Date de naissance:");
        label9.setFont(new Font("",0,14));
        label9.setBounds(470,145,200,20);
        p.add(label9);

        String[] Jour = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        jour_naissance = new JComboBox(Jour);
        jour_naissance.setFont(new Font("",0,14));
        jour_naissance.setBounds(610,150,100,20);
        p.add(jour_naissance);
            

        String[] Mois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        mois_naissance = new JComboBox(Mois);
        mois_naissance.setFont(new Font("",0,14));
        mois_naissance.setBounds(730,150,100,20);
        p.add(mois_naissance);

        String[] Année = {"2019"};
        année_naissance = new JComboBox(Année);
        année_naissance.setFont(new Font("",0,14));
        année_naissance.setBounds(850,150,100,20);
        p.add(année_naissance);




        label10 = new JLabel("Date d'arrivée:");
        label10.setFont(new Font("",0,18));
        label10.setBounds(470,195,200,20);
        p.add(label10);

        String[] Jour_arrivée = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        jour_arrivée = new JComboBox(Jour_arrivée);
        jour_arrivée.setFont(new Font("",0,14));
        jour_arrivée.setBounds(610,200, 100, 20);
        p.add(jour_arrivée);

        String[] Mois_arrivée = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        mois_arrivée = new JComboBox(Mois_arrivée);
        mois_arrivée.setFont(new Font("",0,14));
        mois_arrivée.setBounds(730,200, 100, 20);
        p.add(mois_arrivée);

        String[] Année_arrivée = {"2019"};
        année_arrivée = new JComboBox(Année_arrivée);
        année_arrivée.setFont(new Font("",0,14));
        année_arrivée.setBounds(850,200, 100, 20);
        p.add(année_arrivée);




        label11 = new JLabel("Date de sortie:");
        label11.setFont(new Font("",0,18));
        label11.setBounds(470,245,200,20);
        p.add(label11);

        String[] Jour_sortie = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        jour_sortie = new JComboBox(Jour_sortie);
        jour_sortie.setFont(new Font("",0,14));
        jour_sortie.setBounds(610,250, 100, 20);
        p.add(jour_sortie);

        String[] Mois_sortie = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        mois_sortie = new JComboBox(Mois_sortie);
        mois_sortie.setFont(new Font("",0,14));
        mois_sortie.setBounds(730,250, 100, 20);
        p.add(mois_sortie);

        String[] Année_sortie = {"2019"};
        année_sortie = new JComboBox(Année_sortie);
        année_sortie.setFont(new Font("",0,14));
        année_sortie.setBounds(850,250, 100, 20);
        p.add(année_sortie);




        b1 = new JButton("Enregistrer");
        b1.setBounds(730, 400, 110, 20);
        p.add(b1);
        rootPane.setDefaultButton(b1);
        b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

		
	
		if ( (t2.getText().isEmpty())  ||  (t3.getText().isEmpty()) || (t4.getText().isEmpty()) ||  (t5.getText().isEmpty()) ||  (t6.getText().isEmpty())  ||  (t7.getText().isEmpty())   )
		{JOptionPane.showMessageDialog(null, "Les autres champs sont obligatoire");}

                else {
		try {
		ajouter ();
		} catch (SQLException ex) {
		Logger.getLogger(Ajouter_client.class.getName()).log(Level.SEVERE, null, ex);
		}
		dispose();
		}
                
                try {
		Integer.parseInt(t4.getText());
                Integer.parseInt(t6.getText());
		} catch (NumberFormatException ae) {
		JOptionPane.showMessageDialog(null, "Vérifier CIN ou Téléphone (des chiffres)");
		}}

		});

        
    

        b2 = new JButton("Annuler");
        b2.setBounds(850, 400, 110, 20);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

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
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public List<Client> searchClient(String lastName) throws Exception {
        List<Client> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("select * from Client where last_name like ?");
            myStmt.setString(1, lastName);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                Client tempClient = convertRowToClient(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }

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

    
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }


    public void ajouter () throws SQLException{
        String checked = null;
                    if(h.isSelected())
                      checked=h.getText();
                    else if(f.isSelected())
                      checked=f.getText();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            // 2. Create a statement
            myStmt = myConn.createStatement();
            // our work
            String sql="insert into Client " + " (Statut,Nom,Prénom,ID,Adresse,Téléphone,mail,Nationnalité)"
 +" values ( '" + checked + "','" + t2.getText()+ " ', '" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + t6.getText() + "','"+ t7.getText() + "','"+ nationnalité.getSelectedItem().toString() + "' )" ;
         myStmt.executeUpdate(sql);
        }catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }
                    }
        List<Client> clients = null;
        try {
            clients = getAllClients();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        ClientTableModel model = new ClientTableModel(clients);
        c.getTableau_Clients().setModel(model);
        c = null;

    }
     
}