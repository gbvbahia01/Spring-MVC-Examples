package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDAO extends JpaRepository<File, Long> {
}
