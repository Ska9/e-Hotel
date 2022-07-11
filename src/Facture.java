import java.util.Date;




public class Facture {
    
    private String Numéro_facture ;
    private String ID_client ;
    private String Date ;
    private String Nombre_personne ;
    private String Total ;

    public Facture(String Numéro_facture, String ID_client, String Date, String Nombre_personne, String Total) {
        this.Numéro_facture = Numéro_facture;
        this.ID_client = ID_client;
        this.Date = Date;
        this.Nombre_personne = Nombre_personne;
        this.Total = Total;
    }

    public String getNuméro_facture() {
        return Numéro_facture;
    }

    public String getID_client() {
        return ID_client;
    }

    public String getDate() {
        return Date;
    }

    public String getNombre_personne() {
        return Nombre_personne;
    }

    public String getTotal() {
        return Total;
    }

    public void setNuméro_facture(String Numéro_facture) {
        this.Numéro_facture = Numéro_facture;
    }

    public void setID_client(String ID_client) {
        this.ID_client = ID_client;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setNombre_personne(String Nombre_personne) {
        this.Nombre_personne = Nombre_personne;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "Facture{" + "Num\u00e9ro_facture=" + Numéro_facture + ", ID_client=" + ID_client + ", Date=" + Date + ", Nombre_personne=" + Nombre_personne + ", Total=" + Total + '}';
    }

    
}
