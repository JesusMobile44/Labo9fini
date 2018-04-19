import java.io.Serializable;

public class Adresse implements Serializable {
    private String numP;
    private String rue;
    private String app;
    private String ville;
    private String province;
    private String pays;

    public String getNumP() {
        return numP;
    }

    public void setNumP(String numP) {
        this.numP = numP;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void ajouterAdresse(){
        String input;
        System.out.println("Adresse :");
        numP = Contact.demanderInt("  Numéro de porte : ");
        rue = Contact.demanderString("  Rue : ");
        System.out.print("  Appartement : ");
        input=Liste.sc.nextLine().trim();
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            app=input;
        }
        ville = Contact.demanderString("  Ville : ");
        province = Contact.demanderString("  Province : ");
        pays = Contact.demanderString("  Pays : ");
    }

    public void modifierAdresse(){
        String input;
        System.out.println("Adresse : ");
        System.out.print("  Numéro de porte (" + numP + ") : ");
        input=Liste.sc.nextLine().trim();
        //Contact.verifyInt(numP)
        if(!input.equals("")) {
            numP=input;
        }
        System.out.print("  Rue (" + rue + ") : ");
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            rue=input;
        }
        System.out.print("  Appartement (" + app + ") : ");
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            app=input;
        }
        System.out.print("  Ville (" + ville + ") : ");
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            ville=input;
        }
        System.out.print("  Province (" + province + ") : ");
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            province=input;
        }
        System.out.print("  Pays (" + pays + ") : ");
        input=Liste.sc.nextLine().trim();
        if(!input.equals("")) {
            pays=input;
        }
    }

    public void afficherAdresse(){
        System.out.println("Adresse : ");
        System.out.println("  Numéro de porte : "+numP);
        System.out.println("  Rue : "+rue);
        System.out.println("  Appartement : "+app);
        System.out.println("  Ville : "+ville);
        System.out.println("  Province : "+province);
        System.out.println("  Pays : "+pays);
    }
}