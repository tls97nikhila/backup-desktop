package com.stackroute.SpringBootTask.controller;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.domain.MuzixDTO;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.mapper.MuzixMapper;
import com.stackroute.SpringBootTask.services.MuzixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class MuzixController {

    private MuzixService muzixService;
    private MuzixMapper muzixMapper;

    @Autowired
    public MuzixController(MuzixService muzixService){
        this.muzixService = muzixService;
    }


    @PostMapping("/track")

    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        Muzix savedMuzix = null;

      try {
        savedMuzix = muzixService.saveTrack(muzix);
        }
        catch (TrackAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(savedMuzix, HttpStatus.CREATED);
    }

    /* This method will retrive musix by using Query parameter */

    @GetMapping("/tracks")

    public ResponseEntity<List<MuzixDTO>> getAllTracks() {

        List<MuzixDTO> musixes = muzixMapper.toMuzixDTOs(muzixService.getAllTracks());
        return new ResponseEntity<List<MuzixDTO>>(musixes, HttpStatus.OK);


    }

    @GetMapping("/trackid/{id}")

    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
        Muzix muzix = null;

       try {
        muzix = muzixService.getTrackById(id);
         }
        catch(TrackNotFoundException t){
            return new ResponseEntity<>(t.getMessage(),HttpStatus.CONFLICT);
        }

        return new ResponseEntity<Muzix>(muzix, HttpStatus.OK);
    }

    /*
     This method will delete data by id
     */

    @DeleteMapping("/track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {
      Muzix muzix;
      muzix = muzixService.getTrackById(id);
        muzixService.deleteTrackById(id);
        return new ResponseEntity(muzix, HttpStatus.OK);
    }

    /*
    This method will update data by id
     */

    @PutMapping("/track/{id}")
    public ResponseEntity<Muzix> updateTrackById(@RequestBody Muzix muzix, @PathVariable int id)  throws TrackNotFoundException{

        muzixService.updateTrackById(muzix, id);
        Muzix muzix1 = muzixService.getTrackById(id);
        return new ResponseEntity<Muzix>(muzix, HttpStatus.OK);


    }


    @GetMapping("/trackname/{name}")
    public ResponseEntity<List<Muzix>> getTrackByname(@PathVariable String name) {
        List<Muzix> musix = muzixService.getTrackBYName(name);
        return new ResponseEntity<List<Muzix>>(musix, HttpStatus.CREATED);
    }

}

