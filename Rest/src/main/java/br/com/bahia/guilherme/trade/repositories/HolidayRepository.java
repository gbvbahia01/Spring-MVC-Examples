/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.repositories;

import br.com.bahia.guilherme.trade.model.HoliDay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Guilherme
 */
public interface HolidayRepository extends JpaRepository<HoliDay, Integer> {
    
    List<HoliDay> findByDayAndMonth(Integer day, Integer month);
}
