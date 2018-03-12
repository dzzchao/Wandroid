package com.dzzchao.wandroid.data.source.remote;

import com.dzzchao.wandroid.data.Article;
import com.dzzchao.wandroid.data.source.ArticleDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * 随便你想用什么
 */
public class ArticleRemoteDataSource implements ArticleDataSource {
    @Override
    public Observable<List<Article>> loadArticles(int page, int size) {
        return null;
    }
}
