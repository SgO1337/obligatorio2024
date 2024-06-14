package uy.edu.um.classes;

import uy.edu.um.prog2.adt.closedhash.ClosedHashImpl;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.Cancion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVImport {
    public static MyLinkedListImpl<Object> importData(String filePath, int maxRecords) {
        MyLinkedListImpl<Cancion> list = new MyLinkedListImpl<>();
        MyLinkedListImpl<String> fechas = new MyLinkedListImpl<>();
        MyLinkedListImpl<Object> resultado = new MyLinkedListImpl<>();
        ClosedHashImpl<String, MyLinkedListImpl<Cancion>> hashCanciones = new ClosedHashImpl<>(10);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordsCount = 1;

            reader.readLine(); //Me salteo la primera linea que tiene los nombres de las cosas

            while (recordsCount < maxRecords) {
                line = reader.readLine();

                if (line.isEmpty()) {
                    continue;
                }

                String[] row = parseCsvLine(line);

                if (row.length != 25) {
                    continue;
                }

                String spotifyId = row[0].replaceAll("\"", "").trim();
                String name = row[1].replaceAll("\"", "").trim();
                MyLinkedListImpl<String> artists = parseArtists(row[2]);
                int dailyRank = parseInt(row[3]);
                int dailyMovement = parseInt(row[4]);
                int weeklyMovement = parseInt(row[5]);
                String country = row[6].replaceAll("\"", "").trim();
                String snapshotDate = row[7].replaceAll("\"", "").trim();

                int popularity = parseInt(row[8]);
                boolean isExplicit = Boolean.parseBoolean(row[9]);
                double durationMs = parseDouble(row[10]);
                String albumName = row[11].replaceAll("\"", "").trim();
                String albumReleaseDate = row[12].replaceAll("\"", "").trim();
                double danceability = parseDouble(row[13]);
                double energy = parseDouble(row[14]);
                int key = parseInt(row[15]);
                double loudness = parseDouble(row[16]);
                int mode = parseInt(row[17]);
                double speechiness = parseDouble(row[18]);
                double acousticness = parseDouble(row[19]);
                double instrumentalness = parseDouble(row[20]);
                double liveness = parseDouble(row[21]);
                double valence = parseDouble(row[22]);
                double tempo = parseDouble(row[23]);
                int timeSignature = parseInt(row[24]);

                Cancion cancion = new Cancion(spotifyId, name, artists, dailyRank, dailyMovement, weeklyMovement,
                        country, snapshotDate, popularity, isExplicit, durationMs, albumName, albumReleaseDate,
                        danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness,
                        liveness, valence, tempo, timeSignature);

                if(hashCanciones.getValue(snapshotDate) == null) {
                    MyLinkedListImpl<Cancion> canciones = new MyLinkedListImpl<Cancion>();
                    fechas.add(snapshotDate);
                    canciones.add(cancion);
                    hashCanciones.insertar(snapshotDate, canciones);
                } else {
                    hashCanciones.getValue(snapshotDate).add(cancion);
                }

                recordsCount++;
            }
        } catch (IOException | DuplicateKey e) {
            e.printStackTrace();
        }

        resultado.add(hashCanciones);
        resultado.add(fechas);

        return resultado;
    }

    private static MyLinkedListImpl<String> parseArtists(String artistsString) {
        MyLinkedListImpl<String> artistList = new MyLinkedListImpl<>();
        String[] artists = artistsString.split(",");
        for (String artist : artists) {
            artistList.add(artist.trim());
        }
        return artistList;
    }

    private static int parseInt(String value) {
        return Integer.parseInt(value.replaceAll("\"", "").replaceAll(";", "").trim());
    }

    private static double parseDouble(String value) {
        return Double.parseDouble(value.replaceAll("\"", "").trim());
    }

    private static String[] parseCsvLine(String line) {
        MyLinkedListImpl<String> tokens = new MyLinkedListImpl<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inQuotes = false;
        char[] chars = line.toCharArray();

        for (char c : chars) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(currentToken.toString());
                currentToken.setLength(0);
            } else {
                currentToken.append(c);
            }
        }
        tokens.add(currentToken.toString());

        return (String[]) tokens.toArray();
    }
}