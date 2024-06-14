package uy.edu.um.entities;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class Cancion {
    private String spotifyId;
    private String name;
    private MyLinkedListImpl<String> artists;
    private int dailyRank;
    private int dailyMovement;
    private int weeklyMovement;
    private String country;
    private String snapshotDate;
    private int popularity;
    private boolean isExplicit;
    private double durationMs;
    private String albumName;
    private String albumReleaseDate;
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
    private int timeSignature;

    public Cancion(String spotifyId, String name, MyLinkedListImpl<String> artists, int dailyRank, int dailyMovement,
                   int weeklyMovement, String country, String snapshotDate, int popularity, boolean isExplicit,
                   double durationMs, String albumName, String albumReleaseDate, double danceability,
                   double energy, int key, double loudness, int mode, double speechiness, double acousticness,
                   double instrumentalness, double liveness, double valence, double tempo, int timeSignature) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
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
        this.timeSignature = timeSignature;
    }

    public String getSpotify_id() {
        return spotifyId;
    }

    public void setSpotify_id(String spotifyId) {
        this.spotifyId = spotifyId;
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
        return dailyRank;
    }

    public void setDaily_rank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDaily_movement() {
        return dailyMovement;
    }

    public void setDaily_movement(int dailyMovement) {
        this.dailyMovement = dailyMovement;
    }

    public int getWeekly_movement() {
        return weeklyMovement;
    }

    public void setWeekly_movement(int weeklyMovement) {
        this.weeklyMovement = weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSnapshot_date() {
        return snapshotDate;
    }

    public void setSnapshot_date(String snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isIs_explicit() {
        return isExplicit;
    }

    public void setIs_explicit(boolean isExplicit) {
        this.isExplicit = isExplicit;
    }

    public double getDuration_ms() {
        return durationMs;
    }

    public void setDuration_ms(double durationMs) {
        this.durationMs = durationMs;
    }

    public String getAlbum_name() {
        return albumName;
    }

    public void setAlbum_name(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbum_release_date() {
        return albumReleaseDate;
    }

    public void setAlbum_release_date(String albumReleaseDate) {
        this.albumReleaseDate = albumReleaseDate;
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
        return timeSignature;
    }

    public void setTime_signature(int timeSignature) {
        this.timeSignature = timeSignature;
    }
}