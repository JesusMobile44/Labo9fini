import java.io.*;
import java.util.*;

public class Liste{
    public static final Scanner sc = new Scanner(System.in);
    private static HashMap<String, Contact> map=new HashMap<>();
    private static Queue<Contact> queue=new LinkedList<>();
    public static void main(String[] args) {

        int choixInt;
        System.out.println("Bienvenue!");
        while (true) {
            choixInt=listeChoix();
            choixSwitch(choixInt,map,queue);
        }
    }
    public static int listeChoix(){
        int choixInt;
        System.out.println();
        System.out.println(" 1- Ajouter un contact");
        System.out.println(" 2- Modifier un contact");
        System.out.println(" 3- Afficher les contacts");
        System.out.println(" 4- Supprimer un contact");
        System.out.println(" 5- Ajouter un contact à la liste de rappels");
        System.out.println(" 6- Voir la liste de rappels");
        System.out.println(" 7- Charger les listes");
        System.out.println(" 8- Quitter");
        System.out.print("Que souhaitez-vous faire ? ");
        try{
            String choixString = sc.nextLine();
            choixInt = Integer.parseInt(choixString);
            return choixInt;
        } catch (Exception e){
            System.out.println("Exception trouvée : "+e);
            return 0;
        }


    }
    public static void choixSwitch(int choixInt,HashMap<String,Contact> map,Queue<Contact> queue){
        String choixString;
        switch (choixInt) {
            case 1:
                Contact tempContact=Contact.ajouterContact();
                map.put(tempContact.getPrenom(),tempContact);
                break;
            case 2:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.get(choixString).modifierContact();
                    if(!choixString.equals(map.get(choixString).getPrenom())){
                        map.put(map.get(choixString).getPrenom(),map.get(choixString));
                        map.remove(choixString);
                    }
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 3:
                map.forEach((k,contact)-> {
                    //CONTACT
                    contact.afficherContact();
                });
                System.out.print("------------");
                break;
            case 4:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.remove(choixString);
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 5:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    queue.add(map.get(choixString));
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 6:
                if(queue.peek()!=null){
                    System.out.println("Le contact a rappelé au plus tôt est "+queue.peek().getPrenom()+" "+queue.poll().getNom());
                }
                else{
                    System.out.println("Il n'y a aucun contact à rappeler");
                }
                break;
            case 7:
                Liste.map = chargerMap();
                Liste.queue = chargerRappel();
                System.out.println("Listes chargées correctement");
                break;
            case 8:
                sauvegarde(map, queue);

                System.out.println("Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("ERREUR: Entrez un choix valide (entre 1 et 7)");
                break;
        }
    }
    public static HashMap<String, Contact> chargerMap(){
        HashMap<String, Contact> map=null;
        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("liste.dat")));
            try {
                map = (HashMap<String, Contact>)entree.readObject();
                entree.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Exception trouvée : "+e);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception trouvée : "+e);
        }finally {
            return map;
        }
    }
    public static Queue<Contact> chargerRappel(){
        Queue<Contact> queue=null;
        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("liste.dat")));
            try {
                entree.readObject();
                queue = (Queue<Contact>)entree.readObject();
                entree.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Exception trouvée : "+e);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception trouvée : "+e);
        }finally {
            return queue;
        }
    }
    public static void sauvegarde(HashMap<String, Contact> map,Queue<Contact> queue){
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("liste.dat")));
            sortie.writeObject(map);
            sortie.writeObject(queue);
            sortie.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception trouvée : "+e);
        }
        System.out.println("Listes sauvegardées correctement");
    }

}