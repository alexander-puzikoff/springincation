package com.puzikov.util;

import com.puzikov.domain.Spittle;
import com.puzikov.service.SpitterService;
import com.puzikov.service.SpitterServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static com.puzikov.util.HomeController.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/27/2016</pre>
 */

public class HomeControllerTest {
    @Test
    public void test() {
        List<Spittle> expectedSpittles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());
        SpitterServiceImpl spitterService = mock(SpitterServiceImpl.class);
        when(spitterService.getRecentSpittles(DEFAULT_SPITTERS_PER_PAGE)).thenReturn(expectedSpittles);
        HomeController homeController = new HomeController();
        homeController.setSpitterService(spitterService);
        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = homeController.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService).getRecentSpittles(DEFAULT_SPITTERS_PER_PAGE);
    }
}
