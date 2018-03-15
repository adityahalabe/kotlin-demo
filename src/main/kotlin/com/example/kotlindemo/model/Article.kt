package com.example.kotlindemo.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "articles")
data class Article (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val article_id: Int = 0,

        @get: NotBlank
        val title: String = "",

        @get: NotBlank
        val contents: String = ""
)
