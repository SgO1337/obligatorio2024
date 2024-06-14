# Obligatorio de programacion 2 
### Integrantes: Santiago Garcia, Rodrigo Quincke
# Diagrama UML de la solucion brindada:

![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/6387b40a-61cb-4163-9fdd-2fff88c8d514)

# Descripción de la carga masiva de datos:
### Metodo principal:
Para cargar los datos del csv, tenemos un objeto Cancion con un atributo por cada “columna” del csv (columna entre comillas porque es un coma-separated-file, es decir se separan por comas y no por columnas).
Como salida nuestra clase CSVImport da una lista con dos objetos: uno es una lista de fechas únicas y el otro es un hash con clave fecha y como valor una lista de canciones de esa fecha, donde cada objeto Canción tiene todos los atributos de la línea del csv.
Para leer el archivo csv, utilizamos la clase BufferedReader que lee el archivo línea por línea. La primera línea del archivo que contiene los nombres de los datos se saltea para importar solamente los datos.
El procesamiento de las líneas del csv se realiza mediante una iteración que se detiene al alcanzar el número máximo de registros ingresado (maxRecords). Cada línea se parsea utilizando el método parseCsvLine. Las líneas vacías o que no contienen el número esperado de campos (25) se saltan para mantener la integridad de los datos (igualmente esto no ocurre en la práctica).
Una vez extraídos y limpiados los valores de cada campo en la línea, estos se convierten a su tipo de dato correspondiente, como cadenas, enteros, booleanos y doubles. Esta conversión asegura que los datos sean manejables y precisos.
Con los datos extraídos, se crea una instancia de Cancion. Este objeto tiene toda la información relevante de la línea del csv.
Para almacenar las canciones en el hash cerrado, se verifica si ya existe una lista de canciones para la fecha de la instantánea (snapshotDate). Si no existe, se crea una nueva lista, se agrega la canción y se inserta en el hash. Si ya existe, la canción se añade a la lista existente, garantizando que todas las canciones de una misma fecha estén agrupadas.
El proceso incluye manejo de excepciones para capturar y manejar problemas de entrada/salida (IOException) y claves duplicadas (DuplicateKey). Esto asegura que el programa pueda manejar errores de manera consistente.
Finalmente, se agrega el hash cerrado y la lista de fechas al resultado, que se devuelve como una lista resultado con el hash de canciones y las fechas únicas.
### Métodos auxiliares:
El método parseArtists convierte una cadena de artistas en una lista enlazada de nombres de artistas, facilitando el manejo de múltiples artistas por canción.

El método parseInt convierte una cadena en un entero, lo cual elimina comillas y caracteres innecesarios.

El método parseDouble convierte una cadena en un número flotante, eliminando comillas y caracteres innecesarios.

El método parseCsvLine divide una línea del CSV en un arreglo de cadenas, considerando las comillas para manejar los campos con comas.
# Medicion de eficiencia del programa:
### A modo de aclaracion, medimos tanto la memoria usada como el tiempo ejecutando el programa usando el Profiler del Intellij.
## Medicion de la eficiencia de la carga masiva de datos: 
a. Memoria usada:

![2](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/0e51e5bd-cf08-4f10-a794-5da3d46dd1f4)

b. Tiempo de ejecucion: 

![1](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/dc071a4b-3a01-4e2b-aae0-7bd51e2914b1)

## Medicion de la eficiencia de las consultas:
1. Resultado:
   
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/6ff8b384-fb8e-4071-a77c-1c9b594dbd53)

   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/fddfbe03-5a63-41cf-b1d6-44f31aa1b340)

2. Resultado:
   
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/162ecba2-0420-4e49-998a-da68fbbdc116)

   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/6c2ea66a-1f6b-41da-969f-ca047978b215)

3. Resultado:
   Para la medicion tomamos el peor caso posible, es decir tomamos como rango la primera fecha del csv hasta la ultima fecha.
   
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/9a2ce169-0e3d-418b-8ff7-7defd2ae7dba)
   
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/c01a109a-7c7b-4e32-acbb-d3546d291f7c)

5. Resultado:
  
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/c9ddc866-2184-4f1e-a4ef-76dfee99cfb0)

   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/5d7998cd-5f31-4d3e-b341-4a20439cd11a)
   
6. Resultado:
   Para la medicion tomamos el peor caso posible, es decir tomamos como rango la primera fecha del csv hasta la ultima fecha.
   
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/6d0c5671-c2cf-45ec-83d0-dc270e08104b)
   
   (que a modo de observacion nos dice que hay 10515 canciones unicas/distintas en el csv)
  
   ![image](https://github.com/SgO1337/obligatorio_prog2_sgarcia1_rquincke/assets/69167503/af3ccdbf-cd3e-40a9-b40e-e54055dacdc7)
