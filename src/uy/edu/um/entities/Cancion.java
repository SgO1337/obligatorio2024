package uy.edu.um.entities;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class Cancion {
    private String spotify_id;
    private String name;
    private MyLinkedListImpl<String> artists;
    private int daily_rank;
    private int daily_movement;
    private int weekly_movement;
    private String country;
    private String snapshot_date;
    private int popularity;
    private boolean is_explicit;
    private double duration_ms;
    private String album_name;
    private String album_release_date;
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int time_signature;

    public Cancion(String spotify_id, String name, MyLinkedListImpl<String> artists, int daily_rank, int daily_movement,
                   int weekly_movement, String country, String snapshot_date, int popularity, boolean is_explicit,
                   double duration_ms, String album_name, String album_release_date, double danceability,
                   double energy, int key, double loudness, int mode, double speechiness, double acousticness,
                   double instrumentalness, double liveness, double valence, double tempo, int time_signature) {
        this.spotify_id = spotify_id;
        this.name = name;
        this.artists = artists;
        this.daily_rank = daily_rank;
        this.daily_movement = daily_movement;
        this.weekly_movement = weekly_movement;
        this.country = country;
        this.snapshot_date = snapshot_date;
        this.popularity = popularity;
        this.is_explicit = is_explicit;
        this.duration_ms = duration_ms;
        this.album_name = album_name;
        this.album_release_date = album_release_date;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.time_signature = time_signature;
    }

    public String getSpotify_id() {
        return spotify_id;
    }

    public void setSpotify_id(String spotify_id) {
        this.spotify_id = spotify_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLinkedListImpl<String> getArtists() {
        return artists;
    }

    public void setArtists(MyLinkedListImpl<String> artists) {
        this.artists = artists;
    }

    public int getDaily_rank() {
        return daily_rank;
    }

    public void setDaily_rank(int daily_rank) {
        this.daily_rank = daily_rank;
    }

    public int getDaily_movement() {
        return daily_movement;
    }

    public void setDaily_movement(int daily_movement) {
        this.daily_movement = daily_movement;
    }

    public int getWeekly_movement() {
        return weekly_movement;
    }

    public void setWeekly_movement(int weekly_movement) {
        this.weekly_movement = weekly_movement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSnapshot_date() {
        return snapshot_date;
    }

    public void setSnapshot_date(String snapshot_date) {
        this.snapshot_date = snapshot_date;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isIs_explicit() {
        return is_explicit;
    }

    public void setIs_explicit(boolean is_explicit) {
        this.is_explicit = is_explicit;
    }

    public double getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(double duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_release_date() {
        return album_release_date;
    }

    public void setAlbum_release_date(String album_release_date) {
        this.album_release_date = album_release_date;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public int getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(int time_signature) {
        this.time_signature = time_signature;
    }
}