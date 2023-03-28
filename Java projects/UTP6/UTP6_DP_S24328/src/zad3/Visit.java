package zad3;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Visit implements FileVisitor<Path>
{
    BufferedWriter bufferedWriter;

    public Visit(Path path) throws IOException
    {
        System.out.println(path);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter
                (Files.newOutputStream(path.toFile().toPath()), StandardCharsets.UTF_8));
    }

    public void closing() throws IOException
    {
        bufferedWriter.close();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        String word;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(Paths.get(file.toString())),"cp1250"));
        while ((word = reader.readLine()) != null)
        {
            bufferedWriter.write(word);
            bufferedWriter.newLine();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
    {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
    {
        return FileVisitResult.CONTINUE;
    }
}
