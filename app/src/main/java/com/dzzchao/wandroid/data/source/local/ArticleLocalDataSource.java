package com.dzzchao.wandroid.data.source.local;

import com.dzzchao.wandroid.data.Article;
import com.dzzchao.wandroid.data.source.ArticleDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * 可以写sp，file，db等实现
 */
public class ArticleLocalDataSource implements ArticleDataSource {

    @Override
    public Observable<List<Article>> loadArticles(int page, int size) {
        return null;
    }
}
