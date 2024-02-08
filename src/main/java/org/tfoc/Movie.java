package org.tfoc;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    private String title;
    private int priceCode;

}
