
/**
 * Décrivez votre classe Utilisation ici.
 *
 * @author COLNOT Clemence
 * @version 2021.10.01
 */
public class Utilisation
{
    /**
     * essai
     */
    public void essai(){
        int[] vTab = new int[5];
        initTab(vTab);
        System.out.println();
        affTab(vTab);
        System.out.println();
        affTabInv(vTab);
        System.out.println();
        int vRes = somme(vTab);
        System.out.println("> "+ vRes);
        
    }// essai
    
    /**
     * affTab -> affiche un tableau d'entier en paramètre
     * @param tableau d'entiers
     */
    private void affTab (final int[] pTab){
        for (int vI = 0; vI < pTab.length; vI++){
            System.out.println("tab["+ vI +"] ="+pTab[vI]);
        }
    }// affTab
    
    /**
     * affTabInv -> affiche le tableau en paramètre à l'envers
     * @param tableau d'entiers
     */
    private void affTabInv (final int[] pTab){
        for (int vI = pTab.length-1; vI >= 0; vI--){
            System.out.println("tab["+ vI +"] ="+pTab[vI]);
        }
    }// affTabInv
    
    /**
     * initTab -> initialisation d'un tableau d'entiers contenant dans chaque case 2*Indice
     */
    private void initTab(final int[] pTab){
        for (int vI = 0; vI < pTab.length; vI++){
            pTab[vI] = 2 * vI;
        }
    }// initTab
    
    /**
     * somme -> somme des valeurs d'un tableau en paramètre
     * @param tableau d'entiers
     * @return résultat somme des entiers du tableau en paramètre
     */
    private int somme(final int[] pTab){
        int vRes = 0;
         for (int vI = 0; vI < pTab.length ; vI++){
            vRes = vRes + pTab[vI];
        }
        return vRes;
    }// somme 
}
