
public class Chambre {

    private String Numéro_chambre ;
    private String Type ;
    private String Etage ;
    private String Caractéristiques ;
    private String Prix ;

    public Chambre(String Numéro_chambre, String Type, String Etage, String Caractéristiques, String Prix) {
        this.Numéro_chambre = Numéro_chambre;
        this.Type = Type;
        this.Etage = Etage;
        this.Caractéristiques = Caractéristiques;
        this.Prix = Prix;
    }

    public String getNuméro_chambre() {
        return Numéro_chambre;
    }

    public String getType() {
        return Type;
    }

    public String getEtage() {
        return Etage;
    }

    public String getCaractéristiques() {
        return Caractéristiques;
    }

    public String getPrix() {
        return Prix;
    }

    public void setNuméro_chambre(String Numéro_chambre) {
        this.Numéro_chambre = Numéro_chambre;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setEtage(String Etage) {
        this.Etage = Etage;
    }

    public void setCaractéristiques(String Caractéristiques) {
        this.Caractéristiques = Caractéristiques;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    @Override
    public String toString() {
        return "Chambre{" + "Num\u00e9ro_chambre=" + Numéro_chambre + ", Type=" + Type + ", Etage=" + Etage + ", Caract\u00e9ristiques=" + Caractéristiques + ", Prix=" + Prix + '}';
    }
    
}