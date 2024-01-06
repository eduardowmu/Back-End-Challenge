package br.com.challenge.baas.exception;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StandardError implements Serializable
{	private static final long serialVersionUID = 1L;
    private Long timeStamp;
    private Integer status;
    private String message;
}