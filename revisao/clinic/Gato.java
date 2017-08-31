public class Gato extends Animal {
	
	private String pelagem;

	/**
	 * Construtor para objeto da classe Gato.
	 */
	public Gato() {
		super();
	}

	/**
	 * Recupera pelagem do gato.
	 * @return Pelagem do gato.
	 */
	public String getPelagem() {
	    return pelagem;
	}

	/**
	 * Atualiza pelagem do gato.
	 * @param pelagem Pelagem do gato.
	 */
	public void setPelagem( String pelagem ) {
	    this.pelagem = pelagem;
	}
}