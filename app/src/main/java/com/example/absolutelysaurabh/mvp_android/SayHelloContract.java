package com.example.absolutelysaurabh.mvp_android;

/**
 * Created by absolutelysaurabh on 25/2/18.
 */

public class SayHelloContract {

    //represents view in mvp
    public interface View{
        void showMessage(String message);
        void showError(String error);
    }

    //represents the presenter in MVP
    public interface Presenter{
        void loadMessage();
        void saveName(String firstname, String lastName);
    }
}
