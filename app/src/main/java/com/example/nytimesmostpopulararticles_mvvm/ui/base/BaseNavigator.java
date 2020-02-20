package com.example.nytimesmostpopulararticles_mvvm.ui.base;

public interface BaseNavigator<T> {

    void handleError(String message);

    void setData(T data);
}
