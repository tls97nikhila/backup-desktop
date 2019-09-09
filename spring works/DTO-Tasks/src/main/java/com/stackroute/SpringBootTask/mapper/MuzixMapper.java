package com.stackroute.SpringBootTask.mapper;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.domain.MuzixDTO;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper

public interface MuzixMapper {
    MuzixDTO toMuzixDTO(Muzix muzix);
    List<MuzixDTO> toMuzixDTOs(List<Muzix> muzixes);
    Muzix toMuzix(MuzixDTO muzixDTO);

}
