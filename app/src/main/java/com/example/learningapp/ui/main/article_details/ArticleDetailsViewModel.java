package com.example.learningapp.ui.main.article_details;

import com.example.learningapp.data.DataManager;
import com.example.learningapp.ui.base.BaseViewModel;
import com.example.learningapp.utils.rx.SchedulerProvider;

public class ArticleDetailsViewModel extends BaseViewModel<ArticleDetailsNavigator> {

    public ArticleDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
