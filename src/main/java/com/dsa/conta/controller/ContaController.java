package com.dsa.conta.controller;

import com.dsa.conta.controller.dto.ContaRequestDTO;
import com.dsa.conta.controller.dto.ContaResponseDTO;
import com.dsa.conta.converter.ContaConverter;
import com.dsa.conta.service.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/contas")
public class ContaController {

    private final ContaService contaService;
    private final ContaConverter contaConverter;

    @ApiOperation(value = "Busca uma conta por ID", response = ContaResponseDTO.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Conta encontrada com sucesso"),
            @ApiResponse(code = 404, message = "Conta não encontrada"),
            @ApiResponse(code = 500, message = "Erro ao buscar conta")})
    @GetMapping("/{id}")
    public ResponseEntity findById(@ApiParam(name = "id", value = "ID da conta") @PathVariable String id) {

        return ResponseEntity.ok(contaConverter.toResponseDTO(contaService.findById(id)));
    }

    @ApiOperation(value = "Cadastra uma nova conta", response = ContaResponseDTO.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Conta cadastrada com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao validar conta inserida"),
            @ApiResponse(code = 500, message = "Erro ao cadastrar conta")})
    @PostMapping
    public ResponseEntity insert(@Valid @RequestBody ContaRequestDTO contaRequestDTO) {

        return ResponseEntity.ok(
                contaConverter.toResponseDTO(
                        contaService.insert(
                                contaConverter.toDocument(contaRequestDTO)
                        )
                )
        );
    }
}
