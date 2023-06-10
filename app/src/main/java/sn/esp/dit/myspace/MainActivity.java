package sn.esp.dit.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView usernameTxt ;
    TextView passwordTxt;
    TextView resultTxt;
    Button connexionBtn;
    Button inscriptionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTxt= findViewById(R.id.username);
        passwordTxt= findViewById(R.id.password);
        resultTxt= findViewById(R.id.result);
        connexionBtn= findViewById(R.id.connexion);
        inscriptionBtn= findViewById(R.id.inscription);
        connexionBtn.setOnClickListener(this);
        inscriptionBtn.setOnClickListener(this);
        usernameTxt.setOnClickListener(this);
    }
    private void seconnecter(){
        resultTxt.setText("");
        new  RequestTask(resultTxt)
                .execute(
                        "https://myspace-esp.000webhostapp.com/connexion-api.php",
                        usernameTxt.getText().toString(),
                        passwordTxt.getText().toString()
                );

    }
    private void inscription(){

    }

    @Override
    public void onClick(View view) {
        Log.d("request", "on click event");
        switch (view.getId()){
            case  R.id.connexion:  this.seconnecter(); break;
            case  R.id.inscription: inscription(); break;
            case  R.id.username: break;
            case  R.id.password: break;

        }

    }
}