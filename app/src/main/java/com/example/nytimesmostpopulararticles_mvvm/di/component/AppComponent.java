package com.example.nytimesmostpopulararticles_mvvm.di.component;

import android.app.Application;

import com.example.nytimesmostpopulararticles_mvvm.CustomApplication;
import com.example.nytimesmostpopulararticles_mvvm.di.builder.ActivityBuilder;
import com.example.nytimesmostpopulararticles_mvvm.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(CustomApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
