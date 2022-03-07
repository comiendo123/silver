package com.example.appsilvermin.administrador.adminverceldas.flotacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;

import java.util.HashMap;
import java.util.Map;

public class agregarcelda extends AppCompatActivity {

    EditText id, nombre, descripcion, cantidadhoras,salidatotal, seccion;
    ImageView imagentrabajador, tomarfoto;
    Button ingresar, cancelar;
    String currentPhotoPath;
    Bitmap decoded;
    RequestQueue requestQueue;

    private static final int REQUEST_PERMISSION_CAMERA = 100;
    private static final int REQUEST_TAKE_PHOTO = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarcelda);

        //  id = this.findViewById(R.id.modmarca);
        nombre = this.findViewById(R.id.nombrecelda);
        descripcion = this.findViewById(R.id.descipcioncelda);
        seccion = this.findViewById(R.id.seccioncelda);
        /*celular = this.findViewById(R.id.celulardetallecelda);
        passwordd = this.findViewById(R.id.ingresarcontrasena);
*/


        ingresar=findViewById(R.id.botoningresarcelda);
        ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (v.getContext(), celda.class);
                startActivityForResult(intent, 0);
                insertar();
            }
        });
    }
    private void insertar(){

        String nombre1=nombre.getText().toString().trim();
        String descripcion1=descripcion.getText().toString().trim();
        String secccion1=seccion.getText().toString().trim();


        //  String horas1=horas.getText().toString().trim();

        ProgressDialog progressDialog=new ProgressDialog(this);
        if(nombre1.isEmpty()){
            nombre.setError("complete los campos");
        }
        else if(descripcion1.isEmpty()){
            descripcion.setError("complete los campos");
        }
        else if(secccion1.isEmpty()){
            seccion.setError("complete los campos");
        }
        /*    else if(horas1.isEmpty()){
                horas.setError("complete los campos");
            }*/else{
            progressDialog.show();
            StringRequest request=new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarflotacion", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos insertados")) {
                        Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(agregarcelda.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregarcelda.this, error.getMessage(),Toast.LENGTH_SHORT).show();;
                    progressDialog.dismiss();;
                }
            }){
                @Override
                protected Map<String, String> getParams() throws  AbstractMethodError{
                    Map<String, String>params=new HashMap<String, String>();
                    params.put("nombre",nombre1);
                    params.put("descripcion",descripcion1);
                    params.put("seccion",secccion1);

                    //   params.put("horas",horas1);
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue( agregarcelda.this);
            requestQueue.add(request);

        }
    }












}
/*        initiu();


        requestQueue = Volley.newRequestQueue(this);
        ingresar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        tomarfoto.setOnClickListener(this);
    }

    private void initiu() {
        ci = this.findViewById(R.id.ingresarci);
        nombre = this.findViewById(R.id.ingresarnombre);
        apellidos = this.findViewById(R.id.ingresarapellidos);
        cargo = this.findViewById(R.id.ingresarcargo);
        celular = this.findViewById(R.id.ingresarcelular);
        passwordd = this.findViewById(R.id.ingresarcontrasena);
        imagentrabajador = this.findViewById(R.id.imagentr);
        ingresar = this.findViewById(R.id.botoningresarcelda);
        cancelar = this.findViewById(R.id.botoncancelaringreso);
        tomarfoto = this.findViewById(R.id.tomarfoto);
    }

    private void goToSecondActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG" + timestamp + "_";
        File StorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /*prefix*/
