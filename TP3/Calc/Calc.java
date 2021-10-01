
/**
 * Décrivez votre classe Calc ici.
 *
 * @author COLNOT Clemence
 * @version 2021.10.01
 */
public class Calc
{
   /**
    * expressions
    */
   public void expressions(){
       System.out.println(2 + 3 / 4); //2
       System.out.println(2.0 + 3 / 4); //2.0
       System.out.println(2 + 30E-1 / 4); //2.75
       System.out.println(11 % 4); //3
       System.out.println(Math.cos(Math.PI/4) == Math.sin(Math.PI/4)); //false
       System.out.println(Math.cos(Math.PI/4));
       System.out.println(Math.sin(Math.PI/4));
          
    }// expressions
    
    /**
     * racine negative
     */
    public double racNeg(final double pX){
        if (pX > 0) return Math.sqrt(pX);
        return -Math.sqrt(-pX);
    }// racNeg
    
    /** 
     * affiche moitie
     * @param entier positif 
     * Affiche le resultat de la division par deux successive 
     */
    public void afficheMoitie(final int pX){
        System.out.println(pX);
        if (pX !=1){
            int vR = pX/2;
            afficheMoitie(vR);
        }
        
    }// afficheMoitie
    
    /**
     * sontProches
     * @param deux reels 
     * @return boolean
     */
    public boolean sontProches(final double pA, final double pB){
        if (Math.abs(pA-pB)< 1e-9) return true;
        return false;
    }// sontProches
}
