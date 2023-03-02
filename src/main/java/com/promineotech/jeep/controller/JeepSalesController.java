package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//tells Spring to map jeeps URI to the class DefaultJeepSalesController
@RequestMapping("/jeeps")
@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface JeepSalesController {
  // @formatter:off
  @Operation(
      summary = "Returns a list of Jeeps",
      description = "Returns a list of Jeeps given an optional model and/or trim",
      responses = { 
          @ApiResponse(
              responseCode = "200", 
              description = "Success", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Jeep.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "Bad Input", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Not Found", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "Unplanned Error", 
              content = @Content(mediaType = "application/json"))
          },
      parameters = {
          @Parameter(name = "model",
              allowEmptyValue = false, 
              required = false, 
              description = "The model name (i.e, 'WRANGLER')"),
          @Parameter(name = "trim", 
          allowEmptyValue = false, 
          required = false, 
          description = "The trim level (i.e., 'Sport')")
          }
      )
  //getmapping maps to the fetchjeeps method
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  //requestParam maps parameter named model to the model variable and trim to the trim variable
  List<Jeep> fetchJeeps(@RequestParam(required = false) JeepModel model, @RequestParam(required = false) String trim);
//formatter:on  
}

