package com.puzikov.util;

import com.puzikov.domain.Spitter;
import com.puzikov.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;

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
    public String addSpitterForm(@Valid Spitter spitter, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitters/" + spitter.getName();
    }

    @RequestMapping(value = "/${username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
