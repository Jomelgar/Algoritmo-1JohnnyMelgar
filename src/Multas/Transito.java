
package Multas;

import javax.swing.JOptionPane;

/**
 *
 * @author jomel
 */
public class Transito {
    public Multa[] multas;
    public int contador;
    
    public Transito(){
        contador = 0;
        multas = new Multa[100];
    }
    
    public Multa buscaMultas(int Codigo){
        return buscaMultas(Codigo, 0);
    }
    private Multa buscaMultas(int codigo, int pos){
        if(pos < multas.length){
            if(multas[pos] != null){
                if(multas[pos].getCodigo() == codigo){
                    return multas[pos];
                }
                return buscaMultas(codigo, pos + 1);
            }
            return buscaMultas(codigo, pos + 1);  
        }
        return null;
    }
    
    public boolean agregarMulta(String Nombre, int Codigo, String Tipo){
        if(contador < 100){
            if(buscaMultas(Codigo) == null){
                multas[contador] = new Multa(Codigo, Nombre, Tipo);
                contador++;
                JOptionPane.showMessageDialog(null, "Usuario exitosamente agregado");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: Ese código ya existe");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: No hay espacio para agregar más multas.");
            return false;
        }
    }
    
    public void PagoMulta(int codigo){
        Multa multa = buscaMultas(codigo);
        if(multa != null){
            multa.pay();
            JOptionPane.showMessageDialog(null, "Multa pagada.");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: No existe dicha multa.");
        }
    }
    
    public String imprimirMulta(){
        return imprimirMulta("", 0);
    } 
    
    private String imprimirMulta(String texto, int pos){
        if(pos < 100){
            if(multas[pos] != null){
                texto +=  multas[pos].print() + "\n";
                return imprimirMulta(texto, pos +1);
            }
            return imprimirMulta(texto, pos +1);
        }
        return texto;
    } 
    
    public void infoMultas(){
        int cantpagadas = 0;
        double pagadas = 0;
        double pendientes = 0;
        int cantpendientes = 0;
        
        for(int indice = 0; indice < multas.length; indice++){
            if(multas[indice] != null){
                if(multas[indice].isPagado()){
                    cantpagadas++;
                    pagadas += multas[indice].getMonto();
                }else{
                    cantpendientes++;
                    pendientes += multas[indice].getMonto();
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Multas generadas: " + contador 
                + "\nMultas Pagadas(" + cantpagadas +"): Lps." + pagadas + 
                "\nMultas pendientes(" + cantpendientes + "): Lps." + pendientes);
    }
}
