package br.imd.ufrn.segurancaonlinebackend.controller;

import br.imd.ufrn.segurancaonlinebackend.dto.MessageDTO;
import br.imd.ufrn.segurancaonlinebackend.model.Message;
import br.imd.ufrn.segurancaonlinebackend.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    private final ModelMapper modelMapper;

    public MessageController(MessageService service) {
        this.service = service;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> findAll(){
        return new ResponseEntity<>(
                service.findAll()
                        .stream()
                        .map(message -> modelMapper.map(message, MessageDTO.class))
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<MessageDTO> insert(@RequestBody MessageDTO messageDTO){
        try{
            Message message = modelMapper.map(messageDTO, Message.class);
            message.setTimestamp(LocalDate.now());
            MessageDTO response = modelMapper.map(service.insertMessage(message), MessageDTO.class);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            MessageDTO response = new MessageDTO();
            response.setMessage(e.getMessage());
            response.setTimestamp(LocalDate.now());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }
}
