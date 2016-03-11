package ch.anoop.udacity.popularmovies.data.repository;

import java.util.Map;

import ch.anoop.udacity.popularmovies.data.model.Genre;
import rx.Observable;

public interface GenresRepository {

    Observable<Map<Integer, Genre>> genres();

}
