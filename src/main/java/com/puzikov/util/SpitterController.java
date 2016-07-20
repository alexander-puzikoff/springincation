package com.puzikov.util;

import com.puzikov.domain.Spitter;
import com.puzikov.service.SpitterService;
import com.puzikov.util.exception.ImageUploadException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>07/15/2016</pre>
 */

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String listSpittlesforSpitter(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }


    @RequestMapping(params = "new", method = RequestMethod.GET)
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter("noname"));
        return "spitters/edit";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterForm(@Valid Spitter spitter, BindingResult bindingResult, @RequestParam(value = "image", required = false) MultipartFile image) {
        if (bindingResult.hasErrors()) {
            return "spitters/edit";
        }

        try {
            if (!image.isEmpty()) {
                validateImage(image);
                saveImage(spitter.getName() + ".jpg", image);
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitter/" + spitter.getName();
    }

    private void saveImage(String filename, MultipartFile image) {
        try {
            File file = new File("/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException(e);
        }

    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equalsIgnoreCase("image/jpeg")) {
            throw new ImageUploadException("Only JPG image accepted.");
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