/*      "jpg", /*suffix*/
/*    StorageDir /*directory*/

        /*);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void takePictureFullSize() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();

            } catch (IOException e) {
                e.getMessage();
            }

            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(
                        this,
                        "com.android.cameramysql",
                        photoFile
                );
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, REQUEST_TAKE_PHOTO);
            }
        }

    }
    private String getStringImage(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] imageBytes = baos.toByteArray();

        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private void checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                takePictureFullSize();
            }else{
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.CAMERA},
                        REQUEST_PERMISSION_CAMERA
                );
            }
        }else{
            takePictureFullSize();
        }

}


    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grandResults) {
        if (requestCode == REQUEST_PERMISSION_CAMERA) {
            if (permissions.length > 0 && grandResults[0] == PackageManager.PERMISSION_GRANTED) {
               //funcion de camara
                takePictureFullSize();
            } else {
                Toast.makeText(this, "YOu need to enable permissions", Toast.LENGTH_SHORT).show();
            }
            super.onRequestPermissionsResult(requestCode, permissions, grandResults);
        }
    }


    private Bitmap getResizedBitmap(Bitmap bitmap, int maxSize) {
        int width = bitmap.getWidth();
        int height= bitmap.getHeight();

        if (width <= maxSize && height <=maxSize){
            return  bitmap;
        }
        float bitmapRatio =(float) width/(float) height;
        if (bitmapRatio>1){
            width = maxSize;
            height = (int)(width/bitmapRatio);
        }else{
            height = maxSize;
            width = (int)(height * bitmapRatio);
        }


        return Bitmap.createScaledBitmap(bitmap,width,height,true);
    }

    private void uploadImage(){
        String URL ="";
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> params= new HashMap<>();

                params.put("path", getStringImage(decoded));
                return params;
        }
        };

    }
    private void setToimageView(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bytes);
        decoded= BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));

        imagentrabajador.setImageBitmap(decoded);
    }


    @Override
    public void onActivityResult(int requestCOde, int resultCode, @Nullable Intent data){
        if (requestCOde == REQUEST_TAKE_PHOTO) {
            if(resultCode == Activity.RESULT_OK){
               try{
                   File file = new File(currentPhotoPath);
                   Uri uri = Uri.fromFile(file);

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                        this.getContentResolver(),
                        uri
                );
                setToimageView(getResizedBitmap(bitmap,1024));
               }catch (IOException e){
                   e.printStackTrace();
               }
            }
        }
        super.onActivityResult(requestCOde,resultCode,data);
    }

    //takepicture ?== tomarfoto

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.botoningresarcelda) {
            checkPermission();
        } else if (id == R.id.tomarfoto) {
            uploadImage();
        }else if (id== R.id.botoncancelaringreso){
            goToSecondActivity();
        }
    }
}














        /*
        ci=this.findViewById(R.id.ingresarci);
        nombre=this.findViewById(R.id.ingresarnombre);
        apellidos=this.findViewById(R.id.ingresarapellidos);
        cargo=this.findViewById(R.id.ingresarcargo);
        celular=this.findViewById(R.id.ingresarcelular);
        passwordd=this.findViewById(R.id.ingresarcontrasena);
        imagentrabajador=this.findViewById(R.id.imagentr);
        ingresar1=this.findViewById(R.id.botoningresarcelda);
        cancelar=this.findViewById(R.id.botoncancelaringreso);
        tomarfoto=this.findViewById(R.id.tomarfoto);
//ADQUIERE LA INFORMACION DE LA CAMARA
        tomarfoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(agregartrabajador.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                        gotocamera();
                    }else{
                        ActivityCompat.requestPermissions(agregartrabajador.this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
                    }
                }else {gotocamera();}
            }
        });



//INGRESA DATOS BASICOS
        ingresar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar();
            }
        });
    }
    //camara

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grandResults){
        if (permissions.length > 0 && grandResults[0] == PackageManager.PERMISSION_GRANTED){
            gotocamera();
        }else{
            Toast.makeText(this, "YOu need to enable permissions", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grandResults);
    }

    @Override
    public void onActivityResult(int requestCOde, int resultCode, @Nullable Intent data){
        if (requestCOde == REQUEST_IMAGE_CAMERA) {
            if(resultCode == Activity.RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imagentrabajador.setImageBitmap(bitmap);
                Log.i("TAG","Result=>"+bitmap);
            }
        }
        super.onActivityResult(requestCOde,resultCode,data);
    }



    private void gotocamera(){
        Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraintent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(cameraintent,REQUEST_IMAGE_CAMERA);
        }
    }


    //insertardatos
    private void insertar() {
        String ci1=ci.getText().toString().trim();
        String nombre1=nombre.getText().toString().trim();
        String apellidos1=apellidos.getText().toString().trim();
        String cargo1=cargo.getText().toString().trim();
        String celular1=celular.getText().toString().trim();
        String passwordd1=ci.getText().toString().trim();

        ProgressDialog progressDialog=new ProgressDialog(this);
        if(ci1.isEmpty()){ ci.setError("complete los campos"); }
        else if(nombre1.isEmpty()){ nombre.setError("complete los capmos");
        }else if(apellidos1.isEmpty()){ apellidos.setError("complete los campos");
        }else if(cargo1.isEmpty()){ cargo.setError("complete los campos");
        }else if(celular1.isEmpty()){celular.setError("complete los campos");
        }else if(passwordd1.isEmpty()){ passwordd.setError("complete los campos");
        }  else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://localhost:2000/celda",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Datos insertados")){
                                limpiar();
                                Toast.makeText(agregartrabajador.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(agregartrabajador.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregartrabajador.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();
                    params.put("ci",ci1);
                    params.put("nombre",nombre1);
                    params.put("apellidos",apellidos1);
                    params.put("cargo",cargo1);
                    params.put("celular",celular1);
                    params.put("contraseña",passwordd1);
                    params.put("imagen", String.valueOf(imagentrabajador));
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(agregartrabajador.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public void limpiar(){
        Intent intent=new Intent(agregartrabajador.this,MainActivity.class);
        startActivity(intent);
        ci.setText("");
        nombre.setText("");
        apellidos.setText("");
        cargo.setText("");
        celular.setText("");
        passwordd.setText("");
    }*/
