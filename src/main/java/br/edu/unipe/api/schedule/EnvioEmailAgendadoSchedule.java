package br.edu.unipe.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvioEmailAgendadoSchedule {

        @Scheduled(fixedRate = 10000)
        public void enviarEmailAgendado(){
            log.info("Enviando Email ...");

        }
    }

