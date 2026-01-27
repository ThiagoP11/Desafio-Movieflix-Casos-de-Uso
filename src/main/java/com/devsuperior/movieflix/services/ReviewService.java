package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private MovieRepository movieRepository;

    public ReviewDTO insert(ReviewDTO dto) {
        User entity = authService.authenticated();

        Movie movie = movieRepository.getReferenceById(dto.getMovieId());

        Review review = new Review();
        review.setText(dto.getText());
        review.setUser(entity);
        review.setMovie(movie);

        Review review1 = reviewRepository.save(review);

        return new ReviewDTO(review1, entity);

    }
}
