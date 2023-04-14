package br.imd.ufrn.segurancaonlinebackend.repository;

import br.imd.ufrn.segurancaonlinebackend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
