package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.controllers.FiltersController;
/**
 * Class that defines the test for com.r0r5chach.controllers.FiltersController
 * @author r0r5chach
 */
public class FiltersControllerTest {
    /**
     * Tests FiltersController.getFilters()
     */
    @Test
    public void filtersControllerGetFiltersTest() {
        assertEquals(null, FiltersController.getFilters());
    }
}
