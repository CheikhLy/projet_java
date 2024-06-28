package examen.java.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Pavillon {
  private  int id;
  private  int numero;
  private static int nmbre;
  List<Chambre> listeChambre=new ArrayList<>();
  public List<Chambre> getListeChambre() {
        return listeChambre;
    }
public void setChambre(Chambre chambre) {
       listeChambre.add(chambre);
    }
private int nmbrEtage;
    public Pavillon() {
        id=++nmbre;
    }
    @Override
    public String toString() {
        return "Pavillon [id=" + id + ", numero=" + numero + ", nmbrEtage=" + nmbrEtage + "]";
    }
}
