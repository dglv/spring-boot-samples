package ru.dglv.rest.web.controller;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

interface ImageViewController
{
    String getAllImages(Model model) throws IOException;

    ResponseEntity<Resource> loadImage(String filename);
}
