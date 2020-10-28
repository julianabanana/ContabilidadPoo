/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author jczam
 */
public class Sale {
    private int idventa;

    
    private int idcliente;
    private int idproducto;
    private float costo;
    private int cantidad;

    
    
    public int getIdventa() {
        return idventa;
    }
    public int getIdcliente() {
        return idcliente;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public float getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    
}
