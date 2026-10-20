package com.internship.shoplite.dto;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import java.util.List;
public record CheckoutRequest(@NotBlank String customerName,@NotBlank @Email String customerEmail,@NotBlank String paymentMethod,@NotEmpty List<@Valid Item> items){public record Item(@NotNull Long productId,@NotNull @Min(1) Integer quantity){}}
