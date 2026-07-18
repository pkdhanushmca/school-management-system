package com.educore.school.util;

import java.time.LocalDate;

public class AdmissionNumberGenerator {

	public static String generate(Long id) {

        int year = LocalDate.now().getYear();

        return String.format("ADM%d%05d", year, id);
    }
}
