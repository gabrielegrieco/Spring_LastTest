package it.euris.academy.aca_esame.ServiceImpl;

import it.euris.academy.aca_esame.TestSupport.TestingSupport;
import it.euris.academy.aca_esame.data.dto.CinemaDto;
import it.euris.academy.aca_esame.data.model.Cinema;
import it.euris.academy.aca_esame.repository.CinemaRepository;
import it.euris.academy.aca_esame.service.CinemaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceImplCinema {
    @Autowired
    private CinemaService cinemaService;

    @MockBean
    private CinemaRepository cinemaRepository;

    @Test
    @DisplayName("GivenId_WhenGetMethod_ThenCinemaIdAndCinemaDtoIdShouldBeEquals")
    void givenIdWhenGetMethodThenCinemaIdAndCinemaDtoIdShouldBeEquals() {

        Long id = 1L;

        Cinema Cinema = TestingSupport.createCinema(id);

        Mockito.when(cinemaRepository.findById(id)).thenReturn(Optional.of(Cinema));

        CinemaDto CinemaDto = cinemaService.get(id);

        assertEquals(Cinema.getId().toString(), CinemaDto.getId());
    }

    @Test
    @DisplayName("GivenMockedCinemaList_WhenGetAllCinemaMethod_ThenCinemaListSizeIdAndMockedCinemaListBeEquals")
    void GivenMockedCinemaListWhenGetAllCinemaMethodThenCinemaListSizeIdAndMockedCinemaListBeEquals() {
        //arrange
        List<Cinema> mockedCinemasList = TestingSupport.createCinemaList();
        when(cinemaRepository.findAll()).thenReturn(mockedCinemasList);

        //act
        List<CinemaDto> CinemasList = cinemaService.getAll();

        //assert
        assertEquals(CinemasList.size(), mockedCinemasList.size());
        for(int i = 0; i < mockedCinemasList.size(); i++)
            assertEquals(mockedCinemasList.get(i).toDto(), CinemasList.get(i));
    }

    @Test
    @DisplayName("givenCinemaToAdd_WhenAddCinema_ThenCinemaReturnedShouldEqualsToCinemaDto")
    void givenCinemaToAddWhenAddCinemaThenCinemaReturnedShouldEqualsToCinemaDto() {

        CinemaDto CinemaToSave = new CinemaDto();
        Cinema CinemaToReturn = TestingSupport.createCinema(1L);
        when(cinemaRepository.save(any())).thenReturn(CinemaToReturn);

        CinemaDto testedCinema = cinemaService.insert(CinemaToSave);

        assertEquals( "1", testedCinema.getId() );
    }

    @Test
    @DisplayName("GivenId_WhenCinemadeletedMethod_ThenReturnTrueDeletedByIdJustOnce")
    void delete() {
        Long id = 1l;
        doNothing().when(cinemaRepository).deleteById(id);
        when(cinemaRepository.findById(id)).thenReturn(Optional.empty());

        assertTrue(cinemaService.delete(id));
        Mockito.verify(cinemaRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("GivenCinemaId_WhenUpdatedMethod_ThenShouldKeepSameId")
    void put() {
        Long id = 1l;
        Cinema CinemaToSave = TestingSupport.createCinema(1L);
        Cinema CinemaToReturn = TestingSupport.createCinema(id);
        when(cinemaRepository.save(any())).thenReturn(CinemaToReturn);

        CinemaDto testedCinema = cinemaService.update(CinemaToSave.toDto());

        assertEquals(id.toString(), testedCinema.getId());
    }
}
