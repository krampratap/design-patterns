package a_oops.e_MovieRecommdation;

import java.util.Map;

class MovieRecommendation {
    private RatingRegister ratingRegister;

    public MovieRecommendation(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public String recommendMovie(User user) {
        if (this.ratingRegister.getUserMovies(user).isEmpty()) {
            return this.recommendMovieNewUser();
        } else {
            return this.recommendMovieExistingUser(user);
        }
    }

    // Recommend the movie with the highest average rating
    private String recommendMovieNewUser() {
        Movie bestMovie = null;
        double bestRating = 0;
        for (Movie movie : this.ratingRegister.getMovies()) {
            double rating = this.ratingRegister.getAverageRating(movie);
            if (rating > bestRating) {
                bestMovie = movie;
                bestRating = rating;
            }
        }
        return bestMovie != null ? bestMovie.getTitle() : null;
    }

    // Recommend highest rated movie from another user with similar interest
    private String recommendMovieExistingUser(User user) {
        Movie bestMovie = null;
        int similarityScore = Integer.MAX_VALUE; // Lower is better

        for (User reviewer : this.ratingRegister.getUsers()) {
            if (reviewer.getId() == user.getId()) {
                continue;
            }
            int score = this.getSimilarityScore(user, reviewer);
            if (score < similarityScore) {
                similarityScore = score;
                Movie recommendedMovie = this.recommendUnwatchedMovie(user, reviewer);
                bestMovie = recommendedMovie != null ? recommendedMovie : bestMovie;
            }
        }
        return bestMovie != null ? bestMovie.getTitle() : null;
    }

    private int getSimilarityScore(User user1, User user2) {
        int score = Integer.MAX_VALUE; // Lower is better

        for (Movie movie : this.ratingRegister.getUserMovies(user2)) {
            Map<Integer, MovieRating> ratings = this.ratingRegister.getMovieRatings(movie);
            // If user1 also rated the movie, add the difference in ratings
            if (ratings.containsKey(user1.getId())) {
                score = (score == Integer.MAX_VALUE) ? 0 : score;
                score += Math.abs(ratings.get(user1.getId()).ordinal() - ratings.get(user2.getId()).ordinal());
            }
        }
        return score;
    }

    private Movie recommendUnwatchedMovie(User user, User reviewer) {
        Movie bestMovie = null;
        int bestRating = 0;

        for (Movie movie : this.ratingRegister.getUserMovies(reviewer)) {
            Map<Integer, MovieRating> ratings = this.ratingRegister.getMovieRatings(movie);
            // If user has not watched the movie, and the reviewer gave it a high rating, recommend it
            if (!ratings.containsKey(user.getId()) && ratings.get(reviewer.getId()).ordinal() > bestRating) {
                bestMovie = movie;
                bestRating = ratings.get(reviewer.getId()).ordinal();
            }
        }
        return bestMovie;
    }
}
