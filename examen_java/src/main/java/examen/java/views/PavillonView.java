package examen.java.views;

import java.util.List;

import examen.java.core.ViewImpl;
import examen.java.entities.Chambre;
import examen.java.entities.Pavillon;
import examen.java.repository.ChambreRepository;

public class PavillonView extends ViewImpl<Pavillon> {
  ChambreRepository chambreRepository=new ChambreRepository();
  Pavillon pavillon=new Pavillon();
  Chambre chambre=new Chambre();
 
    @Override
    public Pavillon saisie() {
      Pavillon pavillon=new Pavillon();
      System.out.println("entrer le numéro du pavillon "); 
      pavillon.setNumero(scanner.nextInt());
      System.out.println("entrer le nombre d'etage");
      pavillon.setNmbrEtage(scanner.nextInt());
      return pavillon;

       }
       public void listerChambrePavillon(Pavillon pavillon){
          for (Chambre chambre : pavillon.getListeChambre()) {
              System.out.println(chambre);
          }
       }
       public int  callId(){
         System.out.println("entrer l'id");
         int id=scanner.nextInt();
         return id;   
         }
      public int saisieInt( String msg){
        System.out.println(msg);
        return (scanner.nextInt());
        
      }

        
      

       }
    

