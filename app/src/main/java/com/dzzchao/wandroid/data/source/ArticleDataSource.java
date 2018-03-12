package com.dzzchao.wandroid.data.source;

import com.dzzchao.wandroid.data.Article;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author shenghaiyang
 */
public interface ArticleDataSource {

    Observable<List<Article>> loadArticles(int page, int size);

}
