package com.example.nytimesmostpopulararticles_mvvm.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.nytimesmostpopulararticles_mvvm.data.local.db.dao.ArticleDao;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}
