package com.dzzchao.wandroid.data.source;

import com.dzzchao.wandroid.data.Article;

import java.util.List;

import io.reactivex.Observable;

/**
 * 可以在这里处理，比如是否加载本地缓存的
 */
public class ArticleRepository implements ArticleDataSource {

    @Override
    public Observable<List<Article>> loadArticles(int page, int size) {
        return null;
    }
}
