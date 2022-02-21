package models;

public class ClientesAtendidos {

	private int id_cliente;
	private String nombre_cliente;
	private int id_ventanilla;
	private int total_imagenes_impresas;
	private int cantidad_pasos_sistema;

	public ClientesAtendidos(int id_cliente, String nombre_cliente, int id_ventanilla,int total_imagenes_impresas,int cantidad_pasos_sistema) {
			this.id_cliente=id_cliente;
			this.nombre_cliente=nombre_cliente;
			this.id_ventanilla=id_ventanilla;
			this.total_imagenes_impresas=total_imagenes_impresas;
			this.cantidad_pasos_sistema=cantidad_pasos_sistema;
		}

	public int getIDCliente() {
		return id_cliente;
	}

	public void setIdCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombreCliente() {
		return nombre_cliente;
	}

	public void setNombreCliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
	public int getIdVentanilla() {
		return id_ventanilla;
	}

	public void setIdVentanilla(int id_ventanilla) {
		this.id_ventanilla = id_ventanilla;
	}
	
	public int getTotalImagenesImpresas() {
		return total_imagenes_impresas;
	}

	public void setTotalImagenesImpresas(int total_imagenes_impresas) {
		this.total_imagenes_impresas = total_imagenes_impresas;
	}
	
	public int getCantidadPasosSistema() {
		return cantidad_pasos_sistema;
	}

	public void setCantidadPasosSistema(int cantidad_pasos_sistema) {
		this.cantidad_pasos_sistema = cantidad_pasos_sistema;
	}
}
