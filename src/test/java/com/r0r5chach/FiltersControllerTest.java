package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.r0r5chach.controllers.FiltersController;

public class FiltersControllerTest {

    @Test
    public void filtersControllerGetFiltersTest() {
        assertEquals(null, FiltersController.getFilters());
    }
}
