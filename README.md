# obligatorio_prog2_sgarcia1_rquincke
# Descripción de la carga masiva de datos:
Para cargar los datos del csv, tenemos un objeto Cancion con un atributo por cada “columna” del csv (columna entre comillas porque es un coma-separated-file, es decir se separan por comas y no por columnas).
Como salida nuestra clase CSVImport da una lista con dos objetos: uno es una lista de fechas únicas y el otro es un hash con clave fecha y como valor una lista de canciones de esa fecha, donde cada objeto Canción tiene todos los atributos de la línea del csv.
Para leer el archivo csv, utilizamos la clase BufferedReader que lee el archivo línea por línea. La primera línea del archivo que contiene los nombres de los datos se saltea para importar solamente los datos.
El procesamiento de las líneas del csv se realiza mediante una iteración que se detiene al alcanzar el número máximo de registros ingresado (maxRecords). Cada línea se parsea utilizando el método parseCsvLine. Las líneas vacías o que no contienen el número esperado de campos (25) se saltan para mantener la integridad de los datos (igualmente esto no ocurre en la práctica).
Una vez extraídos y limpiados los valores de cada campo en la línea, estos se convierten a su tipo de dato correspondiente, como cadenas, enteros, booleanos y doubles. Esta conversión asegura que los datos sean manejables y precisos.
Con los datos extraídos, se crea una instancia de Cancion. Este objeto tiene toda la información relevante de la línea del csv.
Para almacenar las canciones en el hash cerrado, se verifica si ya existe una lista de canciones para la fecha de la instantánea (snapshotDate). Si no existe, se crea una nueva lista, se agrega la canción y se inserta en el hash. Si ya existe, la canción se añade a la lista existente, garantizando que todas las canciones de una misma fecha estén agrupadas.
El proceso incluye manejo de excepciones para capturar y manejar problemas de entrada/salida (IOException) y claves duplicadas (DuplicateKey). Esto asegura que el programa pueda manejar errores de manera consistente.
Finalmente, se agrega el hash cerrado y la lista de fechas al resultado, que se devuelve como una lista resultado con el hash de canciones y las fechas únicas.
# Métodos auxiliares:
El método parseArtists convierte una cadena de artistas en una lista enlazada de nombres de artistas, facilitando el manejo de múltiples artistas por canción.

El método parseInt convierte una cadena en un entero, lo cual elimina comillas y caracteres innecesarios.

El método parseDouble convierte una cadena en un número flotante, eliminando comillas y caracteres innecesarios.

El método parseCsvLine divide una línea del CSV en un arreglo de cadenas, considerando las comillas para manejar los campos con comas.
