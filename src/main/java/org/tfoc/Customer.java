package org.tfoc;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ")
                .append(name)
                .append("\n");

        for (Rental each : rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {

                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;

                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;

                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;

                default:

            }

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two-day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1)

                frequentRenterPoints++;

            // show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");

            totalAmount += thisAmount;
        }

        // add footer lines
        result.append("Amount owed is ")
                .append(totalAmount)
                .append("\n");

        result.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points");

        return result.toString();
    }

}
