package com.carapplication.Rental.dto;

import java.time.LocalDate;

public record RentalDateDto(LocalDate startDate, LocalDate endDate) {
}
