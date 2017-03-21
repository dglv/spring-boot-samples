package ru.dglv.rest.business.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import ru.dglv.rest.business.exception.StorageException;
import ru.dglv.rest.business.exception.StorageFileNotFoundException;

@Service
public class StorageServiceImpl implements StorageService
{
    private Path rootLocation;

    public StorageServiceImpl()
    {
        rootLocation = Paths.get("uploaded");
    }
    
    @Override
    public Stream<Path> loadAll()
    {
        try 
        {
            return Files.walk(rootLocation, 1)
                    .filter(path -> !path.equals(rootLocation))
                    .map(path -> rootLocation.relativize(path));
        } 
        catch (final IOException e) 
        {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(final String filename)
    {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(final String filename)
    {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

}
