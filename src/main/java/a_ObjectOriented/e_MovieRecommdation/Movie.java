package a_ObjectOriented.e_MovieRecommdation;

class Movie {
    private final int id;
    private final String title;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
