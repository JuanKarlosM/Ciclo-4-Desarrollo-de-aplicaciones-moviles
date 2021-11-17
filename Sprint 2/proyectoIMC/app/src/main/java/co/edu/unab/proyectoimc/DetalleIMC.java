package co.edu.unab.proyectoimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleIMC extends AppCompatActivity {

    private TextView documento;
    private TextView nombreCompleto;
    private TextView edad;
    private TextView peso;
    private  TextView estatura;
    private TextView IMC;
    private TextView tipoUsuario;
    private TextView genero;
    private TextView recomendaciones;
    private MainActivity main;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_imc);
        Button bt_atras = (Button) findViewById(R.id.bt_IrActividad1);

        documento = (TextView)findViewById(R.id.txtDocumento);
        nombreCompleto= (TextView) findViewById(R.id.txtNombreCompleto);
        edad = (TextView)findViewById(R.id.txtEdad);
        peso = (TextView)findViewById(R.id.txtPeso);
        estatura = (TextView)findViewById(R.id.txtEstatura);
        genero = (TextView)findViewById(R.id.txtGenero);
        tipoUsuario = (TextView)findViewById(R.id.txtTipoUsuario);

        IMC=(TextView)findViewById(R.id.txtIMC);
        recomendaciones=(TextView)findViewById(R.id.txtRecomendaciones);

        String dato_documento = getIntent().getStringExtra("dato1_documento");
        String dato_nombreCompleto = getIntent().getStringExtra("dato2_nombreCompleto");
        String dato_edad = getIntent().getStringExtra("dato3_edad");
        String dato_peso = getIntent().getStringExtra("dato4_peso");
        String dato_estatura = getIntent().getStringExtra("dato4_estatura");
        String dato_genero = getIntent().getStringExtra("dato5_genero");
        String dato_tipoUsuario= getIntent().getStringExtra("dato6_tipoUsuario");
        String dato_IMC = getIntent().getStringExtra("dato7_IMC");
        String dato_recomendaciones = getIntent().getStringExtra("dato8_recomendacion");


        documento.setText("Documento: " + dato_documento);
        nombreCompleto.setText("Nombre completo: " + dato_nombreCompleto);
        edad.setText("Edad: " + dato_edad);
        peso.setText("Peso: " + dato_peso);
        estatura.setText("Estatura: " + dato_estatura);
        genero.setText("Género: " + dato_genero);
        tipoUsuario.setText("Tipo de usuario: " + dato_tipoUsuario);
        IMC.setText("IMC: " + dato_IMC);
        recomendaciones.setText("Recomendaciones: " + dato_recomendaciones);



        bt_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();


            }
        });

    }


}