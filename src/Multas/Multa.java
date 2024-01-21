
package Multas;

/**
 *
 * @author jomel
 */
public class Multa {
    private int Codigo;
    private String Nombre;
    private String Tipo;
    private double Monto;
    private boolean Pagado;
    public double TIPO_GRAVE = 150.3;
    public double TIPO_MEDIO = 90.5;
    public double TIPO_LEVE = 75.8;

    public int getCodigo() {
        return Codigo;
    }

    public double getMonto() {
        return Monto;
    }

    public boolean isPagado() {
        return Pagado;
    }
    
    public Multa(int Codigo, String Nombre, String Tipo){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        Pagado = false;
        if(Tipo.equals("MEDIO")){
            Monto = TIPO_MEDIO;
        }else if(Tipo.equals("LEVE")){
            Monto = TIPO_LEVE;
        }else if(Tipo.equals("GRAVE")){
            Monto = TIPO_GRAVE;
        }else{
            Monto = TIPO_LEVE;
        }
        
    }
    
    public String print(){
        String texto = (Pagado == false)?
                "Multa pendiente.": "Pagado por un monto de Lps." + Monto;
        
        return texto;
    }
    
    public String pay(){
        Pagado = true;
        return "Multa con código " + Codigo + " fue pagada por un monto de Lps." + Monto;
    }
}
