package com.marakicode.springstore.dtos;

import java.math.BigDecimal;

public record ProductSummaryDto(Long id, String name, BigDecimal price) {
}
