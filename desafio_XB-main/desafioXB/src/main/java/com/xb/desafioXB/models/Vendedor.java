package com.xb.desafioXB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String nome;
    char sexo;
    int totalVendas;
    float mediaVendas;

}
