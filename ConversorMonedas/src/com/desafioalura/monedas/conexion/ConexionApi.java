package com.desafioalura.monedas.conexion;

import com.desafioalura.monedas.conversionmoneda.CambioMoneda;
import com.desafioalura.monedas.conversionmoneda.ConversionMoneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static java.net.http.HttpClient.newHttpClient;

public class ConexionApi {

    public static void main(String[] args) throws IOException, InterruptedException {





        String monedaOrigen="";
        String monedaCambio="";
        int numeroMonedas,opcion;
        Scanner lectura= new Scanner(System.in);
        String direccion;

        while(true){
            System.out.println("**********************************************************");

            System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n\n");
            System.out.println("1) Dólar ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real brasileño");
            System.out.println("4) Real brasileño ==> Dólar");
            System.out.println("5) Dólar ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida");

            System.out.println("**********************************************************");
            opcion=lectura.nextInt();


            if(opcion>=1 && opcion<=7){

                System.out.println("Ingrese el valor que desea converter: ");
                numeroMonedas= lectura.nextInt();

                switch(opcion){

                    case 1: monedaOrigen="USD";
                        monedaCambio="ARS";
                        break;

                    case 2: monedaOrigen="ARS";
                        monedaCambio="USD";
                        break;

                    case 3: monedaOrigen="USD";
                        monedaCambio="BRL";
                        break;

                    case 4: monedaOrigen="BRL";
                        monedaCambio="USD";
                        break;

                    case 5: monedaOrigen="USD";
                        monedaCambio="COP";
                        break;

                    case 6: monedaOrigen="COP";
                        monedaCambio="USD";
                        break;
                }


                //FIn Switch
                direccion="https://v6.exchangerate-api.com/v6/0d061d4ab9403157ecdc6710/pair/"+monedaOrigen+"/"+monedaCambio+"/"+numeroMonedas;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
             //   System.out.println(json);

                Gson gson= new GsonBuilder().setPrettyPrinting().create();
                ConversionMoneda conversionMoneda= gson.fromJson(json,ConversionMoneda.class);
                CambioMoneda miCambioMoneda= new CambioMoneda(conversionMoneda);
                miCambioMoneda.setNumeroCambio(numeroMonedas);
                System.out.println(miCambioMoneda);

            } else {
                break;
            }











        }

        //direccion="https://v6.exchangerate-api.com/v6/0d061d4ab9403157ecdc6710/pair/EUR/GBP/10";

        System.out.println("Opcion Invalida");
        System.out.println("La ejecucion ha terminado");


    }

}
