package com.example.nytimesmostpopulararticles_mvvm.ui.base;

public interface BaseNavigator<T> {

    void handleError(Throwable throwable);

    void setData(T data);
}
