package com.example.absolutelysaurabh.mvp_android.dagger;

import com.example.absolutelysaurabh.mvp_android.MainActivity;

import dagger.Component;

/**
 * Created by absolutelysaurabh on 26/2/18.
 */

@Component(modules = SayHelloPresenterModule.class) public interface SayHelloComponent {

    void inject(MainActivity mainActivity);
}