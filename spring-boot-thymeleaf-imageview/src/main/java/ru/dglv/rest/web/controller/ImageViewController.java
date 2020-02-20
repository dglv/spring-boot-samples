package ru.dglv.rest.web.controller;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/imageview")
interface ImageViewController
{
    @GetMapping()
    String getAllImages(Model model) throws IOException;

    @GetMapping("/uploaded/{filename}")
    @ResponseBody
    ResponseEntity<Resource> loadImage(String filename);
}
