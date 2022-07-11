


public class Client {

    private String Statut ;
    private String Nom ;
    private String Prénom ;
    private String ID ;
    private String Adresse ;
    private String Téléphone ;
    private String Email ;
    private String Nationnalité ;

    public Client(String Statut, String Nom, String Prénom, String ID, String Adresse, String Téléphone, String Email, String Nationnalité) {
        this.Statut = Statut;
        this.Nom = Nom;
        this.Prénom = Prénom;
        this.ID = ID;
        this.Adresse = Adresse;
        this.Téléphone = Téléphone;
        this.Email = Email;
        this.Nationnalité = Nationnalité;
    }

    public String getStatut() {
        return Statut;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrénom() {
        return Prénom;
    }

    public String getID() {
        return ID;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getTéléphone() {
        return Téléphone;
    }

    public String getEmail() {
        return Email;
    }

    public String getNationnalité() {
        return Nationnalité;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrénom(String Prénom) {
        this.Prénom = Prénom;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setTéléphone(String Téléphone) {
        this.Téléphone = Téléphone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNationnalité(String Nationnalité) {
        this.Nationnalité = Nationnalité;
    }

    @Override
    public String toString() {
        return "Client{" + "Statut=" + Statut + ", Nom=" + Nom + ", Pr\u00e9nom=" + Prénom + ", ID=" + ID + ", Adresse=" + Adresse + ", T\u00e9l\u00e9phone=" + Téléphone + ", Email=" + Email + ", Nationnalit\u00e9=" + Nationnalité + '}';
    }

    

    

    
}