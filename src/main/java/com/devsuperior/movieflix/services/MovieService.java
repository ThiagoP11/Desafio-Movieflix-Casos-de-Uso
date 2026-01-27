package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieProjection;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;

    @SuppressWarnings("unchecked")
    public Page<MovieCardDTO> findAllPaged(String genreId, Pageable pageable) {

        Long idGenre = null;

        if(!"0".equals(genreId)){
            idGenre = Long.parseLong(genreId);
        }

        Page<MovieProjection> page = movieRepository.searchMovie(idGenre, pageable);

        List<Long> movieIds = page.map(MovieProjection::getId).toList();

        List<Movie> entities = movieRepository.searchMoviesWithGenres(movieIds);

        List<MovieCardDTO> dtos = entities.stream().map(MovieCardDTO::new).toList();

        return new PageImpl<>(dtos, page.getPageable(), page.getTotalElements());
    }

    public MovieDetailsDTO findById(Long id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (!result.isPresent()) {
            throw new ResourceNotFoundException("Movie not found with id: " + id);
        }
        MovieDetailsDTO dto = new MovieDetailsDTO(result.get());

        return dto;
    }
}
