package br.edu.challenge.baas.process;

import br.edu.challenge.baas.model.EntityModel;

public interface Validation {
    void process(EntityModel em);
}