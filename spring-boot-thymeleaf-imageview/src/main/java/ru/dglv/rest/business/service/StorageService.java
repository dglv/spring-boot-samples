package ru.dglv.rest.business.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;

public interface StorageService
{
    Stream<Path> loadAll();
    
    Path load(String filename);
    
    Resource loadAsResource(String filename);
}
