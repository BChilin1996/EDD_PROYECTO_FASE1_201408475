package models;

public class PasosClientes {
	private int cantidad_pasos;
	private int id_cliente;

	public PasosClientes(int id_cliente, int cantidad_pasos) {
			this.id_cliente=id_cliente;
			this.cantidad_pasos=cantidad_pasos;

		}

	public int getCantidadPasos() {
		return cantidad_pasos;
	}

	public void setCantidadPasos(int cantidad_pasos) {
		this.cantidad_pasos = cantidad_pasos;
	}
	
	public int getIDCliente() {
		return id_cliente;
	}

	public void setIDCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
