package ch.anoop.udacity.popularmovies.data.repository;

import android.content.ContentResolver;

import com.squareup.sqlbrite.BriteContentResolver;

import javax.inject.Singleton;

import ch.anoop.udacity.popularmovies.data.api.MoviesApi;
import dagger.Module;
import dagger.Provides;

@Module(complete = false, library = true)
public final class RepositoryModule {

    @Singleton
    @Provides
    public GenresRepository providesGenresRepository(MoviesApi moviesApi, BriteContentResolver contentResolver) {
        return new GenresRepositoryImpl(moviesApi, contentResolver);
    }

    @Singleton
    @Provides
    public MoviesRepository providesMoviesRepository(MoviesApi moviesApi, ContentResolver contentResolver,
                                                     BriteContentResolver briteContentResolver, GenresRepository repository) {
        return new MoviesRepositoryImpl(moviesApi, contentResolver, briteContentResolver, repository);
    }
}