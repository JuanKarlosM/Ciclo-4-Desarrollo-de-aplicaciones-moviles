package co.edu.unab.proyectoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText documento;
    private EditText nombreCompleto;
    private EditText edad;
    private EditText peso;
    private  EditText estatura;
    private double IMC,estaturaDouble;
    private int pesoInt=0;
    private String recomendaciones="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        documento = (EditText) findViewById(R.id.txt_documento);
        nombreCompleto= (EditText) findViewById(R.id.txt_nombreUsuario);
        edad = (EditText)findViewById(R.id.txt_edad);
        peso = (EditText)findViewById(R.id.txt_peso);
        estatura = (EditText)findViewById(R.id.txt_estatura);



    }



    //método para cálcular el IMC
    public double calcularIMC(int peso, double estatura){
        return peso/(estatura*estatura);
    }
    //método para validar el IMC y dejar las recomencaiones
    public String tipoRecomendaciones(double IMC){
        String mensaje="";
        if(IMC<=15){
            mensaje="Delgadez muy severa";
        }else if(IMC>15 && IMC<=15.9){
            mensaje="Delgadez severa";
        }else if(IMC>=16 && IMC<=18.4){
            mensaje="Delgadez";
        }else if(IMC>=18.5 && IMC<=24.9){
            mensaje="Peso saludable";
        }else if(IMC>=25 && IMC<=29.9){
            mensaje="Sobrepeso";
        }else if(IMC>=30 && IMC<=34.9){
            mensaje="Obesidad moderada";
        }else if(IMC>=35 && IMC<=39.9){
            mensaje="Obesidad severa";
        }else{
            mensaje="Obesidad muy severa(Obesidad mórbida)";
        }

        return mensaje;
    }

    //método para el botón enviar
    public void enviarDatos(View view){
        if(validarCampos()){
            pesoInt=Integer.parseInt(peso.getText().toString());
            estaturaDouble = Double.parseDouble(estatura.getText().toString());

            IMC=calcularIMC(pesoInt,estaturaDouble);
            recomendaciones=tipoRecomendaciones(IMC);

            //conversión de double a String con formato
            DecimalFormat df = new DecimalFormat("###.##");
            String string_imc = String.valueOf(df.format(IMC));

            Intent intent = new Intent(this, DetalleIMC.class);
            intent.putExtra("dato1_documento", documento.getText().toString());
            intent.putExtra("dato2_nombreCompleto", nombreCompleto.getText().toString());
            intent.putExtra("dato3_edad", edad.getText().toString());
            intent.putExtra("dato4_peso", peso.getText().toString());
            intent.putExtra("dato4_estatura", estatura.getText().toString());
            intent.putExtra("dato5_IMC", string_imc);
            intent.putExtra("dato6_recomendacion", recomendaciones);
            startActivity(intent);
            Toast.makeText(this, "Datos ingresados", Toast.LENGTH_SHORT).show();
            limpiarCampos();

        }

    }
    //método para limpiar los campos del formulario
    private void limpiarCampos(){
        documento.setText("");
        nombreCompleto.setText("");
        edad.setText("");
        peso.setText("");
        estatura.setText("");
    }

    //método para validar datos
    private boolean validarCampos(){
        boolean retorna= true;
        String dato_documento =documento.getText().toString() ;
        String dato_nombreCompleto = nombreCompleto.getText().toString();
        String dato_edad =edad.getText().toString() ;
        String dato_peso = peso.getText().toString();
        String dato_estatura = estatura.getText().toString();
        if(dato_documento.isEmpty()){
            documento.setError("Debe completar el campo documento");
            retorna=false;
        }
        if(dato_nombreCompleto.isEmpty()){
            nombreCompleto.setError("Debe completar el campo Nombre");
            retorna=false;
        }
        if(dato_edad.isEmpty()){
            edad.setError("Debe completar el campo edad");
            retorna=false;
        }
        if(dato_peso.isEmpty()){
            peso.setError("Debe completar el campo peso");
            retorna=false;
        }
        if(dato_estatura.isEmpty()){
            estatura.setError("Debe completar el campo estatura");
            retorna=false;
        }
        return retorna;
    }
}