package ru.dglv.rest.web.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import ru.dglv.rest.business.service.StorageService;
import ru.dglv.rest.web.constant.Views;

@Controller
@RequestMapping("/")
public class ImageViewControllerImpl implements ImageViewController
{
    @Autowired
    private StorageService storageService;
    
    @Override
    @GetMapping()
    public String getAllImages(final Model model) throws IOException
    {
        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(ImageViewControllerImpl.class, "loadImage", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));
        
        return Views.IMAGEVIEW.getName();
    }

    @Override
    @GetMapping("/uploaded/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> loadImage(@PathVariable final String filename)
    {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + file.getFilename())
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }
}
