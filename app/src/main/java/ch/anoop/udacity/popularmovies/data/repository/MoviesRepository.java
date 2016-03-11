package ch.anoop.udacity.popularmovies.data.repository;

import java.util.List;
import java.util.Set;

import ch.anoop.udacity.popularmovies.data.api.Sort;
import ch.anoop.udacity.popularmovies.data.model.Movie;
import ch.anoop.udacity.popularmovies.data.model.Review;
import ch.anoop.udacity.popularmovies.data.model.Video;
import rx.Observable;

public interface MoviesRepository {

    Observable<List<Movie>> discoverMovies(Sort sort, int page);

    Observable<List<Movie>> savedMovies();

    Observable<Set<Long>> savedMovieIds();

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);

    Observable<List<Video>> videos(long movieId);

    Observable<List<Review>> reviews(long movieId);
}