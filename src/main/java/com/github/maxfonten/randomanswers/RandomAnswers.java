package com.github.maxfonten.randomanswers;

import org.mockito.internal.stubbing.defaultanswers.ReturnsMoreEmptyValues;
import org.mockito.stubbing.Answer;

@SuppressWarnings("unchecked")
public class RandomAnswers {
    public static final Answer<Object> RETURNS_RANDOMS = new DelegatesOrReturnsDeepStubs(new ReturnsRandoms(), new ReturnsMoreEmptyValues());
}
