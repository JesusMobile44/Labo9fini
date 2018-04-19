import java.io.Serializable;
import java.util.Scanner;

public class Telephone implements Serializable {
    private String info;
    private String num;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public static Telephone creerTelephone() {
        Telephone telephone = new Telephone();
        telephone.info = Contact.demanderString("À quoi correspond ce numéro (cellulaire, maison, travail, …) ? ");
        telephone.num = demanderTel();
        return telephone;
    }

    public void modifierTelephone() {
        String input;
        System.out.print("  " + info + " (" + num + ") : ");
        input = Liste.sc.nextLine().trim();
        if (!input.equals("")) {
            num=input;
        }
    }
    public static String demanderTel(){
        Scanner sc = new Scanner(System.in);
        String tel = null;
        boolean trouve = false;
        while (trouve==false){
            System.out.println("Quel est le numéro ? (xxx-xxx-xxxx)");
            tel = sc.next();
            for (int i=0;i<tel.length();i++){
                if (i==3||i==7){
                    if (tel.charAt(i)=='-'){
                        trouve=false;
                    }
                    else{
                        trouve=true;
                    }
                }
                else{
                    if ((int)tel.charAt(i)<46 || (int)tel.charAt(i)>57){
                        trouve=false;
                    }
                    else{
                        trouve=true;
                    }
                }
            }
        }
        return tel;
    }
}