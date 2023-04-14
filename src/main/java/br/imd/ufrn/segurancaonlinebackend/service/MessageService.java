package br.imd.ufrn.segurancaonlinebackend.service;

import br.imd.ufrn.segurancaonlinebackend.model.Message;
import br.imd.ufrn.segurancaonlinebackend.model.MessageFilter;
import br.imd.ufrn.segurancaonlinebackend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message insertMessage(Message message){
        MessageFilter.forbiddenWords.forEach(word -> {
            if(message.getMessage().contains(word)){
                throw new IllegalArgumentException("Foi detectado uma palavra ofensiva na sua mensagem. A mensagem será descartada!");
            }
        });
        return repository.save(message);
    }

    public List<Message> findAll() {
        return repository.findAll();
    }
}
