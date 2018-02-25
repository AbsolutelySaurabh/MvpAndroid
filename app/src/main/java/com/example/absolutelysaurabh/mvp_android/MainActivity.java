package com.example.absolutelysaurabh.mvp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements SayHelloContract.View, View.OnClickListener{

    private SayHelloContract.Presenter presenter;

    //UI properties
    private TextView messageView;
    private EditText firstNameView;
    private EditText lastNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        //creates presenter
        presenter = new SayHelloPresenter(this);
    }

    private void initViews(){

        messageView = findViewById(R.id.message);
        firstNameView = findViewById(R.id.firstName);
        lastNameView = findViewById(R.id.lastName);

        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.showMessage).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.update:
                presenter.saveName(firstNameView.getText().toString(), lastNameView.getText().toString());
                break;

            case R.id.showMessage:
                presenter.loadMessage();
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        messageView.setText(message);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

}