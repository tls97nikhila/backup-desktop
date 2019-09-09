package com.stackroute.SpringBootTask.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.services.MuzixService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MuzixControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private Muzix muzix;
  @MockBean
  private MuzixService muzixService;
  @InjectMocks
  private MuzixController muzixController;

  private List<Muzix> list =null;

  @Before
  public void setUp(){

    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();
    muzix = new Muzix();
    muzix.setId(1);
    muzix.setName("welcome");
    muzix.setComment("good");
    list = new ArrayList();

    list.add(muzix);
  }

  @Test
  public void saveTrack() throws Exception {
    when(muzixService.saveTrack(any())).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());


  }
  @Test
  public void saveTrackFailure() throws Exception {
    when(muzixService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isConflict())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void getAllTracks() throws Exception {
    when(muzixService.getAllTracks()).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void getTrackById() throws Exception {
    when(muzixService.getTrackById(1)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/trackid/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }


  @Test
  public void getTrackByName() throws Exception {
    when(muzixService.getTrackBYName("ashu")).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/trackname/ashu")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void deleteById() throws Exception {
    when(muzixService.deleteTrackById(1)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }


  @Test
  public void updateById() throws Exception {
    when(muzixService.updateTrackById(muzix,1)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void updateByIdNotPresent() throws Exception {
    when(muzixService.updateTrackById(muzix,2)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track/2")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }



  private static String asJsonString(final Object obj)
  {
    try{
      return new ObjectMapper().writeValueAsString(obj);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }





}
