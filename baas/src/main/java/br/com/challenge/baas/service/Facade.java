package br.com.challenge.baas.service;


import br.com.challenge.baas.enumeration.Event;
import br.com.challenge.baas.model.EntityModel;
import br.com.challenge.baas.process.Validation;

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