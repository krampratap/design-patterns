package a_ObjectOriented.e_MovieRecommdation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RatingRegister {
    private final Map<Integer, List<Movie>> userMovies;
    private final Map<Integer, Map<Integer, MovieRating>> movieRatings;

    private final List<Movie> movies;
    private final List<User> users;

    public RatingRegister() {
        this.userMovies = new HashMap<>();
        this.movieRatings = new HashMap<>();

        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addRating(User user, Movie movie, MovieRating rating) {
        if (!this.movieRatings.containsKey(movie.getId())) {
            this.movieRatings.put(movie.getId(), new HashMap<>());
            this.movies.add(movie);
        }
        if (!this.userMovies.containsKey(user.getId())) {
            this.userMovies.put(user.getId(), new ArrayList<>());
            this.users.add(user);
        }
        this.userMovies.get(user.getId()).add(movie);
        this.movieRatings.get(movie.getId()).put(user.getId(), rating);
    }

    public double getAverageRating(Movie movie) {
        if (!this.movieRatings.containsKey(movie.getId())) {
            return MovieRating.NOT_RATED.ordinal();
        }
        Map<Integer, MovieRating> ratings = this.movieRatings.get(movie.getId());
        int sum = 0;
        for (MovieRating rating : ratings.values()) {
            sum += rating.ordinal();
        }
        return (double) sum / ratings.size();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public List<Movie> getUserMovies(User user) {
        if (!this.userMovies.containsKey(user.getId())) {
            return new ArrayList<>();
        }
        return this.userMovies.get(user.getId());
    }

    public Map<Integer, MovieRating> getMovieRatings(Movie movie) {
        if (!this.movieRatings.containsKey(movie.getId())) {
            return new HashMap<>();
        }
        return this.movieRatings.get(movie.getId());
    }
}
