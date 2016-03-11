package ch.anoop.udacity.popularmovies;

import android.app.Application;

import javax.inject.Singleton;

import ch.anoop.udacity.popularmovies.data.DataModule;
import dagger.Module;
import dagger.Provides;

@Module(
        includes = DataModule.class,
        injects = {
                PopularMoviesApplication.class
        },
        library = true
)
public final class ApplicationModule {
    private final PopularMoviesApplication application;

    public ApplicationModule(PopularMoviesApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}

