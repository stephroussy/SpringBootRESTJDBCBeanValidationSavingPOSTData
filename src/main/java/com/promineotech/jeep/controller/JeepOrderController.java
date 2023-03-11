package com.promineotech.jeep.controller;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/orders")

public interface JeepOrderController {
  // formatter:off
  @Operation(
      summary = "Create an order for a Jeep",
      description = "Returns the created Jeep",
      responses = { 
          @ApiResponse(
              responseCode = "201", 
              description = "The created Jeep is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Order.class)))
          }
      )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED) 
 
  Order createOrder(@Valid @RequestBody OrderRequest orderRequest);
//formatter:on  
}

