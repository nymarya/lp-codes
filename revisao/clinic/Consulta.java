public class Consulta {

    private StatusConsulta status;
    private int horario;
    private Animal animal;

    /**
     * Construtor para classe Consulta.
     * @param status Status da consulta.
     * @param horario Horario da consulta.
     * @param cao Cao que sera consultado.
     */
    public Consulta( int horario, Animal animal ) {
	this.status = StatusConsulta.MARCADA;
	this.horario = horario;
	this.animal = animal;
    }

    /** 
     * Desmarcar consulta.
     */
    public void desmarcarConsulta() {
	this.status = StatusConsulta.DESMARCADA;
    }

    /**
     * Remarcar consulta.
     * @hora Horario da nova consulta.
     */
    public void remarcarConsulta( int hora ) {
	status = StatusConsulta.REMARCADA;
	horario = hora;
    }  

    /**
     * Retorna status da consulta.
     * @return Status da consulta.
     */
    public StatusConsulta getStatus() {
	return status;
    }

    /**
     * Cria representação em String da classe.
     * @return String que representa a Consulta.
     */
    public String toString() {
	return "Status: " + status + "\nHorario: " + horario + "\nBichinho: "+ animal.toString(); 
    }
}
