package br.edu.challenge.baas.service;

import br.edu.challenge.baas.enumeration.Event;
import br.edu.challenge.baas.model.EntityModel;
import br.edu.challenge.baas.process.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Facade {
    protected Map<String, Map<Event, List<Validation>>> rules;

    protected void execute(EntityModel em, Event event) {
        Map<Event, List<Validation>> operationRules = this.rules.get(em.getClass().getSimpleName());
        if(operationRules != null) {
            List<Validation> rolesList = new ArrayList<>();
            rolesList.addAll(operationRules.get(event));
            rolesList.forEach(op -> op.process(em));
        }
    }
}