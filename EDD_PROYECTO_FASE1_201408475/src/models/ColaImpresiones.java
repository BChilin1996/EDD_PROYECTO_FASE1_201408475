package models;

public class ColaImpresiones {
	private int id_impresion;
	private int id_cliente;

	public ColaImpresiones(int id_cliente, int id_impresion) {
			this.id_cliente=id_cliente;
			this.id_impresion=id_impresion;

		}

	public int getIDImpresion() {
		return id_impresion;
	}

	public void setIdImpresion(int id_impresion) {
		this.id_impresion = id_impresion;
	}
	
	public int getIDCliente() {
		return id_cliente;
	}

	public void setIDCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
