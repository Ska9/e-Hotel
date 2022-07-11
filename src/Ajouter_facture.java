import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Ajouter_facture extends JFrame {
    JPanel p ;
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JLabel label4 ;
    JLabel label5 ;
    JTextField t1 ;
    JTextField t2 ;
    JTextField t3 ;
    JTextField t4 ;
    JTextField t5 ;
    JButton b1 ;
    JButton b2 ;
    Connection myConn = null;
    EspaceFactures EF ;

    public Ajouter_facture(EspaceFactures EF) {
        this.EF=EF;
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
        setTitle("Ajouter facture");

        
        
        
        p = (JPanel)this.getContentPane();




        label1 = new JLabel("N° Facture :");
        label1.setBounds(50,50,200,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(200,50,100,20);
        p.add(t1);
        



        label2 = new JLabel("ID Client :");
        label2.setBounds(50,100, 300,20);
        p.add(label2);

        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 20);
        p.add(t2);




        label3 = new JLabel("Date :");
        label3.setBounds(50,150,200,20);
        p.add(label3);

        t3 = new JTextField();
        t3.setBounds(200,150,200,20);
        p.add(t3);




        label4 = new JLabel("Nombre personne :");
        label4.setBounds(50,200,200,20);
        p.add(label4);

        t4 = new JTextField();
        t4.setBounds(200,200,200,20);
        p.add(t4);
        
        
        
        
        label5 = new JLabel("Total :");
        label5.setBounds(50,250,200,20);
        p.add(label5);

        t5 = new JTextField();
        t5.setBounds(200,250,200,20);
        p.add(t5);
        
        
        
        
        b1 = new JButton("Enregistrer");
        b1.setBounds(730, 400, 110, 20);
        p.add(b1);
        rootPane.setDefaultButton(b1);
        b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        try {
		ajouter ();
		} catch (SQLException ex) {
		Logger.getLogger(Ajouter_client.class.getName()).log(Level.SEVERE, null, ex);
		}
		dispose();}
		});
        





        b2 = new JButton("Annuler");
        b2.setBounds(850, 400, 110, 20);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

        setVisible(true);

    }

    public List<Facture> getAllFactures() throws Exception {
        List<Facture> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from Facture");
            while (myRs.next()) {
                Facture tempFacture = convertRowToFacture(myRs);
                list.add(tempFacture);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public List<Facture> searchFacture(String lastName) throws Exception {
        List<Facture> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("select * from Facture where last_name like ?");
            myStmt.setString(1, lastName);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                Facture tempFacture = convertRowToFacture(myRs);
                list.add(tempFacture);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }

    private Facture convertRowToFacture(ResultSet myRs) throws SQLException {
        String  Numéro_facture = myRs.getString("Numéro");
        String ID_client = myRs.getString("ID");
        String Date = myRs.getString("Date");
        String Nombre_personne = myRs.getString("Nombre");
        String Total = myRs.getString("Total");

        Facture tempFacture = new Facture(Numéro_facture,ID_client,Date,Nombre_personne,Total);
        return tempFacture;
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
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            // 2. Create a statement
            myStmt = myConn.createStatement();
            // our work
            String sql="insert into Facture " + " (Numéro,ID,,Date,Nombre,Total)"
+" values ( '"  + t1.getText()+ " ','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "' )" ;
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
        List<Facture> factures = null;
        try {
            factures = getAllFactures();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        FactureTableModel model = new FactureTableModel(factures);
        EF.getTableau_Factures().setModel(model);
        EF = null;

    }
}