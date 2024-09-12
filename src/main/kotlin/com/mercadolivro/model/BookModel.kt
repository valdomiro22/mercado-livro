package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import jakarta.persistence.*
import org.springframework.web.bind.annotation.ResponseStatus
import java.math.BigDecimal

@Entity(name = "book")  // Nome da tabela
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Faz com que o id seja auto_increment
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,


    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO) {
                throw Exception("Não é possível altera um livro com status $field")
            }
            field = value
        }

    constructor(
        id: Int? = null, name: String, price: BigDecimal, customer: CustomerModel?, status: BookStatus
    ): this(id, name, price, customer) {
        this.status = status
    }
}