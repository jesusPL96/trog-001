package org.tfoc;

import lombok.Builder;
import lombok.Getter;

/**
 * The rental class represents a customer renting a movie.
 */

@Builder
@Getter
public class Rental {

    private Movie movie;
    private int daysRented;

}
