package com.example.absolutelysaurabh.mvp_android.dagger;

import com.example.absolutelysaurabh.mvp_android.model.Person;
import com.example.absolutelysaurabh.mvp_android.SayHelloContract;

import dagger.Module;
import dagger.Provides;

@Module public class SayHelloPresenterModule {

    private final SayHelloContract.View view;

    private final Person person;

    public SayHelloPresenterModule(SayHelloContract.View view, Person person) {
        this.view = view;
        this.person = person;
    }

    @Provides
    SayHelloContract.View provideSayHelloContractView() {
        return view;
    }

    @Provides
    Person providePerson() {
        return person;
    }
}