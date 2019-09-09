package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.repository.MuzixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MuzixServiceImpl implements MuzixService , ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {



    @Value("${muzix.1.name:default}")
    String name1;

    @Value("${muzix.1.comment:default}")
    String comments1;
    @Value("${muzix.2.name:default}")
    String name2;
    @Value("${muzix.2.comment:default}")
    String comments2;

   private MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository = muzixRepository;
    }

    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException {

        if (muzixRepository.existsById(muzix.getId())) {

            throw new TrackAlreadyExistsException("Track already exists with id  : " + muzix.getId());
        }

            Muzix savedMusix = muzixRepository.save(muzix);

            return savedMusix;
    }

    @Override
    public List<Muzix> getAllTracks() {

        return (List<Muzix>) muzixRepository.findAll();
    }

    @Override
    public Muzix getTrackById(int id) throws TrackNotFoundException {
        Optional<Muzix> user_id = muzixRepository.findById(id);

        if (!user_id.isPresent())

                throw new TrackNotFoundException("Record not found");


        return user_id.get();



    }

    @Override
    public Muzix deleteTrackById(int id) throws TrackNotFoundException {
        muzixRepository.deleteById(id);
        MuzixService muzixService= null;
        return  muzixService.getTrackById(id);


    }
    
    @Override
    public Muzix updateTrackById(Muzix musix, int id) throws TrackNotFoundException {

        Optional<Muzix> userOptional = muzixRepository.findById(id);

        if (!userOptional.isPresent())
        musix.setId(id);
        muzixRepository.save(musix);
        MuzixService muzixService=null;
        return muzixService.getTrackById(id);

    }

    public List<Muzix> getTrackBYName(String name) {
        List<Muzix> user_id = muzixRepository.findTitleByName(name);

        return user_id;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        muzixRepository.save(new Muzix(1, name1,  comments1));
        muzixRepository.save(new Muzix(2, name2,  comments2));
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
