# [Spring Boot API with Spring Security and Docker](https://www.youtube.com/watch?v=0iNmWIi5rG4)
Curso tomado del canal de youtube: **Get Arrays**

# Trabajando con Docker
Necesitamos generar el .jar de la aplicación, para eso nos posicionaremos en la raíz del proyecto y 
usando un cmd, ejecutaremos el siguiente comando:

```
mvnw clean package
```

## Nota:
En algunos proyecto usé el **mvnw install** y en otros el **mvnw package**, la diferencia sería:

- **mvnw package:** compila el código fuente y lo empaqueta (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc…)  
- **mvnw install:** a parte de generar el .jar o un .war, alojará ese empaquetado en el repositorio local de maven(/Users/home/.m2) para usarlo como dependencia en otros proyectos localmente

Además usé el **clean** para asegurarnos de limpiar las compilaciones que se hayan hecho anteriormente.

# Ejecutando .jar del /target mediante cmd (Sin el IDE)
Mediante el cmd nos posicionamos dentro del directorio generado tras el empaquetado (/target), 
y levantaremos la aplicación de la siguiente manera (Es como si ejecutáramos el proyecto
desde el Intellij IDEA):

```
java -jar spring-security-docker-0.0.1-SNAPSHOT.jar
```
# Trabajand con Docker
- Crearemos un archivo Dockerfile, que es para crear una imagen para cualquier contenedor que deseemos ejecutar.