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
    static private Connection conexion;
    static private ResultSet iterador;
    private JPanel panel;
    static private PreparedStatement accesor;
    public Graficador(Connection conexion, JPanel panel){ 
        Graficador.conexion=conexion;
        this.panel=panel; //Panel asociado, donde Graicador implementará las gráficas
    }
    public Graficador(Conexion con,JPanel panel){
        this(con.getConexion(),panel);
    }
    public void limpiar(){ //Limpia el panel y borra todas las graficas instanciadas (o almenos borra la referencia.
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
        /*
        */
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Inventario","Producto","Unidades",true,false);
            accesor=conexion.prepareStatement("SELECT * FROM inventario");
            iterador=accesor.executeQuery();
            this.graficaBarras.anadirDato(iterador,"Unidades","cantidad","nombre");
            graficaBarras.graficar(this.panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Ha ocurrido un error. F");
        }
    }
    public void ingresosVentas(){
        try {
            limpiar();
            this.graficaCircular=new GraficaCircular("Ingresos por venta de productos"); //No sé que nombres colocar xd
            accesor=conexion.prepareStatement("SELECT * FROM inventario");
            
            iterador=accesor.executeQuery();
            this.graficaCircular.anadirDato(iterador,"nombre","ventatotal");
            graficaCircular.graficar(this.panel);           
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gastosCompras(){
        try {
            limpiar();
            this.graficaCircular=new GraficaCircular("Balance"); 
            accesor=conexion.prepareStatement("SELECT * FROM inventario");
            
            iterador=accesor.executeQuery();
            this.graficaBarras.anadirDato(iterador,"Ingresos","nombre","gastototal");
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void productosMayorIngresos(int n){
        try {
            limpiar();
            this.graficaCircular=new GraficaCircular("Productos "); 
            accesor=conexion.prepareStatement("SELECT * FROM inventario ORDER BY ventatotal");
            
            iterador=accesor.executeQuery();
            this.graficaBarras.anadirDato(iterador,"Ingreso","nombre","ventatotal");  
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
           
}
