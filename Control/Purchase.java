package Control;

public class Purchase {
	
	private int idcompra;
	private int idproducto;
	private int proveedor;
	private int cantidad;
	private int costoIndividual;
	private int costoTotal;
	
	
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCostoIndividual() {
		return costoIndividual;
	}
	public void setCostoIndividual(int costoIndividual) {
		this.costoIndividual = costoIndividual;
	}
	public int getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal() {
		this.costoTotal = costoIndividual*cantidad;
	}
	public void setCostoTotal2(int costoTotal) {
		this.costoTotal = costoTotal;
	}
}