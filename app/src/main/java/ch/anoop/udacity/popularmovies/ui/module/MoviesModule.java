package ch.anoop.udacity.popularmovies.ui.module;

import ch.anoop.udacity.popularmovies.ApplicationModule;
import ch.anoop.udacity.popularmovies.ui.fragment.FavoredMoviesFragment;
import ch.anoop.udacity.popularmovies.ui.fragment.MovieFragment;
import ch.anoop.udacity.popularmovies.ui.fragment.SortedMoviesFragment;
import dagger.Module;

@Module(
        injects = {
                SortedMoviesFragment.class,
                FavoredMoviesFragment.class,
                MovieFragment.class
        },
        addsTo = ApplicationModule.class
)
public final class MoviesModule {
}
