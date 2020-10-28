/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficador;

/**
 *
 * @author jczam
 */
import Control.Conexion;
import Control.ConsultTables;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Graficador {
    private GraficaBarras graficaBarras;
    private GraficaCircular graficaCircular;
    private GraficaLineal graficaLineal;
    private Histograma histograma;
    private Connection conexion;
    private ResultSet iterador;
    private JPanel panel;
    private ConsultTables control;
    private PreparedStatement accesor;
    public Graficador(JPanel panel){ 
        conexion= (new Conexion()).getConexion();
        this.control=new ConsultTables();
        this.panel=panel; 
    }
    public void limpiar(){ //Limpia el panel y borra todas las graficas instanciadas (o almenos borra la referencia.
        limpiarBarras();
        limpiarCircular();
        
        limpiarPanel();  
        
    }
    public void limpiarBarras(){
        this.graficaBarras=null;
    }
    public void limpiarCircular(){
        this.graficaCircular=null;
    }
    public void limpiarLineal(){
        this.graficaLineal=null;
    }
    public void limpiarHistograma(){
        this.histograma=null;
    }
    public void limpiarPanel(){
        this.panel.removeAll();
    }
    public void inventario(){
        try {
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Inventario","Producto","Unidades",true,false);
            //accesor=conexion.prepareStatement("SELECT * FROM inventario");
            //iterador=accesor.executeQuery();
            
            ResultSet rs =control.getRowsInventory();
            this.graficaBarras.anadirDato(rs,"Unidades","cantidad","nombre");
            graficaBarras.graficar(this.panel);
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(panel, "Ha ocurrido un error. F");
        }
    }
    
    public void productosMasCaros(){
        try {
            limpiar();
            ResultSet rs=control.getRowsInventoryByPrecio();
            this.graficaBarras=new GraficaBarras("Productos Más Costosos","Producto","Unidades",true,false);
            this.graficaBarras.anadirDato(rs,"Precio","precio","nombre");
            graficaBarras.graficar(this.panel);
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(panel, "Ha ocurrido un error. F");
        }
    }
    public void ingresosPorProducto(){
        try {
            limpiar();
            ResultSet iterador=control.getRowsInventory();
            this.graficaCircular=new GraficaCircular("Ingreso por producto");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),control.getIngresoTotal(iterador.getInt("idproducto")));
            }
            graficaCircular.graficar(this.panel);
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gastoPorProducto(){
        try {
            limpiar();
            ResultSet iterador=control.getRowsInventory();
            this.graficaCircular=new GraficaCircular("Gasto por producto");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),control.getGastoTotal(iterador.getInt("idproducto")));
            }
            graficaCircular.graficar(this.panel);
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosVsVentasTotales(){
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas por Producto","Producto","",true,true);
            graficaBarras.anadirDato(control.getIngresoTotal(), "Ingresos", "Ingresos Totales");
            graficaBarras.anadirDato(control.getGastoTotal(), "Gastos", "Gastos Totales");
            
            graficaBarras.graficar(panel);
    }
    public void ingresosVsVentasPorProducto(){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas por Producto","Producto","",true,true);
            ResultSet iterador=control.getRowsInventory();
            while(iterador.next()){
                graficaBarras.anadirDato(control.getGastoTotal(iterador.getInt("idproducto")), "Gastos", iterador.getString("nombre"));
                graficaBarras.anadirDato(control.getIngresoTotal(iterador.getInt("idproducto")), "Ingresos", iterador.getString("nombre"));
            }
            graficaBarras.graficar(panel);
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosVsVentasVsGanancias(){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas  Vs Ganacias por Producto","Producto","",true,true);
            ResultSet iterador=control.getRowsInventory();
            while(iterador.next()){
                graficaBarras.anadirDato(control.getGastoTotal(iterador.getInt("idproducto")), "Gastos", iterador.getString("nombre"));
                graficaBarras.anadirDato(control.getIngresoTotal(iterador.getInt("idproducto")), "Ingresos", iterador.getString("nombre"));
                graficaBarras.anadirDato(control.getIngresoTotal(iterador.getInt("idproducto"))-control.getGastoTotal(iterador.getInt("idproducto")), "Ganancias", iterador.getString("nombre"));
            }
            graficaBarras.graficar(panel);
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void unidadesVendidas(){
        try {
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Unidades Vendidas Por Producto","Producto","Unidades Vendidas",true,false);
            
            ResultSet rs =control.getRowsInventory();
            while(rs.next()){
                graficaBarras.anadirDato(control.getUnidadesVendidas(rs.getInt("idproducto")),"Unidades Vendidas" , rs.getString("nombre"));
            }
            graficaBarras.graficar(this.panel);
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(panel, "Ha ocurrido un error. F");
        }
    }
}

    

