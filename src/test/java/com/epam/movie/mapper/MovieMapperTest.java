package com.epam.movie.mapper;

import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapperTest {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String CATEGORY_ID = "category_id";
    private static final Integer EXPECTED_ID = 1;
    private static final String EXPECTED_TITLE = "title";
    private static final Integer EXPECTED_YEAR = 2022;
    private static final Integer EXPECTED_CATEGORY_ID = 1;
    private static final Category EXPECTED_CATEGORY = Category.ACTION;

    private ResultSet mock;

    @BeforeTest
    public void init() {
        mock = Mockito.mock(ResultSet.class);
    }

    @Test
    public void testMovieRowMapper() throws SQLException {
        Mockito.when(mock.getInt(ID)).thenReturn(EXPECTED_ID);
        Mockito.when(mock.getString(TITLE)).thenReturn(EXPECTED_TITLE);
        Mockito.when(mock.getInt(YEAR)).thenReturn(EXPECTED_YEAR);
        Mockito.when(mock.getInt(CATEGORY_ID)).thenReturn(EXPECTED_CATEGORY_ID);

        MovieMapper movieMapper = new MovieMapper();
        Movie movie = (Movie) movieMapper.map(mock);

        Assert.assertEquals(movie.getId(), EXPECTED_ID);
        Assert.assertEquals(movie.getTitle(), EXPECTED_TITLE);
        Assert.assertEquals(movie.getYear(), EXPECTED_YEAR);
        Assert.assertEquals(movie.getCategory(), EXPECTED_CATEGORY);
    }
}
