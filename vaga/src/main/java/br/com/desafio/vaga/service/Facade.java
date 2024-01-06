package br.com.desafio.vaga.service;


import br.com.desafio.vaga.enumeration.Event;
import br.com.desafio.vaga.process.Validation;
import br.com.desafio.vaga.model.EntityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Facade {
    protected Map<String, Map<Event, List<Validation>>> roles;

    protected void execute(EntityModel em, Event event) {
        Map<Event, List<Validation>> operationRoles = this.roles.get(em.getClass().getSimpleName());
        if(operationRoles != null) {
            List<Validation> rolesList = new ArrayList<>();
            rolesList.addAll(operationRoles.get(event));
            rolesList.forEach(r -> r.process(em));
        }
    }
}