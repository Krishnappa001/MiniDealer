package com.store_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * This is to store error details of API all errors field name and error
 * messages value
 *
 * @author T0121UY
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {

	private String errorld;

	private String errorMessage;

}
