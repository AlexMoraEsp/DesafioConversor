package com.desafioalura.monedas.conversionmoneda;

public class CambioMoneda {

    private String base_code;
    private int numeroCambio; //Cuanto desea cambiar
    private String target_code;

    private Double conversion_result;


    public CambioMoneda(){}

    public CambioMoneda(ConversionMoneda conversionMoneda){
        this.base_code= conversionMoneda.base_code();
        this.target_code= conversionMoneda.target_code();

        this.conversion_result= Double.valueOf(conversionMoneda.conversion_result());
    }

    public void setNumeroCambio(int numeroDeMonedas){
        this.numeroCambio = numeroDeMonedas;
    }

    public String getBase_code() {
        return base_code;
    }

    public int getNumeroCambio() {
        return numeroCambio;
    }

    public String getTarget_code() {
        return target_code;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString(){
        return  "El valor "+ this.numeroCambio+" ["+this.base_code+"]"+
                "  corresponde al valor final de =>>>"+ this.conversion_result+" ["+ this.target_code+"]";



    }
}
