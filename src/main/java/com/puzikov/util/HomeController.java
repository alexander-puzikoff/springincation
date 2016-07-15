package com.puzikov.util;

import com.puzikov.service.SpitterService;
import com.puzikov.service.SpitterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/27/2016</pre>
 */
@Controller
public class HomeController {
    public final static int DEFAULT_SPITTERS_PER_PAGE = 25;


    private SpitterService spitterService;

    @Inject
    public void setSpitterService(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTERS_PER_PAGE));
        return "home";
    }
}
