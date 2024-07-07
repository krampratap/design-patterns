package a_ObjectOriented.e_MovieRecommdation;

class ZMovieRecommendation {
    public static void main(String[] args) {
        User user1 = new User(1, "User 1");
        User user2 = new User(2, "User 2");
        User user3 = new User(3, "User 3");

        Movie movie1 = new Movie(1, "Batman Begins");
        Movie movie2 = new Movie(2, "Liar Liar");
        Movie movie3 = new Movie(3, "The Godfather");

        RatingRegister ratings = new RatingRegister();
        ratings.addRating(user1, movie1, MovieRating.FIVE);
        ratings.addRating(user1, movie2, MovieRating.TWO);
        ratings.addRating(user2, movie2, MovieRating.TWO);
        ratings.addRating(user2, movie3, MovieRating.FOUR);

        MovieRecommendation recommender = new MovieRecommendation(ratings);

        System.out.println(recommender.recommendMovie(user1)); // The Godfather
        System.out.println(recommender.recommendMovie(user2)); // Batman Begins
        System.out.println(recommender.recommendMovie(user3)); // Batman Begins
    }
}
