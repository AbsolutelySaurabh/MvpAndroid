package com.example.absolutelysaurabh.mvp_android;

import com.example.absolutelysaurabh.mvp_android.model.Person;

import javax.inject.Inject;

/**
 * Created by absolutelysaurabh on 25/2/18.
 */

public class SayHelloPresenter implements SayHelloContract.Presenter {

    private Person person;
    private SayHelloContract.View view;

    @Inject
    public SayHelloPresenter(Person person, SayHelloContract.View view) {
        this.person = person;
        this.view = view;
    }


    @Override
    public void loadMessage() {
        if(person.getFirstName() == null && person.getLastName() == null){
            view.showError("No Person was found.");
            return;
        }

        String message = "Hi " + person.getFirstName() + " !";
        view.showMessage(message);
    }

    @Override
    public void saveName(String firstname, String lastName) {
        person.setFirstName(firstname);
        person.setLastName(lastName);
    }
}
