package Utilerias;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ReconocerFiles {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./test.txt");
        if (Files.exists(path)) {
            System.out.printf("%n\"%s\" EXISTE %n", path.getFileName());
            System.out.printf("%s un directorio%n", Files.isDirectory(path) ? "Es" : "No es");
            System.out.printf("%s una ruta absoluta%n", path.isAbsolute() ? "Es" : "No es");
            System.out.printf("Ultima modificacion: %s%n", Files.getLastModifiedTime(path));
            System.out.printf("Tamanio: %s%n", Files.size(path));
            System.out.printf("Ruta: %s%n", path);
            System.out.printf("Ruta absoluta: %s%n", path.toAbsolutePath());
            if (Files.isDirectory(path)) {
                System.out.printf("%nCONTENIDO DEL DIRECTORIO:%n");
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for (Path p : directoryStream) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.printf("\"%s\" NO EXISTE%n", path);
        }

    }
}
