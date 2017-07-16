/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.repositories;

import br.com.bahia.guilherme.trade.model.ISO4217;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Guilherme
 */
public interface ISO4217Repository extends JpaRepository<ISO4217, String> {
    
    @Query(value = "Select count(*) From ISO4217 iso where iso.code = ?1 or iso.code = ?2")
    Long amountByCodes(String code1, String code2);
}
