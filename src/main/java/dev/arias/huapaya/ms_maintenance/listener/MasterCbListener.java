package dev.arias.huapaya.ms_maintenance.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.arias.huapaya.ms_maintenance.persistence.entity.MasterEntity;
import dev.arias.huapaya.ms_maintenance.service.interfaces.MasterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class MasterCbListener {

    private final MasterService masterService;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "consumerMaintenance", groupId = "circuitbreaker")
    public void insertMsgEvent(String masterEvent) throws JsonMappingException, JsonProcessingException {
        var master = this.objectMapper.readValue(masterEvent, MasterEntity.class);
        this.masterService.save(master);

    }


}
