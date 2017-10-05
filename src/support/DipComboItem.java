package support;


/**
 * The Class DipComboItem.
 */
public class DipComboItem {
	
	/** The nome. */
	private String nome;
    
    /** The id. */
    private String id;    

    /**
     * Instantiates a new dip combo item.
     *
     * @param nome the nome
     * @param id the id
     */
    public DipComboItem(String nome, String id) {
    	this.nome = nome;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return nome;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return nome;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return id;
    }    
}
