package com.example.nytimesmostpopulararticles_mvvm.data.local.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    @Delete
    void delete(Article article);

    @Query("SELECT * FROM favorites WHERE id = :id")
    Article findById(long id);

    @Query("SELECT * FROM favorites")
    LiveData<List<Article>> loadAll();
}
