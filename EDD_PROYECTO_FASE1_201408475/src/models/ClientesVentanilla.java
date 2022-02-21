package models;

public class ClientesVentanilla {
	private int id_cliente;
	private int id_ventanilla;
	private int img_color;
	private int img_bw;
	private int img_color_;
	private int img_bw_;
	private String nombre_cliente;

	public ClientesVentanilla(int id_cliente,int id_ventanilla,String nombre_cliente, int img_color,int img_bw,int img_color_,int img_bw_) {
			this.id_cliente=id_cliente;
			this.id_ventanilla=id_ventanilla;
			this.img_color=img_color;
			this.nombre_cliente=nombre_cliente;
			this.img_bw=img_bw;
			this.img_bw_=img_bw_;
			this.img_color_=img_color_;

		}

	public int getIDCliente() {
		return id_cliente;
	}

	public void setIdCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getIdVentanilla() {
		return id_ventanilla;
	}

	public void setIdVentanilla(int id_ventanilla) {
		this.id_ventanilla = id_ventanilla;
	}

	public int getImgColor() {
		return img_color;
	}

	public void setImgColor(int img_color) {
		this.img_color = img_color;
	}
	
	public int getImgBw() {
		return img_bw;
	}

	public void setImgBw(int img_bw) {
		this.img_bw = img_bw;
	}
	

	public int getImgColor_() {
		return img_color_;
	}

	public void setImgColor_(int img_color_) {
		this.img_color_ = img_color_;
	}
	
	public int getImgBw_() {
		return img_bw_;
	}

	public void setImgBw_(int img_bw_) {
		this.img_bw_ = img_bw_;
	}

	public String getNombreCliente() {
		return nombre_cliente;
	}

	public void setNombreCliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

}
