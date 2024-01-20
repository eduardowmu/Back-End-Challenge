package br.edu.challenge.baas.exception;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StandardError implements Serializable
{	private static final long serialVersionUID = 1L;
    private Long timeStamp;
    private Integer status;
    private String message;
}