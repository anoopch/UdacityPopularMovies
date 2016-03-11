package ch.anoop.udacity.popularmovies.data.repository;

import com.squareup.sqlbrite.BriteContentResolver;

import java.util.Map;

import ch.anoop.udacity.popularmovies.data.api.MoviesApi;
import ch.anoop.udacity.popularmovies.data.model.Genre;
import ch.anoop.udacity.popularmovies.data.provider.MoviesContract;
import rx.Observable;
import rx.schedulers.Schedulers;

final class GenresRepositoryImpl implements GenresRepository {

    private final MoviesApi mMoviesApi;
    private final BriteContentResolver mBriteContentResolver;

    public GenresRepositoryImpl(MoviesApi moviesApi, BriteContentResolver briteContentResolver) {
        mMoviesApi = moviesApi;
        mBriteContentResolver = briteContentResolver;
    }

    @Override
    public Observable<Map<Integer, Genre>> genres() {
        return mBriteContentResolver.createQuery(MoviesContract.Genres.CONTENT_URI, Genre.PROJECTION, null, null, null, true)
                .map(Genre.PROJECTION_MAP)
                .subscribeOn(Schedulers.io());
    }
}
