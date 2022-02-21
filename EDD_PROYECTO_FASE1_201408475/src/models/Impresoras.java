package models;

public class Impresoras {

	private int id_impresora;
	private String nombre_impresora;

	public Impresoras(int id_impresora, String nombre_impresora) {
			this.id_impresora=id_impresora;
			this.nombre_impresora=nombre_impresora;

		}

	public int getIDImpresora() {
		return id_impresora;
	}

	public void setIdImpresora(int id_impresora) {
		this.id_impresora = id_impresora;
	}
	
	public String getNombreImpresora() {
		return nombre_impresora;
	}

	public void setNombreImpresora(String nombre_impresora) {
		this.nombre_impresora = nombre_impresora;
	}

}
