package com.nttdata.devops.controller;


import com.nttdata.devops.dto.MessageRequest;
import com.nttdata.devops.dto.MessageResponse;
import com.nttdata.devops.services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
public class DevOpsController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/DevOps")
    public ResponseEntity<?> devOps(
            @Valid @RequestBody MessageRequest request,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {

        // Obtener JWT del header
        String jwt = httpRequest.getHeader("X-JWT-KWY");

        // Si el JWT es nulo o inválido, rechazar la petición
        if (jwt == null || !jwtService.validateToken(jwt)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("ERROR: JWT inválido o no proporcionado");
        }

        // Generar nuevo JWT para la siguiente transacción
        String newJwt = jwtService.generateToken();
        httpResponse.setHeader("X-JWT-KWY", newJwt); //

        // Responder con mensaje exitoso
        String responseMessage = "Hello " + request.getTo() + " your message will be sent";
        return ResponseEntity.ok(new MessageResponse(responseMessage));
    }

    @RequestMapping(value = "/DevOps", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
    public ResponseEntity<String> handleOtherMethods(){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("ERROR");
    }

}
