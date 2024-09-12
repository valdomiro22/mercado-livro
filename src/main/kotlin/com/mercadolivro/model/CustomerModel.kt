package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "customer")  // Nome da tabela
data class CustomerModel(

    @Id  // Cria o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Faz com que o id seja auto_increment
    var id: Int? = null,

    // @Column(name = "name")  // Isso é necessario caso o nome deste atributo seja diferente do nome que eu quero por na colune
    @Column
    var name: String,

    @Column()
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)