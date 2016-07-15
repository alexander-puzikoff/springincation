package com.puzikov.service;

import com.puzikov.domain.Spitter;
import com.puzikov.domain.Spittle;

import java.util.Collection;
import java.util.List;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/28/2016</pre>
 */
public interface SpitterService {
    Collection<Spittle> getRecentSpittles(int defaultSpittersPerPage);

    Spitter getSpitter(String username);

    Collection<Spittle> getSpittlesForSpitter(String username);

    void saveSpitter(Spitter spitter);
}
