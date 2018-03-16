package com.example.kotlindemo

import com.example.kotlindemo.controller.ArticleController
import com.example.kotlindemo.model.Article
import com.example.kotlindemo.services.ArticleService
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ArticleControllerTest {

    @InjectMocks
    lateinit var articleController: ArticleController
    @Mock
    lateinit var articleService: ArticleService

    @Test
    fun getAllArticles() {
        val expectedArticles = listOf(Article(1,"Bauer","contents"))
        Mockito.doReturn(expectedArticles).`when`(articleService).getAllArticles()
        val result = articleController.getAllArticles()
        TestCase.assertNotNull(result)
        assertEquals(result, expectedArticles)
    }
}