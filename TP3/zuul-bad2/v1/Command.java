package v1;

public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur naturel
     */
    public Command(final String pCommandWord, final String pSecondWord){
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }// Command
    
    /**
     * Getter aCommandWord
     * @return aCommandWord
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }// getCommandWord
    
    /**
     * Getter aSecondWord
     * @return aSecondWord
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }// getSecondWord
    
    /**
     * hasSecondWord
     * @return true if aSecondWord is not null 
     */
    public boolean hasSecondWord(){
        return this.getSecondWord() != null;
    }// hasSecondWord
    
    /**
     * isUnknown 
     * @return true if aCommandWord is null
     */
    public boolean isUnknown(){
        return this.getCommandWord() == null;
    }// isUnknown
    
} // Command
