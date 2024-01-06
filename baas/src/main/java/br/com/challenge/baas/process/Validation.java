package br.com.challenge.baas.process;

import br.com.challenge.baas.model.EntityModel;

public interface Validation {
    void process(EntityModel em);
}