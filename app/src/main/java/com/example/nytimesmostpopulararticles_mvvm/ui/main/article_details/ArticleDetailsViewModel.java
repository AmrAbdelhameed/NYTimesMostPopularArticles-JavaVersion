package com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details;

import com.example.nytimesmostpopulararticles_mvvm.data.DataManager;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

public class ArticleDetailsViewModel extends BaseViewModel<ArticleDetailsNavigator> {

    public ArticleDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
