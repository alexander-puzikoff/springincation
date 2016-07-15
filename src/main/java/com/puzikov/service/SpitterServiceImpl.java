package com.puzikov.service;

import com.puzikov.domain.Spitter;
import com.puzikov.domain.Spittle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/27/2016</pre>
 */
@Service
public class SpitterServiceImpl implements SpitterService {
    Map<Spitter, List<Spittle>> mappings = new HashMap<Spitter, List<Spittle>>();
    Spitter apuzikov = new Spitter("apuzikov"), mkan = new Spitter("mkanunni"), hodor = new Spitter("hodor"), grut = new Spitter("grut");

    public Collection<Spittle> getRecentSpittles(int defaultSpittersPerPage) {
        mappings.put(apuzikov, Arrays.asList(new Spittle.SpittleBuilder().buildSpitter(apuzikov).buildWhen(new Date()).buildText("Houdihou!").build()));
        mappings.put(mkan, Arrays.asList(new Spittle.SpittleBuilder().buildSpitter(mkan).buildWhen(new Date()).buildText("I am max!").build()));
        mappings.put(grut, Arrays.asList(new Spittle.SpittleBuilder().buildSpitter(grut).buildWhen(new Date()).buildText("i am grut").build()));
        mappings.put(hodor, Arrays.asList(new Spittle.SpittleBuilder().buildSpitter(hodor).buildWhen(new Date()).buildText("Hodor!!Hodor!!Hodor!!HOOOODOOOOR!!").build()));
        Collection<List<Spittle>> preliminaryResult = mappings.values();
        List<Spittle> finalResult = new ArrayList<Spittle>();
        for (List smallParts : preliminaryResult) {
            finalResult.addAll(smallParts);
        }
        return finalResult;
    }

    public Spitter getSpitter(String username) {
        for(Map.Entry<Spitter, List<Spittle>> entry : mappings.entrySet()){
            if(entry.getKey().getName().equalsIgnoreCase(username)){
                return entry.getKey();
            }
        }
        return  null;
    }

    public Collection<Spittle> getSpittlesForSpitter(String username) {
        for(Map.Entry<Spitter, List<Spittle>> entry : mappings.entrySet()){
            if(entry.getKey().getName().equalsIgnoreCase(username)){
                return entry.getValue();
            }
        }
        return  null;
    }
    public void saveSpitter(Spitter spitter) {
        mappings.put(spitter, new ArrayList<Spittle>());
    }
}
